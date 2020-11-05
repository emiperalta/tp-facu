/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.Alumno;

import controllers.GestorDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Alumno;

/**
 *
 * @author Emiliano
 */
@WebServlet(name = "EditarAlumno", urlPatterns = {"/EditarAlumno"})
public class EditarAlumno extends HttpServlet {

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
            String sId = request.getParameter("id");
            int id = Integer.parseInt(sId);

            GestorDB gestor = new GestorDB();
            Alumno alumnoObtenido = gestor.obtenerAlumnoPorId(id);

            request.setAttribute("alumnoObtenido", alumnoObtenido);
            RequestDispatcher rd = request.getRequestDispatcher("/editarAlumno.jsp");
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
        int id = Integer.parseInt(request.getParameter("txtIdAlumno"));
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        int edad = Integer.parseInt(request.getParameter("txtEdad"));
        String dni = request.getParameter("txtDni");
        
        Alumno a = new Alumno(id, nombre, apellido, edad, dni);
        GestorDB gestor = new GestorDB();
        gestor.actualizarAlumno(a);
        response.sendRedirect("/tp-facu/Alumno");
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
