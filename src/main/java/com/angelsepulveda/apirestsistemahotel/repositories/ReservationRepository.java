package com.angelsepulveda.apirestsistemahotel.repositories;

import com.angelsepulveda.apirestsistemahotel.models.Reservation;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends BaseRepository<Reservation,Long> {

    @Modifying
    @Query(value = "UPDATE Reservation r SET r.state=:value WHERE r.id=:id")
    void changeState(@Param("value") String value, @Param("id") Long id);
}
