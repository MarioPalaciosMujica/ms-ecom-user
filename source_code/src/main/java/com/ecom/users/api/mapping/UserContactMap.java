package com.ecom.users.api.mapping;

import com.ecom.users.api.models.UserContactModel;
import com.ecom.users.dalc.entities.UserContact;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserContactMap {

    public UserContactModel toModel(UserContact entity){
        if(entity != null){
            UserContactModel model = new UserContactModel();
            model.setIdUserContact(entity.getIdUserContact());
            model.setAddress(entity.getAddress());
            model.setCommune(entity.getCommune());
            model.setPhoneNumber(entity.getPhoneNumber());
            return model;
        }
        else{
            return null;
        }
    }

    public UserContact toEntity(UserContactModel model){
        if(model != null){
            UserContact entity = new UserContact();
            entity.setIdUserContact(model.getIdUserContact());
            entity.setAddress(model.getAddress());
            entity.setCommune(model.getCommune());
            entity.setPhoneNumber(model.getPhoneNumber());
            return entity;
        }
        else{
            return null;
        }
    }

    public List<UserContactModel> toModelList(List<UserContact> listEntity){
        List<UserContactModel> modelList = new ArrayList<>();
        for (UserContact entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<UserContact> toEntityList(List<UserContactModel> listModel){
        List<UserContact> entityList = new ArrayList<>();
        for (UserContactModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
