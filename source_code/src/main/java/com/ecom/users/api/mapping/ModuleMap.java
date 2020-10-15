package com.ecom.users.api.mapping;

import com.ecom.users.api.models.ModuleModel;
import com.ecom.users.dalc.entities.Module;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ModuleMap {

    public ModuleModel toModel(Module entity){
        if(entity != null){
            ModuleModel model = new ModuleModel();
            model.setIdModule(entity.getIdModule());
            model.setModuleCode(entity.getModuleCode());
            model.setModuleName(entity.getModuleName());
            return model;
        }
        else{
            return null;
        }
    }

    public Module toEntity(ModuleModel model){
        if(model != null){
            Module entity = new Module();
            entity.setIdModule(model.getIdModule());
            entity.setModuleCode(model.getModuleCode());
            entity.setModuleName(model.getModuleName());
            return entity;
        }
        else{
            return null;
        }
    }

    public List<ModuleModel> toModelList(List<Module> listEntity){
        List<ModuleModel> modelList = new ArrayList<>();
        for (Module entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<Module> toEntityList(List<ModuleModel> listModel){
        List<Module> entityList = new ArrayList<>();
        for (ModuleModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
