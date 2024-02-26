package controller;

import java.util.List;
import model.Carrera;
import model.Modelo;
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
                System.out.println("Adiós!");
                System.exit(0);
                break;
            case 1://Gestionar carreras
                int opcionCarrera = -1;
                do {
                    opcionCarrera = view.showMenuCarreras();
                    gestionarCarreras(opcionCarrera);
                } while (opcionCarrera != 0);
                break;
            case 2://Gestionar Alumnos

                break;
            default:
                System.out.println("Introduce una opción válida!");
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
                System.out.println("Introduce una opción válida!");
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
        int idCarrera = view.inputId("Introduce el ID de la Carrera a buscar: ");
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
        //Comprovamos que la carrera exista
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
}
