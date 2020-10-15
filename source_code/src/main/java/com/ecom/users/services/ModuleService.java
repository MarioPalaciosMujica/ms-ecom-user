package com.ecom.users.services;

import com.ecom.users.dalc.entities.Module;
import com.ecom.users.dalc.repositories.IModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ModuleService {

    @Autowired private IModuleRepository moduleRepository;

    public Module save(@NotNull Module entity){
        entity.setIdModule(null);
        entity = moduleRepository.save(entity);
        return entity;
    }

    public Module findById(@NotNull Long id){
        Optional<Module> entity = moduleRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else {
            return null;
        }
    }

    public List<Module> findAll(){
        return moduleRepository.findAll();
    }

    public boolean update(@NotNull Module entity){
        Module original = this.findById( entity.getIdModule());
        if(original != null){
            moduleRepository.save(entity);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean deleteById(@NotNull Long id){
        if(this.findById(id) != null){
            moduleRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }
}
