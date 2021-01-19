package me.sjl.es.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Slf4j
@Service
public class EsService {

    private RestHighLevelClient restClient;

    @PostConstruct
    public void init() {
        restClient = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http")
                )
        );
    }

    public void close() {
        try {
            restClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createIndexByString() {
        IndexRequest request = new IndexRequest("index_01_sjl_by_string");
        request.id("doc_01_sjl_by_string");
        String json = "{\n" +
                "    \"name\":\"sjl\",\n" +
                "    \"age\":26,\n" +
                "    \"type\":\"by String\"\n" +
                "}";
        request.source(json, XContentType.JSON);
        try {
            restClient.index(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getIndex() {
        GetRequest getRequest = new GetRequest("index_01_sjl_by_string", "doc_01_sjl_by_string");
        System.out.println(getRequest);
        try {
            GetResponse response = restClient.get(getRequest, RequestOptions.DEFAULT);
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void delIndex() {
        DeleteRequest request = new DeleteRequest("index_01_sjl_by_string", "doc_01_sjl_by_string");
        try {
            restClient.delete(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
