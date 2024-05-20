package com.startech.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersonApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonApplication.class, args);
	}
//	@Bean
//	CommandLineRunner initDatabase(RoleRepository roleRepository){
//		return  args -> {
//			Role role=new Role();
//			role.setName("user");
//			roleRepository.save(role);
//
//			Role role1=new Role();
//			role1.setName("admin");
//			roleRepository.save(role1);
//
//			Role role2=new Role();
//			role2.setName("employee");
//			roleRepository.save(role2);
//		};
//	}

}
