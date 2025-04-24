package task_slack.pharmacy.service.serviceImpl;

import task_slack.pharmacy.database.Database;
import task_slack.pharmacy.models.Employee;
import task_slack.pharmacy.models.Medicine;
import task_slack.pharmacy.models.Pharmacy;
import task_slack.pharmacy.service.PharmacyService;

import java.util.ArrayList;
import java.util.List;

public class PharmacyServiceImpl implements PharmacyService {
    @Override
    public String addPharmacy(Pharmacy pharmacy) {
        try {
           Database.pharmacies.add(pharmacy);
           return "Success";
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Pharmacy> getAllPharmacy() {
        try {
            return Database.pharmacies;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Pharmacy getByIdPharmacy(Long id) {
        try {
            for (Pharmacy pharmacy : Database.pharmacies) {
                if (pharmacy.id().equals(id)) {
                    return pharmacy;
                }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public String updatePharmacy(Long id, Pharmacy newPharmacy) {
        try {
            for (Pharmacy pharmacy : Database.pharmacies) {
                if (pharmacy.id().equals(id)) {
                    pharmacy.setName(newPharmacy.name());
                    return "Success!";
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "not found!";
    }

    @Override
    public String deletePharmacy(Long id) {
        try {
            for (Pharmacy pharmacy : Database.pharmacies) {
                if (pharmacy.id().equals(id)) {
                    Database.pharmacies.remove(pharmacy);
                    return "Success!";
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "not found!";
    }

    public List<Medicine> getMedicinesByPharmacyId(Long pharmacyId) {
//        for (Pharmacy pharmacy : Database.pharmacies){
//            if (pharmacy.id().equals(pharmacyId)){
//                return pharmacy.medicines();
//            }
//        }
//        System.out.println("Pharmacy not found!");
//        return new ArrayList<>();
//}

//        try {
//            for (Pharmacy pharmacy : Database.pharmacies) {
//                if (pharmacy.id().equals(pharmacyId)) {
//                    List<Medicine> medicines = pharmacy.medicines();
//                    if (medicines == null) {
//                        return new ArrayList<>();
//                    }
//                    return medicines;
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//        return new ArrayList<>();
//    }
        try {
            for (Pharmacy pharmacy : Database.pharmacies) {
                if (pharmacy.id().equals(pharmacyId)) {
                    List<Medicine> medicines = pharmacy.medicines();
                    if (medicines == null) {
                        System.out.println("No medicines in this pharmacy.");
                        return new ArrayList<>();
                    }
                    return medicines;
                }
            }
            System.out.println("Pharmacy not found.");
            return new ArrayList<>();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public List<Employee> getEmployeesByPharmacyId(Long pharmacyId) {
        for (Pharmacy pharmacy : Database.pharmacies) {
            if (pharmacy.id().equals(pharmacyId)) {
                return pharmacy.employees();
            }
        }
        System.out.println("Pharmacy not found");
        return new ArrayList<>();
    }
}
