package com.ecom.users.services;

import com.ecom.users.dalc.entities.Role;
import com.ecom.users.dalc.repositories.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired private IRoleRepository roleRepository;

    public Role save(@NotNull Role entity){
        entity.setIdRole(null);
        entity.setCreated(new Date());
        entity = roleRepository.save(entity);
        return entity;
    }

    public Role findById(@NotNull Long id){
        Optional<Role> entity = roleRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else {
            return null;
        }
    }

    public List<Role> findAll(){
        return roleRepository.findAll();
    }

    public boolean update(@NotNull Role entity){
        Role original = this.findById( entity.getIdRole());
        if(original != null){
            entity.setModified(new Date());
            roleRepository.save(entity);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean deleteById(@NotNull Long id){
        if(this.findById(id) != null){
            roleRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }
}
