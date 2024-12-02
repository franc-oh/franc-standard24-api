package com.franc.domain.account.dto;

import com.franc.domain.account.domain.Account;

import java.util.Objects;

/**
 * DTO - 사용자조회
 */
public record AccountGetDTO() {

    /**
     * Response
     * @param accountId
     * @param name
     * @param email
     * @param age
     */
    public record Response(Long accountId,
                           String name,
                           String email,
                           Integer age) {


        // 빈 객체
        private static AccountGetDTO.Response empty(){
            return new AccountGetDTO.Response(null, null, null, null);
        }

        // 필드값 -> DTO
        public static AccountGetDTO.Response of(Long id, String name, String email, int age) {
            if(Objects.isNull(id)) return empty();
            return new AccountGetDTO.Response(id, name, email, age);
        }

        // Entity -> DTO
        public static AccountGetDTO.Response from(Account account) {
            if(Objects.isNull(account)) return empty();
            return new AccountGetDTO.Response(
                    account.getAccountId(),
                    account.getName(),
                    account.getEmail(),
                    account.getAge()
            );
        }

    }
}
