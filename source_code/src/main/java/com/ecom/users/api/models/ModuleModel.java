package com.ecom.users.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ModuleModel {

    @JsonProperty("idModule")
    private Long idModule;

    @JsonProperty("moduleCode")
    private String moduleCode;

    @JsonProperty("moduleName")
    private String moduleName;
}
