package me.sjl.netty.container.bio.response;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.StringJoiner;

public class MiniResponse {

    private final OutputStream outputStream;

    public MiniResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write(String content) {
        // 按照 http 协议规范响应内容
        try {
            outputStream.write(response(content).getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String response(String content) {
        //HTTP/1.1 200 OK
        //Content-Type: text/plain;charset=UTF-8
        StringJoiner sj = new StringJoiner("\n");
        sj.add("HTTP/1.1 200 OK")
                .add("Content-Type: text/plain;charset=UTF-8")
                .add("\r\n")
                .add(content);
        return sj.toString();
    }
}
