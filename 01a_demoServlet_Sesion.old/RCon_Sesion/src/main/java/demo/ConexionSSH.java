/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;


import com.jcraft.jsch.JSchException;
//import demo.SSHConnector;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet(name = "ConexionSSH", urlPatterns = {"/conexionSSH"})
public class ConexionSSH /*extends HttpServlet*/{
    
    private static final String USERNAME = "pi";
    private static final String HOST = "192.168.1.142";
    private static final int PORT = 22;
    private static final String PASSWORD = "raspberry";
    private static final String REFRIGERAR = "mosquitto_pub -h 192.168.1.140 -u stw -P stweb22 -t /stw/rr/s141/cmnd/POWER -m 1";
    private static final String PARAR_REFRIGERACION = "mosquitto_pub -h 192.168.1.140 -u stw -P stweb22 -t /stw/rr/s141/cmnd/POWER -m 0";
    private static final String LEER_TEMPERATURA = "cat /sys/class/thermal/thermal_zone0/temp";
    private static final String PARAR_LECTURA = "";
        
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
}