<%-- 
    Document   : panelDeMando
    Created on : 15 ago 2022, 18:09:14
    Author     : rafar
--%>

<%@page import="demo.Raspberry"%>
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
        
        <table>
            <tr>
                <td>
                    <h2>Menu</h2>
                </td>
            </tr>
            <tr>
                <td>
                    <form method="get" action="temperatura.jsp">
                        <button type="submit">Mostrar temperatura</button>
                    </form>
                </td>
            </tr>
            <tr>
                <td>
                    <form method="POST" action="recomendar">
                        <input type=hidden name=s1 value=100>
                        <input type=hidden name=s2 value=50>
                        <button type="submit">Mostrar recomendacion</button>
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
            <tr>
                <td>                    
                <form method="POST" action="conexionSSH">
                    <input type=hidden name=s1 value=comenzarlectura>
                    <button type="submit">Comenzar lecturas</button>
                </form>
                </td>
            </tr>
            <tr>
                <td>                
                    <form method="POST" action="conexionSSH">
                    <input type=hidden name=s1 value=pararlectura>
                    <button type="submit">Parar lecturas</button>
                </form></td>
            </tr>
        </table>
        
            <br>
            <br>
            <br>
            <br>
        <a href="index.jsp">Inicio</a>

    </body>
</html>
