package com.ecom.users.services;

import com.ecom.users.dalc.entities.Module;
import com.ecom.users.dalc.entities.Permission;
import com.ecom.users.dalc.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class InitService {

    @Autowired private ModuleService moduleService;
    @Autowired private PermissionService permissionService;
    @Autowired private RoleService roleService;

    public void start(){
        Module customerDashboard = new Module(null, "CustomerDasboard", "Resumen de Cliente", null);
        Module checkout = new Module(null, "Checkout", "Pagina de Pago", null);
        customerDashboard = moduleService.save(customerDashboard);
        checkout = moduleService.save(checkout);

        Permission custDasboardPerm = new Permission(null, true, true, false, false, customerDashboard, null);
        Permission checkoutPerm = new Permission(null, true, true, false, false, checkout, null);
        custDasboardPerm = permissionService.save(custDasboardPerm);
        checkoutPerm = permissionService.save(checkoutPerm);

        Role customer = new Role(null, "CLIENTE", true, null, null, null,
                new HashSet<Permission>(Arrays.asList(
                        custDasboardPerm,
                        checkoutPerm
                ))
        );
        roleService.save(customer);
    }
}
