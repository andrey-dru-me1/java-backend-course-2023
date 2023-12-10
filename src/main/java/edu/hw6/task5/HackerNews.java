package edu.hw6.task5;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerNews {

    private static final int OK_STATUS = 200;
    private static final String TOP_STORIES_URL = "https://hacker-news.firebaseio.com/v0/topstories.json";
    private static final String NEWS_ITEM_URL = "https://hacker-news.firebaseio.com/v0/item/%d.json";

    private HackerNews() {
    }

    private static HttpResponse<String> sendRequest(String uri) throws IOException, InterruptedException {
        try (HttpClient httpClient = HttpClient.newHttpClient()) {
            HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();
            return httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        }
    }

    public static long[] hackerNewsTopStories() throws IOException, InterruptedException {
        HttpResponse<String> response = sendRequest(TOP_STORIES_URL);
        if (response.statusCode() == OK_STATUS) {
            String[] ids = response.body().replaceAll("[\\[\\]]", "").split(",");
            return stringsToLongs(ids);
        }
        return new long[0];
    }

    private static long[] stringsToLongs(String[] strings) {
        long[] result = new long[strings.length];
        for (int i = 0; i < strings.length; i++) {
            result[i] = Long.parseLong(strings[i]);
        }
        return result;
    }

    public static String news(long id) throws IOException, InterruptedException {
        HttpResponse<String> response = sendRequest(String.format(NEWS_ITEM_URL, id));
        if (response.statusCode() == OK_STATUS) {
            Pattern pattern = Pattern.compile("\"title\":\"(?<title>.*?)\"");
            Matcher matcher = pattern.matcher(response.body());

            if (matcher.find()) {
                return matcher.group("title");
            }
        }
        return "Cannot get a news title.";
    }

}
