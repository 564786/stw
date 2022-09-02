<!--
 * @author Alvaro Fraidias NIP 780336
 * @author Rafael Rodriguez NIP 564786
 * 
 * Referencias utilizadas:
 * apuntes de @fserna
 * 
 */
 -->
 
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
                <td align="center">
                    <h2>Menu</h2>
                </td>
            </tr>
            <tr>
                <td>
                    <form method="get" action="temperatura.jsp">
                        <button type="submit">Ver temperaturas</button>
                    </form>
                </td>
            </tr>            
        </table>
                
        <br><br>
        <a href="index.jsp">Inicio</a>

    </body>
</html>
