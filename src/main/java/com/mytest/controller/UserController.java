package com.mytest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mytest.controller.mapper.UserMapper;
import com.mytest.datatransferobject.UserDTO;
import com.mytest.domainobject.UserDO;
import com.mytest.exception.ConstraintsViolationException;
import com.mytest.exception.EntityNotFoundException;
import com.mytest.service.user.UserService;

/**
 * All operations with a user will be routed by this controller.
 * <p/>
 */
@RestController
@RequestMapping("api/user")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(final UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserDTO createUser(@Valid @RequestBody UserDTO userDTO) throws ConstraintsViolationException {
		UserDO userDO = UserMapper.makeUserDO(userDTO);
		
		return UserMapper.makeUserDTO(userService.create(userDO));
	}


	@GetMapping("/{userid}")
	public UserDTO findUser(@Valid @PathVariable String userid) throws ConstraintsViolationException, EntityNotFoundException {
		return UserMapper.makeUserDTO(userService.find(userid));
	}

	@GetMapping
	public List<UserDTO> findUsers() throws ConstraintsViolationException, EntityNotFoundException {
		return UserMapper.makeUserDTOList(userService.findAll());
	}
}
