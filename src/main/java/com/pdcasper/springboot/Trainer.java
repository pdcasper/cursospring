package com.pdcasper.springboot;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

import org.springframework.web.bind.annotation.*;

@SpringBootApplication  
public class Trainer {
	@RequestMapping("/")
	String home() {
		return "Hola mundo";
	}

	public static void main(String [] args) throws Exception {
		SpringApplication.run(Trainer.class, args);
	}	

}
