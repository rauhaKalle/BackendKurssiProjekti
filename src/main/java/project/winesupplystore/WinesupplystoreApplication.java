package project.winesupplystore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import project.winesupplystore.domain.AppUser;
import project.winesupplystore.domain.AppUserRepository;
import project.winesupplystore.domain.Manufacturer;
import project.winesupplystore.domain.ManufacturerRepository;
import project.winesupplystore.domain.Product;
import project.winesupplystore.domain.ProductRepository;

@SpringBootApplication

public class WinesupplystoreApplication {
	private static final Logger log = LoggerFactory.getLogger(WinesupplystoreApplication.class);

	@Autowired
	ProductRepository prepository;

	public static void main(String[] args) {
		SpringApplication.run(WinesupplystoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner wineSupplyStoreData(ProductRepository prepository, ManufacturerRepository mrepository,
			AppUserRepository userRepository) {
		return (args) -> {

			log.info("Save manufacturers");
			mrepository.save(new Manufacturer("Michlits Werner"));
			mrepository.save(new Manufacturer("Martin Obenaus"));

			log.info("save products");
			prepository.save(new Product("Meinklang Pet Nat", "Rose", "Itävalta", 2021, mrepository.findByName("Michlits Werner").get(0)));
			prepository.save(new Product("Martin Obenaus MO Weiss", "White", "Itävalta", 2020, mrepository.findByName("Martin Obenaus").get(0)));
			
			log.info("create users");
			AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C",
					"ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);

		};
	}

}
