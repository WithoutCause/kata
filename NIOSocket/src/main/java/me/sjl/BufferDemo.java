package me.sjl;

import java.nio.Buffer;
import java.nio.CharBuffer;

public class BufferDemo {

    public static void main(String[] args) {
        String content = "床前明月光";
        Buffer buffer = CharBuffer.wrap(content.toCharArray());
        buffer.position(1);
        buffer.limit(3);
        System.out.println(buffer.toString());

        buffer.mark();

    }
}
