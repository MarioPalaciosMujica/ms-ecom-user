package com.ecom.users.api.resources;

import com.ecom.users.api.mapping.RoleMap;
import com.ecom.users.api.models.RoleModel;
import com.ecom.users.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/Role")
public class RoleController {

    @Autowired private RoleService roleService;
    @Autowired private RoleMap roleMap;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody @NotNull RoleModel model){
        roleService.save(roleMap.toEntity(model));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<RoleModel> findAll(){
        return roleMap.toModelList(roleService.findAll());
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public RoleModel findById(@PathVariable @NotNull Long id){
        return roleMap.toModel(roleService.findById(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void update(@RequestBody @NotNull RoleModel model){
        roleService.update(roleMap.toEntity(model));
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable @NotNull Long id){
        roleService.deleteById(id);
    }
}
