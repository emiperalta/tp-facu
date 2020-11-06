package servlets.Reporte;

import controllers.GestorDB;
import dtos.*;
import models.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MenuReporte", urlPatterns = {"/Reporte"})
public class MenuReporte extends HttpServlet {
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
           
            //Total facturado por cada curso
            ArrayList<DTOTotalFacturadoPorCurso> listaMontoCurso = gestor.obtenerTotalFacturadoPorCurso();
            request.setAttribute("listaMontoCurso", listaMontoCurso);
            
            //Sumatoria total de los descuentos realizados
            DTOSumatoriaDescuentos sumatoriaDescuentos = gestor.obtenerSumatoriaDescuentos();
            request.setAttribute("sumatoriaDescuentos", sumatoriaDescuentos);
            
            //Carga de combobox de cursos para reporte de alumnos por curso
            ArrayList<Curso> listaCursos = gestor.obtenerCursos();
            request.setAttribute("listaCursos", listaCursos);
            
            //Listado de alumnos de algún curso seleccionado            
            if(request.getParameter("cmbCurso") != null) {
                int idCursoCMB = Integer.parseInt(request.getParameter("cmbCurso"));
                ArrayList<Alumno> listaAlumnosxCurso = gestor.obtenerAlumnosCursoSeleccionado(idCursoCMB);
                request.setAttribute("listaAlumnosxCurso", listaAlumnosxCurso);
            }
            
            //Listado de los 5 programas más descargados
            ArrayList<DTOProgramasMasDescargados> listaProgramasMasDesc = gestor.obtener5ProgramasMasDescargados();
            request.setAttribute("listaProgramasMasDesc", listaProgramasMasDesc);
            
            /*Listado de todos los alumnos que accedieron a algún descuento. Si un alumno
            tiene descuentos en más de un curso, sólo debe aparecer una única vez en el
            listado.*/
            ArrayList<DTOAlumnosConAlgunDescuento> listaAlumnosConDesc = gestor.obtenerAlumnosConDescuento();
            request.setAttribute("listaAlumnosConDesc", listaAlumnosConDesc);
            
            RequestDispatcher rd = request.getRequestDispatcher("/menuReportes.jsp");
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
