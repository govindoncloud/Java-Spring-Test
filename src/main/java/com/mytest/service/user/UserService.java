package com.mytest.service.user;

import java.util.List;

import com.mytest.domainobject.UserDO;
import com.mytest.exception.ConstraintsViolationException;
import com.mytest.exception.EntityNotFoundException;

public interface UserService {

	UserDO find(String userid) throws EntityNotFoundException;

	UserDO create(UserDO userDO) throws ConstraintsViolationException;

	void delete(String userId) throws EntityNotFoundException;

	List<UserDO> findAll() throws EntityNotFoundException;

}
