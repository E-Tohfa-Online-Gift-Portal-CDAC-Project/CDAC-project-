package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.User;

public interface UserDao extends JpaRepository<User, Long> {

	Optional<User> findByEmailAndPassword(String email, String pass);

	@Query("SELECT u FROM User u JOIN FETCH u.addresses a WHERE a.addressId = ?1")
	List<User> findByAddress(Long addressId);
}
