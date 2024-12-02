package com.franc.domain.account.controller;

import com.franc.domain.account.dto.AccountGetDTO;
import com.franc.domain.account.service.AccountFacade;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    1. DTO 구현
    2. Request Valid
    3. 공통예외처리
    4. 공통응답
    5. BizException
 */

/**
 * [사용자] Controller (Controller > Facade > Service > Dao)
 */
@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    private final AccountFacade accountFacade;

    /**
     * 사용자조회
     * @param accountId
     * @return
     * @throws Exception
     */
    @GetMapping("/v1.0/{accountId}")
    public ResponseEntity<?> getAccount(
            @PathVariable("accountId") Long accountId) throws Exception {

        AccountGetDTO.Response response = accountFacade.getAccount(accountId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
