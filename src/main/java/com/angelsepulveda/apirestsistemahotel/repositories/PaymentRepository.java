package com.angelsepulveda.apirestsistemahotel.repositories;

import com.angelsepulveda.apirestsistemahotel.models.Payment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends BaseRepository<Payment,Long>{

    @Modifying
    @Query(value = "UPDATE Payment p SET p.state=:value WHERE p.id=:id")
    void changeState(@Param("value") String value, @Param("id") Long id);
}
