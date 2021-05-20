package io.pivotal.pal.tracker;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

@SpringBootApplication
public class PalTrackerApplication {

    public static void main(String[] args) {

        SpringApplication.run(PalTrackerApplication.class, args);


    }

    @Bean
    public TimeEntryRepository timeEntryRepository(DataSource dataSource){
        return new JdbcTimeEntryRepository(dataSource);

    }
}
