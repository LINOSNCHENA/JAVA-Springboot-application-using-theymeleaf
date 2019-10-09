package com.monze.praha;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PrahaApplication extends SpringBootServletInitializer { // ServletInitializer
	public static void main(String[] args)
	 {
		SpringApplication.run(PrahaApplication.class, args);
	}

}

