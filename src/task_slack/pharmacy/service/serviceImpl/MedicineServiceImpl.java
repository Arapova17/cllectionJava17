package task_slack.pharmacy.service.serviceImpl;

import task_slack.pharmacy.database.Database;
import task_slack.pharmacy.models.Medicine;
import task_slack.pharmacy.models.Pharmacy;
import task_slack.pharmacy.service.MedicineService;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class MedicineServiceImpl implements MedicineService {
    @Override
    public String addMedicine(Medicine medicine) {
        try {
            if (medicine.expirationDate().getYear() != 2025) {
                throw new RuntimeException("Only expiration year 2025 allowed");
            }
            Database.medicines.add(medicine);
            return "SuccessFull";
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public List<Medicine> getAllMedicine() {
        try {
            return Database.medicines;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Medicine getByIdMedicine(Long id) {
        try {
            for (Medicine medicine : Database.medicines) {
                if (medicine.id().equals(id)) {
                    return medicine;
                }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public String updateMedicine(Long id, Medicine newMedicine) {
        try {
            for (Medicine medicine : Database.medicines) {
                if (medicine.id().equals(id)) {
                    medicine.setName(newMedicine.name());
                    medicine.setPrice(newMedicine.price());
                    medicine.setDescription(newMedicine.description());
                    medicine.setExpirationDate(newMedicine.expirationDate());
                    return "Success!";
                }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return "not found!";
    }

    @Override
    public String deleteMedicine(Long id) {
        try {
            for (Medicine medicine : Database.medicines) {
                if (medicine.id().equals(id)) {
                    Database.medicines.remove(medicine);
                    return "delete!";
                }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return "not found!";
    }

    @Override
    public String assignMedicineToPharmacy(Long medicineId, Long pharmacyId) {
        try {
            for (Pharmacy pharmacy : Database.pharmacies){
                if (pharmacy.id().equals(pharmacyId)){
                    for (Medicine medicine : Database.medicines){
                        if (medicine.id().equals(medicineId)){
                            pharmacy.setMedicines(Database.medicines);
                            return "Success!";
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "not found!";
    }
}
