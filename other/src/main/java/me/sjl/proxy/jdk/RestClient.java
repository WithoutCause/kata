package me.sjl.proxy.jdk;

import me.sjl.proxy.jdk.annotation.Rest;

public interface RestClient {

    @Rest("https://baidu.com")
    String execute();

    @Rest("https://spring.io")
    String req();

}
