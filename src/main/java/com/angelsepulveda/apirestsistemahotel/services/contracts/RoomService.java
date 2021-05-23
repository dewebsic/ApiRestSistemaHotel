package com.angelsepulveda.apirestsistemahotel.services.contracts;

import com.angelsepulveda.apirestsistemahotel.dtos.RoomDto;
import com.angelsepulveda.apirestsistemahotel.models.Room;

public interface RoomService extends BaseService<Room, RoomDto,Long>{

    void deactivate(Long id) throws Exception;
    void activate(Long id) throws Exception;
}
