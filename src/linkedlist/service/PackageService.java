package linkedlist.service;

import java.util.List;
import linkedlist.models.Package;

public interface PackageService {
    String createPackage(Package aPackage);
    List<Package> sortPackageByType();
    List<Package> sortPackageByWeight();
}
