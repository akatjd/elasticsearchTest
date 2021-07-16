package com.example.demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.Strings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElasticsearchTestApplication {

	public static void main(String[] args) throws IOException {
		
//		SpringApplication.run(ElasticsearchTestApplication.class, args);
//		
//		String hostname = "172.30.1.29";
//		int port = 9200;
//		HttpHost host = new HttpHost(hostname, port);
//		System.out.println(host);
//		RestClientBuilder restClientBuilder = RestClient.builder(host);
//		RestHighLevelClient client = new RestHighLevelClient(restClientBuilder);
//		
//		String index = "gaia";
//		String id = "1";
//		GetRequest getRequest = new GetRequest(index, id);
//		RequestOptions options = RequestOptions.DEFAULT;
//		
//		GetResponse response = client.get(getRequest, options);
//		
//		Map<String, Object> map = response.getSourceAsMap();
//		System.out.println(map);
//		
//		client.close();
		
//		// ElasticUtil 써서 get 해보기
//		String index = "gaia";
//		String id = "1";
//		
//		ElasticUtil elastic = ElasticUtil.getInstance();
//		
//		Map<String, Object> map = elastic.getReponse(index, id);
//		
//		System.out.println(map);
		
		String index = "gaia";
		String id = "1";
		
		ElasticUtil elastic = ElasticUtil.getInstance();
		
		Map<String, Object> map = new HashMap<>();
		map.put("새로운 항목", 155);
		map.put("test", 153);
		XContentBuilder xContent = XContentFactory.jsonBuilder().map(map);
		String jsonBody = Strings.toString(xContent);
		
		IndexResponse response = elastic.create(index, id, jsonBody);
		
		System.out.println(response);
		
	}

}
