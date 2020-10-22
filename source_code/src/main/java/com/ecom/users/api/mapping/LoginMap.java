package com.ecom.users.api.mapping;

import com.ecom.users.api.models.LoginModel;
import com.ecom.users.dalc.entities.Login;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LoginMap {

    public LoginModel toModel(Login entity){
        if(entity != null){
            LoginModel model = new LoginModel();
            model.setUsername(entity.getUsername());
            model.setPassword(entity.getPassword());
            return model;
        }
        else{
            return null;
        }
    }

    public Login toEntity(LoginModel model){
        if(model != null){
            Login entity = new Login();
            entity.setUsername(model.getUsername());
            entity.setPassword(model.getPassword());
            return entity;
        }
        else{
            return null;
        }
    }

    public List<LoginModel> toModelList(List<Login> listEntity){
        List<LoginModel> modelList = new ArrayList<>();
        for (Login entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<Login> toEntityList(List<LoginModel> listModel){
        List<Login> entityList = new ArrayList<>();
        for (LoginModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
