package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.custom_exceptions.AuthenticationException;
import com.app.dao.UserDao;
import com.app.dto.AuthRequest;
import com.app.dto.UserRegisterDTO;
import com.app.dto.UserRespDTO;
import com.app.entity.Cart;
import com.app.entity.Role;
import com.app.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userdao;
	@Autowired
	private ModelMapper mapper;

	@Override
	public UserRespDTO authenticateUser(AuthRequest dto) {
		User user = userdao.findByEmailAndPassword(dto.getEmail(), dto.getPwd())
				.orElseThrow(() -> new AuthenticationException("Invalid Email or Password !!!!!!"));
		return mapper.map(user, UserRespDTO.class);
	}

	@Override
	public UserRegisterDTO registerUser(UserRegisterDTO userDTO) {

		User user = mapper.map(userDTO, User.class);
		Cart cart = new Cart();
		
		
		return null;
	}

}
