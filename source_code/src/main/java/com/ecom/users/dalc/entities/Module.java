package com.ecom.users.dalc.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "tbl_modules")
@NoArgsConstructor
@AllArgsConstructor
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_module", updatable = false, nullable = false, unique = true)
    private Long idModule;

    @Column(name = "module_code", nullable = false, unique = true)
    @Size(min = 2, max = 50)
    private String moduleCode;

    @Column(name = "module_name", nullable = false, unique = true)
    @Size(min = 2, max = 50)
    private String moduleName;

    @OneToMany(mappedBy = "module", fetch = FetchType.LAZY)
    private Set<Permission> permissions;


    public Long getIdModule() {
        return idModule;
    }

    public void setIdModule(Long idModule) {
        this.idModule = idModule;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}
