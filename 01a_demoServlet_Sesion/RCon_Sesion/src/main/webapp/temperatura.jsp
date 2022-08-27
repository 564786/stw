<%-- 
    Document   : temperatura
    Created on : 19 ago 2022, 18:41:56
    Author     : rafar
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
                <td>
                    <h2>Menu</h2>
                </td>
            <tr>
                <td>
                    <form method="POST" action="conexionSSH">
                        <input type=hidden name=s1 value=comenzarLectura>
                        <button type="submit">Leer temperatura</button>
                    </form>    

                </td>
                <td>
                    <form method="POST" action="conexionSSH">
                        <input type=hidden name=s1 value=comenzarLectura>
                        <button type="submit">Leer temperatura</button>
                    </form>    

                </td>
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

            <tr>
                <td>
                    OTRA CELDA
                </td>
            </tr>
            <tr>
                <td>
                    OTRA CELDA
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
                <td>hola</td>
                <td>hola otra vez</td>
                
            </tr>
            
            <tr>
                <td>Hola?</td>
            </tr>    
                <%for(int i =1; i<=5; i++){  
                    String resultado = "1";
                    
                    double temperatura = 1;
                    if ((String)session.getAttribute("lecturaTemperaturas")!= null){
                        resultado = (String)session.getAttribute("lecturaTemperaturas");
                        temperatura = Integer.parseInt(resultado.substring(0,5))/1000;
                  %>
                <tr><td> 
                        
                      <%
                        out.print(temperatura + " ºC");
                        Thread.sleep(1000);
                    }        
                    %>   
                </td></tr>
                <%}%>
            </tr>

            <tr>
                <td>
           c
                </td>
              <td>
                  <!<!-- DESCOMENTAR SI SE INCLUYEN LAS LECTURAS MULTIPLES -->
                    <!--form method="POST" action="conexionSSH">
                        <input type=hidden name=s1 value=finalizarLectura>
                        <button type="submit">Parar lecturas</button>
                    </form-->   
              </td>

            </tr>
        </table>  
            
        <br><br>
            
        <!--table border="black">
            <tr>
              <td><h2> OPENWHEATHER </h2></td>
            </tr>
            <tr>
              <td>Temperatura</td>
            </tr>
        </table>
            
        <br><br><br><br-->

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
        <table>
            <tr>
                <td>

                    <button id="iniciarLectura" onclick="iniciarLectura();">Iniciar lectura</button> 
                </td>                    
                <td>
                    <button id="pararLectura" onclick="pararLectura();">Parar lectura</button>
                </td>
            </tr>
                
            <tr>                   
                <br>
                <b>Estado lectura: </b><div id="estadoLectura">? ? ?</div>
                <br>
            </tr>
                
            
                <td align="center">
                    <canvas id="graficoDeposito" width="50" height="260" style="border:1px solid #d3d3d3;">
                        Your browser does not support the HTML5 canvas tag.
                    </canvas>
                    <table><tr><td>Termómetro </td><td><div id="nivelDeposito" style="font-weight: bold">? ? ?</div></td><td> ºC</td></tr></table>
                </td>
            </tr>
            
            <!--tr>
                <td align="center" valign="top">

                    <br>
                    Grifo IN: <div id="grifoIn">? ? ?</div>
                    <br>
                    <button id="abrirGrifoIn" onclick="openGrifoIn();">Abrir</button> 
                    <button id="cerrarGrifoIn" onclick="closeGrifoIn();">Cerrar</button>
                </td>
                         
                <td align="center" valign="bottom">

                    <br>
                    Grifo OUT: <div id="grifoOut">? ? ?</div>
                    <br>
                    <button id="abrirGrifoOut" onclick="openGrifoOut();">Abrir</button> 
                    <button id="cerrarGrifoOut" onclick="closeGrifoOut();">Cerrar</button>
                </td>
            </tr-->
            
        </table>
        
        <script type="text/javascript" src="websocket.js"></script>
        
        
        
        
        <table>
            
            
            <tr>                
                <td>
                    

                </td>
            </tr>
            <tr>
                <td>
                    

                </td>
                
                <td align="center" valign="bottom">

                    <br>
                    Estado Lectura: <div id="lectura">? ? ?</div>
                    <br>
                    <button id="botonIniciarRefrigeracion" onclick="iniciarRefrigeracion();">Iniciar Refrigeración</button> 
                    <button id="botonParararRefrigeracion" onclick="pararRefrigeracion();">Parar Refrigeración</button> 
                    <button id="botonIniciarLectura" onclick="iniciarLectura();">Iniciar Lectura</button> 
                    <button id="botonPararLectura" onclick="pararLectura();">Parar Lectura</button>
                </td>
            </tr>
            <tr>
                <td align="center">
                    <canvas id="graficoTermometro" width="50" height="260" style="border:1px solid #d3d3d3;">
                        Your browser does not support the HTML5 canvas tag.
                    </canvas>
                    <table><tr><td>Termómetro: </td><td><div id="tempTermometro" style="font-weight: bold">? ? ?</div></td><td>ºC</td></tr></table>
                </td>
            </tr>
            
        </table>
        <br>
        <br>
        
        <script type="text/javascript" src="websocket.js"></script>
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        <br><br><br><br>
        <a href="panelDeMando.jsp">Volver al panel de mando</a>
        <br>
        <a href="index.jsp">Inicio</a>
    </body>
</html>
