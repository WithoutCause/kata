package me.sjl;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import okhttp3.*;

import java.io.File;
import java.io.IOException;

public class OKHttpTest {

    static OkHttpClient client = new OkHttpClient.Builder()
//            .addInterceptor(new LogInterceptor())
            .eventListener(new Event())
            .build();


    public static void main(String[] args) throws Exception {

        get();
//        post();

    }

    private static void post() throws IOException {
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(mediaType, "");

        Request request = new Request.Builder()
                .url("http://www.baidu.com")
                .post(requestBody)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
        if (response.isSuccessful()) {
            System.out.println("success");
        }
    }

    private static void get() throws IOException {
        Request request = new Request.Builder()
                .url("http://www.baidu.com")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
        if (response.isSuccessful()) {
            System.out.println("success");
        }
    }

    static class LogInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            long start = System.currentTimeMillis();
            Request request = chain.request();
            Response response = chain.proceed(request);
            long end = System.currentTimeMillis();
            System.out.println("请求花费时间:" + (end - start));
            return response;
        }
    }

    static class Event extends EventListener {

        @Override
        public void callStart(Call call) {
            System.out.println("call start .........");
        }
    }

}
