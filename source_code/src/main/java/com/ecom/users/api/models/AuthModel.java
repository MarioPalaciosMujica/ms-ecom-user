package com.ecom.users.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthModel {

    @JsonProperty("clientName")
    private String clientName;

    @JsonProperty("token")
    private String token;

    @JsonProperty("role")
    private RoleModel role;
}
