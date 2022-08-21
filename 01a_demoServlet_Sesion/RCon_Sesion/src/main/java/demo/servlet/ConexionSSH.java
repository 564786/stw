/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo.servlet;


import com.jcraft.jsch.JSchException;
import demo.SSHConnector;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ConexionSSH", urlPatterns = {"/conexionSSH"})
public class ConexionSSH extends HttpServlet{
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 
    private static final String USERNAME = "pi";
    private static final String HOST = "192.168.1.142";
    private static final int PORT = 22;
    private static final String PASSWORD = "raspberry";
    private static final String REFRIGERAR = "mosquitto_pub -h 192.168.1.140 -u stw -P stweb22 -t /stw/rr/s141/cmnd/POWER -m 1";
    private static final String PARAR_REFRIGERACION = "mosquitto_pub -h 192.168.1.140 -u stw -P stweb22 -t /stw/rr/s141/cmnd/POWER -m 0";
    private static final String LEER_TEMPERATURA = "cat /sys/class/thermal/thermal_zone0/temp";
    private static final String PARAR_LECTURA = "";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = "";
        Boolean refrigerando = false;
        String resultadoComando = "";
        String lecturaTemperaturas;
        Boolean leerTemperaturas = false;
        String s1 = String.valueOf(request.getParameter("s1"));              
        accion = s1;
        
        HttpSession session = request.getSession();
        
        switch(accion)
        {
            case "encender":
                resultadoComando = enviarComando(REFRIGERAR);
                refrigerando = true;
                response.sendRedirect("panelDeMando.jsp");
            break;
            case "apagar":
                resultadoComando = enviarComando(PARAR_REFRIGERACION);
                refrigerando = false;
                response.sendRedirect("panelDeMando.jsp");
            
            case "comenzarLectura":
                session.setAttribute("lecturaTemperaturas", " ");
                leerTemperaturas = true;
                lecturaTemperaturas = enviarComando(LEER_TEMPERATURA);
                //leerTemperatura();
                session.setAttribute("lecturaTemperaturas", lecturaTemperaturas);
                session.setAttribute("leerTemperaturas", leerTemperaturas);
                
                response.sendRedirect("temperatura.jsp"); 
            break;
            case "finalizarLectura":
                leerTemperaturas = false;
                session.setAttribute("leerTemperaturas", leerTemperaturas);
                response.sendRedirect("temperatura.jsp");
            break;    
            
        }       
    }
    /*
    public String leerTemperatura(){
        String lectura = "";
        
        while(leer){    
    
            lectura = lectura + "\n"+ enviarComando(LEER_TEMPERATURA);
        }       
        return lectura;
    }
    */
    
    public String enviarComando(String comando){
        
        String resultado = "";
        
        try {
            SSHConnector sshConnector = new SSHConnector();             
             
            sshConnector.connect(USERNAME, PASSWORD, HOST, PORT);
            resultado = sshConnector.executeCommand(comando);
            sshConnector.disconnect();
            
            //ESTO ES LO QUE DEVUELVE EL COMANDO
            System.out.println(resultado);
        } catch (JSchException ex) {
            ex.printStackTrace();
             
            System.out.println(ex.getMessage());
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
             
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
             
            System.out.println(ex.getMessage());
        }
        
        return resultado;
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