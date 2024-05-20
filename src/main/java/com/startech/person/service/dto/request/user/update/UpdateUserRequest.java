package com.startech.person.service.dto.request.user.update;

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
public class UpdateUserRequest {
	private UUID roleId;
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