import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        userService.addUser(new User("test", "test@", "test", "test", 10));
        userService.addUser(new User("test1", "test@1", "test1", "test1", 11));
        System.out.println(userService.getAll());

        userService.getByIdUser(1L);
        System.out.println(userService.getAll());

        userService.updateUser(1L, new User("test2", "test@2", "test2", "test2", 12));
        System.out.println(userService.getAll());
//       int a = 3;
//       Integer b = a; //autoboxing
//
//        Integer s = 5;
//        int c = s; //unboxing
//
//        ArrayList<String> array = new ArrayList<>(); //
//        array.add("Baitenir");
//        array.add("Sanjar");
//        array.add("Junusbek");
//        System.out.println(array);
//        System.out.println(array.get(0));
//        array.add("Elnura");
//        System.out.println(array);
//        //array.clear();
//        System.out.println(array.size());
//        array.set(2, "Nurpazyl");
//        System.out.println(array);
//        System.out.println(array.isEmpty());
//        array.remove("Nurpazyl");
//        System.out.println(array);
//        System.out.println(array.contains("Elnura"));
//
//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("+");
//        arrayList.add("/");
//        arrayList.addAll(array);
//        System.out.println(arrayList);
//
//        ArrayList<Integer> arr = new ArrayList<>();
//
//        List<Object> objects = new ArrayList<>();
//        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(3, 2));
//
//        for (Integer integer : integers){
//            System.out.println(integer);
//        }
//
//        for (int i = 0; i < integers.size(); i++) {
//            System.out.println(integers.get(i));
//        }
//
//        Iterator<Integer> integerIterator = integers.iterator();
//
//        while (integerIterator.hasNext()){
//            System.out.println(integerIterator.next());
//        }

//        ArrayList<Student> students = new ArrayList<>(List.of(new Student("Ainur", 18, "JS"),
//                new Student("Argen", 20, "Java"), new Student("Akyl", 19, "JS"),
//                new Student("Nurkyz", 21, "Java"), new Student("Aigul", 17, "Java"),
//                new Student("Saikal", 26, "JS"), new Student("Meder", 17, "Java"),
//                new Student("Gulnura", 20, "JS"), new Student("Aisalkyn", 19, "Java"),
//                new Student("Aibek", 22, "JS")));
//
//        System.out.println(students);
//
//        System.out.println("----------------- \nJS");
//        System.out.println(getStudentWithGroup(students, "JS"));
//        System.out.println("----------------- \nJava");
//        System.out.println(getStudentWithGroup(students, "Java"));
//        System.out.println("--------------------- \nAge");
//        System.out.println(getStudentWhichAge19and23(students));
//        System.out.println("---------------------- \nA");
//        System.out.println(getStudentWhichNameStartWithA(students));

//
//        try{
//            for (int i = 0; i < employees.size(); i++) {
//                if (employees.get(i).age() < 0){
//                    throw new MyException();
//                }
//                System.out.println(employees.get(i));
//            }
//        } catch (MyException e) {
//            System.out.println();
//        }
//
//        System.out.println(employees);

//        List<Integer> integerList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
//        System.out.println(integerList);
//
//        List<Integer> evenNumbers = new LinkedList<>();
//        List<Integer> oddNumbers = new LinkedList<>();
//        for (Integer integer : integerList){
//            if (integer % 2 == 0) {
//                evenNumbers.add(integer);
//            } else {
//                oddNumbers.add(integer);
//            }
//
//        }
//
//        Collections.sort(integerList);
//        System.out.println(evenNumbers);
//        System.out.println(oddNumbers);
//
    }

    public static List<Student> getStudentWithGroup(List<Student> students, String group){
        List<Student> studentList = new ArrayList<>();
        for (Student student : students){
            if (student.group().equals(group)){
                studentList.add(student);
            }
        }
        return studentList;
    }

    public static List<Student> getStudentWhichAge19and23(List<Student> students){
        List<Student> studentList = new ArrayList<>();
        for (Student student : students){
            if (student.age() >= 19 && student.age() <= 23){
                studentList.add(student);
            }
        }
        return studentList;
    }

    public static List<Student> getStudentWhichNameStartWithA(List<Student> students){
        List<Student> studentList = new ArrayList<>();
        for (Student student : students){
            if (student.name().charAt(0) == 'A'){
                studentList.add(student);
            }
        }
        return studentList;
    }
}