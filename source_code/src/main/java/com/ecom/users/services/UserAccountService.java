package com.ecom.users.services;

import com.ecom.users.dalc.entities.Auth;
import com.ecom.users.dalc.entities.Login;
import com.ecom.users.dalc.entities.Role;
import com.ecom.users.dalc.entities.UserAccount;
import com.ecom.users.dalc.repositories.IUserAccountRepository;
import com.ecom.users.enums.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserAccountService {

    @Autowired private IUserAccountRepository userAccountRepository;
    @Autowired private RoleService roleService;

    public UserAccount save(@NotNull UserAccount entity){
        entity.setIdUserAccount(null);
        entity.setUsername(entity.getEmail());
        entity.setCreated(new Date());
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
            entity.setUsername(entity.getEmail());
            entity.setModified(new Date());
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

    public Auth login(@NotNull Login login){
        Optional<UserAccount> account = userAccountRepository.findByUsernameAndPassword(login.getUsername(), login.getPassword());
        if(account.isPresent()){
            Auth auth = new Auth();
            auth.setClientName(account.get().getFirstName());
            auth.setToken(account.get().getIdUserAccount().toString());
            auth.setRole(account.get().getRole());
            return auth;
        }
        else {
            return null;
        }
    }

    public Auth register(@NotNull UserAccount account){
        Role clientRole = roleService.findByRoleName(RoleEnum.CLIENTE.toString());
        if(clientRole != null){
            account.setRole(clientRole);
            account = this.save(account);
            Auth auth = new Auth();
            auth.setClientName(account.getFirstName());
            auth.setToken(account.getIdUserAccount().toString());
            auth.setRole(account.getRole());
            return auth;
        }
        else {
            return null;
        }
    }
}
