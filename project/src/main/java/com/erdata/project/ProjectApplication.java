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

				User user1 = new User();
				user1.setUsername("kenna");
				user1.setPassword(passwordEncoder.encode("UGR/0317/12"));
				user1.setFirstName("Kenna");
				user1.setLastName("Tefera");
				user1.setGender("female");
				user1.setPhone("0930255228");
				user1.setEmail("kenna@gmail.com");
				user1.setRole("ROLE_ADMIN");
				userRepository.save(user1);

				User user2 = new User();
				user2.setUsername("endale");
				user2.setPassword(passwordEncoder.encode("UGR/7379/12"));
				user2.setFirstName("Endale");
				user2.setLastName("Yohannes");
				user2.setGender("male");
				user2.setPhone("0922255228");
				user2.setEmail("endaleyohannes8@gmail.com");
				user2.setRole("ROLE_ADMIN");
				userRepository.save(user2);

				User user3 = new User();
				user3.setUsername("tesfaye");
				user3.setPassword(passwordEncoder.encode("UGR/4709/12"));
				user3.setFirstName("Tesfaye");
				user3.setLastName("Adugna");
				user3.setPhone("0912255228");
				user3.setGender("male");
				user3.setEmail("adugatesfaye888@gmail.com");
				user3.setRole("ROLE_ADMIN");
				userRepository.save(user3);

				User user4 = new User();
				user4.setUsername("beniam");
				user4.setPassword(passwordEncoder.encode("UGR/4689/12"));
				user4.setFirstName("Beniam");
				user4.setLastName("Alemu");
				user4.setGender("male");
				user4.setPhone("0912455228");
				user4.setEmail("rediet@gmail.com");
				user4.setRole("ROLE_ADMIN");
				userRepository.save(user4);

				User user5 = new User();
				user5.setUsername("gizaw");
				user5.setPassword(passwordEncoder.encode("UGR/6640/12"));
				user5.setFirstName("Gizaw");
				user5.setLastName("Dagne");
				user5.setGender("male");
				user5.setPhone("0912455228");
				user5.setEmail("giaw@gmail.com");
				user5.setRole("ROLE_ADMIN");
				userRepository.save(user5);
			}
		};
	}


			}
