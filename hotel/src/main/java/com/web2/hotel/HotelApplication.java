package com.web2.hotel;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.web2.hotel.repositories.UserRepository;

@SpringBootApplication
public class HotelApplication{

    @Autowired
    UserRepository userRepository;
    
	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
	
	}

}
