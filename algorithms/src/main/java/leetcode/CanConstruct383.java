package leetcode;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct383 {

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>(magazine.length());
        for (char c : magazine.toCharArray()) {
            map.put(c , map.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }
            map.put(c, map.get(c) - 1);
            Integer i = map.get(c);
            if (i < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "ab";
        boolean b = canConstruct(ransomNote, magazine);
        System.out.println(b);
    }

}
