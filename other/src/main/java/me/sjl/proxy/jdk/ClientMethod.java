package me.sjl.proxy.jdk;

import me.sjl.proxy.jdk.annotation.Rest;
import okhttp3.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class ClientMethod {

    private static final OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

    public String execute(Method method, Object[] args) {
        Rest restAnnotation = method.getAnnotation(Rest.class);
        if (restAnnotation == null) {
            return "error";
        }

        try {
            return request(restAnnotation);
        } catch (IOException e) {
            return "error";
        }
    }

    private String request(Rest restAnnotation) throws IOException {
        Request request = new Request.Builder()
                .url(restAnnotation.value())
                .method(restAnnotation.method(), null)
                .build();
        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();
    }

}
