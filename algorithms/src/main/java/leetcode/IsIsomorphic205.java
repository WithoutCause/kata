package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 * 示例 1:
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * 示例 3：
 *
 * 输入：s = "paper", t = "title"
 * 输出：true
 * @author sjl
 */
public class IsIsomorphic205 {

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sCharMap = new HashMap<>();
        Map<Character, Character> tCharMap = new HashMap<>();
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        for (int i = 0; i < sCharArray.length; i++) {
            Character sChar = sCharMap.get(sCharArray[i]);
            Character tChar = tCharMap.get(tCharArray[i]);
            if ((sChar != null && tCharArray[i] != sChar) || (tChar != null && sCharArray[i] != tChar)) {
                return false;
            }
            sCharMap.put(sCharArray[i], tCharArray[i]);
            tCharMap.put(tCharArray[i], sCharArray[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";

        boolean isomorphic = isIsomorphic(s, t);
        System.out.println(isomorphic);
    }

}
