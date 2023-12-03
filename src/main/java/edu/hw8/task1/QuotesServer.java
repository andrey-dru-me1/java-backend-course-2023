package edu.hw8.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuotesServer {

    private final int port;
    private final int threadCount;
    private final List<String> quotes;
    private final Logger log = LoggerFactory.getLogger("QuotesServer");
    private volatile boolean running = true;
    private ServerSocket serverSocket;

    public QuotesServer(int port, int threadCount, List<String> quotes) {
        this.port = port;
        this.threadCount = threadCount;
        this.quotes = quotes;
    }

    public void start() {
        try (ThreadPoolExecutor threadPool = new ThreadPoolExecutor(threadCount, threadCount, 0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(threadCount))) {
            serverSocket = new ServerSocket(port);
            running = true;
            while (running) {
                Socket clientSocket = serverSocket.accept();
                log.info("Client is connected: {}", clientSocket.getPort());
                threadPool.submit(() -> handleClientSocket(clientSocket));
            }
            threadPool.shutdown();
        } catch (IOException e) {
            // ignore
        }
    }

    private void handleClientSocket(Socket clientSocket) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream())); PrintWriter writer = new PrintWriter(
                clientSocket.getOutputStream())) {
            String request = reader.readLine();
            while (request != null) {
                log.info("Request '{}' received.", request);
                writer.println(findByKeyWord(request));
                writer.flush();
                request = reader.readLine();
            }
            log.info("Client is disconnected: {}", clientSocket.getPort());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void stop() {
        running = false;
        try {
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String findByKeyWord(String keyWord) {
        for (String quote : quotes) {
            if (quote.contains(keyWord)) {
                return quote;
            }
        }
        return String.format("Я не знаю цитат с ключевым словом '%s'.", keyWord);
    }

}
