package com.angelsepulveda.apirestsistemahotel.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "method_payments")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class MethodPayment extends BaseModel{

    @Column(name = "name", length = 30, unique = true, nullable = false)
    private String name;

    @Column(name = "description",length = 256, nullable = true)
    private String description;

    @Column(name = "state", nullable = false)
    private Boolean state;

}
