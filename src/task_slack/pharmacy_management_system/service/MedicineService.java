package task_slack.pharmacy_management_system.service;

import task_slack.pharmacy_management_system.models.Medicine;

import java.util.List;

public interface MedicineService {
    void createMedicine(String pharmacyId, Medicine medicine);
    void getMedicinesByPharmacy(String pharmacyId);
    void updateMedicine(String medicineId, Medicine updatedMedicine);
    void deleteMedicine(String medicineId);

}
