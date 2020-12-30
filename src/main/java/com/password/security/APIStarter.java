package com.password.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@Slf4j
@SpringBootApplication
public class APIStarter {

    public static void main(final String[] args) {
        final SpringApplication app = new SpringApplication(APIStarter.class);
        final Environment env = app.run(args).getEnvironment();

        log.info("\n=====================================\n" +
                        "\tAcesse: http://localhost:{}\n" +
                        "=====================================",
                env.getProperty("server.port")
        );

    }

}
