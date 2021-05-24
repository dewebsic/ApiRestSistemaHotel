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
@Table(name = "reservations")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_customer", nullable = false, foreignKey = @ForeignKey(name = "FK_customer_reservation"))
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false, foreignKey = @ForeignKey(name = "FK_user_reservation"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_room", nullable = false, foreignKey = @ForeignKey(name = "FK_room_reservation"))
    private Room room;


    @Column(name="registration_date", nullable = false, updatable = false)
    private String registrationDate;

    @Size(max = 15, message = "La fecha de entrada no debe superar los 15 caracteres")
    @Column(name = "start",length = 15, nullable = false)
    private String start;

    @Size(max = 15, message = "La fecha de salida no debe superar los 15 caracteres")
    @Column(name = "end",length = 15, nullable = false)
    private String end;

    @NotNull
    @Column(name = "guest_number",nullable = false)
    private int guestNumber;

    @Size(max = 20, message = "el estado no debe superar los 20 caracteres")
    @Column(name = "state",length = 20, nullable = false)
    private String state;

}
