package com.mytest.controller.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.mytest.datatransferobject.UserDTO;
import com.mytest.domainobject.UserDO;

public class UserMapper {
	public static UserDO makeUserDO(UserDTO userDTO) {
		return new UserDO(userDTO.getUserid(), userDTO.getFirstName(), userDTO.getLastName(), userDTO.getPassword());
	}

	public static UserDTO makeUserDTO(UserDO userDO) {
		UserDTO.UserDTOBuilder userDTOBuilder = UserDTO.newBuilder().setUserid(userDO.getUserid())
				.setFirstName(userDO.getfirstName()).setLastName(userDO.getLastName())
				.setPassword(userDO.getPassword());

		
		return userDTOBuilder.createUserDTO();
	}

	public static List<UserDTO> makeUserDTOList(Collection<UserDO> users) {
		return users.stream().map(UserMapper::makeUserDTO).collect(Collectors.toList());
	}
}
