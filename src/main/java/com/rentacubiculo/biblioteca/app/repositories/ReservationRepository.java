/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.repositories;

import com.rentacubiculo.biblioteca.app.entities.Client;
import com.rentacubiculo.biblioteca.app.entities.ContadorClientes;
import com.rentacubiculo.biblioteca.app.entities.Reservation;
import com.rentacubiculo.biblioteca.app.repositories.crud.ReservationCrudRepository;
import java.util.ArrayList;
import java.util.Date;
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
     * @return 
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
     * @param reservation
     * @return 
     */
    public Reservation save(Reservation reservation){
        return reservationCrudrepository.save(reservation);
    }
    
    /**
     * Eliminar
     * @param reservation
     */
    public void delete(Reservation reservation){
        reservationCrudrepository.delete(reservation);
    }
    public List<Reservation> getReportDate(Date date1, Date date2){
        return (List<Reservation>) reservationCrudrepository.getAllReservationsByStartDateAfterAndDevolutionDateBefore(date1, date2);
    }
    
    public List<Reservation> getReservationsBySatus(String status){
        return (List<Reservation>) reservationCrudrepository.findAllByStatus(status);
    }
    
    public List<ContadorClientes> getClientesRepositorio(){
         List<ContadorClientes> res = new ArrayList<>();
         List<Object[]> report = reservationCrudrepository.countTotalReservationsByClient();
         for(int i=0; i<report.size(); i++){
             res.add(new ContadorClientes((Long)report.get(i)[1],(Client) report.get(i)[0]));
         }
         return res;
     }  
    
}
