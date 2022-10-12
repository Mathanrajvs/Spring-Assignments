package com.medicine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicine.model.Medicine;
@Repository
public interface IMedicineRepository  extends JpaRepository<Medicine, Integer> {
	List<Medicine> findByMedicineName(String author);
	List<Medicine> findByCategory(String category);
	List<Medicine> findByMedicineNameAndCategory(String name,String category);;
	List<Medicine> findByCategoryAndBrand(String category,String brand);
	List<Medicine> findByCategoryAndCost(String category,double cost);
	List<Medicine> findByMedicineNameAndAvailability(String name,boolean present);
}
