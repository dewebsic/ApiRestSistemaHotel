package com.angelsepulveda.apirestsistemahotel.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "customers")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "id_document_type", nullable = false, foreignKey = @ForeignKey(name = "FK_customer_document_type"))
    private DocumentType documentType;

    @Size(min = 3, max = 150, message = "La razón social debe tener un minimo de 3 y un maximo de 150 caracteres")
    @Column(name = "name", length = 150, nullable = false)
    private String businessName;

    @Size(max = 256, message = "El giró comercial no debe superar los 256 caracteres")
    @Column(name = "commercial_name", length = 256, nullable = true)
    private String commercialName;

    @Size(min = 6, max = 30, message = "El numero de documento debe tener un minimo de 6 y un maximo de 30 caracteres")
    @Column(name = "document_number", length = 30, nullable = false, unique = true)
    private String documentNumber;

    @Size(min = 5, max = 50, message = "La nacionalidad debe tener un minimo de 5 y un maximo de 50 caracteres")
    @Column(name = "nationality", length = 50, nullable = false)
    private String nationality;

    @Size(max = 150, message = "La dirección no debe superar los 150 caracteres")
    @Column(name = "address", length = 150, nullable = true)
    private String address;

    @Size(max = 30, message = "El telefono no debe superar los 30 caracteres")
    @Column(name = "phone_number", length = 30, nullable = true)
    private String phoneNumber;

    @Email(message = "El email debe ser valido")
    @Column(name = "email", length = 200, nullable = true)
    private String email;

    @NotNull(message = "el estado es requerido")
    @Column(name = "state", nullable = false)
    private Boolean state;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getId().equals(customer.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
