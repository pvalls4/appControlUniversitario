/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.persist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
    
    public List<Carrera> listarCarreras(){
        List<Carrera> result = new ArrayList<>();
        try (Connection conn = dbConnect.getConnection()) {
            //Si la conexión es exitosa
            if (conn != null) {
                String query = "SELECT * FROM carreras;";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    Carrera carrera = fromResultSet(rs);
                    //Comprovamos que la carrera sea válida
                    if (carrera != null) {
                        result.add(carrera);
                    }
                }
            }
        } catch (SQLException ex) {
            result = null;
        }
        return result;
    }
    
    public Carrera buscarCarrera(int idCarrera){
        Carrera result = null;
        
        return result;
    }
    
    public int agregarCarrera(Carrera carrera){
        int result = 0;
        
        return result;
    }
    
    public int modificarCarrera(Carrera oldCarrera, Carrera updatedCarrera){
        int result = 0;
        
        return result;
    }
    
    public int eliminarCarrera(Carrera carrera){
        int result = 0;
        
        return result;
    }
}
