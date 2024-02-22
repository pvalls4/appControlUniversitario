/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.persist;

import java.sql.*;
import model.Carrera;


/**
 *
 * @author Mati
 */
public class CarreraDao {

    private final DbConnect dbConnect;
    
    public CarreraDao(){
        dbConnect = new DbConnect();
    }
    
    private Carrera fromResultSet(ResultSet rs) throws SQLException{
        Carrera carrera;
        //Leemos los atributos de carrera
        int idCarrera = rs.getInt("id");
        String nombreCarrera = rs.getString("nombre");
        //Instanciamos un nuevo objeto Carrera con los datos obtenidos
        carrera = new Carrera(idCarrera, nombreCarrera);
        return carrera;
    }
}
