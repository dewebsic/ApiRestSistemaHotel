package com.angelsepulveda.apirestsistemahotel.services;

import com.angelsepulveda.apirestsistemahotel.dtos.ReservationDto;
import com.angelsepulveda.apirestsistemahotel.exceptions.ModelNotFoundException;
import com.angelsepulveda.apirestsistemahotel.mappers.contracts.ReservationMapper;
import com.angelsepulveda.apirestsistemahotel.models.Reservation;
import com.angelsepulveda.apirestsistemahotel.repositories.ReservationRepository;
import com.angelsepulveda.apirestsistemahotel.services.contracts.ReservationService;
import com.angelsepulveda.apirestsistemahotel.validators.contracts.ReservationValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    private final ReservationMapper reservationMapper;
    private final ReservationRepository reservationRepository;
    private final ReservationValidator reservationValidator;

    public ReservationServiceImpl(ReservationMapper reservationMapper, ReservationRepository reservationRepository,
                                  ReservationValidator reservationValidator) {
        this.reservationMapper = reservationMapper;
        this.reservationRepository = reservationRepository;
        this.reservationValidator = reservationValidator;
    }

    @Override
    public List<Reservation> findAll() throws Exception {

        try{

            return this.reservationRepository.findAll();

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Reservation> findAll(Pageable pageable) throws Exception {

        try{
            return this.reservationRepository.findAll(pageable);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public Reservation findById(Long id) throws Exception {

        Optional<Reservation> optionalEntity = this.reservationRepository.findById(id);

        //validamos si existe
        if(!optionalEntity.isPresent()){
            throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
        }

        return optionalEntity.get();
    }

    @Override
    public Reservation save(ReservationDto dto) throws Exception {

        try{

            Reservation entity = this.reservationMapper.fromDto(dto);
            //validaciones
            this.reservationValidator.validate(entity);

            return this.reservationRepository.save(entity);

        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }

    }

    @Override
    public void cancel(Long id) throws Exception {
        try{
            this.reservationRepository.changeState("Anulado",id);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
