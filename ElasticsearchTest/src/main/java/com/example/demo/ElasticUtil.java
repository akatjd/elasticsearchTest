package com.example.demo;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;
import java.util.Properties;

import org.apache.http.HttpHost;
import org.apache.ibatis.io.Resources;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

public class ElasticUtil {
	
	private static ElasticUtil self;
	private static RestHighLevelClient client;
	
	private ElasticUtil() throws IOException {
		
        Properties properties = new Properties();
        Reader reader = Resources.getResourceAsReader("el.properties");
        properties.load(reader);
        String hostname = properties.getProperty("el.url");
        int port = Integer.parseInt(properties.getProperty("el.port"));
        HttpHost host = new HttpHost(hostname, port);
        RestClientBuilder restClientBuilder = RestClient.builder(host);
        client = new RestHighLevelClient(restClientBuilder);
        
	}
	
	public static ElasticUtil getInstance() throws IOException {
		
		if(self == null)
			self = new ElasticUtil();
		return self;
		
	}
	
	public Map<String,Object> getReponse(String index, String id) {
		
		GetResponse response = null; 
		
		GetRequest getRequest = new GetRequest(index, id);
		RequestOptions options = RequestOptions.DEFAULT;
		try {
		response = client.get(getRequest, options);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return response.getSourceAsMap();
		
	}
	
	public IndexResponse create(String index, String id, String jsonBody) {
		
		IndexResponse response = null;
		
		IndexRequest indexRequest = new IndexRequest(index).id(id).source(jsonBody, XContentType.JSON);
		
		try {
			response = client.index(indexRequest, RequestOptions.DEFAULT);
		} catch(IOException e) {
			e.printStackTrace();
		}
		return response;
		
	}
	
}
