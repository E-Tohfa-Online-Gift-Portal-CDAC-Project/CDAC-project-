package com.app.service;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.CartDao;
import com.app.dao.CategoryDao;
import com.app.dao.ProductDao;
import com.app.dao.UserDao;
import com.app.dto.ApiResponse;
import com.app.dto.ProductPostReqDTO;
import com.app.entity.Category;
import com.app.entity.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productdao;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private CartDao cartDao;

	@Override
	public ProductPostReqDTO addProduct(Long categoryId, Product product) {

		Category category = categoryDao.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

		boolean isProductNotPresent = true;

		List<Product> products = category.getProducts();

		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getProductName().equals(product.getProductName())
					&& products.get(i).getDescription().equals(product.getDescription())) {

				isProductNotPresent = false;
				break;
			}
		}

		if (isProductNotPresent) {
			product.setImage("default.png");

			product.setCategory(category);

			double specialPrice = product.getPrice() - ((product.getDiscount() * 0.01) * product.getPrice());
			product.setSpecialPrice(specialPrice);

			Product savedProduct = productdao.save(product);

			return mapper.map(savedProduct, ProductPostReqDTO.class);
		} else {
			throw new ApiResponse("Alredy Exist");
		}
	}

	@Override
	public String deleteProduct(Long productId) {

		return null;
	}

	/*
	 * @Override public String deleteProduct(Long productId) {
	 * 
	 * Product product = productdao.findById(productId).orElseThrow(()->new
	 * ResourceNotFoundException("Product","productId",productId)); List<Cart> carts
	 * = cartDao.findCartsByProductId(productId);
	 * 
	 * carts.forEach(cart -> cartService.deleteProductFromCart(cart.getCartId(),
	 * productId));
	 * 
	 * productdao.delete(product);
	 * 
	 * return "Product with productId: " + productId + " deleted successfully !!!";
	 * return null; }
	 */

}
