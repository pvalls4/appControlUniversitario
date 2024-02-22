/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import model.persist.CarreraDao;

/**
 *
 * @author Mati
 */
public class Modelo {
    private final CarreraDao carreraDao;

    public Modelo() {
        carreraDao = new CarreraDao();
    }
    
    public List<Carrera> listarCarreras(){
        return carreraDao.listarCarreras();
    }
}
