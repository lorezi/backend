package com.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.learn.domain.Car;
import com.learn.domain.CarRepository;
import com.learn.domain.Owner;
import com.learn.domain.OwnerRepository;
import com.learn.domain.User;
import com.learn.domain.UserRepository;

@SpringBootApplication
public class CarAppApplication {

	// DI
	@Autowired
	private CarRepository repository;
	
	@Autowired
	private OwnerRepository ownerRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CarAppApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			Owner owner1 = ownerRepository.save(new Owner("Lawrence", "Onaulogho"));
			Owner owner2 = ownerRepository.save(new Owner("Seun", "Ogun"));
			Owner owner3 = ownerRepository.save(new Owner("Daniel", "Nyambi"));
			
			// Save demo data to database
			repository.save(new Car("Ford", "Mustang", "Red",
					"ADF-1121", 2017, 5900, owner1));
			repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2));
			repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner3));
			
			// username: user
			// password: user
			userRepository.save(new User("user", "$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi",
					"USER"));
			
			//username: admin
			//password: admin
			userRepository.save(new User("admin", "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG", "ADMIN"));
		};
	}

}

