package com.app.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDTO {

	private Long userId;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String email;
	private String password;
	private String role;
	private AddressDTO address;
	private CartDTO cart;

}
