<%-- 
    Document   : panelDeMando
    Created on : 15 ago 2022, 18:09:14
    Author     : rafar
--%>



<%@page import="demo.ConexionSSH"%>
<%@page import="java.io.IOException"%>
<%@page import="com.jcraft.jsch.JSchException"%>
<%@page import="demo.SSHConnector"%>
<%@page import="demo.Raspberry"%>
<%@page import="com.jcraft.jsch.JSchException"%>
<%@page import="java.io.IOException"%>
<%@page import="static java.lang.Integer.parseInt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%ConexionSSH conexionSSH = new ConexionSSH();
    final String REFRIGERAR = "mosquitto_pub -h 192.168.1.140 -u stw -P stweb22 -t /stw/rr/s141/cmnd/POWER -m 1";
    final String PARAR_REFRIGERACION = "mosquitto_pub -h 192.168.1.140 -u stw -P stweb22 -t /stw/rr/s141/cmnd/POWER -m 0";
    %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Raspberry Controller</title>
    </head>
    
    <body>
        <h1>Panel del mando Raspberry Controller</h1>
        <hr>
        <br>   
        
        <table border="back">
            <tr>
                <td>
                    <h2>Menu</h2>
                </td>
            </tr>
            <tr>
                <td>
                    <form method="get" action="temperatura.jsp">
                        <button type="submit">Ver temperaturas</button>
                    </form>
                </td>
            </tr>            
        </table>
                
        <br><br>
        <a href="index.jsp">Inicio</a>

    </body>
</html>
