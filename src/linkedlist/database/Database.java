package linkedlist.database;

import linkedlist.models.Courier;
import linkedlist.models.Delivery;
import linkedlist.models.Package;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Database {
    public static List<Delivery> deliveries = new LinkedList<>();
    public static Set<Courier> couriers = new HashSet<>();
    public static Set<Package> packages = new HashSet<>();
}
