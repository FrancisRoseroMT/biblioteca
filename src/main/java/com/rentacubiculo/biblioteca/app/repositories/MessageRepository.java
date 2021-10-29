/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.repositories;
import com.rentacubiculo.biblioteca.app.entities.Message;
import com.rentacubiculo.biblioteca.app.repositories.crud.MessageCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Guest
 */
@Repository
public class MessageRepository {
    
    @Autowired
    private MessageCrudRepository messageCrudrepository;
    
    /**
     * Consultar
    */
    public List<Message> getAll(){
        return (List<Message>) messageCrudrepository.findAll();
    }
    
    //Buscar registro por Id
    public Optional<Message> getMessage(int id){
        return messageCrudrepository.findById(id);
    }
    
    /**
     * Registrar
     */
    public Message save(Message message){
        return messageCrudrepository.save(message);
    }
    
    /**
     * Eliminar
     */
    public void delete(Message message){
        messageCrudrepository.delete(message);
    }
    
    
}

