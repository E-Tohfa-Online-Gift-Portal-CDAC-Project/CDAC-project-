package com.app.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addressId;

	@Pattern(regexp = "[A-Za-z0-9\\s-]{3,}", message = "Not a valid street no")
	private String streetNo;

	@Pattern(regexp = "[A-Za-z0-9\\s-]{3,}", message = "Not a valid building name")
	private String buildingName;

	@NotNull
	@Pattern(regexp = "[A-Za-z0-9\\s-]{3,}", message = "Not a valid locality name")
	private String locality;

	@NotNull(message = "City name cannot be null")
	@Pattern(regexp = "[A-Za-z\\s]{2,}", message = "Not a valid city name")
	private String city;

	@NotNull(message = "State name cannot be null")
	private String state;

	@NotNull(message = "Pincode cannot be null")
	@Pattern(regexp = "[0-9]{6}", message = "Pincode not valid. Must be 6 digits")
	private String pincode;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	
	public Address(String streetNo, String buildingName, String locality, String city, String state, String pincode) {
		this.streetNo = streetNo;
		this.buildingName = buildingName;
		this.locality = locality;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

}
