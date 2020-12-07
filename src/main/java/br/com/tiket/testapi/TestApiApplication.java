package br.com.tiket.testapi;

import br.com.tiket.testapi.util.TimeZones;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class TestApiApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestApiApplication.class);

	@PostConstruct
	void started() {
		TimeZones.setUTC();
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(TestApiApplication.class, args);
		String profile = Arrays.toString(ctx.getEnvironment().getActiveProfiles());
		LOGGER.info("Using profile {}", profile);
	}

}
