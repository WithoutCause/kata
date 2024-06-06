package me.sjl.proxy.jdk;


public class Main {

    public static void main(String[] args) {
        ClientFactory clientFactory = ClientFactory.builder()
                .build();
        RestClient restClient = clientFactory.create(RestClient.class);
        String result = restClient.execute();
        System.out.println(result);
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        String req = restClient.req();
        System.out.println(req);
    }

}

