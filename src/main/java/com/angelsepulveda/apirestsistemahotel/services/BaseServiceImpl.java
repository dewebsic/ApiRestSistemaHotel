package com.angelsepulveda.apirestsistemahotel.services;

import com.angelsepulveda.apirestsistemahotel.exceptions.ModelNotFoundException;
import com.angelsepulveda.apirestsistemahotel.mappers.contracts.BaseMapper;
import com.angelsepulveda.apirestsistemahotel.repositories.BaseRepository;
import com.angelsepulveda.apirestsistemahotel.services.contracts.BaseService;
import com.angelsepulveda.apirestsistemahotel.validators.contracts.BaseValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<E,D,ID extends Serializable> implements BaseService<E,D,ID> {

    protected BaseRepository<E,ID> repository;
    protected BaseValidator<E> validator;
    protected BaseMapper<E,D> mapper;

    public BaseServiceImpl(BaseRepository<E,ID> repository,BaseValidator<E> validator,
                           BaseMapper<E,D> mapper){
        this.repository = repository;
        this.validator = validator;
        this.mapper = mapper;
    }

    @Override
    public List<D> findAll() throws Exception {
        try{

            List<E> entities = this.repository.findAll();
            return this.mapper.fromEntity(entities);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<E> findAll(Pageable pageable) throws Exception{
        try{
            return this.repository.findAll(pageable);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public D findById(ID id) throws Exception {

        Optional<E> optionalEntity = this.repository.findById(id);

        //validamos si existe
        if(!optionalEntity.isPresent()){
            throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
        }

        return this.mapper.fromEntity(optionalEntity.get());
    }

    @Override
    public D save(D dto) throws Exception {
        try{

            E entity = this.mapper.fromDto(dto);
            //validaciones
            this.validator.validate(entity);

            E entityCreated = this.repository.save(entity);

            return this.mapper.fromEntity(entityCreated);

        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public D update(ID id, D dto) throws Exception {
        try {

            Optional<E> entityOptional = this.repository.findById(id);

            //validacion si existe
            if(!entityOptional.isPresent()){
                throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
            }

            E entity = this.mapper.fromDto(dto);
            E entityUpdate = entityOptional.get();
            entityUpdate = this.repository.save(entity);

            return this.mapper.fromEntity(entityUpdate);

        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
