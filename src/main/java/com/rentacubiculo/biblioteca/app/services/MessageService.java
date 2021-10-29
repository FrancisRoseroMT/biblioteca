/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.services;

import com.rentacubiculo.biblioteca.app.entities.Message;
import com.rentacubiculo.biblioteca.app.entities.Message;
import com.rentacubiculo.biblioteca.app.repositories.MessageRepository;
import com.rentacubiculo.biblioteca.app.repositories.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author linda
 */
@Service
public class MessageService {
    @Autowired
    private MessageRepository repository;


    //GET Consultar todos los registros.
    public List<Message> getAll(){
        return repository.getAll();
    }
    
    //Buscar registro
    public Optional<Message> getMessage(int messageId) {
        return repository.getMessage(messageId);
    }
    
    // POST Registrar 
    public Message save(Message message){
        if(message.getIdMessage()==null){
            return repository.save(message);
        }else{
            Optional<Message> resultado = repository.getMessage(message.getIdMessage());
            if(resultado.isPresent()){
                return message;
            }else{
                return repository.save(message);
            }
        }
    }
    
    //PUT Actualizar
    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> resultado = repository.getMessage(message.getIdMessage());
            if(resultado.isPresent()){
                if(message.getMessageText()!=null){
                    resultado.get().setMessageText(message.getMessageText());
                }
                repository.save(resultado.get());
                return resultado.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }
    
    //DELETE Eliminar
    public boolean delete(int id){
        Boolean aBoolean = getMessage(id).map(message -> {
           repository.delete(message);
           return true;
        }).orElse(false);
        return aBoolean;
    } 
}
