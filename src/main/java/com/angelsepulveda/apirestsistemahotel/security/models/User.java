package com.angelsepulveda.apirestsistemahotel.security.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 3, max = 100, message = "El nombre debe tener un minimo de 3 y un maximo de 100 caracteres")
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Size(min = 3, max = 100, message = "El apellido debe tener un minimo de 3 y un maximo de 100 caracteres")
    @Column(name = "lastname", length = 100, nullable = false)
    private String lastName;

    @Size(max = 150, message = "La dirección no debe superar los 150 caracteres")
    @Column(name = "address", length = 150, nullable = true)
    private String address;

    @Size(max = 30, message = "El telefono no debe superar los 30 caracteres")
    @Column(name = "phone_number", length = 30, nullable = true)
    private String phoneNumber;

    @Email(message = "El email debe ser valido")
    @Column(name = "email", length = 200, nullable = true)
    private String email;

    @Column(name = "email", length = 256, nullable = false)
    private String passoword;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns  = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Role> roles = new HashSet<>();

    @NotNull(message = "el estado es requerido")
    @Column(name = "state", nullable = false)
    private Boolean state;
}
