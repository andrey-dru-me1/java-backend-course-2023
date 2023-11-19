package edu.project3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogAnalyzer {

    private static final Pattern LOG_ENTRY_PATTERN = Pattern.compile(
            "(?<remoteAddress>.*?) - (?<remoteUser>.*?) \\[(?<timeLocal>.*?)] "
                    + "\"(?<request>.*?)\" (?<status>\\d+) (?<bodyBytesSent>\\d+) \"(?<httpReferer>.*?)\" \"(?<httpUserAgent>.*?)\"");
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("d/LLL/y:H:m:s Z");

    private static LogEntry parseLogEntry(String logEntry) {
        Matcher matcher = LOG_ENTRY_PATTERN.matcher(logEntry);
        matcher.matches();
        String remoteAddress = matcher.group("remoteAddress");
        String remoteUser = matcher.group("remoteUser");
        OffsetDateTime timeLocal = OffsetDateTime.parse(matcher.group("timeLocal"), DATE_TIME_FORMATTER);
        String request = matcher.group("request");
        int status = Integer.parseInt(matcher.group("status"));
        int bodyBytesSent = Integer.parseInt(matcher.group("bodyBytesSent"));
        String httpReferer = matcher.group("httpReferer");
        String httpUserAgent = matcher.group("httpUserAgent");
        return new LogEntry(remoteAddress, remoteUser, timeLocal, request, status, bodyBytesSent, httpReferer,
                httpUserAgent);
    }

    private static List<LogEntry> readLog(Path path) throws IOException {
        File file = path.toFile();
        List<LogEntry> logEntries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                logEntries.add(parseLogEntry(line));
            }
        }
        return logEntries;
    }

    private static void printCommonInformationTable(List<LogEntry> logEntries, String filename) {
        System.out.printf("### Common information%n%n");
        System.out.printf("|%25s|%20s|%n", "Metric", "Value");
        System.out.printf("|%25s|%20s|%n", ":" + "-".repeat(23) + ":", ":" + "-".repeat(18) + ":");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd:MM:yyyy");

        Map<String, String> commonInformation = new HashMap<>();
        commonInformation.put("File", filename);
        commonInformation.put("Initial date", formatter.format(logEntries.getFirst().timeLocal));
        commonInformation.put("Last date", formatter.format(logEntries.getLast().timeLocal));
        commonInformation.put("Request count", String.format("%d", logEntries.size()));
        commonInformation.put("Average respond size",
                String.format("%f", logEntries.stream().mapToInt(LogEntry::bodyBytesSent).average().orElseThrow()));

        for (Map.Entry<String, String> entry : commonInformation.entrySet()) {
            System.out.printf("|%25s|%20s|%n", entry.getKey(), entry.getValue());
        }
        System.out.printf("%n%n");
    }

    private static void printRequestedResourcesTable(List<LogEntry> logEntries) {
        System.out.printf("### Requested resources%n%n");
        System.out.printf("|%25s|%8s|%n", "Resource", "Count");
        System.out.printf("|%25s|%8s|%n", ":" + "-".repeat(23) + ":", ":" + "-".repeat(6) + ":");

        Pattern requestPattern = Pattern.compile(".*? (?<resource>.*?) .*?");
        Map<String, Integer> resourceCount = new HashMap<>();
        for (LogEntry entry : logEntries) {
            Matcher matcher = requestPattern.matcher(entry.request);
            matcher.matches();
            String resource = matcher.group("resource");
            resourceCount.putIfAbsent(resource, 0);
            resourceCount.computeIfPresent(resource, (key, value) -> value + 1);
        }

        for (Map.Entry<String, Integer> entry : resourceCount.entrySet()) {
            System.out.printf("|%25s|%8d|%n", entry.getKey(), entry.getValue());
        }
        System.out.printf("%n%n");
    }

    private static void printResponseCodesTable(List<LogEntry> logEntries) {
        System.out.printf("### Response codes%n%n");
        System.out.printf("|%8s|%8s|%n", "Code", "Count");
        System.out.printf("|%8s|%8s|%n", ":" + "-".repeat(6) + ":", ":" + "-".repeat(6) + ":");

        Map<Integer, Integer> codeCount = new HashMap<>();
        for (LogEntry logEntry : logEntries) {
            codeCount.putIfAbsent(logEntry.status, 0);
            codeCount.computeIfPresent(logEntry.status, (key, value) -> value + 1);
        }
        for (Map.Entry<Integer, Integer> entry : codeCount.entrySet()) {
            System.out.printf("|%8d|%8d|%n", entry.getKey(), entry.getValue());
        }
        System.out.printf("%n%n");
    }

    private static void analyzeLog(Path path) throws IOException {
        List<LogEntry> logEntries = readLog(path);

        printCommonInformationTable(logEntries, path.getFileName().toString());

        printRequestedResourcesTable(logEntries);

        printResponseCodesTable(logEntries);

    }

    public static void main(String[] args) throws IOException {
        analyzeLog(Path.of("src", "main", "resources", "logs.txt"));
    }

    private record LogEntry(String remoteAddress, String remoteUser, OffsetDateTime timeLocal, String request,
                            int status, int bodyBytesSent, String httpReferer, String httpUserAgent) {
    }

}
