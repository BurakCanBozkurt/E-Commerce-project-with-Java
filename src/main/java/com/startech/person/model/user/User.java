package com.startech.person.model.user;

import java.util.Date;
import java.util.Set;
import java.util.UUID;


import jakarta.persistence.*;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user", schema = "person")
public class User {

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
	@Column(nullable = false, length = 32)
	@Length(min = 1, max = 32)
	private String name;

	@NotNull
	@Column(nullable = false, length = 32)
	@Length(min = 1, max = 32)
	private String surname;

	@Column(nullable = false, length = 65)
	@Formula("concat(name,' ',surname)")
	private String nameSurname;

	@Column(nullable = false)
	private String gender;

	@Temporal(TemporalType.DATE)
	@Column(nullable = true)
	@JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Istanbul")
	Date birthDate;

	@Column(nullable = false, length = 64,unique = true)
	@Length(min = 0, max = 64)
	private String email;

	@Column(nullable = true, length = 24)
	@Length(min = 0, max = 24)
	private String phone1;

	@NotNull
   	@Column(columnDefinition = "boolean default true", nullable = false)
	private boolean campaignNotification;

	@Column(nullable = false, length = 128)
	@Length(min = 0, max = 128)
	private String password;

	@NotNull
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			schema = "person",
			name = "user_roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> role;
}
