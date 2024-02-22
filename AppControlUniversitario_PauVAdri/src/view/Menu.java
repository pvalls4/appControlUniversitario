/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Mati
 */
public class Menu {

    public int showMenu() {
        Scanner sc = new Scanner(System.in);
        int result = -1;
        System.out.println("============== APP CONTROL UNIVERSITARIO ==============");
        System.out.println("    0. Salir");
        System.out.println("    1. Gestionar Carreras");
        try {
            result = sc.nextInt();
        } catch (InputMismatchException e) {
            result = showMenu();
        }
        return result;
    }
    
    public int showMenuCarrera(){
        Scanner sc = new Scanner(System.in);
        int result = -1;
        System.out.println("============== GESTIÓN DE CARRERAS ==============");
        System.out.println("    0. Atrás");
        System.out.println("    1. Listar Todas las Carreras");
        System.out.println("    2. Listar una Carrera");
        System.out.println("    3. Modificar una Carrera");
        System.out.println("    4. Añadir una Carrera");
        System.out.println("    5. Eliminar una Carrera");
        try {
            result = sc.nextInt();
        } catch (InputMismatchException e) {
            result = showMenu();
        }
        return result;
    }
    
}
