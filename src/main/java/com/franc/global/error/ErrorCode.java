package com.franc.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    // Test Error
    TEST_ERROR(10000, HttpStatus.BAD_REQUEST, "임의 에러입니다."),
    REQUEST_ARGUMENT_NOT_VALID(10001, HttpStatus.BAD_REQUEST, "잘못된 요청 양식입니다."),
    ACCOUNT_NOT_FOUND(10002, HttpStatus.BAD_REQUEST, "사용자를 찾을 수 없습니다."),
    ACCOUNT_EXISTS(10003, HttpStatus.BAD_REQUEST, "이미 가입된 사용자입니다."),
    // 404 Not Found
    NOT_FOUND_END_POINT(40400, HttpStatus.NOT_FOUND, "존재하지 않는 API입니다."),
    // 500 Internal Server Error
    INTERNAL_SERVER_ERROR(50000, HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류입니다.");

    private final Integer code;
    private final HttpStatus httpStatus;
    private final String message;
}
