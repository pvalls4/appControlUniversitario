package view;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Mati
 */
public class Menu {
    
    private Scanner sc;

    public Menu() {
        sc = new Scanner(System.in);
    }
    
    

    public int showMenu() {
        int result = -1;
        System.out.println("============== APP CONTROL UNIVERSITARIO ==============");
        System.out.println("    0. Salir");
        System.out.println("    1. Gestionar Carreras");
        System.out.println("    2. Gestionar Alumnos");
        System.out.println("Introduce una opción: ");
        try {
            result = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            result = showMenu();
        }
        return result;
    }
    
    public int showMenuCarreras(){
        int result = -1;
        System.out.println("============== GESTIÓN DE CARRERAS ==============");
        System.out.println("    0. Atrás");
        System.out.println("    1. Listar todas las Carreras");
        System.out.println("    2. Buscar una Carrera existente");
        System.out.println("    3. Modificar una Carrera");
        System.out.println("    4. Añadir una Carrera");
        System.out.println("    5. Eliminar una Carrera");
        System.out.println("Introduce una opción: ");
        try {
            result = sc.nextInt();
        } catch (InputMismatchException e) {
            result = showMenuCarreras();
        }
        return result;
    }
    
    public int showMenuAlumnos(){
        int result = -1;
        System.out.println("============== GESTIÓN DE ALUMNOS ==============");
        System.out.println("    0. Atrás");
        System.out.println("    1. Listar todos los Alumnos");
        System.out.println("    2. Buscar un Alumno existente");
        System.out.println("    3. Modificar un Alumno");
        System.out.println("    4. Añadir un Alumno");
        System.out.println("    5. Eliminar un Alumno");
        System.out.println("Introduce una opción: ");
        try {
            result = sc.nextInt();
        } catch (InputMismatchException e) {
            result = showMenu();
        }
        return result;
    }
    
    public void cerrarScanner(){
        sc.close();
    }
}
