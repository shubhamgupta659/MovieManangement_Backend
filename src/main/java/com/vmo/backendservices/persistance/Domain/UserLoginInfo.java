package com.vmo.backendservices.persistance.Domain;

import lombok.Data;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "register_user_details")
public class UserLoginInfo {

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Long userId;

	@NotEmpty(message = "First name can not be empty")
	@Column(name = "first_name")
	private String firstName;

	@NotEmpty(message = "Last name can not be empty")
	@Column(name = "last_name")
	private String lastName;

	@NotEmpty(message = "User name can not be empty")
	@Column(name = "user_name")
	private String username;

	@NotEmpty(message = "Email can not be empty")
	@Email(message = "Please provide a valid email id")
	@Column(name = "user_email")
	private String email;

	@NotEmpty(message = "Password can not be empty")
	@Column(name = "user_password")
	private String password;

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<UserRoleInfo> rolesInfo;

}
