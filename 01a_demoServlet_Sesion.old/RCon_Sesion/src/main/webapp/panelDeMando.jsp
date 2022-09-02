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
            <tr>
                <td>
            <button id="botonIniciarRefrigeracion" onclick="iniciarRefrigeracion();">Iniciar Refrigeración</button> 
                </td>
            </tr>
            <tr>
                <td>
                    <button id="botonParararRefrigeracion" onclick="pararRefrigeracion();">Parar Refrigeración</button>   
                </td>
            </tr>
            <tr>
                <td>
                    <!--button id="botonIniciarRefrigeracion" onclick="iniciarRefrigeracion();">Iniciar Refrigeración</button> 
                    <button id="botonParararRefrigeracion" onclick="pararRefrigeracion();">Parar Refrigeración</button--> 
                    <button id="botonIniciarLectura" onclick="iniciarLectura();">Iniciar Lectura</button> 
                </td>
            </tr>
            <tr>
                <td>
                    <button id="botonPararLectura" onclick="pararLectura();">Parar Lectura</button>

                </td>
            <tr>
                <td>
                    <form method="POST" action="recomendar">
                        <!--SUSTITUIR ESTAS DOS LÍNEAS POR LA MEDIA DE TEMPERATURAS-->
                        <input type=hidden name=s1 value=100>
                        <input type=hidden name=s2 value=50>
                        <!----------------------------------------------------------->
                        <button type="submit">Mostrar recomendacion</button>
                    </form>
                </td>
            </tr>
        </table>
        
        <script type="text/javascript" src="websocket.js"></script>
        
        <br><br><br><br>
        <a href="index.jsp">Inicio</a>

    </body>
</html>
