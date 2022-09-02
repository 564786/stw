<!--
 * @author Alvaro Fraidias NIP 780336
 * @author Rafael Rodriguez NIP 564786
 * 
 * Referencias utilizadas:
 * apuntes de @fserna
 * 
 */
 -->
 
 <%-- 
    Document   : temperatura
    Created on : 19 ago 2022, 18:41:56
    Author     : rafar
--%>
<%@page import="demo.TermometroBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="demo.TemperaturaOW"%>
<% 
    TermometroBean termometroBean = new TermometroBean();
    TemperaturaOW temperaturaOW = new TemperaturaOW();
    temperaturaOW.getTemperaturaOW();
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! I'm temperatura.jsp</h1>
        
                
        <h1> TEMPERATURA </h1>  
        
        <table border="back">
            <tr>
                <td align="center">
                    <h2>Menu</h2>
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
                        <input type=hidden name=s1  value=<%out.println( termometroBean.getTempCPU());%>>                        
                        <input type=hidden name=s2  value=<%out.println( temperaturaOW.getTempOW());%>>
                        <button type="submit">Mostrar recomendacion</button>
                    </form>
                </td>
            </tr>
        </table>

        <br><br>
        
        <table border="black">
            
            <tr>
                <td><h2> CPU Raspberry </h2></td>
                <td><h2> OPENWHEATHER </h2></td>
            </tr>
            
            <tr>
               <td align="center" valign="bottom">

                    <br>
                    Estado Lectura: <b><div id="lectura">? ? ?</div></b>
                    <br>
                </td> 
                <td align="center">
                    <%
                        out.println("Temperatura máxima en <br> <b>Teruel</b> <br> para hoy es:");
                    %>
                </td>
            </tr>
            <tr>
                <td align="center">
                <div id="tempTermometro" style="font-weight: bold">? ? ?</div>ºC
                </td>  
                <td align="center">
                    <b>
                 <%
                     out.println(temperaturaOW.getTempOW());
                 %>
                    </b>
                    <br>
                ºC
                </td>
            </tr>
            <tr>
                <td align="center">
                    Termómetro: 
                    <br>
                    <canvas id="graficoTermometro" width="50" height="126" style="border:1px solid #d3d3d3;">
                        Your browser does not support the HTML5 canvas tag.
                    </canvas>
                    </td>               
            </tr>
        </table>  
            
        <br><br>
           
        <script type="text/javascript" src="websocket.js"></script>
        

        <br><br>
        <a href="panelDeMando.jsp">Volver al panel de mando</a>
        <br>
        <a href="index.jsp">Inicio</a>
    </body>
</html>
