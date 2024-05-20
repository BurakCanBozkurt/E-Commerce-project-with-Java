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
public class GetAllUsersResponse {
	private UUID id;
	private Date createdAt;
	private Date updatedAt;
	private String name;
	private String surname;
	private String nameSurname;
	private String gender;
	private boolean campaignNotification;
	private Date birthDate;
	private String email;
	private String password;
	private String phone1;
	private String phone2;
}