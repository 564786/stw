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
        
        <table border="black">
            <tr>
              <td><h2> CPU Raspberry </h2></td>
            </tr>

            <tr>
              <td>
                <%  
                    String resultado = "555";
                    int temperatura = 555;
                    if ((String)session.getAttribute("lecturaTemperaturas")!= null){
                        resultado = (String)session.getAttribute("lecturaTemperaturas");
                        temperatura = Integer.parseInt(resultado.substring(0,5))/1000;
                        out.print(temperatura + " ºC");
                    }        
                %>   
            </tr>
            
                        <tr>
              <td>
                    <form method="POST" action="conexionSSH">
                        <input type=hidden name=s1 value=comenzarLectura>
                        <button type="submit">Leer temperatura</button>
                    </form>               
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
            
        <br><br><br><br>
            
        <table border="black">
            <tr>
              <td><h2> OPENWHEATHER </h2></td>
            </tr>
            <tr>
              <td>Temperatura</td>
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
        
        <br><br><br><br>
        <a href="panelDeMando.jsp">Volver al panel de mando</a>
        <br>
        <a href="index.jsp">Inicio</a>
    </body>
</html>
