package com.greenleafcommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.greenleafcommerce")
public class GreenleafCommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreenleafCommerceApplication.class, args);
	}

}
