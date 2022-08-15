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
        <h2>Menu</h2>
        <br>
            <form method="POST" action="comprobarEstado">
            <input type=hidden name=s1 value=100>
            <button type="submit">Comprobar Estado</button>
        </form>
        <form method="get" action="temperatura.html">
            <button type="submit">Mostrar temperatura</button>
        </form>
        <br>
        <br>
        <form method="get" action="temperatura.html">
            <button type="submit">Mostrar temperatura</button>
        </form>
        <br>
        <br>
    </body>
</html>
