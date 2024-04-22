package com.shop;

import com.shop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@RequiredArgsConstructor
@SpringBootApplication
public class ECommerceApplication implements CommandLineRunner {

	private static Logger logger = LoggerFactory.getLogger(ECommerceApplication.class);
	private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("{}",userRepository.findAll());
		userRepository.softDeleteById(18L);
		logger.info("{}",userRepository.findAllByEnabledTrue());
	}
}
