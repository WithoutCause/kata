package me.sjl.netty.container.bio.request;

import java.io.IOException;
import java.io.InputStream;

public class MiniRequest {

    private String method;

    private String url;

    public MiniRequest(InputStream inputStream) {
        // 构造请求对象，1.解析 inputStream 传过来的请求内容
        byte[] buffer = new byte[1024];
        String content = "";
        try {
//            for (int len = 0; len != -1; len = inputStream.read(buffer)) {
//                content = new String(buffer, 0, len);
//            }
            int len;
            if ((len = inputStream.read(buffer)) > 0) {
                content = new String(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("收到的请求内容:" + content);
        // 解析 请求内容
        try {
            String[] headers = content.split("\\n");
            String[] lines = headers[0].split("\\s");
            this.method = lines[0];
            String[] arr = lines[1].split("\\?");
            this.url = arr[0];
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }

}
