import java.util.*;

class User {
    private final String name;
    private final String email;
    private final int age;

    public User(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Main_Refactored {
    public static boolean task1(boolean darkModeSelected) {
        return !darkModeSelected;
    }

    public static User task2(Map<Integer, String> inpList) {
        String cName = inpList.getOrDefault(0, "").replace(",", ".");
        String cEmail = inpList.getOrDefault(1, "").replace(",", ".");
        String cAge = inpList.getOrDefault(4, "").replace(",", ".");
        return new User(cName, cEmail, Integer.parseInt(cAge));
    }

    public static List<Integer> task3(List<String> results) {
        List<Integer> arr = new ArrayList<>();
        for (String res : results) {
            int number = parseNumber(res);
            if (number != -1) {
                arr.add(number);
            }
        }
        return arr;
    }
    
    private static int parseNumber(String res) {
        String[] numberWords = {"one", "two", "three"};
        String[] numberSymbols = {"１", "２", "３", "一", "二", "三", "일", "이", "삼"};
        for (int i = 0; i < numberWords.length; i++) {
            if (res.matches("(?i).*" + numberWords[i] + ".*") || res.matches(".*" + numberSymbols[i] + ".*")) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(task1(true));
        System.out.println(task1(false));
        System.out.println(task3(Arrays.asList("one", "two", "three")));
        System.out.println(task3(Arrays.asList("일", "1", "一")));
        Map<Integer, String> data = new HashMap<>();
        data.put(0,"Oles");
        data.put(4, "31");
        data.put(1, "dobosevych@ucu.edu.ua");
        data.put(3, "1991-03-14");
        data.put(5, "UCU");
        System.out.println(task2(data));
    }
}