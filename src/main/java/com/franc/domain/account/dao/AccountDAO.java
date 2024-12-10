package com.franc.domain.account.dao;

import com.franc.domain.account.domain.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountDAO {
    Account findById(@Param("accountId") Long accountId) throws Exception;
    Account findByEmail(@Param("email") String email) throws Exception;
    void save(Account account) throws Exception;
}
