<%-- 
    Document   : index
    Created on : 15 ago 2022, 14:32:19
    Author     : rafar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Raspberry Controller</title>
    </head>
    <body>
        <h1>Raspberry Controller</h1>
        <hr>
        <h3>Bienvenido/a a Raspberry Controller</h3>
        <br>
        <b>IMPORTANTE</b>: Tu navegador debe permitir cookies.
        <br>
        <br>
        
        Esta es tu Raspberry, ¿qué quieres hacer?
        
        <br>
        <br>
        <img src="raspSwitchedOn.png" width = 300>
        
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
        
        <br>
        <br>
        <form method="get" action="temperatura.html">
            <button type="submit">Mostrar temperatura</button>
        </form>
    </body>
</html>
