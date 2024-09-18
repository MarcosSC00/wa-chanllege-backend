package com.chanlleges.wachanllege;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.chanlleges.wachanllege.service.CommandLineRunnerService;

@SpringBootApplication
public class WachanllegeApplication {

	public static void main(String[] args) {
		 SpringApplication.run(WachanllegeApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CommandLineRunnerService service) {
		return args -> service.run(args);
		
	}
}