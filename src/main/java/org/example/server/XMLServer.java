package org.example.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class XMLServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server is waiting for connection...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        File xmlFile = new File("student.xml");
        try (BufferedReader reader = new BufferedReader(
             new FileReader(xmlFile));
             PrintWriter writer = new PrintWriter(
             socket.getOutputStream(), true)) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line);
            }
        }
        socket.close();
        serverSocket.close();
    }
}
