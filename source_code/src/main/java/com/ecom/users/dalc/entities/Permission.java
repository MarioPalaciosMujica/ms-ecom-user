package com.ecom.users.dalc.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Table(name = "tbl_permissions")
@NoArgsConstructor
@AllArgsConstructor
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permission", updatable = false, nullable = false, unique = true)
    private Long idPermission;

    @Column(name = "is_create_allowed", nullable = false)
    private boolean isCreateAllowed;

    @Column(name = "is_retrieve_allowed", nullable = false)
    private boolean isRetrieveAllowed;

    @Column(name = "is_update_allowed", nullable = false)
    private boolean isUpdateAllowed;

    @Column(name = "is_delete_allowed", nullable = false)
    private boolean isDeleteAllowed;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_module")
    private Module module;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tbr_roles_permissions",
            joinColumns = @JoinColumn(name = "id_permission"),
            inverseJoinColumns = @JoinColumn(name = "id_role")
    )
    private Set<Role> roles;


    public Long getIdPermission() {
        return idPermission;
    }

    public void setIdPermission(Long idPermission) {
        this.idPermission = idPermission;
    }

    public boolean isCreateAllowed() {
        return isCreateAllowed;
    }

    public void setCreateAllowed(boolean createAllowed) {
        isCreateAllowed = createAllowed;
    }

    public boolean isRetrieveAllowed() {
        return isRetrieveAllowed;
    }

    public void setRetrieveAllowed(boolean retrieveAllowed) {
        isRetrieveAllowed = retrieveAllowed;
    }

    public boolean isUpdateAllowed() {
        return isUpdateAllowed;
    }

    public void setUpdateAllowed(boolean updateAllowed) {
        isUpdateAllowed = updateAllowed;
    }

    public boolean isDeleteAllowed() {
        return isDeleteAllowed;
    }

    public void setDeleteAllowed(boolean deleteAllowed) {
        isDeleteAllowed = deleteAllowed;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
