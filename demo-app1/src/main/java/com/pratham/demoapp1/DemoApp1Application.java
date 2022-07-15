package com.pratham.demoapp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoApp1Application.class, args);
	}

	@GetMapping("/")
	public String greet(){
		return "Greetings from demo1 app";
	}

}
