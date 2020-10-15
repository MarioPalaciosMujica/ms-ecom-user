package com.ecom.users.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PermissionModel {

    @JsonProperty("idPermission")
    private Long idPermission;

    @JsonProperty("isCreateAllowed")
    private boolean isCreateAllowed;

    @JsonProperty("isRetrieveAllowed")
    private boolean isRetrieveAllowed;

    @JsonProperty("isUpdateAllowed")
    private boolean isUpdateAllowed;

    @JsonProperty("isDeleteAllowed")
    private boolean isDeleteAllowed;

    @JsonProperty("module")
    private ModuleModel module;

}
