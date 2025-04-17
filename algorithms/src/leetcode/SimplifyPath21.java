package leetcode;

import java.util.Stack;

public class SimplifyPath21 {

    public static String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String pathName : paths) {
            if ("..".equals(pathName)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!pathName.isEmpty() && !".".equals(pathName)){
                stack.push(pathName);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        } else {
            String result = "";
            while (!stack.isEmpty()) {
                result = "/" + stack.pop() + result;
            }
            return result;
        }
    }


    public static void main(String[] args) {
        String path = "/home/user/Documents/../Pictures";
        String s = simplifyPath(path);
        System.out.println(s);

    }
}
