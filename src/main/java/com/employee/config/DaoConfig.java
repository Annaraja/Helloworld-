package com.employee.config;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.sql.DataSource;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.employee.dao.EmployeeDao;
import com.employee.dao.EmployeeDaoImpl;


public class DaoConfig {
	
//	@Bean
//	public DataSource dataSource(){
//		DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
//		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/world");
//		driverManagerDataSource.setUsername("root");
//		driverManagerDataSource.setPassword("Annaraj1$");
//		return driverManagerDataSource;
// 	}

	@Autowired
	DataSource dataSource;
	
	@Bean
	public JdbcTemplate jdbcTemplate(){
		return new JdbcTemplate(dataSource);
	}
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
//@Bean
//public RestHighLevelClient restHighLevelClient(){
//	RestHighLevelClient restHighLevelClient= new RestHighLevelClient(
//			   RestClient.builder(
//	                    new HttpHost("localhost", 9200, "http"),
//	                    new HttpHost("localhost", 9201, "http")));
//	return restHighLevelClient;
//}
//	
//	
//	@Autowired
//	private RestHighLevelClient restHighLevelClient;
	
	
	@Bean
    public Client client() throws UnknownHostException {
		Settings settings =Settings.builder().put("cluster.name", "my-application").build();

		TransportClient  client = new PreBuiltTransportClient(settings) .addTransportAddress
				(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        return client;
    }

//    @Bean
//    public ElasticsearchTemplate elasticsearchTemplate() throws UnknownHostException {
//        return new ElasticsearchTemplate(client());
//    }
	
	@Bean
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Bean
	public EmployeeDao employeeDao(){
		return new EmployeeDaoImpl(jdbcTemplate,namedParameterJdbcTemplate) ;
	}
	
	
}
