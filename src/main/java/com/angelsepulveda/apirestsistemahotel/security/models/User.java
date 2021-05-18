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

    @Column(name = "password", length = 256, nullable = false)
    private String passoword;

    @NotNull(message = "el estado es requerido")
    @Column(name = "state", nullable = false)
    private Boolean state;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns  = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Role> roles = new HashSet<>();

    public User(String name, String lastName, String address, String phoneNumber,
                String email, String passoword, Boolean state) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passoword = passoword;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassoword() {
        return passoword;
    }

    public void setPassoword(String passoword) {
        this.passoword = passoword;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
