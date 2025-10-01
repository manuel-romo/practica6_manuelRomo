
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author Manuel Romo López
 * ID: 00000253080
 */
@WebServlet(name = "UsuariosServlet", urlPatterns = {"/UsuariosServlet"})
public class UsuariosServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsuariosServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsuariosServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        
        String nombre = request.getParameter("txt_name");
        
        if(nombre == null || nombre.isBlank()){
            processParameterErrorRequest(request, response);
            return;
        }
        
        String mensaje = String.format("\"Bienvenido %s!\"", nombre);
        response.setContentType("appllication/json");
        
        try (PrintWriter out = response.getWriter()){
            out.println("{\"mensaje\": "+ mensaje+"}");
        }
        
    }
    
    protected void processParameterErrorRequest
        (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
            response.setContentType("text/html;charset=UTF-8");
            
            try(PrintWriter out = response.getWriter()){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet UsuariosServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>No se encontró el parámetro nombre</h1>");
                out.println("</body>");
                out.println("</html>");
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
        
        String nombre = request.getParameter("txt_name");
        String pseudonimo = request.getParameter("txt_nickname");
        String correo = request.getParameter("txt_mail");
        String cotrasenia = request.getParameter("txt_password");
        String estado = request.getParameter("radios_estados");
        String tipoCuenta = request.getParameter("sel_account");
        String fechaNacimiento = request.getParameter("txt_dob");
        String terminos = request.getParameter("chk_tyc");
        
        
        if(terminos.equalsIgnoreCase("aceptado")){
            String content = String.format(
                    "Usuario registrado <br>"+
                    "Nombre: %s <br>"+
                    "Correo: %s <br>"+
                    "Contraseña: ********  <br>"+                                     
                    "Estado: %s <br>"+
                    "Tipo de cuenta: %s <br>"+
                    "Fecha de nacimiento: %s"
                    , nombre, correo, estado, tipoCuenta, fechaNacimiento);
                    
            response.setContentType("text/html;charset=UTF-8");
            
            try(PrintWriter out = response.getWriter()){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet UsuariosServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Usuario registrado</h1>");
                out.println("<h3>" + content + "</h3>");
                out.println("</body>");
                out.println("</html>");
            }
            
            
        }
        
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
