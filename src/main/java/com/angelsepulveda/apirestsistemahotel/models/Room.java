package com.angelsepulveda.apirestsistemahotel.models;

import lombok.*;

import javax.persistence.*;

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

    @Column(name = "room_number", length = 10, nullable = false, unique = true)
    private String roomNumber;

    @Column(name = "floor_number", length = 5, nullable = true)
    private String floorNumber;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @Column(name = "description",length = 256, nullable = true)
    private String description;

    @Column(name = "state", nullable = false)
    private Boolean state;
}
