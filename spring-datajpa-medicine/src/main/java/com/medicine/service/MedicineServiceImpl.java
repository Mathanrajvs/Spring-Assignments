package com.medicine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicine.exceptions.IdNotFoundException;
import com.medicine.exceptions.MedicineNotFoundException;
import com.medicine.model.Medicine;
import com.medicine.repository.IMedicineRepository;
/**
 *Perform operations in Service layer
 * @implSpec IMedicineService the interface
 * @author MathanRajS
 *@version 18.x
 */
@Service
public class MedicineServiceImpl implements IMedicineService {
	@Autowired
	IMedicineRepository medicineDao;
	
	public MedicineServiceImpl(IMedicineRepository medicineDao) {
		super();
		this.medicineDao = medicineDao;
	}
	/**
	 * Transfer data to DAO layer to add medicine in the database
	 * @param medicine the medicine object class
	 * @return void returns nothing
	 * @author MathanRajS
	 */
	@Override
	public void addMedicine(Medicine medicine) {
		medicineDao.save(medicine);
		
	}
	/**
	 * Transfer data to DAO layer to Update medicine in the database
	 * @param medicineId the medicine id
	 * @param fees the cost of a medicine
	 * @return void return nothing
	 * @author MathanRajS
	 */
	@Override
	public void updateMedicine(Medicine medicine) {
		medicineDao.save(medicine);
	}
	/**
	 * Transfer data to DAO layer to Find the specific medicine in the database and if not then throw the exception
	 * @param medicineId the medicine id
	 * @throws IdNotFoundException to throw exception 
	 * @return Medicine return medicine object
	 * @author MathanRajS
	 */
	@Override
	public Medicine getById(int medicineId) throws IdNotFoundException {
		Medicine medicine=medicineDao.findById(medicineId).get();
		return medicine;
	}
	/**
	 * Transfer data to DAO layer to  Delete the specific medicine in the database
	 * @param medicineId the medicine id
	 * @return void return nothing
	 * @author MathanRajS
	 */
	@Override
	public void deleteMedicine(int medicineId) {
		medicineDao.deleteById(medicineId);
	}
	/**
	 * Transfer data to DAO layer to Show all medicines starts with name containing and if not then throw the exception
	 * @param name the name of the medicine
	 * @throws MedicineNotFoundException to throw the exception
	 * @return List<Medicine> to list the medicines
	 * @author MathanRajS
	 */
	@Override
	public List<Medicine> getByNameContaining(String name) throws MedicineNotFoundException {
		List<Medicine> medicines=medicineDao.findByMedicineName(name);
		
		if(medicines.isEmpty()) {
			throw new MedicineNotFoundException("MEDICINE IS NOT FOUND");
		}
		
		return medicines;
	}
	/**
	 *Transfer data to DAO layer to Show all medicines with specific category and if not then throw the exception
	 *@param category the category of the medicine
	 *@throws MedicineNotFoundException to throw the exception
	 *@return List<Medicine> to list the medicines
	 *@author MathanRajS
	 */
	@Override
	public List<Medicine> getByCategory(String category) throws MedicineNotFoundException {
		List<Medicine> medicines=medicineDao.findByCategory(category);
		
		if(medicines.isEmpty()) {
			throw new MedicineNotFoundException("MEDICINE IS NOT FOUND");
		}
		
		return medicines;
	}
	/**
	 *Transfer data to DAO layer to Show medicines with specific category and specific name and if not then throw the exception
	 *@param name the name of the medicine
	 *@param category the category of the medicine
	 *@throws MedicineNotFoundException to throw the exception
	 *@return List<Medicine> to list the medicines
	 *@author MathanRajS
	 */
	@Override
	public List<Medicine> getByNameAndCategory(String name, String category) throws MedicineNotFoundException {
		List<Medicine> medicines=medicineDao.findByMedicineNameAndCategory(name, category);
		
		if(medicines.isEmpty()) {
			throw new MedicineNotFoundException("MEDICINE IS NOT FOUND");
		}
		
		return medicines;
	}
	/**
	 *Transfer data to DAO layer to Show medicines with specific category and specific brand and if not then throw the exception
	 *@param brand the brand of the medicine
	 *@param category the category of the medicine
	 *@throws MedicineNotFoundException to throw the exception
	 *@return List<Medicine> to list the medicines
	 *@author MathanRajS
	 */
	@Override
	public List<Medicine> getByCategoryAndBrand(String category, String brand) throws MedicineNotFoundException {
		List<Medicine> medicines=medicineDao.findByCategoryAndBrand(category, brand);
		if(medicines.isEmpty()) {
			throw new MedicineNotFoundException("MEDICINE IS NOT FOUND");
		}
		
		return medicines;
	}
	/**
	 *Transfer data to DAO layer to Show medicines with specific category and specific cost and if not then throw the exception
	 *@param cost the cost of the medicine
	 *@param category the category of the medicine
	 *@throws MedicineNotFoundException to throw the exception
	 *@return List<Medicine> to list the medicines
	 *@author MathanRajS
	 */
	@Override
	public List<Medicine> getByCategoryAndLessCost(String category, double cost) throws MedicineNotFoundException {
		List<Medicine> medicines=medicineDao.findByCategoryAndCost(category, cost);
		if(medicines.isEmpty()) {
			throw new MedicineNotFoundException("MEDICINE IS NOT FOUND");
		}
		
		return medicines;
	}
	/**
	 *Transfer data to DAO layer to Show medicines with specific name and check if it is present and if not then throw the exception
	 *@param name the name of the medicine
	 *@param present to check the medicine is available or not
	 *@throws MedicineNotFoundException to throw the exception
	 *@return List<Medicine> to list the medicines
	 *@author MathanRajS
	 */

	@Override
	public List<Medicine> getByNameAndAvailabilty(String name,boolean present) throws MedicineNotFoundException{
		
		List<Medicine> medicines=medicineDao.findByMedicineNameAndAvailability(name,present);
		
		if(medicines.isEmpty()) {
			throw new MedicineNotFoundException("MEDICINE IS NOT FOUND");
		}
		
		return medicines;
	}
	
}
