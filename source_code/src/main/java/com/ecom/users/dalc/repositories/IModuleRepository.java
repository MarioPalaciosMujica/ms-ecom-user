package com.ecom.users.dalc.repositories;

import com.ecom.users.dalc.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IModuleRepository extends JpaRepository<Module, Long> {
}
