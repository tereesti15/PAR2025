/*
    Autor: Teresa Estigarribia
    Fecha: 03-2025
    Notas:
    - En este ejemplo, el servidor UDP escucha en el puerto 9877 y recibe los mensajes de los clientes.
    - Luego, convierte los mensajes a mayúsculas y los envía de vuelta al cliente.
    - El cliente envía un mensaje al servidor, espera la respuesta del servidor y la imprime en la consola.
    - Para ejecutar este código, primero ejecuta el servidor y luego el cliente.
    - Revisa que el puerto 9877 esté disponible y que no esté bloqueado o en uso por otro programa.
*/

import java.io.*;
import java.net.*;

public class UDPServer {
    public static void main(String[] args) {
        final int SERVER_PORT = 9877; // Puerto en el que el servidor UDP escucha

        try {
            // Crear un socket UDP para escuchar en el puerto especificado
            DatagramSocket serverSocket = new DatagramSocket(SERVER_PORT);
            System.out.println("Servidor UDP escuchando en el puerto " + SERVER_PORT + "...");

            byte[] receiveData = new byte[1024]; // Buffer para recibir datos
            byte[] sendData = new byte[1024]; // Buffer para enviar datos

            while (true) {
                // Crear un paquete para recibir los datos
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket); // Recibir el paquete de datos

                // Obtener la dirección y el puerto del cliente
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                // Convertir los datos recibidos a un mensaje String
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Mensaje recibido del cliente: " + message);

                // Convertir el mensaje a mayúsculas
                String response = "Respuesta del servidor: " + message.toUpperCase();
                sendData = response.getBytes(); // Convertir la respuesta a un arreglo de bytes

                // Crear un paquete con la respuesta para enviar al cliente
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                serverSocket.send(sendPacket); // Enviar el paquete al cliente
            }
        } catch (IOException e) {
            e.printStackTrace(); // Imprimir la traza de la excepción si ocurre algún error
        }
    }
}
