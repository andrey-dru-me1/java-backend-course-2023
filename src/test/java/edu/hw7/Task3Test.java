package edu.hw7;

import edu.hw7.task3.Person;
import edu.hw7.task3.PersonDatabase;
import edu.hw7.task3.ReadWriteLockPersonDatabase;
import edu.hw7.task3.SynchronizedPersonDatabase;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class Task3Test {

    private static Stream<PersonDatabase> personDatabases() {
        return Stream.of(new SynchronizedPersonDatabase(), new ReadWriteLockPersonDatabase());
    }

    @ParameterizedTest
    @MethodSource("personDatabases")
    void test(PersonDatabase personDatabase) {
        ReentrantLock lock = new ReentrantLock();
        AtomicBoolean atLeastOneExistingTest = new AtomicBoolean(false);
        Thread threadCreator = new Thread(() -> assertDoesNotThrow(() -> {
            for (int i = 0; !atLeastOneExistingTest.get() && i < 100_000; i++) {
                lock.lock();
                personDatabase.add(new Person(0, "somebody", "somewhere", "somewhat"));
                lock.unlock();

                lock.lock();
                personDatabase.delete(0);
                lock.unlock();
            }
        }));
        Thread threadTester = new Thread(() -> assertDoesNotThrow(() -> {
            for (int i = 0; !atLeastOneExistingTest.get() && i < 100_000; i++) {
                lock.lock();
                List<Person> byAddress = personDatabase.findByAddress("somewhere");
                List<Person> byName = personDatabase.findByName("somebody");
                List<Person> byPhone = personDatabase.findByPhone("somewhat");
                assertThat(byAddress.isEmpty() || (!byPhone.isEmpty() && !byName.isEmpty())).isTrue();
                assertThat(byName.isEmpty() || (!byPhone.isEmpty() && !byAddress.isEmpty())).isTrue();
                assertThat(byPhone.isEmpty() || !byAddress.isEmpty()).isTrue();
                if (!byAddress.isEmpty()) {
                    atLeastOneExistingTest.set(true);
                }
                lock.unlock();
            }
        }));

        threadCreator.start();
        threadTester.start();

        try {
            threadTester.join();
            threadCreator.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}