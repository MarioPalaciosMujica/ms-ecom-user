package com.ecom.users.api.resources;

import com.ecom.users.api.mapping.AuthMap;
import com.ecom.users.api.mapping.LoginMap;
import com.ecom.users.api.mapping.UserAccountMap;
import com.ecom.users.api.models.AuthModel;
import com.ecom.users.api.models.LoginModel;
import com.ecom.users.api.models.UserAccountModel;
import com.ecom.users.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/UserAccount")
public class UserAccountController {

    @Autowired private UserAccountService userAccountService;
    @Autowired private UserAccountMap userAccountMap;
    @Autowired private AuthMap authMap;
    @Autowired private LoginMap loginMap;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody @NotNull UserAccountModel model){
        userAccountService.save(userAccountMap.toEntity(model));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<UserAccountModel> findAll(){
        return userAccountMap.toModelList(userAccountService.findAll());
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public UserAccountModel findById(@PathVariable @NotNull String id){
        return userAccountMap.toModel(userAccountService.findById(UUID.fromString(id)));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void update(@RequestBody @NotNull UserAccountModel model){
        userAccountService.update(userAccountMap.toEntity(model));
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable @NotNull String id){
        userAccountService.deleteById(UUID.fromString(id));
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public AuthModel login(@RequestBody @NotNull LoginModel model){
        return authMap.toModel(userAccountService.login(loginMap.toEntity(model)));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public AuthModel register(@RequestBody @NotNull UserAccountModel model){
        return authMap.toModel(userAccountService.register(userAccountMap.toEntity(model)));
    }
}
