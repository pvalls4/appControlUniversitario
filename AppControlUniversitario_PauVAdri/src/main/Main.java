
package main;

import controller.Controlador;
import model.Modelo;

/**
 *
 * @author Mati
 */
public class Main {
    public static void main(String[] args) {
        Modelo modelo = new Modelo();
        Controlador controlador = new Controlador(modelo);
        controlador.start();
    }
}
