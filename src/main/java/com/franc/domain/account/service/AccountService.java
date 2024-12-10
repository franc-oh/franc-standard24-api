package com.franc.domain.account.service;

import com.franc.domain.account.dao.AccountDAO;
import com.franc.domain.account.domain.Account;
import com.franc.global.error.BizException;
import com.franc.global.error.ErrorCode;
import com.franc.global.util.FrancUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;
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
        if(FrancUtil.isNull(accountId)) return null;
        return accountDAO.findById(accountId);
    }

    public Account findAccountByEmail(String email) throws Exception {
        if(!StringUtils.hasText(email)) return null;
        return accountDAO.findByEmail(email);
    }

    public void saveAccount(Account account) throws Exception {
        if(FrancUtil.isNull(account)) {
            throw new BizException(ErrorCode.REQUEST_ARGUMENT_NOT_VALID);
        }

        accountDAO.save(account);
    }

}
