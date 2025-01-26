package study.spring.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableScheduling;
import study.spring.others.AnyBean;

@Configuration
@EnableScheduling
public class ExampleConfuguration {

    @Bean(name = "any_bean")
    @Scope("prototype")
    public AnyBean getAnyBean() {
        return new AnyBean();
    }
}
