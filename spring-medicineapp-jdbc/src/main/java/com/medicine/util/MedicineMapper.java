package com.medicine.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.medicine.model.Medicine;

public class MedicineMapper implements RowMapper<Medicine> {

	@Override
	public Medicine mapRow(ResultSet rs, int rowNum) throws SQLException {
		Medicine medicine=new Medicine();
		medicine.setMedicineId(rs.getInt("medicineId"));
		medicine.setMedicineName(rs.getString("medicineName"));
		medicine.setCategory(rs.getString("category"));
		medicine.setBrand(rs.getString("brand"));
		medicine.setCost(rs.getDouble("cost"));
		medicine.setAvailability(rs.getBoolean("availability"));
		return medicine;
	}


}
