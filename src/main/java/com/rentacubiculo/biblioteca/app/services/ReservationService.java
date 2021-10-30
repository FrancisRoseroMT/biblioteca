/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.services;

import com.rentacubiculo.biblioteca.app.entities.ContadorClientes;
import com.rentacubiculo.biblioteca.app.entities.Reservation;
import com.rentacubiculo.biblioteca.app.entities.StatusReserva;
import com.rentacubiculo.biblioteca.app.repositories.ReservationRepository;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author linda
 */
@Service
public class ReservationService {
   @Autowired
    private ReservationRepository repository;
    
    //Consultar Todos los registros.
    public List<Reservation> getAll(){
        return repository.getAll();
    }
    
    //Buscar registro
    public Optional<Reservation> getReservation(int reservationId) {
        return repository.getReservation(reservationId);
    }
    
    //Registrar 
    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return repository.save(reservation);
        }else{
            Optional<Reservation> resultado = repository.getReservation(reservation.getIdReservation());
            if(resultado.isPresent()){
                return reservation;
            }else{
                return repository.save(reservation);
            }
        }
    }
    
    //Actualizar
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> resultado = repository.getReservation(reservation.getIdReservation());
            if(resultado.isPresent()){
                if(reservation.getStartDate()!=null){
                    resultado.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    resultado.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    resultado.get().setStatus(reservation.getStatus());
                }
                repository.save(resultado.get());
                return resultado.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }
    
    //Eliminar
    public boolean delete(int id){
        Boolean aBoolean = getReservation(id).map(reservation -> {
           repository.delete(reservation);
           return true;
        }).orElse(false);
        return aBoolean;
    } 
    public List<Reservation> getReportDate(String date1, String date2) {
        
        SimpleDateFormat parser = new  SimpleDateFormat("yyyy-MM-dd");
        Date dateOne = new Date();
        Date dateTwo = new Date();
        try {
            dateOne = parser.parse(date1);
            dateTwo = parser.parse(date2);
        } catch (Exception e) {
        }
        
        if (dateOne.before(dateTwo)) {
            return repository.getReportDate(dateOne,dateTwo);
        }
        else{
            return new ArrayList<>();
        }
    }
    
    public StatusReserva reporteStatusServicio (){
        List<Reservation>completed= repository.getReservationsBySatus("completed");
        List<Reservation>cancelled= repository.getReservationsBySatus("cancelled");
        
        return new StatusReserva(completed.size(), cancelled.size() );
    }
    
    public List<ContadorClientes> reporteClientesServicio(){
            return repository.getClientesRepositorio();
        }
}
