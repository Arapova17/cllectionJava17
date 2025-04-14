package set;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Set<String> courses = new HashSet<>();
//        courses.add("PeakSoft");
//        courses.add("PeakSoft");
//        courses.add("Codify");
//        courses.add("Geeks");
//        courses.add("MegaLab");
//        courses.add("MotionWeb");
//        Set<String> courses1 = new LinkedHashSet<>();
//        courses1.add("PeakSoft");
//        courses1.add("Codify");
//        courses1.add("Geeks");
//        courses1.add("MegaLab");
//        courses1.add("MotionWeb");
//        System.out.println(courses1);
//        Set<Integer> number = new TreeSet<>();
//        number.add(11);
//        number.add(34);
//        number.add(76);
//        number.add(89);
//        number.add(100);
//        System.out.println(number);
//        //courses.remove("PeakSoft");
//        System.out.println(courses.contains("PeakSoft"));
//        courses.clear();
//        Iterator<String> iterator = courses.iterator();
//        System.out.println(courses.isEmpty());
//        System.out.println(courses);
//        while (iterator.hasNext()){
//            System.out.println(iterator);
//        }
//
//        List<String> test = new ArrayList<>();
//        test.add("PeakSoft");
//        test.add("Codify");
//        test.add("MotionWeb");
//        System.out.println(courses.containsAll(test));
//
//        Set<Student> students = new TreeSet<>();
//        System.out.println(students.add(new Student("Baitenir", 18, "@gmail")));

        Random random = new Random();
       Integer sum = 0;
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 400; i++) {
            integers.add(random.nextInt(0, 21));
        }

        for (Integer integer : integers){
            System.out.print(integer + ", ");
            sum += integer;
        }
        System.out.println("\nsum: " + sum);

        Set<Integer> integers1 = new HashSet<>(integers);
        int summa = 0;
        for (Integer i : integers1) {
            System.out.print(i + ", ");
            summa += i;
        }
        System.out.println("\nsumma: " + summa);
    }
}
