package com.angelsepulveda.apirestsistemahotel.models;

import lombok.*;

import javax.persistence.*;

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

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "description",length = 256, nullable = true)
    private String description;

    @Column(name = "state", nullable = false)
    private Boolean state;
}
