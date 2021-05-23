package com.angelsepulveda.apirestsistemahotel.services;

import com.angelsepulveda.apirestsistemahotel.dtos.RoomDto;
import com.angelsepulveda.apirestsistemahotel.mappers.contracts.BaseMapper;
import com.angelsepulveda.apirestsistemahotel.models.Room;
import com.angelsepulveda.apirestsistemahotel.repositories.BaseRepository;
import com.angelsepulveda.apirestsistemahotel.repositories.RoomRepository;
import com.angelsepulveda.apirestsistemahotel.services.contracts.RoomService;
import com.angelsepulveda.apirestsistemahotel.validators.contracts.BaseValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoomServiceImpl extends BaseServiceImpl<Room, RoomDto,Long> implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public RoomServiceImpl(BaseRepository<Room,Long> repository, BaseValidator<Room> validator,
                               BaseMapper<Room,RoomDto> mapper){
        super(repository,validator,mapper);
    }

    @Override
    public void deactivate(Long id) throws Exception {
        try{
            this.roomRepository.changeState(false,id);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public void activate(Long id) throws Exception {

    }
}
