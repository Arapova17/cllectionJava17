package task_slack.pharmacy.service;

import task_slack.pharmacy.models.Medicine;

import java.util.List;

public interface MedicineService {
    String addMedicine(Medicine medicine);
    List<Medicine> getAllMedicine();
    Medicine getByIdMedicine(Long id);
    String updateMedicine(Long id, Medicine newMedicine);
    String deleteMedicine(Long id);
    String assignMedicineToPharmacy (Long medicineId, Long pharmacyId);

}
