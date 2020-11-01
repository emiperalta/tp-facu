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
            con = DriverManager.getConnection(CONN, USER, PASS);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT nombrePrograma, pf.descripcion, descargas, disponible, c.tema, nombre + ' ' + apellido 'Alumno'\n"
                    + "FROM ProgramasFinales pf JOIN Alumnos a ON pf.idAlumno = a.idAlumno \n"
                    + "	JOIN Cursos c ON pf.idCurso = c.idCurso");

            while (rs.next()) {
                String nombreProg = rs.getString("nombrePrograma");
                String descrip = rs.getString("descripcion");
                int descargas = rs.getInt("descargas");
                int isDisponible = rs.getInt("disponible");
                boolean disponible;
                if (isDisponible == 1) {
                    disponible = true;
                } else {
                    disponible = false;
                }
                String tema = rs.getString("tema");
                String nombreAlumno = rs.getString("Alumno");

                DTOListadoProgramasFinales lstPF = new DTOListadoProgramasFinales(nombreProg, descrip, descargas, disponible, tema, nombreAlumno);
                lista.add(lstPF);
            }

            st.close();
            rs.close();
        } catch (Exception ex) {
            Logger.getLogger(GestorDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return lista;
    }

    public ArrayList<Alumno> obtenerAlumnos() {
        ArrayList<Alumno> lista = new ArrayList<>();
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONN, USER, PASS);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Alumnos");

            while (rs.next()) {
                int id = rs.getInt("idAlumno");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int edad = rs.getInt("edad");
                String dni = rs.getString("dni");

                Alumno lstA = new Alumno(id, nombre, apellido, edad, dni);
                lista.add(lstA);
            }

            st.close();
            rs.close();
        } catch (Exception ex) {
            Logger.getLogger(GestorDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return lista;
    }
    
    public Alumno obtenerAlumnoPorId(int id) {
        Alumno alum = null;
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONN,USER,PASS);
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Alumnos WHERE idAlumno="+id);
            
            if (rs.next()) {
                int idAlumno = rs.getInt("idAlumno");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int edad = rs.getInt("edad");
                String dni = rs.getString("dni");
                
                alum = new Alumno(idAlumno, nombre, apellido, edad, dni);                
            }
            
            st.close();            
            con.close();            
        } 
        catch (Exception ex) {
            Logger.getLogger(GestorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception exc)
            {
                exc.printStackTrace();
            }
        }
        
        return alum;
    }

    public void agregarAlumno(Alumno alumno) {
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = con.prepareStatement("INSERT INTO Alumnos VALUES(?,?,?,?)");
            
            st.setString(1, alumno.getNombre());
            st.setString(2, alumno.getApellido());
            st.setInt(3, alumno.getEdad());
            st.setString(4, alumno.getDni());

            st.executeUpdate();

            st.close();
        } catch (Exception ex) {
            Logger.getLogger(GestorDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void actualizarAlumno(Alumno alumno) {        
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = con.prepareStatement("UPDATE Alumnos\n"
                                                      + "SET nombre = ?, apellido = ?, edad = ?, dni = ?\n"
                                                      + "WHERE idAlumno = ?");
            
            st.setString(1, alumno.getNombre());
            st.setString(2, alumno.getApellido());
            st.setInt(3, alumno.getEdad());
            st.setString(4, alumno.getDni());
            st.setInt(5, alumno.getIdAlumno());

            st.executeUpdate();

            st.close();
        } catch (Exception ex) {
            Logger.getLogger(GestorDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void eliminarAlumno(Alumno alumno) {
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = con.prepareStatement("DELETE FROM Alumnos WHERE idAlumno = ?");
            
            st.setInt(1, alumno.getIdAlumno());

            st.executeUpdate();

            st.close();
        } catch (Exception ex) {
            Logger.getLogger(GestorDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
