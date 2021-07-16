package com.example.demo;

import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElasticsearchTestApplication {

	public static void main(String[] args) throws IOException {
		
		SpringApplication.run(ElasticsearchTestApplication.class, args);
		
		String hostname = "172.30.1.29";
		int port = 9200;
		HttpHost host = new HttpHost(hostname, port);
		System.out.println(host);
		RestClientBuilder restClientBuilder = RestClient.builder(host);
		RestHighLevelClient client = new RestHighLevelClient(restClientBuilder);
		
		String index = "gaia";
		String id = "1";
		GetRequest getRequest = new GetRequest(index, id);
		RequestOptions options = RequestOptions.DEFAULT;
		
		GetResponse response = client.get(getRequest, options);
		
		Map<String, Object> map = response.getSourceAsMap();
		System.out.println(map);
		
		client.close();
		
	}

}
