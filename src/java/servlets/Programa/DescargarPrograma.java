package servlets.Programa;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DescargarPrograma", urlPatterns = {"/DescargarPrograma"})
public class DescargarPrograma extends HttpServlet {

    public static int BUFFER_SIZE = 1024 * 100;
    public static final String UPLOAD_DIR = "public\\archivos";
    public static String fileName = null;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        fileName = request.getParameter("fileName");
        if (fileName == null || fileName.equals("")) {
            response.setContentType("text/html");
            response.getWriter().println("<h3>File " + fileName + "is not present!</h3>");
        } else {
           String appliactionPath = getServletContext().getRealPath("");
           String downloadPath = appliactionPath + File.separator + UPLOAD_DIR;
           String filePath = downloadPath + File.separator + fileName;
           File file = new File(filePath);
           OutputStream outStream = null;
            FileInputStream inputStream = null;
            
            if (file.exists()) {
                String mimeType = "application/octet-stream";
                response.setContentType(mimeType);
                
                String headerKey = "Content-Disposition";
                String headerValue = String.format("attachment; filename=\"%s\"", file.getName());
                response.setHeader(headerKey, headerValue);
                
                try {
                    outStream = response.getOutputStream();
                    inputStream = new FileInputStream(file);
                    byte[] buffer = new byte[BUFFER_SIZE];
                    int bytesRead = -1;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outStream.write(buffer, 0, bytesRead);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }

                    outStream.flush();
                    if (outStream != null) {
                        outStream.close();
                    }

                    //HACER +1 METOAJSDKLa hjslbk
                }
            } else {
                response.setContentType("text/html");
                response.getWriter().println("<h3>File " + fileName + " Is Not Present .....!</h3>");
            }
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
