package com.mytest.dataaccessobject;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mytest.domainobject.UserDO;

public interface UserRepository extends CrudRepository<UserDO, String>, JpaSpecificationExecutor<UserDO> {

	@Query("SELECT u FROM UserDO u where u.userid = :userid") 
	UserDO findByUserid(@Param("userid")String userid);
}
