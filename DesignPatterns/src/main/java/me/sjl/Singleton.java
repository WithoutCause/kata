package me.sjl;

public class Singleton {

    private static User user = new User();

    public static User getUser() {
        return user;
    }

//    private static User user;
//
//    public static User getUser() {
//        if (user == null) {
//            user = new User();
//        }
//        return user;
//    }

}
