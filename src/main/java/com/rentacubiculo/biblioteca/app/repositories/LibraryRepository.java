/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.repositories;

import com.rentacubiculo.biblioteca.app.entities.Library;
import com.rentacubiculo.biblioteca.app.repositories.crud.LibraryCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author David Riaño
 */
@Repository
public class LibraryRepository {
    
    @Autowired
    private LibraryCrudRepository libraryCrudrepository;
    
    /**
     * Consultar
    */
    public List<Library> getAll(){
        return (List<Library>) libraryCrudrepository.findAll();
    }
    
    //Buscar registro por Id
    public Optional<Library> getLibrary(int id){
        return libraryCrudrepository.findById(id);
    }
    
    /**
     * Registrar
     */
    public Library save(Library library){
        return libraryCrudrepository.save(library);
    }
    
    /**
     * Eliminar
     */
    public void delete(Library library){
        libraryCrudrepository.delete(library);
    }
    
    
}
