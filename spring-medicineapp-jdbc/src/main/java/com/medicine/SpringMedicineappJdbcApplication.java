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
	
	@Autowired
	IMedicineService medicineService;
	
	public SpringMedicineappJdbcApplication(IMedicineService medicineService) {
		super();
		this.medicineService = medicineService;
	}

	@Autowired
	Medicine medicine;
	@Override
	public void run(String... args) throws Exception {
		Scanner sc=new Scanner(System.in);
			System.out.println("Add Medicine....");
			String name = sc.next();
			int id = sc.nextInt();
			int category = 2;
			String special = Category.values()[category - 1].type;
			String brand = "MNK company";
			Double fees = 200d;
			boolean available = true;
			medicine.setMedicineName(name);
			medicine.setMedicineId(id);
			medicine.setCost(fees);
			medicine.setAvailability(available);
			medicine.setBrand(brand);
			medicine.setCategory(special);
			medicineService.addMedicine(medicine);	
			
			sc.close();
			System.out.println("Update...");
			medicineService.updateMedicine(101, 100);
			
			System.out.println("Medicine ID....");
			Medicine medicineFind = medicineService.getById(101);
			System.out.println(medicineFind);
			
			System.out.println("Delete Medicine By ID ....");
			medicineService.deleteMedicine(102);
			
			System.out.println("Medicine Name :");
			String nameMedicine = "Calpal";
			System.out.println(medicineService.getByNameContaining(nameMedicine));
			
			System.out.println("Category......");
			String specialname = Category.values()[1].type;
			List<Medicine> showMedicineCategory= medicineService.getByCategory(specialname);
			System.out.println(showMedicineCategory);
			
			
			
			
			System.out.println("Category and Brand.....");
			int showCategory = 1;
			String showSpecialMedicine = Category.values()[showCategory - 1].type;
			List<Medicine> showCategoryAndBrand= medicineService.getByCategoryAndBrand(showSpecialMedicine, "MKG company");
			showCategoryAndBrand.forEach(System.out::println);
			
			System.out.println("Category and Cost.....");
			double cost = 100;
			List<Medicine> showCategoryAndCost= medicineService.getByCategoryAndLessCost("Covid Essentials",
						cost);
			showCategoryAndCost.forEach(System.out::println);
			
			System.out.println("Name and Availability...");
			String MedicineName = "Dollo";
			boolean present = true;
			List<Medicine> available1= medicineService.getByNameAndAvailabilty(MedicineName, present);
		System.out.println(available1);
		
		System.out.println("Name and Category.....");
		List<Medicine> showNameAndCategory = medicineService.getByNameAndCategory("Dolo","Covid Essentials");
		showNameAndCategory.forEach(System.out::println);
		
		
		
		
	
	}	

		
	}


