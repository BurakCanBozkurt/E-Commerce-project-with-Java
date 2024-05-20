package com.startech.person.service.dto.response.user.create;

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
public class CreateUserResponse {
	private UUID id;
	private UUID roleId;
	private UUID roleName;
	private Date createdAt;
	private Date updatedAt;
	private String name;
	private String surname;
	private String nameSurname;
	private String gender;
	private boolean campaignNotification;
	private Date birthDate;
	private String email;
	private String phone1;
	private String phone2;
}
