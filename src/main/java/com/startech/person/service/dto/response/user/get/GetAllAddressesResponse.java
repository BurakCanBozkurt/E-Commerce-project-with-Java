package com.startech.person.service.dto.response.user.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllAddressesResponse {
	private UUID id;
	private Date createdAt;
	private Date updatedAt;
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
