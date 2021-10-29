/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.repositories;

import com.rentacubiculo.biblioteca.app.entities.Client;
import com.rentacubiculo.biblioteca.app.repositories.crud.ClientCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author linda
 */
@Repository
public class ClientRepository {
    
    @Autowired
    private ClientCrudRepository clientCrudrepository;
    
    /**
     * Consultar
    */
    public List<Client> getAll(){
        return (List<Client>) clientCrudrepository.findAll();
    }
    
    //Buscar registro por Id
    public Optional<Client> getClient(int id){
        return clientCrudrepository.findById(id);
    }
    
    /**
     * Registrar
     */
    public Client save(Client client){
        return clientCrudrepository.save(client);
    }
    
    /**
     * Eliminar
     */
    public void delete(Client client){
        clientCrudrepository.delete(client);
    }
    
    
}
