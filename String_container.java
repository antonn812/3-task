import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class String_container {
    private ArrayList<String> strings = new ArrayList<>();


    public void addString(String str) {
        strings.add(str);
        Collections.sort(strings, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
    }

    public String getMaxLengthString() {
        if (strings.isEmpty()) throw new RuntimeException("список пустой");
        return strings.get(strings.size() - 1);
    }

    public double getAverageLength() {
        if (strings.isEmpty()) throw new RuntimeException("список пустой");
        return strings.stream().mapToInt(String::length).average().orElse(0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String_container stringArray = new String_container();
        
        System.out.println("Ввод строк (чтобы закончить ввод писать - stop):");
        
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("stop")) {
                break;
            }
            stringArray.addString(input);
        }

        System.out.println("Максимальная строка: " + stringArray.getMaxLengthString());
        System.out.println("Средняя длина строк: " + stringArray.getAverageLength());
    }
}

