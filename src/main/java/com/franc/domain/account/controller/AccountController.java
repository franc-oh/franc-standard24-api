package com.franc.domain.account.controller;

import com.franc.domain.account.dto.AccountGetDTO;
import com.franc.domain.account.dto.AccountSaveDTO;
import com.franc.domain.account.service.AccountFacade;
import com.franc.global.common.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
@Validated
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
    public ApiResponse<?> getAccount(
            @PathVariable("accountId") @NotNull @Min(1L) Long accountId) throws Exception {

        AccountGetDTO.Response response = accountFacade.getAccount(accountId);

        return ApiResponse.ok(response);
    }


    /**
     * 사용자등록
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/v1.0")
    public ApiResponse<?> saveAccount(@RequestBody @Valid AccountSaveDTO.Request request) throws Exception {

        logger.info("Request : {}", request); // 유효성 성공 시 출력

        return ApiResponse.ok("ok");
    }

}
