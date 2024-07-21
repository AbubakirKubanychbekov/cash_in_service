package com.ak.cash_in_service.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Abubakir Dev
 */
@Getter
public enum Status {
    successfully(200, "проверка прощла успешно"),
    pending(249, "В обработке"),
    paymentCompletedSuccessfully(250,"платеж успешно проведен"),
    undocumented(400,"недокументированная ошибка"),
    incorrectRequestFormat(401,"неправильный формат запроса"),
    theDataIsFilledInIncorrectly(420,"данные заполнены некорректно"),
    serviceIsTemporarilyUnavailable(424,"сервис времмено не доступен"),
    payerNotFoundInTheSystem(431,"плательщик не найден в системе"),
    payerBlocked(432,"плательщик заблокирован"),
    activePayerAccountNotFoundInTheSystem(435,"активный счет плательщика не найден в системе"),
    recipientNotFoundInTheSystem(441,"получатель не найден в системе"),
    recipientBlocked(442,"получатель заблокирован"),
    theRecipientsActiveAccountWasNotFoundInTheSystem(445,"активный счет получателя не найден в системе"),
    operationRejected_AllowedBalanceExceeded(447,"операция отклонена : превышен допустимый баланс");

    private final int code;
    private final String description;

    Status(int code, String description) {
        this.code = code;
        this.description = description;
    }
}
