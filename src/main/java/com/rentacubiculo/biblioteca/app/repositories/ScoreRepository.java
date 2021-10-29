/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.repositories;

import com.rentacubiculo.biblioteca.app.entities.Score;
import com.rentacubiculo.biblioteca.app.repositories.crud.ScoreCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author David Riaño
 */
@Repository
public class ScoreRepository {
    
    @Autowired
    private ScoreCrudRepository scoreCrudrepository;
    
    /**
     * Consultar
    */
    public List<Score> getAll(){
        return (List<Score>) scoreCrudrepository.findAll();
    }
    
    //Buscar registro por Id
    public Optional<Score> getScore(int id){
        return scoreCrudrepository.findById(id);
    }
    
    /**
     * Registrar
     */
    public Score save(Score score){
        return scoreCrudrepository.save(score);
    }
    
    /**
     * Eliminar
     */
    public void delete(Score score){
        scoreCrudrepository.delete(score);
    }
    
    
}
