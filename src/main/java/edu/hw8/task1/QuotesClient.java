package edu.hw8.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuotesClient {
    private final String serverHost;
    private final int serverPort;
    private final Logger log = LogManager.getLogger("QuotesClient");
    private final List<String> responds = new ArrayList<>();
    private final InputStream inputStream;

    public QuotesClient(String serverHost, int serverPort, InputStream inputStream) {
        this.serverHost = serverHost;
        this.serverPort = serverPort;
        this.inputStream = inputStream;
    }

    public void start() {
        try (Socket socket = new Socket(serverHost, serverPort); BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream())); PrintWriter writer = new PrintWriter(
                socket.getOutputStream()); BufferedReader userInput = new BufferedReader(
                new InputStreamReader(inputStream))) {
            String line;
            while ((line = userInput.readLine()) != null) {
                writer.println(line);
                writer.flush();
                String respond = reader.readLine();
                responds.add(respond);
                log.info("Server's respond: '{}'.", respond);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getResponds() {
        return this.responds;
    }

}
