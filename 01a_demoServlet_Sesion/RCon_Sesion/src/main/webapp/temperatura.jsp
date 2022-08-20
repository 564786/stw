<%-- 
    Document   : temperatura
    Created on : 19 ago 2022, 18:41:56
    Author     : rafar
--%>

<%@page import="demo.LecturaTemperaturaCPU"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! I'm temperata.jsp</h1>
        
                
        <h1> TEMPERATURA </h1>
        
        <br><br><br>      
        
        <table>
            <tr>
                <td>
                    <h2> MQTT </h2>
                </td>
                
                <td>
                    "      ---------------    "
                </td>
                
                <td>
                    <h2> WEB REST </h2>
                </td>
            </tr>
                                    
            <tr>
                

                
                
                <td>
                    Datos raspberry
                    <br>
                    <%LecturaTemperaturaCPU.leerTemperaturas();%>
                </td>
                
                <td>
                    Datos OpenWeather
                </td>
            </tr>
        </table>
            
        <br><br><br><br>

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
        
        <form method="POST" action="recomendar">
            <!--SUSTITUIR ESTAS DOS LÍNEAS POR LA MEDIA DE TEMPERATURAS-->
            <input type=hidden name=s1 value=100>
            <input type=hidden name=s2 value=50>
            <!----------------------------------------------------------->
            <button type="submit">Mostrar recomendacion</button>
        </form>
        
        <br>
        <br>
        <br>
        <br>
        <a href="panelDeMando.jsp">Volver al panel de mando</a>
        <br>
        <a href="index.jsp">Inicio</a>
    </body>
</html>
