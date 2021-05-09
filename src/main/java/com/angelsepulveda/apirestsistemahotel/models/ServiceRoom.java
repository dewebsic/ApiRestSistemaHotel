package com.angelsepulveda.apirestsistemahotel.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "service_rooms")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceRoom extends BaseModel{

    @ManyToOne
    @JoinColumn(name = "id_category_service", nullable = false, foreignKey = @ForeignKey(name = "FK_service_room_category"))
    private CategoryServi categoryServi;

    @NotNull(message = "El precio es requerido")
    @Column(name = "price", nullable = false)
    private Double price;

    @Size(max = 256, message = "la descripción no debe superar los 256 caracteres")
    @Column(name = "description",length = 256, nullable = true)
    private String description;

    @NotNull(message = "el estado es requerido")
    @Column(name = "state", nullable = false)
    private Boolean state;
}
