package com.franc.domain.account.domain;

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode(of = {"accountId"})
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    Long accountId;
    String name;
    String email;
    Integer age;
}
