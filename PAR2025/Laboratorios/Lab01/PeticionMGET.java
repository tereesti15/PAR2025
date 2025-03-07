/*
    Autor: Teresa Estigarribia
    Fecha: 03-2025
    Descripción: Este programa realiza una solicitud HTTP GET a la URL proporcionada y lee el contenido de la respuesta, imprimiéndolo en la consola.
*/

import java.io.*;
import java.net.*;

public class PeticionMGET {

    public static void main(String[] args) {
        try {
            // Definir la URL a la que se realizará la solicitud GET
            String var_url = "https://www.google.com/";
            URL url = new URL(var_url); // Crear un objeto URL con la URL proporcionada

            // Establecer la conexión con la URL
            URLConnection conexion = url.openConnection();

            // Leer la respuesta de la URL
            InputStreamReader input_str = new InputStreamReader(conexion.getInputStream()); // Crear un InputStreamReader para leer los datos
            BufferedReader reader = new BufferedReader(input_str); // Usar un BufferedReader para leer de manera eficiente

            String linea;
            // Leer cada línea de la respuesta y mostrarla en la consola
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            // Cerrar el BufferedReader después de usarlo
            reader.close();

        } catch (MalformedURLException me) {
            // Capturar errores relacionados con una URL mal formada
            System.err.println("MalformedURLException: " + me);

        } catch (IOException ioe) {
            // Capturar errores relacionados con la entrada y salida (por ejemplo, problemas de red)
            System.err.println("IOException: " + ioe);
        }
	}
}