package me.sjl;

import java.nio.ByteBuffer;

public class Main {

    public static void main(String[] args) {
        byte[] bytes = new byte[]{1, 2, 3};
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());
    }

}
