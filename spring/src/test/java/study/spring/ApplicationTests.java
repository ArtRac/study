package study.spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
		log.info("TEST");
		log.error("TEST");
	}

}
