/*
    Autor: Teresa Estigarribia
    Fecha: 03-2025
    Notas:
    - En este ejemplo, el servidor TCP espera a que el cliente se conecte, luego recibe un mensaje del cliente, lo convierte a mayúsculas y lo envía de vuelta al cliente.
    - El cliente se conecta al servidor, envía un mensaje al servidor, espera la respuesta del servidor y la imprime en la consola.
    - Para ejecutar este código, primero ejecuta el servidor y luego el cliente.
    - Revisa que el puerto 9876 esté disponible y que no esté bloqueado o en uso por otro programa.
*/

import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        final int SERVER_PORT = 9876; // El puerto donde el servidor escuchará conexiones

        try {
            // Crear un ServerSocket que escuchará en el puerto 9876
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Servidor TCP escuchando en el puerto " + SERVER_PORT + "...");

            // El servidor entra en un ciclo infinito, esperando conexiones de clientes
            while (true) {
                // Espera una conexión de cliente y la acepta
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nuevo cliente conectado: " + clientSocket);

                // Crear flujos de entrada y salida para leer y escribir mensajes con el cliente
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Leer el mensaje enviado por el cliente
                String message = in.readLine();
                System.out.println("Mensaje recibido del cliente: " + message);

                // Convertir el mensaje a mayúsculas y enviarlo de vuelta al cliente
                String response = "Respuesta del servidor: " + message.toUpperCase();
                out.println(response);

                // Cerrar la conexión con el cliente
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace(); // En caso de error, imprimir la traza de la excepción
        }
    }
}
