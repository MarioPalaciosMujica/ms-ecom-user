package com.ecom.users.api.mapping;

import com.ecom.users.api.models.UserAccountModel;
import com.ecom.users.dalc.entities.UserAccount;
import com.ecom.users.tools.DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class UserAccountMap {

    @Autowired private RoleMap roleMap;
    @Autowired private UserContactMap userContactMap;
    @Autowired private DateFormat dateFormat;

    public UserAccountModel toModel(UserAccount entity){
        if(entity != null){
            UserAccountModel model = new UserAccountModel();
            model.setIdUserAccount(entity.getIdUserAccount().toString());
            model.setUsername(entity.getUsername());
            model.setPassword(entity.getPassword());
            model.setEmail(entity.getEmail());
            model.setFirstName(entity.getFirstName());
            model.setLastName(entity.getLastName());
            model.setCreated(dateFormat.dateToString(entity.getCreated()));
            model.setModified(dateFormat.dateToString(entity.getModified()));
            model.setRole(roleMap.toModel(entity.getRole()));
            model.setUserContact(userContactMap.toModel(entity.getUserContact()));
            return model;
        }
        else{
            return null;
        }
    }

    public UserAccount toEntity(UserAccountModel model){
        if(model != null){
            UserAccount entity = new UserAccount();
            if(model.getIdUserAccount() != null){
                entity.setIdUserAccount(UUID.fromString(model.getIdUserAccount()));
            }
            entity.setUsername(model.getUsername());
            entity.setPassword(model.getPassword());
            entity.setEmail(model.getEmail());
            entity.setFirstName(model.getFirstName());
            entity.setLastName(model.getLastName());
            entity.setCreated(dateFormat.stringToDate(model.getCreated()));
            entity.setModified(dateFormat.stringToDate(model.getModified()));
            if(model.getRole() != null){
                entity.setRole(roleMap.toEntity(model.getRole()));
            }
            entity.setUserContact(userContactMap.toEntity(model.getUserContact()));
            return entity;
        }
        else{
            return null;
        }
    }

    public List<UserAccountModel> toModelList(List<UserAccount> listEntity){
        List<UserAccountModel> modelList = new ArrayList<>();
        for (UserAccount entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<UserAccount> toEntityList(List<UserAccountModel> listModel){
        List<UserAccount> entityList = new ArrayList<>();
        for (UserAccountModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
