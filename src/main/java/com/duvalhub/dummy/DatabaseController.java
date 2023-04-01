package com.duvalhub.dummy;

import com.zaxxer.hikari.HikariConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/databases")
@RequiredArgsConstructor
@Slf4j
public class DatabaseController implements ApplicationRunner {
  private final HikariConfig hikariConfig;

  @GetMapping
  public String info() {
    return String.format("jdbcUrl=%s, username=%s", hikariConfig.getJdbcUrl(), hikariConfig.getUsername());
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    log.info("Connected to database with info: {}", info());
  }
}
