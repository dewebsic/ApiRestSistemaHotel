package com.angelsepulveda.apirestsistemahotel.models;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "customers")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseModel{

    @ManyToOne
    @JoinColumn(name = "id_document_type", nullable = false, foreignKey = @ForeignKey(name = "FK_customer_document_type"))
    private DocumentType documentType;

    @Column(name = "name", length = 150, nullable = false)
    private String businessName;

    @Column(name = "commercial_name", length = 256, nullable = true)
    private String commercialName;

    @Column(name = "document_number", length = 30, nullable = false, unique = true)
    private String documentNumber;

    @Column(name = "nationality", length = 50, nullable = false)
    private String nationality;

    @Column(name = "address", length = 150, nullable = true)
    private String address;

    @Column(name = "phone_number", length = 30, nullable = true)
    private String phoneNumber;

    @Column(name = "email", length = 200, nullable = true)
    private String email;

    @Column(name = "state", nullable = false)
    private Boolean state;

}
