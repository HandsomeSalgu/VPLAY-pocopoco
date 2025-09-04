package pocopoco_vplay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class VplayApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(VplayApplication.class, args);
	}
	
	@Override protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) { 
		return builder.sources(VplayApplication.class); 
	}

}
