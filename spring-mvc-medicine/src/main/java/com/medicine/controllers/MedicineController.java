package com.medicine.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.medicine.model.Medicine;
import com.medicine.service.IMedicineService;

@Controller
public class MedicineController {
	@Autowired
	IMedicineService medicineService;
	
	public void setMedicineService(IMedicineService medicineService) {
		this.medicineService = medicineService;
	}
	@RequestMapping("/")
	public String allMedicines(Model model) {
		return "home";
	}
	@RequestMapping("/add-medicine")
	public String addMedicines(Medicine medicine,Model model) {
		medicineService.addMedicine(medicine);
		model.addAttribute("medicine",medicine);
		return "success";
	}
	@RequestMapping("get-one")
	public String updateMedicines(@RequestParam("updateId")int updateId,Model model) {
		Medicine medicine=medicineService.getById(updateId);
		model.addAttribute("medicine",medicine);
		return "update-form";
	}
	@RequestMapping("get-two")
	public String deleteMedicines(@RequestParam("deleteId")int deleteId,Model model) {
		medicineService.deleteMedicine(deleteId);
		model.addAttribute("medicine", "DELETED SUCCESSFULLY");
		return "success";
	}
	@RequestMapping("/update-medicine")
	public String upToDateMedicines(@RequestParam("medicineId")int medicineId,@RequestParam("cost")int cost,Model model) {
		medicineService.updateMedicine(medicineId, cost);
		return "admin";
	}
	@RequestMapping("/search-medicine-for-diseases")
	public String searchMedicines(@RequestParam("choice")String choice,Model model) {
		List<Medicine> medicines=medicineService.getByCategory(choice);
		model.addAttribute("medicine",medicines);
		return "success";
	}

	
}
