package com.franc.domain.account.service;

import com.franc.domain.account.dao.AccountDAO;
import com.franc.domain.account.domain.Account;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * [사용자] Service (Controller > Facade > Service > Dao)
 * - 해당 도메인의 개별 기능구현
 *      - 쿼리호출
 *      - 데이터 가공
 *      - 재사용
 */
@Service
@RequiredArgsConstructor
public class AccountService {
    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

    private final AccountDAO accountDAO;

    public Account findAccount(Long accountId) throws Exception {
        Account account = Optional.ofNullable(accountDAO.findById(accountId))
                .orElseGet(() -> null);
        return account;
    }

}
