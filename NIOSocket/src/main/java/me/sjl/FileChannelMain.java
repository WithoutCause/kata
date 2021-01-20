package me.sjl;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelMain {

    @Test
    public void writeTest() throws IOException {
        String filePath = "/Users/sjl/Desktop";
        FileOutputStream fs = new FileOutputStream(new File(filePath, "a.txt"));
        FileChannel channel = fs.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.wrap("abcdefg".getBytes());
        channel.write(byteBuffer);
    }

    @Test
    public void writeThreadTest() throws IOException {
        String filePath = "/Users/sjl/Desktop";
        FileOutputStream fs = new FileOutputStream(new File(filePath, "a_b.txt"));
        FileChannel channel = fs.getChannel();
        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread() {
                @Override
                public void run() {
                    ByteBuffer byteBuffer = ByteBuffer.wrap("abcdefg\n".getBytes());
                    try {
                        channel.write(byteBuffer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };

            Thread t2 = new Thread() {
                @Override
                public void run() {
                    ByteBuffer byteBuffer = ByteBuffer.wrap("123456789\n".getBytes());
                    try {
                        channel.write(byteBuffer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };

            t1.start();
            t2.start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        channel.close();
        fs.close();

    }

}
