package com.duvalhub.dummy;

//import com.duvalhub.core.exceptions.DuvalhubException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class Run {
    @Bean
    public ApplicationRunner applicationRunner() {
        return (ApplicationArguments args) -> {
            log.info("App running");
        };
    }
}
