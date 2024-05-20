package com.startech.person.model.user;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.startech.person.model.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.rest.core.annotation.RestResource;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address", schema = "person")
public class Address {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;

	@Column(nullable = false, name = "created_at")
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "Asia/Istanbul")
	private Date createdAt = new Date();

	@Column(nullable = false, name = "updated_at")
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "Asia/Istanbul")
	private Date updatedAt;

	@NotNull
	@ManyToOne()
	@RestResource(exported = false)
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private User user;

	@NotNull
	@Column(nullable = false, length = 32)
	@Length(min = 1, max = 32)
	private String firstName;

	@NotNull
	@Column(nullable = false, length = 32)
	@Length(min = 1, max = 32)
	private String lastName;

	@NotNull
	@Column(nullable = false, length = 32)
	@Length(min = 1, max = 32)
	private String title;

	@Column(nullable = true, length = 24)
	@Length(min = 0, max = 24)
	private String mobileNo;

	@Column(nullable = true, length = 1024)
	@Length(min = 0, max = 1024)
	private String addressLine1;

	@Column(nullable = true, length = 1024)
	@Length(min = 0, max = 1024)
	private String direction;

	@NotNull
	@Column(nullable = false, length = 32)
	@Length(min = 1, max = 32)
	private String country;

	@NotNull
	@Column(nullable = false, length = 32)
	@Length(min = 1, max = 32)
	private String city;

	@NotNull
	@Column(nullable = false, length = 32)
	@Length(min = 1, max = 32)
	private String district;

	@NotNull
	@Column(nullable = false, length = 32)
	@Length(min = 1, max = 32)
	private String neighbourhood;

	@NotNull
	@Column(nullable = false, length = 32)
	@Length(min = 1, max = 32)
	private String zipCode;

}
