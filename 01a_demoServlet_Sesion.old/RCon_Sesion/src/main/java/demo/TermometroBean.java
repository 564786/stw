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

    private Double temperatura          = 1.0;
    private final Double NIVEL_MAXIMO   = 250.0;    // valor máximo del depósito
    
    private boolean lecturaIniciada     = false;
    private String resultado = "";
    private ConexionSSH conexionSSH = new ConexionSSH();
                
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
        
        if(lecturaIniciada()){
            resultado = conexionSSH.enviarComando("cat /sys/class/thermal/thermal_zone0/temp");


            //this.temperatura = this.temperatura +        1.1 ;
            this.temperatura = Double.parseDouble(resultado.substring(0,5))/1000;    
        }        
        websocket.broadcastValorNumerico(this.temperatura);
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
        conexionSSH.enviarComando("mosquitto_pub -h 192.168.1.140 -u stw -P stweb22 -t /stw/rr/s141/cmnd/POWER -m 1");
    }
    
    public void pararRefrigeracion(){
        conexionSSH.enviarComando("mosquitto_pub -h 192.168.1.140 -u stw -P stweb22 -t /stw/rr/s141/cmnd/POWER -m 0");
    }

}
