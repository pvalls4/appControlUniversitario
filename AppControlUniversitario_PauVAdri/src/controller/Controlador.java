package controller;

import java.util.List;
import model.*;
import view.View;

/**
 *
 * @author Mati
 */
public class Controlador {

    private Modelo modelo;
    private View view;

    public Controlador(Modelo modelo) {
        this.modelo = modelo;
        this.view = new View();
    }

    public void start() {
        int opcion = -1;
        do {
            opcion = view.showMenu();
            procesarMenu(opcion);
        } while (opcion != 0);

    }

    public void procesarMenu(int opcion) {
        switch (opcion) {
            case 0://Salir
                exitApplication();
                break;
            case 1://Gestionar carreras
                int opcionCarrera = -1;
                do {
                    opcionCarrera = view.showMenuCarreras();
                    gestionarCarreras(opcionCarrera);
                } while (opcionCarrera != 0);
                break;
            case 2://Gestionar Alumnos
                int opcionAlumno = -1;
                do {
                    opcionAlumno = view.showMenuAlumnos();
                    gestionarAlumnos(opcionAlumno);
                } while (opcionAlumno != 0);
                break;
            case 3://Gestionar Catedrático
                int opcionCatedratico = -1;
                do {
                    opcionCatedratico = view.showMenuCatedraticos();
                    gestionarCatedraticos(opcionCatedratico);
                } while (opcionCatedratico!= 0);
                break;
            default:
                view.displayMessage("Introduce una opción válida!");
        }
    }

    private void gestionarCarreras(int opcion) {
        switch (opcion) {
            case 0://Volver atrás al menú general
                break;
            case 1://Listar todas las carreras
                listarCarreras();
                break;
            case 2://Buscar carrera existente
                buscarCarrera();
                break;
            case 3://Modificar una carrera
                modificarCarrera();
                break;
            case 4://Añadir una carrera
                agregarCarrera();
                break;
            case 5://Eliminar una carrera
                eliminarCarrera();
                break;
            default:
                view.displayMessage("Introduce una opción válida!");
        }
    }
    
    private void gestionarAlumnos(int opcion) {
        switch (opcion) {
            case 0://Volver atrás al menú general
                break;
            case 1://Listar todos lo alumnos
                listarAlumnos();
                break;
            case 2://Buscar un alumno existente
                buscarAlumno();
                break;
            case 3://Modificar un alumno
                modificarAlumno();
                break;
            case 4://Añadir un alumno
                agregarAlumno();
                break;
            case 5://Eliminar un alumno
                eliminarAlumno();
                break;
            case 6://Lista los alumnos de una carrera seleccionada
                listarAlumnosDeCarrera();
                break;
            default:
                view.displayMessage("Introduce una opción válida!");
        }
    }
    
    private void gestionarCatedraticos(int opcion) {
        switch (opcion) {
            case 0://Volver atrás al menú general
                break;
            case 1://Listar todod los catedratico
                listarCatedraticos();
                break;
            case 2://Buscar catedratico existente
                buscarCatedratico();
                break;
            case 3://Modificar un catedratico
                modificarCatedratico();
                break;
            case 4://Añadir un catedratico
                agregarCatedratico();
                break;
            case 5://Eliminar un catedratico
                eliminarCatedratico();
                break;
            default:
                view.displayMessage("Introduce una opción válida!");
        }
    }

    private void listarCarreras() {
        List<Carrera> result = modelo.listarCarreras();
        if (result != null) {
            view.displayList(result);
        }
    }

    private void buscarCarrera() {
        //Pedimos por teclado el id de la carrera
        int idCarrera = view.inputId("Introduce el ID de la Carrera a buscar: ");
        Carrera carrera = modelo.buscarCarrera(new Carrera(idCarrera));
        if (carrera != null) {
            view.displayMessage(carrera.toString());
        } else {
            view.displayMessage("No se ha encontrado ninguna carrera con ese ID!");
        }
    }

