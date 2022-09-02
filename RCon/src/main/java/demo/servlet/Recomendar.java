/**
 * @author Alvaro Fraidias NIP 780336
 * @author Rafael Rodriguez NIP 564786
 * 
 * Referencias utilizadas:
 * apuntes de @fserna
 * 
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Recomendar", urlPatterns = {"/recomendar"})
public class Recomendar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String recomendacion = "";
        
        Double s1 = Double.valueOf(request.getParameter("s1"));
        Double s2 = Double.valueOf(request.getParameter("s2"));
        Double diferencia = s1 - s2;
                        
        recomendacion = "Temperatura RPi: " + s1 + "<br>" + 
                "<bt>Temperatura OW: " + s2 + "<br>" ;
        
        if(diferencia <= 10){
            recomendacion = recomendacion + "<br> No es necesario tomar "
                    + "ninguna accion";
        }else{
            recomendacion = recomendacion + "<br> Es necesario refrigerar";
        }

        
        HttpSession session = request.getSession();
        session.setAttribute("recomendacion", recomendacion);
        
        response.sendRedirect("visualizadorRecomendacion");
    }

    @Override
    public void init(){
        System.out.println("===== INIT");
    }
    
    
    @Override
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
    @Override
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
