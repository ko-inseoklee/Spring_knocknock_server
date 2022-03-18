package com.knkn.knockknock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KnockknockApplication {

	public static void main(String[] args) {
		try{
			SpringApplication.run(KnockknockApplication.class, args);
			System.out.println("Server opened Successfully");
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
