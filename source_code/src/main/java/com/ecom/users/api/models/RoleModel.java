package com.ecom.users.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RoleModel {

    @JsonProperty("idRole")
    private Long idRole;

    @JsonProperty("roleName")
    private String roleName;

    @JsonProperty("isActive")
    private boolean isActive;

    @JsonProperty("created")
    private String created;

    @JsonProperty("modified")
    private String modified;

    @JsonProperty("permissions")
    private List<PermissionModel> permissions;
}
