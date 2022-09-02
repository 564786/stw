/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import demo.servlet.WebSocketManager;
import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author fserna
 */
@Stateless
public class TermometroBean {

    private final String COMANDO_LEER_TEMPERATURA = "cat "
            + "/sys/class/thermal/thermal_zone0/temp";
    private final String COMANDO_INICIAR_REFRIGERACION = "mosquitto_pub -h "
            + "192.168.1.140 -u stw -P stweb22 -t /stw/rr/s141/cmnd/POWER -m 1";
    private final String COMANDO_PARAR_REFRIGERACION = "mosquitto_pub -h "
            + "192.168.1.140 -u stw -P stweb22 -t /stw/rr/s141/cmnd/POWER -m 0";
    
    private Double temperatura          = 0.0;
    
    private boolean lecturaIniciada     = false;
    private String resultado = "";
    private ConexionSSH conexionSSH = new ConexionSSH();
    public double tempCPU = 0.0;
                
    @EJB  WebSocketManager websocket;
    
    
    @PostConstruct
    public void init(){
        //websocket = WebSocketManager.getInstance();
    }
    
    @PreDestroy
    private void sayBye(){
        //if (websocket!=null){
            websocket.destroy();  // propaga el evento de "destroy" al elemento
                                 // que gestiona las sesiones websocket, 
                                 // para que puedan ser cerradas convenientemente.
        //}
    }
   
    @Schedule (hour="*", minute="*", second="*/1")
    public void leerTemperatura(){        
        this.temperatura = 0.0;
        if(this.lecturaIniciada){
            //resultado = conexionSSH.enviarComando(COMANDO_LEER_TEMPERATURA);
            //this.temperatura = Double.parseDouble(resultado.substring(0,5))/1000;   
            this.temperatura = envioComandoLecturaTemperatura();
        } else {
            this.temperatura = 0.0;
        }
        
        websocket.broadcastValorNumerico(this.temperatura);
    }
    
    public double envioComandoLecturaTemperatura(){        
        double temp = 0.0;
        resultado = conexionSSH.enviarComando(COMANDO_LEER_TEMPERATURA);
        temp = Double.parseDouble(resultado.substring(0,5))/1000;
        return temp;
    }
    
    public boolean lecturaIniciada(){
        return lecturaIniciada;
    }
    
    public void setEstadoLectura(boolean _estado){
        this.lecturaIniciada = _estado;
        if(this.lecturaIniciada){
            websocket.broadcastMsg("lecturaIniciada");
        }else{
            websocket.broadcastMsg("lecturaParada");
        }
    }
    
    public void iniciarRefrigeracion(){
        conexionSSH.enviarComando(COMANDO_INICIAR_REFRIGERACION);
    }
    
    public void pararRefrigeracion(){
        conexionSSH.enviarComando(COMANDO_PARAR_REFRIGERACION);
    }

    public double getTempCPU(){
        tempCPU = envioComandoLecturaTemperatura(); 
        return tempCPU;
        
    }
}
