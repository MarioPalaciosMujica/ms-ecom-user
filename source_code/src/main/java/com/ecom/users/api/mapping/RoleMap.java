package com.ecom.users.api.mapping;

import com.ecom.users.api.models.RoleModel;
import com.ecom.users.dalc.entities.Role;
import com.ecom.users.tools.DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class RoleMap {

    @Autowired private PermissionMap permissionMap;
    @Autowired private DateFormat dateFormat;

    public RoleModel toModel(Role entity){
        if(entity != null){
            RoleModel model = new RoleModel();
            model.setIdRole(entity.getIdRole());
            model.setRoleName(entity.getRoleName());
            model.setActive(entity.isActive());
            model.setCreated(dateFormat.dateToString(entity.getCreated()));
            model.setModified(dateFormat.dateToString(entity.getModified()));
            model.setPermissions(permissionMap.toModelList(new ArrayList<>(entity.getPermissions())));
            return model;
        }
        else{
            return null;
        }
    }

    public Role toEntity(RoleModel model){
        if(model != null){
            Role entity = new Role();
            entity.setIdRole(model.getIdRole());
            entity.setRoleName(model.getRoleName());
            entity.setActive(model.isActive());
            entity.setCreated(dateFormat.stringToDate(model.getCreated()));
            entity.setModified(dateFormat.stringToDate(model.getModified()));
            entity.setPermissions(new HashSet<>(permissionMap.toEntityList(model.getPermissions())));
            return entity;
        }
        else{
            return null;
        }
    }

    public List<RoleModel> toModelList(List<Role> listEntity){
        List<RoleModel> modelList = new ArrayList<>();
        for (Role entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<Role> toEntityList(List<RoleModel> listModel){
        List<Role> entityList = new ArrayList<>();
        for (RoleModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
