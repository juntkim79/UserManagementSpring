package com.moneylion.usermanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class Database {

  private static final Logger log = LoggerFactory.getLogger(Database.class);

  @Bean
  CommandLineRunner initDatabase(UserRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new User("github","juntkim79@gmail.com", true)));
      log.info("Preloading " + repository.save(new User("jenkins", "korrisha@moneylion.com", false)));
    };
  }
}