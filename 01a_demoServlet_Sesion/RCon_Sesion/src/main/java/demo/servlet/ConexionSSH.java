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
    private static final String HOST = "192.168.99.60";
    private static final int PORT = 22;
    private static final String PASSWORD = "raspberry";
    private static final String REFRIGERAR = "Mosquitto_pub -u stw -P stweb22 -t /stw/rr/s141/cmnd/POWER -m 1";
    private static final String PARAR_REFRIGERACION = "Mosquitto_pub -h 192.168.1.140 -u stw -P stweb22 -t /stw/rr/s141/cmnd/POWER -m 0";
    private static final String LEER_TEMPERATURA = "";
    private static final String PARAR_LECTURA = "";
    //private String comando = "";
    private Boolean leer = false;
    private String lecturaTemperatura = "";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = "";
        Boolean refrigerando = false;
        
        String s1 = String.valueOf(request.getParameter("s1"));
              
        accion = s1;
        
        switch(accion)
        {
            case "encender":
                enviarComando(REFRIGERAR);
                refrigerando = true;
            break;
            case "apagar":
                enviarComando(PARAR_REFRIGERACION);
                refrigerando = false;
                
            case "comenzarlectura":
                leer = true;
                leerTemperatura();
            break;
            case "pararlectura":
                leer = false;                
            break;            
        }
        
        HttpSession session = request.getSession();
        session.setAttribute("resultadoComando", refrigerando.toString());
        
        response.sendRedirect("panelDeMando.jsp");        
    }
    
    public String leerTemperatura(){
        String lectura ="";
        
        while(leer){    
            lectura = lectura + "\n"+ enviarComando(LEER_TEMPERATURA);
        }       
        return lectura;
    }
    
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