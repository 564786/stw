/**
 * @author Alvaro Fraidias NIP 780336
 * @author Rafael Rodriguez NIP 564786
 * 
 * Referencias utilizadas:
 * apuntes de @fserna
 * 
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "VisualizadorDeEstado", urlPatterns = {"/visualizadorDeEstado"})
public class VisualizadorDeEstado extends HttpServlet{
    

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
        
        HttpSession session = request.getSession();
        String ipRaspberry = (String)session.getAttribute("ipRaspberry");
        Boolean encendida = (Boolean)session.getAttribute("encendida");
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet VisualizadorDeEstado</title>");  
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            out.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css\"  crossorigin=\"anonymous\">");
            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VisualizadorDeEstado</h1>");
            out.println("<br><br>");
            out.println("Mostrando host: <b>"+ ipRaspberry +"</b>");
            out.println("<br><br>");
            out.println("Tu Raspberry se encuentra:");
            out.println("<br>");
            
            if (encendida){
            out.println("<br><br>");
            out.println("<b>Encendida</b>");
            out.println("<br><br>");
            out.println("<img src=\"raspSwitchedOn.png\" width = 300>");
            
            out.println("<br><br><br>");
            
            out.println("<form method=\"POST\" action=\"panelDeMando.jsp\">");
            out.println("<input type=hidden name=s1 value=100>");
            out.println("<button type=\"submit\">Acceder al panel de mando</button>");
            out.println("</form>");
            
             }else{
            out.println("<br><br>");
            out.println("Apagada");
            out.println("<br><br>");
            out.println("<img src=\"raspSwitchedOff.png\" width = 300>");
            
            }
            
            //out.println("<a href=\"panelDeMando.jsp\">Acceder al panel de mando</a>");
            out.println("<br><br><br>");
            out.println("<a href=\"index.jsp\">Inicio</a>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
