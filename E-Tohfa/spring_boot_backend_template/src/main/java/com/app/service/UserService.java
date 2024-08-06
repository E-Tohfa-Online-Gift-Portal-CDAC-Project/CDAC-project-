package com.app.service;

import com.app.dto.AuthRequest;
import com.app.dto.UserRegisterDTO;
import com.app.dto.UserRespDTO;

public interface UserService {
	UserRespDTO authenticateUser(AuthRequest dto);

	UserRegisterDTO registerUser(UserRegisterDTO userDTO);
}
