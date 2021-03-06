/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.controllers;

import com.rentacubiculo.biblioteca.app.entities.ContadorClientes;
import com.rentacubiculo.biblioteca.app.entities.Reservation;
import com.rentacubiculo.biblioteca.app.entities.StatusReserva;
import com.rentacubiculo.biblioteca.app.services.ReservationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author linda
 */
@RestController
@RequestMapping("Reservation")
@CrossOrigin(origins = "*")
public class ReservationController {
  @Autowired
    private ReservationService service;
    
    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return service.getAll();
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save (@RequestBody Reservation reservation){
        service.save(reservation);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@RequestBody Reservation reservation){
         service.update(reservation);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int reservationId){
         service.delete(reservationId);
    }

    @GetMapping("/report-dates/{date1}/{date2}")
    public List<Reservation> getReportDate(@PathVariable("date1") String date1,@PathVariable("date2") String date2){
        return service.getReportDate(date1, date2);
    }
    @GetMapping("/report-status")
    public StatusReserva getReservas(){
        return service.reporteStatusServicio();
    }
    @GetMapping("/report-clients")
     public List<ContadorClientes> getClientes(){
         return service.reporteClientesServicio();
     }    
}
