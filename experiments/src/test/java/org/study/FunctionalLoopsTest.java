package org.study;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

@Slf4j
class FunctionalLoopsTest {
    @Test
    void loopTest() {
//gdzie umieścić konfigurację?
        log.debug("TEST debug");
        log.info("TEST info");
        log.warn("TEST warning");
        log.error("TEST error");
        Stream.of("A", "B", "C", "D")
                .map(String::toLowerCase)
                .forEach(System.out::println);
    }
}