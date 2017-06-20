import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class Ejemplo {
	@RequestMapping("/")
	String home() {
		return "Hola mundo";
	}

	public static void main(String [] args) throws Exception {
		SpringApplication.run(Ejemplo.class, args);
	}	

}
