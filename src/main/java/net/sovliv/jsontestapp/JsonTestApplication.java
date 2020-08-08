package net.sovliv.jsontestapp;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sovliv.jsontestapp.domain.User;
import net.sovliv.jsontestapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class JsonTestApplication {
	Logger logger = LoggerFactory.getLogger(JsonTestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JsonTestApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserService userService){
		return args -> {
			//read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<User>> typeReference = new TypeReference<List<User>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/users.json");
			try{
				List<User> users = mapper.readValue(inputStream, typeReference);
				userService.saveAll(users);
                System.out.println("all users saved!");
                //users.stream().forEach(System.out::println);
			} catch (IOException e) {
				e.printStackTrace();
				logger.error("All users didn't save!" + e.getMessage());
			}
		};
	}

}
