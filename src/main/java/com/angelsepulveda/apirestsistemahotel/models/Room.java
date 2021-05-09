package com.angelsepulveda.apirestsistemahotel.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "rooms")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room extends BaseModel{

    @ManyToOne
    @JoinColumn(name = "id_category_room", nullable = false, foreignKey = @ForeignKey(name = "FK_room_category"))
    private CategoryRoom categoryRoom;

    @NotBlank(message = "el numero de habitación no debe ser vació")
    @Size(max = 10, message = "el numero de habitación no debe superar los 10 caracteres")
    @Column(name = "room_number", length = 10, nullable = false, unique = true)
    private String roomNumber;

    @Size(max = 5, message = "el numero de piso no debe superar los 5 caracteres")
    @Column(name = "floor_number", length = 5, nullable = true)
    private String floorNumber;

    @NotNull(message = "La capacidad es requerida")
    @Column(name = "capacity", nullable = false)
    private int capacity;

    @Size(max = 256, message = "la descripción no debe superar los 256 caracteres")
    @Column(name = "description",length = 256, nullable = true)
    private String description;

    @NotNull(message = "el estado es requerido")
    @Column(name = "state", nullable = false)
    private Boolean state;
}
