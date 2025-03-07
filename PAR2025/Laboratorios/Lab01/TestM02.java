/*
    Autor: Teresa Estigarribia
    Fecha: 03-2025
    Descripción: Este programa realiza peticiones HTTP y HTTPS a las URL proporcionadas y muestra la respuesta obtenida en la consola.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class TestM02 {
    public static void main(String[] args) throws IOException {
        // URL para probar HTTP
        String httpUrl = "http://grado.pol.una.py";
        // URL para probar HTTPS
        String httpsUrl = "https://grado.pol.una.py";

        // Realiza la solicitud HTTP y muestra la respuesta
        System.out.println("Haciendo solicitud HTTP:");
        hacerHttpRequest(httpUrl);

        // Realiza la solicitud HTTPS y muestra la respuesta
        System.out.println("\nHaciendo solicitud HTTPS:");
        hacerHttpsRequest(httpsUrl);
    }

    /*
     * Método que realiza una solicitud HTTP GET a la URL proporcionada y muestra la respuesta en consola.
     * 
     * @param urlString: La URL a la que se realiza la solicitud HTTP.
     * @throws IOException: Lanza una excepción si ocurre un error durante la lectura o conexión.
     */
    private static void hacerHttpRequest(String urlString) throws IOException {
        URL url = new URL(urlString); // Crea un objeto URL a partir de la cadena proporcionada
        HttpURLConnection connection = (HttpURLConnection) url.openConnection(); // Establece la conexión HTTP

        // Configura el método de la solicitud como GET
        connection.setRequestMethod("GET");

        // Lee la respuesta de la solicitud HTTP
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String inputLine;
            StringBuilder response = new StringBuilder(); // Acumulador para la respuesta
            // Lee línea por línea y las agrega al StringBuilder
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            // Muestra la respuesta completa
            System.out.println(response.toString());
        } finally {
            // Cierra la conexión HTTP
            connection.disconnect();
        }
    }

    /*
     * Método que realiza una solicitud HTTPS GET a la URL proporcionada y muestra la respuesta en consola.
     * 
     * @param urlString: La URL a la que se realiza la solicitud HTTPS.
     * @throws IOException: Lanza una excepción si ocurre un error durante la lectura o conexión.
     */
    private static void hacerHttpsRequest(String urlString) throws IOException {
        URL url = new URL(urlString); // Crea un objeto URL a partir de la cadena proporcionada
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection(); // Establece la conexión HTTPS

        // Configura el método de la solicitud como GET
        connection.setRequestMethod("GET");

        // Lee la respuesta de la solicitud HTTPS
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String inputLine;
            StringBuilder response = new StringBuilder(); // Acumulador para la respuesta
            // Lee línea por línea y las agrega al StringBuilder
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            // Muestra la respuesta completa
            System.out.println(response.toString());
        } finally {
            // Cierra la conexión HTTPS
            connection.disconnect();
        }
    }
}
