package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Address;

public interface AddressDao extends JpaRepository<Address, Long>  {

	Address findByStreetNoAndLocalityAndCityAndStateAndPincodeAndBuildingName(String streetNo, String locality,
			String city, String state, String pincode, String buildingName);

}
