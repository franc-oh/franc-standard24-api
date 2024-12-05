package com.franc.domain.account.dto;

import com.franc.domain.account.domain.Account;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * DTO - 사용자등록
 */
public record AccountSaveDTO() {

    /**
     * Request
     * @param name
     * @param email
     * @param age
     */
    public record Request(
            @NotBlank
            String name,
            @Email
            String email,
            @Min(19)
            Integer age
    ) {

    }
}
