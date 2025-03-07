/*
    Autor: Teresa Estigarribia
    Fecha: 03-2025
    Notas:
    - En este ejemplo, el cliente UDP envía un mensaje al servidor y espera la respuesta.
    - El servidor UDP recibe el mensaje, lo convierte a mayúsculas y lo envía de vuelta al cliente.
    - Para ejecutar este código, primero ejecuta el servidor y luego el cliente.
    - Revisa que el puerto 9877 esté disponible y que no esté bloqueado o en uso por otro programa.
*/

import java.io.*;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost"; // Dirección del servidor
        final int SERVER_PORT = 9877; // Puerto del servidor UDP

        try {
            // Crear un socket UDP para el cliente
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName(SERVER_ADDRESS); // Obtener la dirección del servidor

            // Crear un lector para la entrada del usuario
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                // Pedir al usuario que ingrese un mensaje
                System.out.print("Ingrese un mensaje para enviar al servidor: ");
                String message = userInput.readLine();
                byte[] sendData = message.getBytes(); // Convertir el mensaje a bytes

                // Crear un paquete de datos con el mensaje y la dirección del servidor
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, SERVER_PORT);
                clientSocket.send(sendPacket); // Enviar el mensaje al servidor

                // Crear un buffer para recibir la respuesta
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket); // Recibir la respuesta del servidor

                // Convertir los datos recibidos en un string y mostrarlo
                String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Respuesta del servidor: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Imprimir la traza de la excepción si ocurre un error
        }
    }
}
