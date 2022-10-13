package com.medicineapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.medicineapp.model.Medicine;
import com.medicineapp.service.IMedicineService;

@SpringBootApplication
public class SpringDatajpaMedicineappApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDatajpaMedicineappApplication.class, args);
	}
	IMedicineService medicineService;
	@Autowired
	public void setMedicineService(IMedicineService medicineService) {
		this.medicineService = medicineService;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Add Medicine....");
		Medicine addMedicine=new Medicine("Rolax",221,"Food Poisoning","SKS company",200,true);
		medicineService.addMedicine(addMedicine);
		System.out.println("Update Medicine....");
		Medicine updateMedicine=new Medicine("roval",221,"covid","SKS company",500,true);
		medicineService.addMedicine(updateMedicine);
		System.out.println("Get By ID.....");
		Medicine medicineId=medicineService.getById(221);
		System.out.println(medicineId);
		System.out.println("Delete Medicine.....");
		medicineService.deleteMedicine(32);
		
		
		System.out.println("Medicine Name Containing....");
		medicineService.getByNameContaining("r").forEach(System.out::println);
		System.out.println("Medicine Category....");
		medicineService.getByCategory("covid").forEach(System.out::println);
		
		System.out.println("Medicine Name and Category....");
		medicineService.getByNameAndCategory("roval", "covid").forEach(System.out::println);
		System.out.println("Medicine Category And Brand....");
		medicineService.getByCategoryAndBrand("covid", "SKS company").forEach(System.out::println);
		System.out.println("Medicine Category And Cost....");
		medicineService.getByCategoryAndLessCost("covid", 500).forEach(System.out::println);
		System.out.println("Medicine Name and Availability....");
		medicineService.getByNameAndAvailabilty("roval", true).forEach(System.out::println);
		
		
	}
	

}
