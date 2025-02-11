package study;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

// The config file log4j2.properties has to be in classpath
// https://logging.apache.org/log4j/2.x/manual/configuration.html

@Slf4j
class LoggingTests {

    @Test
    void contextLoads() {
        log.error("ERROR!!!!");
        log.debug("DEBUG!!!!");
        log.info("INFO!!!!");
    }

}
