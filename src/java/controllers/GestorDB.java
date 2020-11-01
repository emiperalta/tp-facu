package controllers;

import dtos.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.*;

public class GestorDB {
    private String CONN = "jdbc:sqlserver://localhost;databaseName=TPTema3";    
    private String USER = "sa";
    private String PASS = "password";
    
    public ArrayList<DTOListadoProgramasFinales> obtenerProgramasFinales() {
        ArrayList<DTOListadoProgramasFinales> lista = new ArrayList<>();
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONN,USER,PASS);
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT nombrePrograma, pf.descripcion, descargas, disponible, c.tema, nombre + ' ' + apellido 'Alumno'\n" +
                                            "FROM ProgramasFinales pf JOIN Alumnos a ON pf.idAlumno = a.idAlumno \n" +
                                            "	JOIN Cursos c ON pf.idCurso = c.idCurso");

            while (rs.next()) {
                String nombreProg = rs.getString("nombrePrograma");
                String descrip = rs.getString("descripcion");
                int descargas = rs.getInt("descargas");
                int isDisponible = rs.getInt("disponible");
                boolean disponible;
                if (isDisponible == 1) disponible = true;
                else disponible = false;
                String tema = rs.getString("tema");
                String nombreAlumno = rs.getString("Alumno");

                DTOListadoProgramasFinales lstPF = new DTOListadoProgramasFinales(nombreProg, descrip, descargas, disponible, tema, nombreAlumno);
                lista.add(lstPF);
            }

            st.close();
            rs.close();
        } 
        catch (Exception ex) {
            Logger.getLogger(GestorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
        
        return lista;
    }
    
    public ArrayList<DTOAlumnos> obtenerAlumnos() {
        ArrayList<DTOAlumnos> lista = new ArrayList<>();
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONN,USER,PASS);
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT idAlumno, nombre, apellido, dni\n" +
                                            "FROM Alumnos");

            while (rs.next()) {
                int id = rs.getInt("idAlumno");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String dni = rs.getString("dni");

                DTOAlumnos lstA = new DTOAlumnos(id, nombre, apellido, dni);
                lista.add(lstA);
            }

            st.close();
            rs.close();
        } 
        catch (Exception ex) {
            Logger.getLogger(GestorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
        
        return lista;
    }
    
    public void agregarAlumno() {
        
    }
}
