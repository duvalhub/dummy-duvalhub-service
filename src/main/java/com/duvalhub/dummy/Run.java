package com.duvalhub.dummy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Run implements ApplicationRunner {
  @Override
  public void run(ApplicationArguments args) throws Exception {
    log.info("App running");
  }
}
