<%-- 
    Document   : index
    Created on : 15 ago 2022, 14:32:19
    Author     : rafar
--%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Raspberry Controller</title>
    </head>
    
    
    <body>
        <h1>Bienvenido/a a Raspberry Controller</h1>
        <hr>

        <br>
        <b>IMPORTANTE</b>: Tu navegador debe permitir cookies.
        <br>
        <br>
        
        <form method="POST" action="comprobarEstado">
            <table>
                <tr>
                    <td>Introduzca la dirección IP:</td>
                    <td><input name="s1"></td>
                </tr>
                    <td></td>
                    <td><input type="submit" value="Comprobar Estado"></td>
            </table>
        </form>
        
        <br>
        <br>   
        
    </body>
</html>
