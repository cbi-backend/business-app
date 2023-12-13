package com.business.card;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
	"com.business.card.admincapability",
	"com.business.card.usercapability",
	"com.business.card.appcapability",
	"com.business.card.swagger",
	"com.business.card.security"})
public class CardApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardApplication.class, args);
	}

}
