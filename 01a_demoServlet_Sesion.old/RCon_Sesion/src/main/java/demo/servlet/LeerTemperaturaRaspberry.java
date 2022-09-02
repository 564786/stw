/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo.servlet;

import demo.Raspberry;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rafar
 */
@WebServlet(name = "LeerTemperaturaRaspberry", urlPatterns = {"/leerTemperaturaRaspberry"})
public class LeerTemperaturaRaspberry extends HttpServlet {
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
        
        String s1 = String.valueOf(request.getParameter("s1"));
        String ipRaspberry = s1;
        //String URL = "file://"+s1+"/tcp.txt"
        
        Boolean encendida;
                
        //String s1 = String.valueOf(request.getParameter("s1"));
        //String ipRaspberry = s1;
        ArrayList ipConsultadas = new ArrayList();
        
        Raspberry raspberry = new Raspberry();
        raspberry.encendida(ipRaspberry);
        encendida = raspberry.getEstado();
        ipConsultadas.add(s1);
                
        HttpSession session = request.getSession();
        session.setAttribute("ipRaspberry", ipRaspberry);
        session.setAttribute("encendida", encendida);
        session.setAttribute("ipConsultadas", ipConsultadas);
        

        
        
        
        response.sendRedirect("visualizadorDeEstado");
    }
    
    

    public void init(){
        System.out.println("===== INIT");
    }
    
    
    public void destroy(){
        System.out.println("===== DESTROY");
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
