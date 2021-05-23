package com.angelsepulveda.apirestsistemahotel.services.contracts;

import com.angelsepulveda.apirestsistemahotel.dtos.ServiceRoomDto;
import com.angelsepulveda.apirestsistemahotel.models.ServiceRoom;

public interface ServiceRoomService extends BaseService<ServiceRoom, ServiceRoomDto,Long>{

    void deactivate(Long id) throws Exception;
    void activate(Long id) throws Exception;

}
