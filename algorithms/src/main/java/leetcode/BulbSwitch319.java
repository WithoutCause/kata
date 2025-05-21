package leetcode;

public class BulbSwitch319 {

    public static int bulbSwitch(int n) {
        return (int) Math.sqrt(n + 0.5);
    }

    public static void main(String[] args) {
        int n = 3;
        int res = bulbSwitch(n);
        System.out.println(res);
    }

}
