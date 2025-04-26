package stream;

import stream.enums.Language;
import stream.models.Programmer;
import stream.service.ProgrammerService;
import stream.service.serviceImpl.ProgrammerServiceImpl;
import task_lms.task_map.service.ProductService;
import task_lms.task_map.service.serviceImpl.ProductServiceImpl;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        Random random = new Random();
//        int [] array = new int[20];
//        int count = 0;
//        for (int i = 0; i < array.length; i++) {
//            array[i] = random.nextInt(-20, 20);
//            if (array[i] > 0){
//                ++count;
//            }
//        }
//        System.out.println(Arrays.toString(array));
//        System.out.println(count);
//
//        System.out.println(Arrays.stream(array).filter(number -> number > 0).count());
//
//        String[] strings = {"Sanjar", "Baitenir", "Elnura", "Chyngyz", "Junusbek"};
//
//        Arrays.stream(strings).forEach(System.out::println);
//        long count1 = Arrays.stream(strings).count();
//        System.out.println(count1);
//
//        System.out.println(Arrays.toString(strings));
//        Arrays.stream(strings).map(name -> name + " " + name.length()).forEach(System.out::println);

        ProgrammerService programmerService = new ProgrammerServiceImpl();
        programmerService.addProgrammer(new Programmer("Sanjar", 700000, Language.JAVA));
        programmerService.addProgrammer(new Programmer("Baitenir", 900000, Language.JS));
        programmerService.addProgrammer(new Programmer("Elnura", 1000000, Language.PYTHON));
        programmerService.addProgrammer(new Programmer("Chyngyz", 50000, Language.JAVA));
        programmerService.addProgrammer(new Programmer("Junusbek", 600000, Language.JS));
        programmerService.addProgrammer(new Programmer("Artur", 700000, Language.JAVA));
        programmerService.addProgrammer(new Programmer("Sanjar", 700000, Language.JAVA));
        programmerService.addProgrammer(new Programmer("Sanjar", 700000, Language.JAVA));


    }
}
