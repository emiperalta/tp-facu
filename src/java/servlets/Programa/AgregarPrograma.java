package servlets.Programa;

import controllers.GestorDB;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Alumno;
import models.Curso;
import models.ProgramaFinal;

@WebServlet(name = "Programa", urlPatterns = {"/AgregarPrograma"})
public class AgregarPrograma extends HttpServlet {
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = (String) request.getSession().getAttribute("usuario");
        if (usuario != null && !usuario.equals("")) {
            GestorDB gestor = new GestorDB();
            ArrayList<Alumno> listaAlumnos = gestor.obtenerAlumnos();
            ArrayList<Curso> listaCursos = gestor.obtenerCursos();
            
            request.setAttribute("listaAlumnos", listaAlumnos);
            request.setAttribute("listaCursos", listaCursos);
            
            RequestDispatcher rd = request.getRequestDispatcher("/agregarPrograma.jsp");
            rd.forward(request, response);
        } else {
            response.sendRedirect("/tp-facu/Principal");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        GestorDB gestor = new GestorDB();
        
        int idAlumnoCMB = Integer.parseInt(request.getParameter("cmbAlumno"));
        Alumno idAlumno = gestor.obtenerAlumnoPorId(idAlumnoCMB);
        
        int idCursoCMB = Integer.parseInt(request.getParameter("cmbCurso"));
        Curso idCurso = gestor.obtenerCursoPorId(idCursoCMB);
        
        String nombrePrograma = request.getParameter("txtNombrePrograma");
        String descripcion = request.getParameter("txtDescripcion");
        
        boolean disponible = false;
        if(request.getParameter("txtDisponible") == null) {
            disponible = false;
        } else {
            disponible = true;
        }
        
        ProgramaFinal programaFinal = new ProgramaFinal(0, nombrePrograma, descripcion, 0, disponible, idCurso, idAlumno);
        
        gestor.agregarPrograma(programaFinal);
        response.sendRedirect("/tp-facu/Principal");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
