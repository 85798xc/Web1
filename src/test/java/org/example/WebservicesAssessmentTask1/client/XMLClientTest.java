package org.example.WebservicesAssessmentTask1.client;

import org.example.client.XMLClient;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class XMLClientTest {
    @Test
    void testClientReceivesData() throws Exception {
        Thread clientThread = new Thread(() -> {
            try {
                XMLClient.main(new String[]{});
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        clientThread.start();
        clientThread.join();
        File receivedFile = new File("received_student.xml");
        assertTrue(receivedFile.exists());
    }
}
