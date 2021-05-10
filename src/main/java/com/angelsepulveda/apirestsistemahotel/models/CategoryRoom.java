package com.angelsepulveda.apirestsistemahotel.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "categories_rooms")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRoom{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;
    
    @Size(min = 3, max = 50, message = "El nombre debe tener un minimo de 3 y un maximo de 50 caracteres")
    @Column(name = "name", length = 50, unique = true, nullable = false)
    private String name;

    @NotNull(message = "El precio es requerido")
    @Column(name = "price", nullable = false)
    private Double price;

    @Size(max = 256, message = "La descripcion no debe superar los 256 caracteres")
    @Column(name = "description",length = 256, nullable = true)
    private String description;

    @NotNull(message = "el estado es requerido")
    @Column(name = "state", nullable = false)
    private Boolean state;
}
