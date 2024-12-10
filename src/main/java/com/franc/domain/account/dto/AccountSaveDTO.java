package com.franc.domain.account.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

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
            Integer age,
            LocalDateTime dt
    ) {

    }
}
