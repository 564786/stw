/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import javax.json.Json;
import javax.json.JsonReader;
import javax.json.JsonStructure;

import static java.lang.System.out;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/**
 *
 * @author RAFA
 */
public class TemperaturaOW {
    final String URL = "https://api.openweathermap.org/data/2.5/weather?q=teruel&appid=996866bb954a2a8e65b9644c759a5b85";  
    JSONObject myObject = new JSONObject();

    public static String peticionHttpGet(String urlParaVisitar) throws Exception {
            // Esto es lo que vamos a devolver
            StringBuilder resultado = new StringBuilder();
            // Crear un objeto de tipo URL
            URL url = new URL(urlParaVisitar);

            // Abrir la conexión e indicar que será de tipo GET
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");
            // Búferes para leer
            BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            String linea;
            // Mientras el BufferedReader se pueda leer, agregar contenido a resultado
            while ((linea = rd.readLine()) != null) {
                    resultado.append(linea);
            }
            // Cerrar el BufferedReader
            rd.close();
            // Regresar resultado, pero como cadena, no como StringBuilder
            return resultado.toString();
    }
        
    public int getTemperaturaOW() {
        //String URL = "https://api.openweathermap.org/data/2.5/weather?q=teruel&appid=996866bb954a2a8e65b9644c759a5b85";
        String respuesta = "";
        String temperatura = "666";

        
        try {
            respuesta = peticionHttpGet(URL);
            if (respuesta!=null){                
                JSONObject lecturaOW = new JSONObject(respuesta);
                temperatura = lecturaOW.query("/main/temp_max").toString();
            }        else{
                temperatura = "293";
            }
            
        } catch (Exception e) {
                // Manejar excepción
                e.printStackTrace();
        }

        return (Integer.parseInt(temperatura.substring(0,3))-273);
	}
}
