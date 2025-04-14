package task_slack.pharmacy_management_system.service;

import task_slack.pharmacy_management_system.models.Pharmacy;

import java.util.List;

public interface PharmacyService {
    void createPharmacy(Pharmacy pharmacy);
    void getAllPharmacies();
    void updatePharmacy(String pharmacyId, Pharmacy updatedPharmacy);
    void deletePharmacy(String pharmacyId);
}
