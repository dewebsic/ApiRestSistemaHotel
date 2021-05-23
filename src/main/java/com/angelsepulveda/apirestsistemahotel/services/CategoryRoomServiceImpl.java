package com.angelsepulveda.apirestsistemahotel.services;

import com.angelsepulveda.apirestsistemahotel.dtos.CategoryRoomDto;
import com.angelsepulveda.apirestsistemahotel.mappers.contracts.BaseMapper;
import com.angelsepulveda.apirestsistemahotel.models.CategoryRoom;
import com.angelsepulveda.apirestsistemahotel.repositories.BaseRepository;
import com.angelsepulveda.apirestsistemahotel.repositories.CategoryRoomRepository;
import com.angelsepulveda.apirestsistemahotel.services.contracts.CategoryRoomService;
import com.angelsepulveda.apirestsistemahotel.validators.contracts.BaseValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CategoryRoomServiceImpl  extends BaseServiceImpl<CategoryRoom, CategoryRoomDto,Long> implements CategoryRoomService {

    @Autowired
    private CategoryRoomRepository categoryRoomRepository;

    public CategoryRoomServiceImpl(BaseRepository<CategoryRoom,Long> repository, BaseValidator<CategoryRoom> validator,
                                    BaseMapper<CategoryRoom, CategoryRoomDto> mapper){
        super(repository,validator,mapper);
    }

    @Override
    public Page<CategoryRoom> search(String filter, Pageable pageable) throws Exception {
        try{
            return this.categoryRoomRepository.search(filter,pageable);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public void deactivate(Long id) throws Exception {
        try{
            this.categoryRoomRepository.changeState(false,id);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public void activate(Long id) throws Exception {
        try{
            this.categoryRoomRepository.changeState(true,id);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
