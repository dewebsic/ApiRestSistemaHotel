package com.angelsepulveda.apirestsistemahotel.repositories;

import com.angelsepulveda.apirestsistemahotel.models.VoucherType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherTypeRepository extends BaseRepository<VoucherType,Long>{

    @Query(value = "SELECT v FROM VoucherType v WHERE v.name LIKE %:filter% OR v.description LIKE %:filter%")
    Page<VoucherType> search(@Param("filter") String filter, Pageable pageable);

    @Modifying
    @Query(value = "UPDATE VoucherType v SET v.state=:value WHERE v.id=:id")
    void changeState(@Param("value") Boolean value, @Param("id") Long id);
}
