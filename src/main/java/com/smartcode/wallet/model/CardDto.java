package com.smartcode.wallet.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardDto {

    private String name;

    private String cardNumber;

    private String expDate;

    private Integer userId;
}
