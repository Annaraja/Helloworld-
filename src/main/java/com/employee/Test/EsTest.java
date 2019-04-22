package com.employee.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.ScrollableHitSource.Hit;
import org.elasticsearch.script.Script;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

public class EsTest {
public static void main(String[] args) throws UnknownHostException{
	Settings settings =Settings.builder().put("cluster.name", "my-application").build();

	TransportClient  client = new PreBuiltTransportClient(settings) .addTransportAddress
			(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
	
	
	String indexname="library";
	
	//Insert and create
	
//	
//	Map<String,Object> dataMap=new HashMap<String,Object>();
//	
//	dataMap.put("title", "Google Chrome");
//	dataMap.put("version", "6");
//	dataMap.put("author", "Google");
//	dataMap.put("publishere", "Sundar");
//	
//	
//	
//	client.prepareIndex(indexname, "Technology", "5").setSource(dataMap).execute().actionGet();
	
	
	// Fetch
	 SearchRequestBuilder searchReq = client.prepareSearch(indexname)
			 .setQuery(QueryBuilders.boolQuery()
					 //.must(QueryBuilders.termQuery("author", "annaraj"))
					 .should(QueryBuilders.termQuery("version", "2"))
					 .should(QueryBuilders.termQuery("title", "java")));
	 SearchResponse searchResponse = searchReq.execute().actionGet();
	 System.out.println(searchResponse);
	 SearchHits searchHits= searchResponse.getHits();
	 List<Object> authors=new ArrayList<Object>();
	 List<Object> titles=new ArrayList<Object>();
	 for(SearchHit hit:searchHits){
		 System.out.println(hit.getSource());
		 authors.add(hit.getSource().get("author"));
		 titles.add(hit.getSource().get("title"));
	 }
	 System.out.println("Hits :" +searchHits.totalHits());
	System.out.println(authors);
	System.out.println(titles);
	SearchRequestBuilder searchReq2 = client.prepareSearch(indexname)
			 .setQuery(QueryBuilders.boolQuery()
					 //.must(QueryBuilders.termQuery("author", "annaraj"))
				//	 .must(QueryBuilders.matchQuery("author", "Annaraj"))
				//	 .must(QueryBuilders.matchPhrasePrefixQuery("publishere", "micro"))
					// .must(QueryBuilders.matchPhrasePrefixQuery("title", "JA"))
					// .must(QueryBuilders.multiMatchQuery("google", "publishere","author"))
					 .must(QueryBuilders.matchPhrasePrefixQuery("author", "a"))
					 .must(QueryBuilders.regexpQuery("version", "1.[0-9]"))
					 );
	
	 SearchResponse searchResponse2 = searchReq2.execute().actionGet();
	 System.out.println(searchResponse2);
	 SearchHits searchHits2= searchResponse2.getHits();
	 List<Object> authors2=new ArrayList<Object>();
	 List<Object> titles2=new ArrayList<Object>();
	 for(SearchHit hit:searchHits2){
		 System.out.println(hit.getSource());
		 authors2.add(hit.getSource().get("author"));
		 titles2.add(hit.getSource().get("title"));
	 }
	 System.out.println("Hits :" +searchHits2.totalHits());
	System.out.println(authors2);
	 System.out.println(titles2);
	 
}
}
