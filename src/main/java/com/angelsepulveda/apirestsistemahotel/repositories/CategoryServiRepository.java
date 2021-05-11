package com.angelsepulveda.apirestsistemahotel.repositories;

import com.angelsepulveda.apirestsistemahotel.models.CategoryServi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryServiRepository extends BaseRepository<CategoryServi,Long>{

    @Query(value = "SELECT c FROM CategoryServi c WHERE c.name LIKE %:filter% OR c.description LIKE %:filter%")
    Page<CategoryServi> search(@Param("filter") String filter, Pageable pageable);

    @Modifying
    @Query(value = "UPDATE CategoryServi c SET c.state=:value WHERE c.id=:id")
    void changeState(@Param("value") Boolean value, @Param("id") Long id);
}
