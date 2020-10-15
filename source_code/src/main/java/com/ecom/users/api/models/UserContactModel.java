package com.ecom.users.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserContactModel {

    @JsonProperty("idUserContact")
    private Long idUserContact;

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("commune")
    private String commune;

    @JsonProperty("address")
    private String address;

}
