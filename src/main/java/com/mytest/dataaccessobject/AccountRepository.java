package com.mytest.dataaccessobject;

import org.springframework.data.repository.CrudRepository;

import com.mytest.domainobject.AccountDO;

public interface AccountRepository extends CrudRepository<AccountDO, Long> {
	public AccountDO findByUsername(String username);

}
