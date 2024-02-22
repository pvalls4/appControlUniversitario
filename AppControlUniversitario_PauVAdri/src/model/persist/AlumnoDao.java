/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.persist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Alumno;

public class AlumnoDao {

    private final DbConnect dbConnect;
    
    public AlumnoDao(){
        dbConnect = new DbConnect();
    }
    
    private Alumno fromResultSet(ResultSet rs) throws SQLException{
        Alumno alumno;
        //Leemos los atributos de carrera
        int id = rs.getInt("id");
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido");
        String email = rs.getString("email");
        int idCarrera = rs.getInt("idCarrera");
        //Instanciamos un nuevo objeto Carrera con los datos obtenidos
        alumno = new Alumno(id, nombre, apellido, email, idCarrera);
        return alumno;
    }
    
    public List<Alumno> listarCarreras(){
        List<Alumno> result = new ArrayList<>();
        try (Connection conn = dbConnect.getConnection()) {
            //Si la conexión es exitosa
            if (conn != null) {
                String query = "SELECT * FROM alumnos;";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    Alumno alumno = fromResultSet(rs);
                    //Comprovamos que la carrera sea válida
                    if (alumno != null) {
                        result.add(alumno);
                    }
                }
            }
        } catch (SQLException ex) {
            result = null;
        }
        return result;
    }
    
    public Alumno buscarALumno(int id){
        Alumno result = null;
        
        return result;
    }
    
    public int agregarAlumno(Alumno alumno){
        int result = 0;
        
        return result;
    }
    
    public int modificarAlumno(Alumno oldCarrera, Alumno updatedCarrera){
        int result = 0;
        
        return result;
    }
    
    public int eliminarAlumno(Alumno carrera){
        int result = 0;
        
        return result;
    }
}
