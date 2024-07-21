package com.ak.cash_in_service.dto.request;

import com.ak.cash_in_service.enums.Currency;
import com.ak.cash_in_service.enums.Status;
import com.ak.cash_in_service.model.Body;
import com.ak.cash_in_service.model.Payee;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Abubakir Dev
 */
@Getter
@Setter
public class SendBalanceByPhoneNumber {
    private Long sourceId;
    private String balance;
    private Currency currency;
    private Payee payee;
    private Body body;
    private String qid;
    private Status status;
    private String msg;
}
