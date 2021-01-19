package me.sjl;

import okhttp3.*;
import okio.BufferedSource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AsyncOkHttpTest {

    private static OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

    public static void main(String[] args) throws IOException {

        List<String> result = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            Request request = new Request.Builder()
                    .url("http://baidu.com")
                    .get()
                    .build();
            Response response = okHttpClient.newCall(request).execute();
            result.add(response.body().string());

            BufferedSource source = response.body().source();
            String s = source.toString();
            System.out.println(s);
        }

        System.out.println(result.size());

    }

}
