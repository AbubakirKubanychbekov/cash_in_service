package com.ak.cash_in_service.model;

import com.ak.cash_in_service.enums.Currency;
import com.ak.cash_in_service.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Abubakir Dev
 */
@Entity
@Table(name = "bodies")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Body {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "supplier_id")
    private Long supplierId;
    @Column(name = "account")
    private String account;
    @Column(name = "id_series_number")
    private String idSeriesNumber;
    @Column(name = "sender_fio")
    private String senderFio;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "sum")
    private BigDecimal sum;
    @Column(name = "currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @Column(name = "payee_currency")
    @Enumerated(EnumType.STRING)
    private Currency payeeCurrency;
    @Column(name = "curr_rate")
    private BigDecimal currRate;
    @Column(name = "sva_available_limit")
    private BigDecimal svaAvailableLimit;
    @Enumerated(EnumType.STRING)
    private Status status;
}
