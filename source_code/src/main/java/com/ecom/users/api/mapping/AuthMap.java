package com.ecom.users.api.mapping;

import com.ecom.users.api.models.AuthModel;
import com.ecom.users.dalc.entities.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthMap {

    @Autowired private RoleMap roleMap;

    public AuthModel toModel(Auth entity){
        if(entity != null){
            AuthModel model = new AuthModel();
            model.setClientName(entity.getClientName());
            model.setToken(entity.getToken());
            model.setRole(roleMap.toModel(entity.getRole()));
            return model;
        }
        else{
            return null;
        }
    }

    public Auth toEntity(AuthModel model){
        if(model != null){
            Auth entity = new Auth();
            entity.setClientName(model.getClientName());
            entity.setToken(model.getToken());
            entity.setRole(roleMap.toEntity(model.getRole()));
            return entity;
        }
        else{
            return null;
        }
    }

    public List<AuthModel> toModelList(List<Auth> listEntity){
        List<AuthModel> modelList = new ArrayList<>();
        for (Auth entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<Auth> toEntityList(List<AuthModel> listModel){
        List<Auth> entityList = new ArrayList<>();
        for (AuthModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
