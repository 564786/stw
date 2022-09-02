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
package demo;

import com.jcraft.jsch.JSchException;
//import demo.SSHConnector;
import java.io.IOException;

public class ConexionSSH /*extends HttpServlet*/{
    
    private static final String USERNAME = "pi";
    private static final String HOST = "192.168.1.142";
    private static final int PORT = 22;
    private static final String PASSWORD = "raspberry";
        
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