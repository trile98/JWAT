package hello;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import hello.config.AppConfig;
import hello.service.UserService;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		 AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	        UserService userService = (UserService) context.getBean("userService");
		
		SpringApplication.run(Application.class, args);
	}
	
	
}
