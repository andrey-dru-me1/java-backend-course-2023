package edu.hw8;

import edu.hw8.task1.QuotesClient;
import edu.hw8.task1.QuotesServer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static java.lang.Thread.sleep;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {

    @Test
    void test() throws InterruptedException {
        List<String> quotes = List.of("Не переходи на личности там, где их нет",
                "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами",
                "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.",
                "Чем ниже интеллект, тем громче оскорбления");

        QuotesServer server = new QuotesServer(8000, Runtime.getRuntime().availableProcessors(), quotes);

        InputStream is = new ByteArrayInputStream("личности\nоскорбления\nглупый\nинтеллект\nнеключевое\n".getBytes());
        QuotesClient client = new QuotesClient("localhost", 8000, is);

        Thread serverThread = new Thread(server::start);
        Thread clientThread = new Thread(client::start);

        serverThread.start();
        sleep(10);
        clientThread.start();

        clientThread.join();
        List<String> responds = client.getResponds();
        server.stop();

        List<String> expected = new ArrayList<>(quotes);
        expected.add("Я не знаю цитат с ключевым словом 'неключевое'.");
        assertThat(responds).isEqualTo(expected);

        serverThread.join();
    }

    @Test
    void testClientCountExcess() throws InterruptedException, IOException {
        PipedOutputStream out = new PipedOutputStream();
        PrintWriter writer = new PrintWriter(out);
        PipedInputStream in = new PipedInputStream(out);
        QuotesServer server = new QuotesServer(8000, 1, List.of());
        QuotesClient client1 = new QuotesClient("localhost", 8000, in);

        Thread serverThread = new Thread(server::start);
        Thread client1Thread = new Thread(client1::start);

        serverThread.start();
        sleep(100);
        client1Thread.start();

        QuotesClient client2 = new QuotesClient("localhost", 8000, new ByteArrayInputStream("неключевое".getBytes()));
        Thread client2Thread = new Thread(client2::start);
        client2Thread.start();

        sleep(100);
        assertThat(client2Thread.isAlive()).isTrue();
        sleep(100);
        writer.println("неключ");
        out.close();
        client1Thread.join();

        sleep(10);
        assertThat(client2Thread.isAlive()).isFalse();

        server.stop();
        serverThread.join();
    }

}
