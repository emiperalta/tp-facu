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
            ResultSet rs = st.executeQuery("SELECT idProgramaFinal, nombrePrograma, pf.descripcion, descargas, disponible, c.tema, nombre + ' ' + apellido 'Alumno', filename, path\n" +
                                           "FROM ProgramasFinales pf JOIN Alumnos a ON pf.idAlumno = a.idAlumno \n" +
                                            "  JOIN Cursos c ON pf.idCurso = c.idCurso");

            while (rs.next()) {
                int idProgramaFinal = rs.getInt("idProgramaFinal");
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
                String fileName = rs.getString("filename");
                String path = rs.getString("path");

                DTOListadoProgramasFinales lstPF = new DTOListadoProgramasFinales(idProgramaFinal,nombreProg, descrip, descargas, disponible, tema, nombreAlumno, fileName, path);
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
    
    public DTODescargasProgramaFinal obtenerDescargasProgramaFinalPorId(int id) {
        DTODescargasProgramaFinal progfin = null;
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONN,USER,PASS);
            
            String sql = "SELECT idProgramaFinal, descargas FROM ProgramasFinales \n" + 
                         "WHERE idProgramaFinal = ?";
            
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                int idProgramaFinal = rs.getInt("idProgramaFinal");
                int descargas = rs.getInt("descargas");
                
                progfin = new DTODescargasProgramaFinal(idProgramaFinal, descargas);                
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
        
        return progfin;
    }
    
    public void sumarDescargas(DTODescargasProgramaFinal progfin) {
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = con.prepareStatement("UPDATE ProgramasFinales\n"
                                                      + "SET descargas = ?\n"
                                                      + "WHERE idProgramaFinal = ?");
            
            st.setInt(1, progfin.getDescargas() + 1);
            st.setInt(2, progfin.getIdProgramaFinal());

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
            
            String sql = "SELECT * FROM Alumnos \n" + 
                         "WHERE idAlumno = ?";
            
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            
            ResultSet rs = st.executeQuery();
            
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

            PreparedStatement st = con.prepareStatement("UPDATE Alumnos \n" +
                                                        "SET nombre = ?, apellido = ?, edad = ?, dni = ? \n" +
                                                        "WHERE idAlumno = ?");
            
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

            PreparedStatement st = con.prepareStatement("DELETE FROM Alumnos \n"+
                                                        "WHERE idAlumno = ?");
            
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
    
    public ArrayList<Curso> obtenerCursos() {
        ArrayList<Curso> lista = new ArrayList<>();
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONN, USER, PASS);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Cursos");

            while (rs.next()) {
                int id = rs.getInt("idCurso");
                String tema = rs.getString("tema");
                String descripcion = rs.getString("descripcion");
                double costo = rs.getDouble("costo");

                Curso lstC = new Curso(id, tema, descripcion, costo);
                lista.add(lstC);
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
    
    public Curso obtenerCursoPorId(int id) {
        Curso cur = null;
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONN,USER,PASS);
            
            String sql = "SELECT * FROM Cursos \n"+
                         "WHERE idCurso = ?";
            
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                int idCurso = rs.getInt("idCurso");
                String tema = rs.getString("tema");
                String descripcion = rs.getString("descripcion");
                double costo = rs.getDouble("costo");
                
                cur = new Curso(idCurso, tema, descripcion, costo);                
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
        
        return cur;
    }
    
    public void agregarCurso(Curso curso) {
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = con.prepareStatement("INSERT INTO Cursos VALUES(?,?,?)");
            
            st.setString(1, curso.getTema());
            st.setString(2, curso.getDescripcion());
            st.setDouble(3, curso.getCosto());

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
    
    public void actualizarCurso(Curso curso) {        
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = con.prepareStatement("UPDATE Cursos\n"
                                                      + "SET tema = ?, descripcion = ?, costo = ?\n"
                                                      + "WHERE idCurso = ?");
            
            st.setString(1, curso.getTema());
            st.setString(2, curso.getDescripcion());
            st.setDouble(3, curso.getCosto());
            st.setInt(4, curso.getIdCurso());

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
    
    public void eliminarCurso(Curso curso) {
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = con.prepareStatement("DELETE FROM Cursos WHERE idCurso = ?");
            
            st.setInt(1, curso.getIdCurso());

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
    
    public void agregarPrograma(ProgramaFinal programa) {
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = con.prepareStatement("INSERT INTO ProgramasFinales VALUES(?,?,?,?,?,?,?,?)");
            
            st.setString(1, programa.getNombrePrograma());
            st.setString(2, programa.getDescripcion());
            st.setInt(3, programa.getDescargas());
            st.setBoolean(4, programa.isDisponible());
            st.setInt(5, programa.getCurso().getIdCurso());
            st.setInt(6, programa.getAlumno().getIdAlumno());
            st.setString(7, programa.getFilename());
            st.setString(8, programa.getPath());

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
    
    public Descuento obtenerDescuentoPorId(int id) {
        Descuento desc = null;
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONN,USER,PASS);
            
            String sql = "SELECT * FROM Descuentos WHERE idDescuento = ?";
            
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                int idDescuento = rs.getInt("idDescuento");
                int porcentaje = rs.getInt("porcentaje");
                
                desc = new Descuento(idDescuento, porcentaje);                
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
        
        return desc;
    }
    
    public ArrayList<Descuento> obtenerDescuentos() {
        ArrayList<Descuento> lista = new ArrayList<>();
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONN, USER, PASS);
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Descuentos \n" +
                                           "ORDER BY porcentaje");

            while (rs.next()) {
                int id = rs.getInt("idDescuento");
                int porcentaje = rs.getInt("porcentaje");

                Descuento lstD = new Descuento(id, porcentaje);
                lista.add(lstD);
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
    
    public ArrayList<DTOListadoInscripciones> obtenerInscripciones() {
        ArrayList<DTOListadoInscripciones> lista = new ArrayList<>();
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONN, USER, PASS);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT idInscripcion, nombre + ' ' + apellido 'NombreAlumno', tema, \n"+
                                                "porcentaje, fechaInicio, fechaFin, monto, montoDescuento \n" +
                                           "FROM Inscripciones i JOIN Alumnos a ON i.idAlumno = a.idAlumno \n" +
                                           "    JOIN Cursos c ON i.idCurso = c.idCurso \n" +
                                           "    JOIN Descuentos d ON i.idDescuento = d.idDescuento");

            while (rs.next()) {
                int idInscripcion = rs.getInt("idInscripcion");
                String nombreAlumno = rs.getString("NombreAlumno");
                String temaCurso = rs.getString("tema");
                int porcentajeDesc = rs.getInt("porcentaje");
                String fechaInicio = rs.getString("fechaInicio");
                String fechaFin = rs.getString("fechaFin");
                double monto = rs.getDouble("monto");
                double montoDescuento = rs.getDouble("montoDescuento");

                DTOListadoInscripciones lstD = new DTOListadoInscripciones(idInscripcion, nombreAlumno, temaCurso, porcentajeDesc, fechaInicio, fechaFin, monto, montoDescuento);
                lista.add(lstD);
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
    
    public void agregarInscripcion(Inscripcion inscripcion) {
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = con.prepareStatement("INSERT INTO Inscripciones VALUES(?,?,?,?,?,?,?)");
            
            st.setInt(1, inscripcion.getAlumno().getIdAlumno());
            st.setInt(2, inscripcion.getCurso().getIdCurso());
            st.setInt(3, inscripcion.getDescuento().getIdDescuento());
            st.setString(4, inscripcion.getFechaInicio());
            st.setString(5, inscripcion.getFechaFin());
            st.setDouble(6, inscripcion.getMonto());
            st.setDouble(7, inscripcion.getMontoDescuento());

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
    
    
    // REPORTES
    
    public ArrayList<DTOTotalFacturadoPorCurso> obtenerTotalFacturadoPorCurso() {
        ArrayList<DTOTotalFacturadoPorCurso> lista = new ArrayList<>();
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONN, USER, PASS);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT i.idCurso, tema, SUM(monto) 'Total' \n" +
                                           "FROM Inscripciones i JOIN Cursos c ON i.idCurso = c.idCurso \n" +
                                           "GROUP BY i.idCurso, tema");

            while (rs.next()) {
                int idCurso = rs.getInt("idCurso");
                String tema = rs.getString("tema");
                double montoFacturado = rs.getDouble("Total");

                DTOTotalFacturadoPorCurso lstTF = new DTOTotalFacturadoPorCurso(idCurso, tema, montoFacturado);
                lista.add(lstTF);
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
    
    public DTOSumatoriaDescuentos obtenerSumatoriaDescuentos() {
        DTOSumatoriaDescuentos total = null;
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONN,USER,PASS);
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(montoDescuento) 'TotalDescuentos' \n" +
                                           "FROM Inscripciones");
            
            rs.next();
            double sumatoria = rs.getDouble("TotalDescuentos");
            
            total = new DTOSumatoriaDescuentos(sumatoria);
            
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
        return total;
    }
    
    public ArrayList<Alumno> obtenerAlumnosCursoSeleccionado(int idCurso) {
        ArrayList<Alumno> lista = new ArrayList<>();
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONN, USER, PASS);

            String sql = "SELECT a.idAlumno, nombre, apellido, edad, dni \n" +
                         "FROM Inscripciones i JOIN Alumnos a ON i.idAlumno = a.idAlumno \n" +
                         "WHERE idCurso = ?";
            
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, idCurso);
            
            ResultSet rs = st.executeQuery();

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
    
    public ArrayList<DTOProgramasMasDescargados> obtener5ProgramasMasDescargados() {
        ArrayList<DTOProgramasMasDescargados> lista = new ArrayList<>();
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONN, USER, PASS);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT TOP 5 nombrePrograma, descargas \n" +
                                           "FROM ProgramasFinales \n" +
                                           "ORDER BY descargas DESC");

            while (rs.next()) {
                String nombrePrograma = rs.getString("nombrePrograma");
                int descargas = rs.getInt("descargas");

                DTOProgramasMasDescargados lstPMD = new DTOProgramasMasDescargados(nombrePrograma, descargas);
                lista.add(lstPMD);
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
    
    public ArrayList<DTOAlumnosConAlgunDescuento> obtenerAlumnosConDescuento() {
        ArrayList<DTOAlumnosConAlgunDescuento> lista = new ArrayList<>();
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONN, USER, PASS);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT DISTINCT i.idAlumno, nombre + ' ' + apellido 'NombreAlumno', dni \n" +
                                           "FROM Inscripciones i JOIN Alumnos a on i.idAlumno = a.idAlumno \n" +
                                           "WHERE montoDescuento > 0");

            while (rs.next()) {
                int idAlumno = rs.getInt("idAlumno");
                String nombreCompleto = rs.getString("NombreAlumno");
                String dni = rs.getString("dni");

                DTOAlumnosConAlgunDescuento lstAD = new DTOAlumnosConAlgunDescuento(idAlumno, nombreCompleto, dni);
                lista.add(lstAD);
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
}