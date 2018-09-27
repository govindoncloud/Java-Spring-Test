package com.mytest.service.user;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mytest.dataaccessobject.UserRepository;
import com.mytest.domainobject.UserDO;
import com.mytest.exception.ConstraintsViolationException;
import com.mytest.exception.EntityNotFoundException;

/**
 * Service to encapsulate the link between DAO and controller and to have
 * business logic for some user specific things.
 * <p/>
 */
@Service
public class DefaultUserService implements UserService {

	private static org.slf4j.Logger LOG = LoggerFactory.getLogger(DefaultUserService.class);

	private final UserRepository userRepository;

	public DefaultUserService(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/**
	 * Selects a user by id.
	 *
	 * @param userId
	 * @return found user
	 * @throws EntityNotFoundException
	 *             if no user with the given id was found.
	 */
	@Override
	public UserDO find(String userid) throws EntityNotFoundException {

		UserDO userDO = userRepository.findByUserid(userid);
		if (userDO == null)
			throw new EntityNotFoundException("User " + userid + " not found");

		return userDO;

	}

	/**
	 * Creates a new user.
	 *
	 * @param userO
	 * @return
	 * @throws ConstraintsViolationException
	 *             if a user already exists with the given license plate, ... .
	 */
	@Override
	public UserDO create(UserDO userDO) throws ConstraintsViolationException {
		UserDO user;
		try {

			user = userRepository.save(userDO);
		} catch (DataIntegrityViolationException e) {
			LOG.warn("Some constraints are thrown due to user creation", e);
			throw new ConstraintsViolationException(e.getMessage());
		}
		return user;
	}

	/**
	 * Deletes an existing user by id.
	 *
	 * @param userId
	 * @throws EntityNotFoundException
	 *             if no user with the given id was found.
	 */
	@Override
	@Transactional
	public void delete(String userid) throws EntityNotFoundException {
		UserDO userDO = find(userid);
		userDO.setDeleted(true);
	}

	/**
	 * Deletes an existing user by id.
	 *
	 * @param userId
	 * @throws EntityNotFoundException
	 *             if no user with the given id was found.
	 */
	@Override
	@Transactional
	public List<UserDO> findAll() throws EntityNotFoundException {
		List<UserDO> userDOList = (List<UserDO>) userRepository.findAll();
		return userDOList;
	}

}
