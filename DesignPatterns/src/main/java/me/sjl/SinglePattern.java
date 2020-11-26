package me.sjl;

public class SinglePattern {


    public static void main(String[] args) {
        // 每次需要使用 user 的时候，就去创建一个对象
        User user = new User();

        // 每次需要使用 user 的时候，去获取一个 user 对象
        User user1 = Singleton.getUser();
        System.out.println(user == user1);

        User user2 = Singleton.getUser();
        System.out.println(user1 == user2);
    }


}
