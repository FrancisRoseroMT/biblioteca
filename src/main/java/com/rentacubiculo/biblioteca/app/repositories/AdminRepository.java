/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.repositories;

import com.rentacubiculo.biblioteca.app.entities.Admin;
import com.rentacubiculo.biblioteca.app.repositories.crud.AdminCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author linda
 */
@Repository
public class AdminRepository {
    
    @Autowired
    private AdminCrudRepository adminCrudrepository;
    
    /**
     * Consultar
    */
    public List<Admin> getAll(){
        return (List<Admin>) adminCrudrepository.findAll();
    }
    
    //Buscar registro por Id
    public Optional<Admin> getAdmin(int id){
        return adminCrudrepository.findById(id);
    }
    
    /**
     * Registrar
     */
    public Admin save(Admin admin){
        return adminCrudrepository.save(admin);
    }
    
    /**
     * Eliminar
     */
    public void delete(Admin admin){
        adminCrudrepository.delete(admin);
    }
    
    
}
