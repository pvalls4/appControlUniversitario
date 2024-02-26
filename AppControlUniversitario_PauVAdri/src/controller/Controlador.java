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
    }

    private void modificarCarrera() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void agregarCarrera() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void eliminarCarrera() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
