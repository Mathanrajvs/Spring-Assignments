package com.medicine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.medicine.model.Medicine;
import com.medicine.util.MedicineMapper;
import com.medicine.util.Queries;

/**
 * Perform operations in DAO layer
 * 
 * @implSpec IMedicineDao the interface
 * @author MathanRajS
 * @version 18.x
 */
@Repository
public class MedicineDaoImpl implements IMedicineDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * To add medicine in the database
	 * 
	 * @param medicine the medicine object class of Medicine
	 * @return void returns nothing
	 * @author MathanRajS
	 *
	 */
	@Override
	public void addMedicine(Medicine medicine) {
		Object[] medicineArray = { medicine.getMedicineName(), medicine.getMedicineId(), medicine.getCategory(),
				medicine.getBrand(), medicine.getCost(), medicine.isAvailability() };
		jdbcTemplate.update(Queries.INSERTQUERY, medicineArray);
	}

	/**
	 * To Update medicine in the database
	 * 
	 * @param medicineId the medicine id
	 * @param fees       the cost of a medicine
	 * @return void return nothing
	 * @author MathanRajS
	 *
	 */
	@Override
	public void updateMedicine(int medicineId, double fees) {
		jdbcTemplate.update(Queries.UPDATEQUERY, fees, medicineId);

	}

	/**
	 * To Find the specific medicine in the database if it is present or not
	 * 
	 * @param medicineId the medicine id
	 * @return Medicine return medicine object
	 * @author MathanRajS
	 *
	 */
	@Override
	public Medicine findById(int medicineId) {
		Medicine medicine = jdbcTemplate.queryForObject(Queries.FINDQUERY, new MedicineMapper(), medicineId);
		return medicine;
	}

	/**
	 * To Delete the specific medicine in the database
	 * 
	 * @param medicineId the medicine id
	 * @return void returns nothing
	 * @author MathanRajS
	 */

	@Override
	public void deleteMedicine(int medicineId) {
		jdbcTemplate.update(Queries.DELETEQUERY, medicineId);
	}

	/**
	 * Show all medicines with specific category
	 * 
	 * @param category the category of the medicine
	 * @return List<Medicine> to list the medicines
	 * @author MathanRajS
	 */
	@Override
	public List<Medicine> findByCategory(String category) {

		List<Medicine> medicineList = jdbcTemplate.query(Queries.QUERYBYCATEGORY, new MedicineMapper(), category);

		return medicineList;
	}

	/**
	 * Show medicines with specific category and specific brand
	 * 
	 * @param brand    the brand of the medicine
	 * @param category the category of the medicine
	 * @return List<Medicine> to list the medicines
	 * @author MathanRajS
	 */
	@Override
	public List<Medicine> findByCategoryAndBrand(String category, String brand) {
		List<Medicine> medicineList = jdbcTemplate.query(Queries.QUERYBYCATEGORYANDBRAND, new MedicineMapper(),
				category, brand);

		return medicineList;
	}

	/**
	 * Show all medicines that starts with name containing
	 * 
	 * @param name the name of the medicine
	 * @return List<Medicine> to list the medicines
	 * @author MathanRajS
	 */
	@Override
	public List<Medicine> findByNameContaining(String name) {
		List<Medicine> medicineList = jdbcTemplate.query(Queries.QUERYBYNAMECONTAINING, new MedicineMapper(), name);

		return medicineList;
	}

	/**
	 * Show medicines with specific category and specific name
	 * 
	 * @param name     the name of the medicine
	 * @param category the category of the medicine
	 * @return List<Medicine> to list the medicines
	 * @author MathanRajS
	 */
	@Override
	public List<Medicine> findByNameAndCategory(String name, String category) {
		List<Medicine> medicineList = jdbcTemplate.query(Queries.QUERYBYNAMEANDCATEGORY, new MedicineMapper(),
				name + "%", category);

		return medicineList;
	}

	/**
	 * Show medicines with specific category and specific cost
	 * 
	 * @param cost     the cost of the medicine
	 * @param category the category of the medicine
	 * @return List<Medicine> to list the medicines
	 * @author MathanRajS
	 */
	@Override
	public List<Medicine> findByCategoryAndLessCost(String category, double cost) {
		List<Medicine> medicineList = jdbcTemplate.query(Queries.QUERYFORCATEORYANDCOST, new MedicineMapper(), category,
				cost);

		return medicineList;
	}

	/**
	 * Show medicines with specific name and check if it is present or not
	 * 
	 * @param name    the name of the medicine
	 * @param present to check the medicine is available
	 * @return List<Medicine> to list the medicines
	 * @author MathanRajS
	 */
	@Override
	public List<Medicine> findByNameAndAvailabilty(String name, boolean present) {
		List<Medicine> medicineList = jdbcTemplate.query(Queries.QUERYBYNAMEANDAVAILABILITY,new MedicineMapper(), name+"%", present);

		return medicineList;

	}

}
