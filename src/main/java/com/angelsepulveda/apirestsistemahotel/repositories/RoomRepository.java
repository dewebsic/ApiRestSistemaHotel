package com.angelsepulveda.apirestsistemahotel.repositories;

import com.angelsepulveda.apirestsistemahotel.models.Room;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends BaseRepository<Room,Long>{

    @Modifying
    @Query(value = "UPDATE Customer c SET c.state=:value WHERE c.id=:id")
    void changeState(@Param("value") Boolean value, @Param("id") Long id);
}
