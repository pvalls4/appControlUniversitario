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

    public List<Carrera> listarCarreras() {
        return carreraDao.listarCarreras();
    }
    
    public Carrera buscarCarrera(Carrera carrera){
        return carreraDao.buscarCarrera(carrera);
    }
    
    public int modificarCarrera(Carrera oldCarrera, Carrera updatedCarrera){
        return carreraDao.modificarCarrera(oldCarrera, updatedCarrera);
    }
    
    public int agregarCarrera(Carrera carrera){
        return carreraDao.agregarCarrera(carrera);
    }
    
    public int eliminarCarrera(Carrera carrera){
        return carreraDao.eliminarCarrera(carrera);
    }
}
