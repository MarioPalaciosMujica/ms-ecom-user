package com.ecom.users.services;

import com.ecom.users.dalc.entities.UserAccount;
import com.ecom.users.dalc.repositories.IUserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserAccountService {

    @Autowired private IUserAccountRepository userAccountRepository;

    public UserAccount save(@NotNull UserAccount entity){
        entity.setIdUserAccount(null);
        entity = userAccountRepository.save(entity);
        return entity;
    }

    public UserAccount findById(@NotNull UUID id){
        Optional<UserAccount> entity = userAccountRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else {
            return null;
        }
    }

    public List<UserAccount> findAll(){
        return userAccountRepository.findAll();
    }

    public boolean update(@NotNull UserAccount entity){
        UserAccount original = this.findById(entity.getIdUserAccount());
        if(original != null){
            userAccountRepository.save(entity);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean deleteById(@NotNull UUID id){
        if(this.findById(id) != null){
            userAccountRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }
}
