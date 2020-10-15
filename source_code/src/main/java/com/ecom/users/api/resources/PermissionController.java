package com.ecom.users.api.resources;

import com.ecom.users.api.mapping.PermissionMap;
import com.ecom.users.api.models.PermissionModel;
import com.ecom.users.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/Permission")
public class PermissionController {

    @Autowired private PermissionService permissionService;
    @Autowired private PermissionMap permissionMap;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody @NotNull PermissionModel model){
        permissionService.save(permissionMap.toEntity(model));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<PermissionModel> findAll(){
        return permissionMap.toModelList(permissionService.findAll());
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public PermissionModel findById(@PathVariable @NotNull Long id){
        return permissionMap.toModel(permissionService.findById(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void update(@RequestBody @NotNull PermissionModel model){
        permissionService.update(permissionMap.toEntity(model));
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable @NotNull Long id){
        permissionService.deleteById(id);
    }
}
