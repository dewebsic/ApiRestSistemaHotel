package com.angelsepulveda.apirestsistemahotel.models;

import com.angelsepulveda.apirestsistemahotel.security.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false, foreignKey = @ForeignKey(name = "FK_user_payment"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_method_payment", nullable = false, foreignKey = @ForeignKey(name = "FK_method_payment_payment"))
    private MethodPayment methodPayment;

    @ManyToOne
    @JoinColumn(name = "id_reservation", nullable = false, foreignKey = @ForeignKey(name = "FK_reservation_payment"))
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name = "id_voucher_type", nullable = false, foreignKey = @ForeignKey(name = "FK_voucher_payment"))
    private VoucherType voucherType;

    @Column(name="payment_date", nullable = false, updatable = false)
    private String paymentDate;

    @NotNull
    @Column(name = "subtotal",nullable = false)
    private Double subtotal;

    @NotNull
    @Column(name = "discount",nullable = false)
    private Double discount;

    @NotNull
    @Column(name = "total",nullable = false)
    private Double total;

    @Size(max = 20, message = "el estado no debe superar los 20 caracteres")
    @Column(name = "state",length = 20, nullable = false)
    private String state;
}
