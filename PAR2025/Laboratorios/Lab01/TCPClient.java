/*
    Autor: Teresa Estigarribia
    Fecha: 03-2025
    Notas:
    - En este ejemplo, el cliente TCP se conecta al servidor, envía un mensaje, espera la respuesta del servidor y la imprime en la consola.
    - El servidor debe estar en ejecución antes de que el cliente pueda conectarse.
    - Revisa que el puerto 9876 esté disponible y que no esté bloqueado o en uso por otro programa.
*/

import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost"; // Dirección del servidor (en este caso, localhost)
        final int SERVER_PORT = 9876; // Puerto al que se conecta el cliente

        try {
            // Crear un socket para conectarse al servidor en la dirección y puerto especificados
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println("Conectado al servidor: " + socket);

            // Crear flujos de entrada y salida
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in)); // Para leer la entrada del usuario
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // Para enviar mensajes al servidor
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Para leer la respuesta del servidor

            // Ciclo para permitir múltiples mensajes entre el cliente y el servidor
            while (true) {
                // Solicitar al usuario que ingrese un mensaje
                System.out.print("Ingrese un mensaje para enviar al servidor: ");
                String message = userInput.readLine(); // Leer el mensaje del usuario

                out.println(message); // Enviar el mensaje al servidor

                // Leer la respuesta del servidor y mostrarla
                String response = in.readLine();
                System.out.println("Respuesta del servidor: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Si ocurre una excepción, imprimir la traza de la excepción
        }
    }
}
