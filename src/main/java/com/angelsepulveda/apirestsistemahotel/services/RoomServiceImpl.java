package com.angelsepulveda.apirestsistemahotel.services;

import com.angelsepulveda.apirestsistemahotel.exceptions.ModelNotFoundException;
import com.angelsepulveda.apirestsistemahotel.models.Room;
import com.angelsepulveda.apirestsistemahotel.repositories.RoomRepository;
import com.angelsepulveda.apirestsistemahotel.services.contracts.RoomService;
import com.angelsepulveda.apirestsistemahotel.validators.contracts.RoomValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final RoomValidator roomValidator;

    public RoomServiceImpl(RoomRepository roomRepository,
                           RoomValidator roomValidator){
        this.roomRepository = roomRepository;
        this.roomValidator = roomValidator;
    }

    @Override
    public List<Room> findAll() throws Exception {
        try{
            return this.roomRepository.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Room findById(Long id) throws Exception {

        Optional<Room> optionalRoom = this.roomRepository.findById(id);

        if(!optionalRoom.isPresent()){
            throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
        }

        return optionalRoom.get();
    }

    @Override
    public Room save(Room entity) throws Exception {

        try{

            //validaciones
            this.roomValidator.validate(entity);

            return this.roomRepository.save(entity);

        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Room update(Long id, Room entity) throws Exception {

        try {

            Optional<Room> roomOptional = this.roomRepository.findById(id);

            if(!roomOptional.isPresent()){
                throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
            }

            Room roomUpdate = roomOptional.get();
            roomUpdate = this.roomRepository.save(entity);
            return roomUpdate;

        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
