package com.ecom.users.api.resources;

import com.ecom.users.api.mapping.ModuleMap;
import com.ecom.users.api.models.ModuleModel;
import com.ecom.users.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/Module")
public class ModuleController {

    @Autowired private ModuleService moduleService;
    @Autowired private ModuleMap moduleMap;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody @NotNull ModuleModel model){
        moduleService.save(moduleMap.toEntity(model));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<ModuleModel> findAll(){
        return moduleMap.toModelList(moduleService.findAll());
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public ModuleModel findById(@PathVariable @NotNull Long id){
        return moduleMap.toModel(moduleService.findById(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void update(@RequestBody @NotNull ModuleModel model){
        moduleService.update(moduleMap.toEntity(model));
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable @NotNull Long id){
        moduleService.deleteById(id);
    }
}
