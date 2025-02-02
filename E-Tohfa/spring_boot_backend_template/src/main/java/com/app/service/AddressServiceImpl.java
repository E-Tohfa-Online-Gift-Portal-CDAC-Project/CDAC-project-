package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.custom_exceptions.ApiException;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.AddressDao;
import com.app.dao.UserDao;
import com.app.dto.AddressDTO;
import com.app.entity.Address;
import com.app.entity.User;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDao addressDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public AddressDTO createAddress(AddressDTO addressDTO) {

		String streetNo = addressDTO.getStreetNo();
		String locality = addressDTO.getLocality();
		String city = addressDTO.getCity();
		String state = addressDTO.getState();
		String pincode = addressDTO.getPincode();
		String buildingName = addressDTO.getBuildingName();

		Address addressFromDb = addressDao.findByStreetNoAndLocalityAndCityAndStateAndPincodeAndBuildingName(streetNo,
				locality, city, state, pincode, buildingName);
		if (addressFromDb != null) {
			throw new ApiException("Address already exists with addressId: " + addressFromDb.getAddressId());
		}

		Address address = modelMapper.map(addressDTO, Address.class);

		Address savedAddress = addressDao.save(address);

		return modelMapper.map(savedAddress, AddressDTO.class);
	}

	@Override
	public List<AddressDTO> getAddresses() {

		List<Address> addresses = addressDao.findAll();

		List<AddressDTO> addressDTOs = addresses.stream().map(address -> modelMapper.map(address, AddressDTO.class))
				.collect(Collectors.toList());

		return addressDTOs;
	}

	@Override
	public AddressDTO getAddress(Long addressId) {
		Address address = addressDao.findById(addressId)
				.orElseThrow(() -> new ResourceNotFoundException("Address", "addressId", addressId));
		return modelMapper.map(address, AddressDTO.class);
	}

	@Override
	public AddressDTO updateAddress(Long addressId, Address address) {
		Address addressFromDB = addressDao.findByStreetNoAndLocalityAndCityAndStateAndPincodeAndBuildingName(
				address.getBuildingName(), address.getCity(), address.getLocality(), address.getPincode(),
				address.getState(), address.getStreetNo());
		if (addressFromDB == null) {
			addressFromDB = addressDao.findById(addressId)
					.orElseThrow(() -> new ResourceNotFoundException("Address", "addressId", addressId));
			addressFromDB.setAddressId(address.getAddressId());
			addressFromDB.setBuildingName(address.getBuildingName());
			addressFromDB.setCity(address.getCity());
			addressFromDB.setLocality(address.getLocality());
			addressFromDB.setPincode(address.getPincode());
			addressFromDB.setState(address.getState());
			addressFromDB.setStreetNo(address.getStreetNo());

			Address updatedAddress = addressDao.save(addressFromDB);
			return modelMapper.map(updatedAddress, AddressDTO.class);

		} else {
			List<User> users = userDao.findByAddress(addressId);
			final Address a = addressFromDB;

			users.forEach(user -> user.getAddresses().add(a));

			deleteAddress(addressId);

			return modelMapper.map(addressFromDB, AddressDTO.class);
		}
	}

	@Override
	public String deleteAddress(Long addressId) {
		Address addressFromDB = addressDao.findById(addressId)
				.orElseThrow(() -> new ResourceNotFoundException("Address", "addressId", addressId));

		List<User> users = userDao.findByAddress(addressId);

		users.forEach(user -> {
			user.getAddresses().remove(addressFromDB);

			userDao.save(user);
		});

		addressDao.deleteById(addressId);

		return "Address deleted succesfully with addressId: " + addressId;
	}

}