    private void modificarCarrera() {
        int result = 0;
        //Pedimos el id de la carrera a modificar
        int idCarrera = view.inputId("Introduce el ID de la Carrera a modificar: ");
        Carrera carrera = modelo.buscarCarrera(new Carrera(idCarrera));
        if (carrera != null) {
            //Si existe, pedimos los datos de la nueva carrera
            view.displayMessage("Modificando carrera...");
            Carrera updatedCarrera = view.inputCarrera();
            if (updatedCarrera != null) {
                result = modelo.modificarCarrera(carrera, updatedCarrera);
                if (result > 0) {
                    view.displayMessage("Carrera modificada con éxito!");
                } else {
                    view.displayMessage("Carrera no modificada!");
                }
            } else {
                view.displayMessage("Nuevos datos de carrera no válidos!");
            }
        } else {
            view.displayMessage("No se ha encontrado ninguna carrera con ese ID!");
        }
    }

    private void agregarCarrera() {
        int result = 0;
        //Pedimos los datos de la nueva carrera
        Carrera carrera = view.inputCarrera();
        if (carrera != null) {
            result = modelo.agregarCarrera(carrera);
            if (result > 0) {
                view.displayMessage("Carrera agregada con éxito!");
            } else {
                view.displayMessage("No se pudo agregar la carrera!");
            }
        } else {
            view.displayMessage("Datos de Carrera no válidos!");
        }
    }

    private void eliminarCarrera() {
        int result = 0;
        //Pedimos el id de la carrera a borrar
        int idCarrera = view.inputId("Introduce el ID de la carrera a borrar: ");
        Carrera carrera = modelo.buscarCarrera(new Carrera(idCarrera));
        //Comprobmos que la carrera exista
        if (carrera != null) {
            result = modelo.eliminarCarrera(carrera);
            if (result > 0) {
                view.displayMessage("Carrera eliminada con éxito!");
            } else {
                view.displayMessage("No se pudo eliminar la carrera!");
            }
        } else {
            view.displayMessage("No se ha encontrado ninguna carrera con ese ID!");
        }
    }
    
    private void listarAlumnos() {
        List<Alumno> result = modelo.listarAlumnos();
        if (result != null) {
            view.displayList(result);
        }
    }

    private void buscarAlumno() {
        //Pedimos por teclado el id del alumno
        int idAlumno = view.inputId("Introduce el ID del Alumno a buscar: ");
        Alumno alumno = modelo.buscarAlumno(idAlumno);
        if (alumno != null) {
            view.displayMessage(alumno.toString());
        } else {
            view.displayMessage("No se ha encontrado ningún alumno con ese ID!");
        }
    }

    private void modificarAlumno() {
        int result = 0;
        //Pedimos el id del alumno a modificar
        int idAlumno = view.inputId("Introduce el ID del Alumno a modificar: ");
        Alumno alumno = modelo.buscarAlumno(idAlumno);
        if (alumno != null) {
            //Si existe, pedimos los datos de la nueva carrera
            view.displayMessage("Modificando alumno...");
            Alumno updatedAlumno = view.inputAlumno();
            if (updatedAlumno != null) {
                result = modelo.modificarAlumno(alumno, updatedAlumno);
                if (result > 0) {
                    view.displayMessage("Alumno modificado con éxito!");
                } else {
                    view.displayMessage("Alumno no modificado!");
                }
            } else {
                view.displayMessage("Nuevos datos del alumno no válidos!");
            }
        } else {
            view.displayMessage("No se ha encontrado ningún alumno con ese ID!");
        }
    }

    private void agregarAlumno() {
        int result = 0;
        //Pedimos los datos de la nueva carrera
        Alumno alumno = view.inputAlumno();
        if (alumno != null) {
            result = modelo.agregarAlumno(alumno);
            if (result > 0) {
                view.displayMessage("Alumno agregado con éxito!");
            } else {
                view.displayMessage("No se pudo agregar el alumno!");
            }
        } else {
            view.displayMessage("Datos del Alumno no válidos!");
        }
    }

