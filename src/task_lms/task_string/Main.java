package task_lms.task_string;

public class Main {
    public static void main(String[] args) {

        String word = "Salam";
        String[] wordsArray = {"Java", "kiziktuu", "til"};
        String sentence = "java oozgocho programmaloo tili";

        System.out.println("1. Тескери сөз: " + reverseString(word));
        System.out.println("2. Бириккен сөздөр: " + joinWords(wordsArray));
        System.out.println("3. Үндүү тамгалардын саны: " + countVowels(word));
        System.out.println("4. Палиндромбу?: " + isPalindrome("kok"));
        System.out.println("5. Баш тамгалар: " + capitalizeWords(sentence));
        System.out.println("6. Сөздөрдүн саны: " + countWords(sentence));
        System.out.println("7. ASCII коддор: " + convertToAscii(word));
        System.out.println("8. Боштуксуз сүйлөм: " + removeSpaces(sentence));
    }

    //1. Тескерисинен кылып кайтарган метод
    public static String reverseString(String word) {
        return new StringBuilder(word).reverse().toString();
    }

    //2. Массивдеги сөздөрдү бир сапка бириктирүүчү метод
    public static String joinWords(String[] words) {
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word).append(" ");
        }
        return result.toString().trim();
    }

    //3. Сөздүн ичиндеги үндүү тамгаларды эсептөөчү метод
    public static int countVowels(String word) {
        int count = 0;
        String vowels = "aeiouAEIOUаеёиоуыэюяАЕЁИОУЫЭЮЯ";
        for (char c : word.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    //4. Палиндром экенин текшерүүчү метод
    public static boolean isPalindrome(String word) {
        StringBuilder reversed = new StringBuilder(word).reverse();
        return word.equalsIgnoreCase(reversed.toString());
    }

    //5. Ар бир сөздүн биринчи тамгасын баш тамга кылган метод.
    public static String capitalizeWords(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1)).append(" ");
            }
        }
        return result.toString().trim();
    }

    //6. Сүйлөмдөгү сөздөрдүн санын эсептөөчү метод
    public static int countWords(String sentence) {
        String trimmed = sentence.trim();
        if (trimmed.isEmpty()) {
            return 0;
        }
        return trimmed.split("\\s+").length;
    }

    //7. Ар бир тамганы ASCII кодуна алмаштырган метод
    public static String convertToAscii(String sentence) {
        StringBuilder result = new StringBuilder();
        for (char c : sentence.toCharArray()) {
            result.append((int) c).append(" ");
        }
        return result.toString().trim();
    }

    //8. Бардык пробелдерди алып салуучу метод
    public static String removeSpaces(String sentence) {
        return new StringBuilder(sentence.replaceAll(" ", "")).toString();
    }
}
