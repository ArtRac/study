package study;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

@Slf4j
class FunctionalLoopsTest {
    @Test
    void loopTest() {
        Stream.of("A", "B", "C", "D")
                .map(String::toLowerCase)
                .forEach(System.out::println);
    }
}