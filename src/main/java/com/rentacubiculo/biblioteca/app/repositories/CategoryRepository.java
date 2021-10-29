/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.repositories;

import com.rentacubiculo.biblioteca.app.entities.Category;
import com.rentacubiculo.biblioteca.app.repositories.crud.CategoryCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author David Riaño
 */
@Repository
public class CategoryRepository {
    
    @Autowired
    private CategoryCrudRepository categoryCrudrepository;
    
    /**
     * Consultar
    */
    public List<Category> getAll(){
        return (List<Category>) categoryCrudrepository.findAll();
    }
    
    //Buscar registro por Id
    public Optional<Category> getCategory(int id){
        return categoryCrudrepository.findById(id);
    }
    
    /**
     * Registrar
     */
    public Category save(Category category){
        return categoryCrudrepository.save(category);
    }
    
    /**
     * Eliminar
     */
    public void delete(Category category){
        categoryCrudrepository.delete(category);
    }
    
    
}
