package com.somepackege;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EntityScan(basePackages = {"com.somepackege"})
@Slf4j
public class CoreApplication {

    public static void main(String[] args) {
        log.info("Starting CoreApplication");
        SpringApplication application = new SpringApplication(CoreApplication.class);
        application.addListeners(new ApplicationPidFileWriter("app.pid"));
        application.run(args);
    }
}
