package com.ecom.users.services;

import com.ecom.users.dalc.entities.Permission;
import com.ecom.users.dalc.repositories.IPermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
public class PermissionService {

    @Autowired private IPermissionRepository permissionRepository;

    public Permission save(@NotNull Permission entity){
        entity.setIdPermission(null);
        entity = permissionRepository.save(entity);
        return entity;
    }

    public Permission findById(@NotNull Long id){
        Optional<Permission> entity = permissionRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else {
            return null;
        }
    }

    public List<Permission> findAll(){
        return permissionRepository.findAll();
    }

    public boolean update(@NotNull Permission entity){
        Permission original = this.findById( entity.getIdPermission());
        if(original != null){
            permissionRepository.save(entity);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean deleteById(@NotNull Long id){
        if(this.findById(id) != null){
            permissionRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }
}
