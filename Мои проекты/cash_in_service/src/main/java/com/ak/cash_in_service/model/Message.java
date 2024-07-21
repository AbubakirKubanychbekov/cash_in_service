package com.ak.cash_in_service.model;

import com.ak.cash_in_service.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Abubakir Dev
 */
@Entity
@Table(name = "messages")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "dts_requests")
    LocalDateTime dtsRequest;
    @Column(name = "dts_responses")
    LocalDateTime dtsResponses;
    @Column(name = "qid")
    String qid;
    @Enumerated(EnumType.STRING)
    Status status;
    @Column(name = "msg")
    String msg;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "body_id")
    Body body;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payee_id")
    Payee payee;
    @Column(name = "sender_id")
    Long senderId;
    @Column(name = "sender_services")
    String senderServices;
    @Column(name = "sender_phone")
    String senderPhone;
    @ManyToOne
    @JoinColumn(name = "source_id", nullable = false)
    User source;
    @ManyToOne
    @JoinColumn(name = "destination_id", nullable = false)
    User destination;
}
