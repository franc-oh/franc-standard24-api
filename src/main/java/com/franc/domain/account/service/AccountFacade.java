package com.franc.domain.account.service;

import com.franc.domain.account.domain.Account;
import com.franc.domain.account.dto.AccountGetDTO;
import com.franc.domain.account.dto.AccountSaveDTO;
import com.franc.global.error.BizException;
import com.franc.global.error.ErrorCode;
import com.franc.global.util.FrancUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * [사용자] Facade (Controller > Facade > Service > Dao)
 *  - 하나의 엔드포인트에 대한 비즈니스로직을 담당
 *      - Service의 개별 기능들을 조립 > 비즈니스 로직을 구현
 *      - Transaction 설정
 */
@Component
@RequiredArgsConstructor
public class AccountFacade {
    private static final Logger logger = LoggerFactory.getLogger(AccountFacade.class);

    private final AccountService accountService;

    /**
     * 사용자 조회
     * @param accountId
     * @return
     */
    public AccountGetDTO.Response getAccount(Long accountId) throws Exception {

        // #1. 사용자 조회
        Account account = FrancUtil.isNullThrowBizException(
                accountService.findAccount(accountId), ErrorCode.ACCOUNT_NOT_FOUND);

        return AccountGetDTO.Response.fromEntity(account);

    }

    /**
     * 사용자 등록
     * @param request
     * @throws Exception
     */
    public void saveAccount(AccountSaveDTO.Request request) throws Exception {

        // #1. 이미 사용자가 있는지?
        if(FrancUtil.isNotNull(accountService.findAccountByEmail(request.email()))) {
            throw new BizException(ErrorCode.ACCOUNT_EXISTS);
        }

        accountService.saveAccount(AccountSaveDTO.Request.toEntity(request));
    }
}
