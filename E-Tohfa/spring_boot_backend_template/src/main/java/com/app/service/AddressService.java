package com.app.service;

import java.util.List;

import com.app.dto.AddressDTO;
import com.app.entity.Address;

public interface AddressService {

	AddressDTO createAddress(AddressDTO addressDTO);

	List<AddressDTO> getAddresses();

	AddressDTO getAddress(Long addressId);

	AddressDTO updateAddress(Long addressId, Address address);

	String deleteAddress(Long addressId);

}
