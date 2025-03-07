/*
    Autor: Teresa Estigarribia
    Fecha: 03-2025
    Referencia: https://docs.oracle.com/javase/10/docs/api/java/net/URL.html
    Descripción: Este programa muestra cómo trabajar con objetos `URL` en Java. Se crean dos instancias de `URL` con diferentes formatos y se imprime la información sobre ellas.
*/

import java.io.IOException;
import java.net.URL;

public class EjemploMURL {
    public static void main(String[] args) throws IOException {
        
        // Definir dos URLs con diferentes formatos
        String test_url = "http://www.pol.una.py"; // URL con cadena completa
        URL pagina1 = new URL(test_url); // Crear un objeto URL a partir de la cadena proporcionada
        URL pagina2 = new URL("http", "grado.pol.una.py", 80, "index.html"); // Crear un objeto URL con componentes separados

        // Primera prueba: Muestra la información sobre la primera URL
        System.out.println("***** Primera pagina");
        System.out.println("Protocolo: " + pagina1.getProtocol()); // Obtiene el protocolo de la URL (http, https, etc.)
        System.out.println("Puerto: " + pagina1.getPort()); // Obtiene el puerto de la URL (-1 si no se especifica)
        System.out.println("Host: " + pagina1.getHost()); // Obtiene el nombre del host de la URL
        System.out.println("Archivo: " + pagina1.getFile()); // Obtiene el archivo (path) de la URL
        System.out.println("External form: " + pagina1.toExternalForm()); // Obtiene la representación externa completa de la URL
        System.out.println();

        // Segunda prueba: Muestra la información sobre la segunda URL
        System.out.println("***** Segunda pagina");
        System.out.println("Protocolo: " + pagina2.getProtocol()); // Obtiene el protocolo de la URL
        // Si el puerto es -1 (no especificado), se utiliza el puerto por defecto
        System.out.println("Puerto: " + (pagina2.getPort() != -1 ? pagina2.getPort() : pagina2.getDefaultPort()));
        System.out.println("Host: " + pagina2.getHost()); // Obtiene el nombre del host
        System.out.println("Archivo: " + pagina2.getFile()); // Obtiene el archivo de la URL
        System.out.println("External form: " + pagina2.toExternalForm()); // Representación externa completa de la URL
        System.out.println();
    } //fin main
} //fin EjemploMURL
