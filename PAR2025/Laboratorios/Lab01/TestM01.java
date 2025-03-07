/*
    Autor: Teresa Estigarribia
    Fecha: 02-2025
    Descripción: Este programa realiza una petición HTTP GET a una URL dada y muestra la respuesta obtenida en la consola.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class TestM01 {
    public static void main(String[] args) {
        // URL a la que se realiza la petición HTTP GET
        String url = "https://www.datos.gov.py/dataset/proyectos-adjudicados-hackathon";
        String respuesta = ""; // Variable para almacenar la respuesta de la petición
        try {
            // Realiza la petición HTTP GET a la URL especificada
            respuesta = peticionHttpGet(url);
            // Imprime la respuesta obtenida en consola
            System.out.println("La respuesta es:\n" + respuesta);
        } catch (Exception e) {
            // Maneja cualquier excepción que pueda ocurrir durante la ejecución
            e.printStackTrace();
        }
    }

    /*
     * Método que realiza una petición HTTP GET a una URL y devuelve el contenido de la respuesta.
     * 
     * @param urlParaVisitar: La URL a la que se enviará la petición HTTP GET.
     * @return String: El contenido de la respuesta recibida en formato de texto.
     * @throws Exception: Lanza una excepción si ocurre algún error durante la petición.
     */
    public static String peticionHttpGet(String urlParaVisitar) throws Exception {
        StringBuilder resultado = new StringBuilder(); // Acumulador para la respuesta
        // Crea un objeto URL con la URL proporcionada
        URL url = new URL(urlParaVisitar);

        // Establece la conexión HTTP con la URL
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        // Define el método de la petición HTTP (GET)
        conexion.setRequestMethod("GET");
        
        // Lee la respuesta de la URL utilizando un BufferedReader
        BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        String linea;
        // Lee cada línea de la respuesta y las agrega al StringBuilder
        while ((linea = rd.readLine()) != null) {
            resultado.append(linea);
        }

        // Cierra el BufferedReader después de leer toda la respuesta
        rd.close();
        // Devuelve la respuesta completa como un String
        return resultado.toString();
    }
}
