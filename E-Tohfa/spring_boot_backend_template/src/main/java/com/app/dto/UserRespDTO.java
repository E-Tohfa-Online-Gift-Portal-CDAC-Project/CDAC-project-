package com.app.dto;

import java.time.LocalDate;
import com.app.entity.Role;

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
public class UserRespDTO {

	private String email;
	private LocalDate dob;
	private Role role;

}
