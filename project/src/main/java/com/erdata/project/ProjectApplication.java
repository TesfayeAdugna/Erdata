package com.erdata.project;

import com.erdata.project.Security.User;
import com.erdata.project.Security.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			Long userList = userRepository.count();
			if(userList.intValue()== 0) {
				User user = new User();
				user.setUsername("teshome");
				user.setPassword(passwordEncoder.encode("UGR/3281/12"));
				user.setFirstName("Teshome");
				user.setLastName("Nbret");
				user.setGender("male");
				user.setPhone("0932255228");
				user.setRole("ROLE_ADMIN");
				user.setEmail("endale@gmail.com");
				userRepository.save(user);
			}};}


			}
