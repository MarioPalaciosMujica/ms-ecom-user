package com.ecom.users.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginModel {

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;
}
