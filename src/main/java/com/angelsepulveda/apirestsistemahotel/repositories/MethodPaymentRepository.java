package com.angelsepulveda.apirestsistemahotel.repositories;

import com.angelsepulveda.apirestsistemahotel.models.MethodPayment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MethodPaymentRepository extends BaseRepository<MethodPayment,Long>{

    @Query(value = "SELECT m FROM MethodPayment m WHERE m.name LIKE %:filter% OR m.description LIKE %:filter%")
    Page<MethodPayment> search(@Param("filter") String filter, Pageable pageable);

    @Modifying
    @Query(value = "UPDATE MethodPayment m SET m.state=:value WHERE m.id=:id")
    void changeState(@Param("value") Boolean value, @Param("id") Long id);
}
