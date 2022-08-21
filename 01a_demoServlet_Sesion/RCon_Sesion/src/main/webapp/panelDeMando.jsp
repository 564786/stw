<%-- 
    Document   : panelDeMando
    Created on : 15 ago 2022, 18:09:14
    Author     : rafar
--%>



<%@page import="java.io.IOException"%>
<%@page import="com.jcraft.jsch.JSchException"%>
<%@page import="demo.SSHConnector"%>
<%@page import="demo.Raspberry"%>
<%@page import="com.jcraft.jsch.JSchException"%>
<%@page import="java.io.IOException"%>
<%@page import="static java.lang.Integer.parseInt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


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
            <tr>
                <td>
                    <form method="get" action="temperatura.jsp">
                        <button type="submit">Ver temperaturas</button>
                    </form>
                </td>
            </tr>

            <tr>
                <td>
                    <form method="POST" action="conexionSSH">
                        <input type=hidden name=s1 value=encender>
                        <button type="submit">Refrigerar</button>
                    </form>

                </td>
            </tr>
            <tr>
                <td>
                    <form method="POST" action="conexionSSH">
                        <input type=hidden name=s1 value=apagar>
                        <button type="submit">Parar refrigeracion</button>
                    </form>
                </td>
            </tr>
        </table>

        <br><br><br><br>
        <a href="index.jsp">Inicio</a>

    </body>
</html>
