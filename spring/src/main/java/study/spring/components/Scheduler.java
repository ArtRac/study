package study.spring.components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import study.spring.others.AnyBean;

@Slf4j
@Component
public class Scheduler {

    @Autowired
    private AnyBean anyBean1;

    @Autowired
    private AnyBean anyBean2;

    @Scheduled(fixedRate = 10000)
    public void ping() {

        log.info("ping " + this.anyBean1 + " " + this.anyBean2);
    }

}
