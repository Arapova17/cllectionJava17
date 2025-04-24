package task_slack.pharmacy.service;

import task_slack.pharmacy.models.Employee;
import task_slack.pharmacy.models.Medicine;
import task_slack.pharmacy.models.Pharmacy;

import java.util.List;

public interface PharmacyService {
    String addPharmacy(Pharmacy pharmacy);
    List<Pharmacy> getAllPharmacy ();
    Pharmacy getByIdPharmacy (Long id);
    String updatePharmacy (Long id,Pharmacy newPharmacy);
    String deletePharmacy (Long id);
    List<Medicine> getMedicinesByPharmacyId(Long pharmacyId);
    List<Employee> getEmployeesByPharmacyId(Long pharmacyId);
}
