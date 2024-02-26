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
