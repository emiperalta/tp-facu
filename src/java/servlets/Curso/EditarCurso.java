package servlets.Curso;

import controllers.GestorDB;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Curso;

@WebServlet(name = "EditarCurso", urlPatterns = {"/EditarCurso"})
public class EditarCurso extends HttpServlet {

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
            Curso cursoObtenido = gestor.obtenerCursoPorId(id);

            request.setAttribute("cursoObtenido", cursoObtenido);
            RequestDispatcher rd = request.getRequestDispatcher("/editarCurso.jsp");
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
        int id = Integer.parseInt(request.getParameter("txtIdCurso"));
        String tema = request.getParameter("txtTema");
        String descripcion = request.getParameter("txtDescripcion");
        double costo = Double.parseDouble(request.getParameter("txtCosto"));
        
        Curso curso = new Curso(id, tema, descripcion, costo);
        GestorDB gestor = new GestorDB();
        gestor.actualizarCurso(curso);
        response.sendRedirect("/tp-facu/Curso");
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
