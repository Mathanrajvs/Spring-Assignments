package com.medicine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	@RequestMapping("admin-view")
	public String Admin(Model model) {
		return "admin";
	}
	@RequestMapping("add-medicine-form")
	public String addMedicine(Model model) {
		return "add-form";
	}
	@RequestMapping("update-medicine-form")
	public String updateMedicine(Model model) {
		return "edit-form";
	}
	@RequestMapping("delete-medicine-form")
	public String deleteMedicine(Model model) {
		return "delete-form";
	}
}