    private void eliminarAlumno() {
        int result = 0;
        //Pedimos el id de la carrera a borrar
        int idAlumno = view.inputId("Introduce el ID del alumno a borrar: ");
        Alumno alumno = modelo.buscarAlumno(idAlumno);
        //Comprovamos que la carrera exista
        if (alumno != null) {
            result = modelo.eliminarAlumno(alumno);
            if (result > 0) {
                view.displayMessage("Alumno " + alumno.getNombre() + " " + alumno.getApellido() + " eliminado con éxito!");
            } else {
                view.displayMessage("No se pudo eliminar el alumno!");
            }
        } else {
            view.displayMessage("No se ha encontrado ningún alumno con ese ID!");
        }
    }
    
    private void listarAlumnosDeCarrera() {
        //Pedimos el id de la carrera a borrar
        int idCarrera = view.inputId("Introduce el ID de la carrera de la que quieres saber los alumnos matriculados: ");
        Carrera carrera = modelo.buscarCarrera(new Carrera(idCarrera));
        //Comprobamos que la carrera exista
        if (carrera != null) {
            List<Alumno> result = modelo.listarAlumnosDeCarrera(idCarrera);
            if (result != null) {
                view.displayList(result);
            }
        }
    }
    
    /**
     * asks for confirmation and, if so, exits application.
     */
    public void exitApplication() {
        String answer = view.inputString("Sure to exit? ");
        if (answer.equalsIgnoreCase("yes")) {
            //System.exit(0);
            view.close();
        }   
    }
    
    private void listarCatedraticos() {
        List<Catedratico> result = modelo.listarCatedraticos();
        if (result != null) {
            view.displayList(result);
        }
    }

    private void buscarCatedratico() {
        //Pedimos por teclado el id del alumno
        int idCatedratico = view.inputId("Introduce el ID del Catedratico a buscar: ");
        Catedratico catedratico = modelo.buscarCatedratico(idCatedratico);
        if (catedratico != null) {
            view.displayMessage(catedratico.toString());
        } else {
            view.displayMessage("No se ha encontrado ningún Catedratico con ese ID!");
        }
    }

    private void modificarCatedratico() {
        int result = 0;
        //Pedimos el id del alumno a modificar
        int idCatedratico = view.inputId("Introduce el ID del Catedratico a modificar: ");
        Catedratico catedratico = modelo.buscarCatedratico(idCatedratico);
        if (catedratico != null) {
            //Si existe, pedimos los datos de la nueva carrera
            view.displayMessage("Modificando catedratico...");
            Catedratico updatedCatedratico = view.inputCatedratico();
            if (updatedCatedratico != null) {
                result = modelo.modificarCatedratico(catedratico, updatedCatedratico);
                if (result > 0) {
                    view.displayMessage("Catedratico modificado con éxito!");
                } else {
                    view.displayMessage("Catedratico no modificado!");
                }
            } else {
                view.displayMessage("Nuevos datos del catedratico no válidos!");
            }
        } else {
            view.displayMessage("No se ha encontrado ningún catedratico con ese ID!");
        }
    }

    private void agregarCatedratico() {
        int result = 0;
        //Pedimos los datos del nuevo catedratico
        Catedratico catedratico = view.inputCatedratico();
        if (catedratico != null) {
            result = modelo.agregarCatedratico(catedratico);
            if (result > 0) {
                view.displayMessage("Catedratico agregado con éxito!");
            } else {
                view.displayMessage("No se pudo agregar el catedratico!");
            }
        } else {
            view.displayMessage("Datos del Catedratico no válidos!");
        }
    }

    private void eliminarCatedratico() {
        int result = 0;
        //Pedimos el id de la carrera a borrar
        int idCatedratico = view.inputId("Introduce el ID del catedratico a borrar: ");
        Catedratico catedratico = modelo.buscarCatedratico(idCatedratico);
        //Comprovamos que la carrera exista
        if (catedratico != null) {
            result = modelo.eliminarCatedratico(catedratico);
            if (result > 0) {
                view.displayMessage("Catedratico " + catedratico.getNombre() + " eliminado con éxito!");
            } else {
                view.displayMessage("No se pudo eliminar el catedratico!");
            }
        } else {
            view.displayMessage("No se ha encontrado ningún catedratico con ese ID!");
        }
    }
}
