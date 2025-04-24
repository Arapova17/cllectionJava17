package map;

import java.util.*;

public class Main {
    public static void main(String[] args) {

//        System.out.println(get(List.of("alma",
//                "banana",
//                "alma",
//                "oruk",
//                "alcha",
//                "banana",
//                "alma",
//                "alcha",
//                "banana",
//                "alma")));

//        System.out.println(map(List.of("H",
//                "E",
//                "L",
//                "L",
//                "O",
//                "W",
//                "O",
//                "R",
//                "L",
//                "D")));
//
//        Map<Character, Integer> helloWord = NEW(List.of());
//        System.out.println(NEW(Collections.singletonList("Hello world")));
//
//        String world = "hello world";
//        world = world.replace(" ", "");
//
//        Map<Character, Integer> countSymbol = new TreeMap<>();
//
//        for (char c : world.toCharArray()) {
//            countSymbol.put(c, countSymbol.getOrDefault(c, 0) + 1);
//            System.out.println(c);
//        }
//
//        System.out.println(countSymbol);

        Student student = new Student("Ali", "a@gmail.com");
        Student student1 = new Student("Beka", "b@gmail.com");
        Student student2 = new Student("Dima", "d@gmail.com");
        Student student3 = new Student("Jak", "j@gmail.com");

    }

    public static Map<String, Integer> get(List<String> words){
        Map<String, Integer> newMap = new HashMap<>();
        for (String word : words) {
            newMap.put(word, newMap.getOrDefault(word, 0) + 1);
        }
        return newMap;
    }

    public static Map<String, Integer> integerMap(Map<Integer, String> original) {
        Map<String, Integer> newInteger = new HashMap<>();
        for (Map.Entry<Integer, String> entry : original.entrySet()) {
            newInteger.put(entry.getValue(), entry.getKey());
        }
        return newInteger;
    }

    public static Map<String, Integer> map (List<String> strings) {
        Map<String, Integer> newMap = new TreeMap<>();
        for (String s : strings) {
            newMap.put(s, newMap.getOrDefault(s, 0) + 1);
        }
        return newMap;
    }
    public static Map<Character, Integer> NEW (List<String> strings) {
        Map<Character, Integer> newMap = new TreeMap<>();
        for (String s : strings) {
            newMap.put(s.charAt(strings.size()), newMap.getOrDefault(s, 0) + 1);
        }
        return newMap;
    }
}
