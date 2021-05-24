package com.angelsepulveda.apirestsistemahotel.services.contracts;

import com.angelsepulveda.apirestsistemahotel.dtos.ReservationDto;
import com.angelsepulveda.apirestsistemahotel.models.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReservationService {

    public List<Reservation> findAll() throws Exception;
    public Page<Reservation> findAll(Pageable pageable) throws Exception;
    public Reservation findById(Long id) throws Exception;
    public Reservation save(ReservationDto dto) throws Exception;
    void cancel(Long id) throws Exception;
}
