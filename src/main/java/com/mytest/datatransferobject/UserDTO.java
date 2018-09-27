package com.mytest.datatransferobject;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
	@JsonIgnore
	private Long id;

	@NotNull(message = "Userid can not be null!")
	private String userid;

	@NotNull(message = "FirstName can not be null!")
	private String firstName;

	@NotNull(message = "lastName can not be null!")
	private String lastName;

	@NotNull(message = "Password can not be null!")
	private String password;

	private UserDTO() {
	}

	private UserDTO(Long id, String userid, String firstName, String lastName, String password) {
		this.id = id;
		this.userid = userid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;

	}

	public static UserDTOBuilder newBuilder() {
		return new UserDTOBuilder();
	}

	@JsonProperty
	public Long getId() {
		return id;
	}

	public String getUserid() {
		return userid;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	public static class UserDTOBuilder {
		private Long id;
		private String userid;
		private String firstName;
		private String lastName;
		private String password;

		public UserDTOBuilder setId(Long id) {
			this.id = id;
			return this;
		}

		public UserDTOBuilder setUserid(String userid) {
			this.userid = userid;
			return this;
		}

		public UserDTOBuilder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public UserDTOBuilder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public UserDTOBuilder setPassword(String password) {
			this.password = password;
			return this;
		}

		public UserDTO createUserDTO() {
			UserDTO user = new UserDTO(id, userid, firstName, lastName, password);

			return user;
		}

	}

}
