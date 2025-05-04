package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstUnicodeChar387 {

    public static int firstUnicodeCharV2(String s) {
        Map<Character, Long> charMap1 = s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        for (int i = 0; i < s.length(); i++) {
            if (charMap1.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static int firstUnicodeChar(String s) {
        Map<Character, Integer> charMap = new HashMap<>(s.length());

        for (char c : s.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (charMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "aabb";
        int i = firstUnicodeChar(s);
        System.out.println(i);
    }

}
