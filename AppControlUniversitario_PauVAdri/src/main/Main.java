/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
