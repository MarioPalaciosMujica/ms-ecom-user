package com.ecom.users.dalc.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Table(name = "tbl_user_contacts")
@NoArgsConstructor
@AllArgsConstructor
public class UserContact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_contact", updatable = false, nullable = false, unique = true)
    private Long idUserContact;

    @Column(name = "phone_number", nullable = false)
    @Size(min = 2, max = 50)
    private String phoneNumber;

    @Column(name = "commune", nullable = false)
    @Size(min = 2, max = 50)
    private String commune;

    @Column(name = "address", nullable = false)
    @Size(min = 2, max = 50)
    private String address;


    public Long getIdUserContact() {
        return idUserContact;
    }

    public void setIdUserContact(Long idUserContact) {
        this.idUserContact = idUserContact;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
