package com.startech.person;

import com.startech.person.model.user.Role;
import com.startech.person.repository.user.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PersonApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonApplication.class, args);
	}
	@Bean
	public CommandLineRunner initDatabase(RoleRepository roleRepository) {
		return args -> {
			if (roleRepository.count() == 0) {
				addDefaultRoles(roleRepository);
			}
		};
	}

	@Transactional
	void addDefaultRoles(RoleRepository roleRepository) {
		Role role = new Role();
		role.setName("user");
		roleRepository.save(role);

		Role role1 = new Role();
		role1.setName("admin");
		roleRepository.save(role1);

		Role role2 = new Role();
		role2.setName("employee");
		roleRepository.save(role2);
	}

}
