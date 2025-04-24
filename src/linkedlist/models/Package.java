package linkedlist.models;

import linkedlist.enums.PackageType;

import java.util.Comparator;

public class Package implements Comparable<Package> {
    private static Long count = 0L;
    private Long id;
    private double weight;
    private PackageType packageType;

    public Package() {
    }

    public Package(double weight, PackageType packageType) {
        this.id = ++count;
        this.weight = weight;
        this.packageType = packageType;
    }

    public Long id() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double weight() {
        return weight;
    }

    public Comparator<? super Package> setWeight(double weight) {
        this.weight = weight;
        return null;
    }

    public PackageType packageType() {
        return packageType;
    }

    public Comparator<? super Package> setPackageType(PackageType packageType) {
        this.packageType = packageType;
        return null;
    }

    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", weight=" + weight +
                ", packageType=" + packageType +
                '}';
    }


    @Override
    public int compareTo(Package o) {
        return o.packageType.name().compareTo(o.packageType.name());
    }
}
