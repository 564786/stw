<%-- 
    Document   : index
    Created on : 15 ago 2022, 14:32:19
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
        
        <form method="POST" action="recomendar">
            <!--SUSTITUIR ESTAS DOS LÍNEAS POR LA MEDIA DE TEMPERATURAS-->
            <input type=hidden name=s1 value=100>
            <input type=hidden name=s2 value=50>
            <!----------------------------------------------------------->
            <button type="submit">Mostrar recomendacion</button>
        </form>
        
        <!--INCLUIR UNA TABLA DE IP's CONSULTADAS-->
        
        <!-- Comento los sumadores -->        
        <!--form method="POST" action="sumador">
            <table>
                <tr>
                    <td>1er sumando:</td>
                    <td><input name="s1"></td>
                </tr>
                <tr>
                    <td>2º sumando:</td>
                    <td><input name="s2"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="¡A Sumar!"></td>
            </table>
        </form-->  
        
    </body>
</html>
