package edu.hw6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Task6 {

    private static final Map<Integer, String> PORT_LIST = loadPortList();

    private static Map<Integer, String> loadPortList() {
        Path path = Paths.get("src", "main", "resources", "portlist.csv");
        File file = path.toFile();

        Map<Integer, String> result = new HashMap<>();
        try (FileReader fileReader = new FileReader(file); BufferedReader reader = new BufferedReader(fileReader)) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                String[] entry = line.split(";");
                if (entry.length < 3) {
                    continue;
                }
                try {
                    Integer key = Integer.parseInt(entry[0]);
                    String value = entry[2];
                    result.put(key, value);
                } catch (NumberFormatException ignored) {
                    // Ignore
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private static boolean portInUse(String protocol, int port) {
        try {
            if ("TCP".equals(protocol)) {
                new ServerSocket(port).close();
                return false;
            } else if ("UDP".equals(protocol)) {
                new DatagramSocket(port).close();
                return false;
            } else {
                return false;
            }
        } catch (IOException e) {
            return true;
        }
    }

    public static void printPortsInUse() {
        for (int port = 0; port < 49151; port++) {
            for (String protocol : new String[]{"UDP", "TCP"}) {
                if (portInUse(protocol, port)) {
                    System.out.printf("%-10s%-7d%-20s%n", protocol, port, PORT_LIST.getOrDefault(port, ""));
                }
            }
        }
    }

}
