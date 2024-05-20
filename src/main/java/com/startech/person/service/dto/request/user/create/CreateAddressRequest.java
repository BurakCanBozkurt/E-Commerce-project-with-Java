package com.startech.person.service.dto.request.user.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAddressRequest {
	private UUID userId;
	private String title;
	private String firstName;
	private String lastName;
	private String mobileNo;
	private String addressLine1;
	private String direction;
	private String country;
	private String city;
	private String district;
	private String neighbourhood;
	private String zipCode;
}