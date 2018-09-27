package com.mytest.domainobject;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "account", uniqueConstraints = @UniqueConstraint(name = "uc_username", columnNames = { "username" }))
public class AccountDO {
	  
	  @Id
	  private String id;
	  private String username;
	  private String password;
	  
	  public AccountDO(){}
	  
	  public AccountDO(String username, String password) {
	    this.username = username;
	    this.password = password;
	  }
	  public String getId() {
	    return id;
	  }
	  public void setId(String id) {
	    this.id = id;
	  }
	  public String getUsername() {
	    return username;
	  }
	  public void setUsername(String username) {
	    this.username = username;
	  }
	  public String getPassword() {
	    return password;
	  }
	  public void setPassword(String password) {
	    this.password = password;
	  }

	}