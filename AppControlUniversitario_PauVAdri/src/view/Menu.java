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
        System.out.println("    2. Gestionar Alumnos");
        System.out.println("Introduce una opción: ");
        try {
            result = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            result = showMenu();
        } finally {
            sc.close();
        }
        return result;
    }
    
    public int showMenuCarreras(){
        Scanner sc = new Scanner(System.in);
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
            sc.nextLine();
        } catch (InputMismatchException e) {
            result = showMenu();
        } finally {
            sc.close();
        }
        return result;
    }
    
    public int showMenuAlumnos(){
        Scanner sc = new Scanner(System.in);
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
            sc.nextLine();
        } catch (InputMismatchException e) {
            result = showMenu();
        } finally {
            sc.close();
        }
        return result;
    }
    
}
