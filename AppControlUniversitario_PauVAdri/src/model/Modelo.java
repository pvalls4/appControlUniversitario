package model;

import java.util.List;
import model.persist.AlumnoDao;
import model.persist.CarreraDao;

/**
 *
 * @author Mati
 */
public class Modelo {

    private final CarreraDao carreraDao;
    private final AlumnoDao alumnoDao;

    public Modelo() {
        carreraDao = new CarreraDao();
        alumnoDao = new AlumnoDao();
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
    
    public List<Alumno> listarAlumnos() {
        return alumnoDao.listarAlumnos();
    }
    
    public Alumno buscarAlumno(int idAlumno){
        return alumnoDao.buscarAlumno(idAlumno);
    }
    
    public int modificarAlumno(Alumno oldAlumno, Alumno updatedAlumno){
        return alumnoDao.modificarAlumno(oldAlumno, updatedAlumno);
    }
    
    public int agregarAlumno(Alumno alumno){
        return alumnoDao.agregarAlumno(alumno);
    }
    
    public int eliminarAlumno(Alumno alumno){
        return alumnoDao.eliminarAlumno(alumno);
    }
}
