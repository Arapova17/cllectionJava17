package linkedlist.service.serviceImpl;

import linkedlist.database.Database;
import linkedlist.service.PackageService;
import linkedlist.models.Package;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PackageServiceImpl implements PackageService , Comparable<Package>{
    @Override
    public String createPackage(Package aPackage) {
        Database.packages.add(aPackage);
        return "SuccessFull!";
    }

    @Override
    public List<Package> sortPackageByType() {
         Collections.sort(Database.packages);
         return Database.packages;
    }

    @Override
    public int compareTo(Package o) {
        return (int) (o.weight() - o.weight());
    }

    @Override
    public List<Package> sortPackageByWeight() {
        Collections.sort(Database.packages);
        return Database.packages;
    }

}
