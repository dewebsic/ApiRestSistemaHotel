package com.angelsepulveda.apirestsistemahotel.services;

import com.angelsepulveda.apirestsistemahotel.dtos.CategoryServiDto;
import com.angelsepulveda.apirestsistemahotel.mappers.contracts.BaseMapper;
import com.angelsepulveda.apirestsistemahotel.models.CategoryServi;
import com.angelsepulveda.apirestsistemahotel.repositories.BaseRepository;
import com.angelsepulveda.apirestsistemahotel.repositories.CategoryServiRepository;
import com.angelsepulveda.apirestsistemahotel.services.contracts.CategoryServiService;
import com.angelsepulveda.apirestsistemahotel.validators.contracts.BaseValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CategoryServiServiceImpl extends BaseServiceImpl<CategoryServi, CategoryServiDto,Long> implements CategoryServiService {

    @Autowired
    private CategoryServiRepository categoryServiRepository;

    public CategoryServiServiceImpl(BaseRepository<CategoryServi,Long> repository, BaseValidator<CategoryServi> validator,
                                   BaseMapper<CategoryServi, CategoryServiDto> mapper){
        super(repository,validator,mapper);
    }


    @Override
    public Page<CategoryServi> search(String filter, Pageable pageable) throws Exception {
        try{
            return this.categoryServiRepository.search(filter,pageable);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public void deactivate(Long id) throws Exception {
        try{
            this.categoryServiRepository.changeState(false,id);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public void activate(Long id) throws Exception {
        try{
            this.categoryServiRepository.changeState(true,id);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
