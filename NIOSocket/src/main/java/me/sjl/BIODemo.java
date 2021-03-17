package me.sjl;

import java.io.*;

public class BIODemo {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/sjl/Desktop/bio.txt");
        OutputStream outputStream = new FileOutputStream(file);
        String content = "写入测试内容";
        outputStream.write(content.getBytes());
        outputStream.flush();
        outputStream.close();
    }

}
