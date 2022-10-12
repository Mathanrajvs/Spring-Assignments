package com.medicine;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.medicine.exceptions.IdNotFoundException;
import com.medicine.model.Category;
import com.medicine.model.Medicine;
import com.medicine.service.IMedicineService;
import com.medicine.service.MedicineServiceImpl;

@SpringBootApplication
public class SpringMedicineappJdbcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringMedicineappJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}


