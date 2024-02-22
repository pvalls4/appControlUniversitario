/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.Carrera;
import model.Modelo;
import view.Menu;

/**
 *
 * @author Mati
 */
public class Controlador {

    private Modelo modelo;
    private Menu menu;

    public Controlador(Modelo modelo) {
        this.modelo = modelo;
        this.menu = new Menu();
    }
    
    public void start(){
        int opcion = -1;
        do {
           opcion = menu.showMenu();
           procesarMenu(opcion);
        } while (opcion != 0);
        
    }
    
    public void procesarMenu(int opcion){
        switch (opcion) {
            case 0://Salir
                System.out.println("Adiós!");
                System.exit(0);
                break;
            case 1://Gestionar carreras
                gestionarCarreras(menu.showMenuCarreras());
                break;
            case 2:
                
                break;
            default:
                System.out.println("Introduce una opción válida!");
        }
    }

    private void gestionarCarreras(int opcion) {
        switch (opcion) {
            case 0:
                
                break;
            case 1://Listar todas las carreras
                listarCarreras();
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            case 5:
                
                break;
            default:
                System.out.println("Introduce una opción válida!");
        }
    }

    private void listarCarreras() {
        List<Carrera> result = modelo.listarCarreras();
        if (result != null) {
            for (Carrera carrera : result) {
                System.out.println(carrera);
            }
        }
    }
}
