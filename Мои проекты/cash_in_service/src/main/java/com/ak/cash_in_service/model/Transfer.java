package com.ak.cash_in_service.model;

import com.ak.cash_in_service.enums.Currency;
import com.ak.cash_in_service.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Abubakir Dev
 */
@Entity
@Table(name = "transfers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "source_id", nullable = false)
    private User source;

    @ManyToOne
    @JoinColumn(name = "destination_id", nullable = false)
    private User destination;

    private Double amount;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @Enumerated(EnumType.STRING)
    private Status status;
}
