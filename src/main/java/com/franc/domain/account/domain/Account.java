package com.franc.domain.account.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode(of = {"accountId"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    private Long accountId;
    private String name;
    private String status;
    private String email;
    private Boolean vipYn;
    private LocalDateTime insertDate;
    private String insertUser;
    private LocalDateTime updateDate;
    private String updateUser;

}
