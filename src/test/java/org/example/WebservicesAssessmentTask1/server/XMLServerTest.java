package org.example.WebservicesAssessmentTask1.server;

import org.example.server.XMLServer;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class XMLServerTest {
    @Test
    void testServerStartup() throws Exception {
        Thread serverThread = new Thread(() -> {
            try {
                XMLServer.main(new String[]{});
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        serverThread.start();
        Thread.sleep(1000);
        assertTrue(serverThread.isAlive());
    }

}
