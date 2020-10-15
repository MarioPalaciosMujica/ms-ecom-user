package com.ecom.users.api.mapping;

import com.ecom.users.api.models.PermissionModel;
import com.ecom.users.dalc.entities.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PermissionMap {

    @Autowired private ModuleMap moduleMap;

    public PermissionModel toModel(Permission entity){
        if(entity != null){
            PermissionModel model = new PermissionModel();
            model.setIdPermission(entity.getIdPermission());
            model.setCreateAllowed(entity.isCreateAllowed());
            model.setRetrieveAllowed(entity.isRetrieveAllowed());
            model.setUpdateAllowed(entity.isUpdateAllowed());
            model.setDeleteAllowed(entity.isDeleteAllowed());
            model.setModule(moduleMap.toModel(entity.getModule()));
            return model;
        }
        else{
            return null;
        }
    }

    public Permission toEntity(PermissionModel model){
        if(model != null){
            Permission entity = new Permission();
            entity.setIdPermission(model.getIdPermission());
            entity.setCreateAllowed(model.isCreateAllowed());
            entity.setRetrieveAllowed(model.isRetrieveAllowed());
            entity.setUpdateAllowed(model.isUpdateAllowed());
            entity.setDeleteAllowed(model.isDeleteAllowed());
            entity.setModule(moduleMap.toEntity(model.getModule()));
            return entity;
        }
        else{
            return null;
        }
    }

    public List<PermissionModel> toModelList(List<Permission> listEntity){
        List<PermissionModel> modelList = new ArrayList<>();
        for (Permission entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<Permission> toEntityList(List<PermissionModel> listModel){
        List<Permission> entityList = new ArrayList<>();
        for (PermissionModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
