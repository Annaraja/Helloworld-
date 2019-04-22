package com.employee.elastic.resource;

import java.net.InetAddress;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.elastic.service.SearchQueryBuilder;



@RestController
@RequestMapping("/rest/manual/search")
public class ManualSearchResource {
	
	private  Client client;	
private	SearchQueryBuilder searchQueryBuilder;


@RequestMapping(value="/searchAll",method = RequestMethod.GET)
public String searchAll(){
	
//	Settings settings = Settings.settingsBuilder().put("cluster.name", "elasticsearch1").build();
//    TransportClient transportClient = TransportClient.builder().
//            settings(settings).build().addTransportAddress(
//            new InetSocketTransportAddress(InetAddress.getByName("172.16.2.95"), 9300));
//	
	
	String indexName="";
	
	
	 SearchRequestBuilder searchReq = getClient().prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery());
	return "sadfese";
}

public Client getClient() {
    return client;
}
}
