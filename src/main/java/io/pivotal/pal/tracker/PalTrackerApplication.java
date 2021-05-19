package io.pivotal.pal.tracker;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.servlet.ServletContext;

@SpringBootApplication
public class PalTrackerApplication {

  public static void main(String[] args) {

    ConfigurableApplicationContext context= SpringApplication.run(PalTrackerApplication.class, args);
    TimeEntryRepository inMemoryTimeEntryRepositoryr = context.getBean(InMemoryTimeEntryRepository.class);
}
    }
