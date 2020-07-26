package com.cg.bookstore;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import com.cg.bookstore.entities.Admin;
import com.cg.bookstore.entities.CustomerInformation;

@SpringBootApplication
@Transactional
public class BookstoreApplication implements CommandLineRunner{

	@Autowired
	EntityManager entityManager;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

}
