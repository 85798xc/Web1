package org.example.client;

import org.example.entity.Student;
import org.example.mapper.XMLTransformer;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class XMLClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to server.");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            FileWriter fileWriter = new FileWriter("received_student.xml");

            String line;
            while ((line = reader.readLine()) != null) {
                fileWriter.write(line + "\n");
            }
            fileWriter.close();
            socket.close();

            // Handle exception when transforming XML to POJO
            try {
                Student student = XMLTransformer.transformToPOJO("received_student.xml", "student.xsd");
                System.out.println("Received Student: " + student.getName() + " Age: " + student.getAge());
            } catch (Exception e) {
                System.err.println("Error transforming XML to POJO: " + e.getMessage());
                e.printStackTrace();
            }

        } catch (IOException e) {
            System.err.println("Error connecting to server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
