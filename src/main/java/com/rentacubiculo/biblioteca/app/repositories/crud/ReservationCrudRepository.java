/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.repositories.crud;

import com.rentacubiculo.biblioteca.app.entities.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author linda
 */
public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer>{
public List<Reservation> getAllReservationsByStartDateAfterAndDevolutionDateBefore (Date date1, Date date2);
    public List<Reservation> findAllByStatus (String status); 

    // SELECT clientid, COUNT(*) AS total FROM reservacion group by clientid order by desc;
    @Query ("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationsByClient();    
}
