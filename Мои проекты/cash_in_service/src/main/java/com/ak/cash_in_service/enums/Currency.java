package com.ak.cash_in_service.enums;

import lombok.Getter;

/**
 * @author Abubakir Dev
 */
@Getter
public enum Currency {
    KGS("Кыргызский сом"),
    RUB("Российский рубль"),
    USD("Доллар США"),
    EUR("Евро");

    private final String name;

    Currency(String name) {
        this.name = name;
    }
}
