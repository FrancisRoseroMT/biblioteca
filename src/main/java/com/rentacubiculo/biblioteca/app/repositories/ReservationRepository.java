/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.repositories;

import com.rentacubiculo.biblioteca.app.entities.Reservation;
import com.rentacubiculo.biblioteca.app.repositories.crud.ReservationCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author David Riaño
 */
@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationCrudRepository reservationCrudrepository;
    
    /**
     * Consultar
    */
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudrepository.findAll();
    }
    
    //Buscar registro por Id
    public Optional<Reservation> getReservation(int id){
        return reservationCrudrepository.findById(id);
    }
    
    /**
     * Registrar
     */
    public Reservation save(Reservation reservation){
        return reservationCrudrepository.save(reservation);
    }
    
    /**
     * Eliminar
     */
    public void delete(Reservation reservation){
        reservationCrudrepository.delete(reservation);
    }
    
    
}
