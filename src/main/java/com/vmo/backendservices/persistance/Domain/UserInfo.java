package com.vmo.backendservices.persistance.Domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "user_info")
public class UserInfo {

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
	private String userName;

	@NotEmpty(message = "User name can not be empty")
	@Column(name = "user_phone")
	private String phone;

	@NotEmpty(message = "User notification mode can not be empty")
	@Column(name = "user_notif_mode")
	private String notification;

	@NotEmpty(message = "Email can not be empty")
	@Email(message = "Please provide a valid email id")
	@Column(name = "user_email")
	private String email;

	@NotEmpty(message = "Password can not be empty")
	@Column(name = "user_password")
	private String password;

	@Column(name = "user_send_catalog")
	private boolean sendCatalog;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Address> addresses;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<RoleInfo> rolesInfo;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_movies", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "movie_id"))
	private Set<MovieInfo> movieInfo;

}
