package com.angelsepulveda.apirestsistemahotel.services;

import com.angelsepulveda.apirestsistemahotel.dtos.ServiceRoomDto;
import com.angelsepulveda.apirestsistemahotel.mappers.contracts.BaseMapper;
import com.angelsepulveda.apirestsistemahotel.models.ServiceRoom;
import com.angelsepulveda.apirestsistemahotel.repositories.BaseRepository;
import com.angelsepulveda.apirestsistemahotel.repositories.ServiceRoomRepository;
import com.angelsepulveda.apirestsistemahotel.services.contracts.ServiceRoomService;
import com.angelsepulveda.apirestsistemahotel.validators.contracts.BaseValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ServiceRoomServiceImpl extends BaseServiceImpl<ServiceRoom, ServiceRoomDto,Long> implements ServiceRoomService {

    @Autowired
    private ServiceRoomRepository serviceRoomRepository;

    public ServiceRoomServiceImpl(BaseRepository<ServiceRoom,Long> repository, BaseValidator<ServiceRoom> validator,
                           BaseMapper<ServiceRoom, ServiceRoomDto> mapper){
        super(repository,validator,mapper);
    }

    @Override
    public void deactivate(Long id) throws Exception {
        try{
            this.serviceRoomRepository.changeState(false,id);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public void activate(Long id) throws Exception {
        try{
            this.serviceRoomRepository.changeState(true,id);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
