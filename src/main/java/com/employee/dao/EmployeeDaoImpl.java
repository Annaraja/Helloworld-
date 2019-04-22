package com.employee.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.RequiredArgsConstructor;

import org.apache.http.HttpHost;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.employee.entity.EmployeeEntity;
import com.employee.entity.UserMapper;


@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeDaoImpl implements EmployeeDao {

	private final JdbcTemplate jdbcTemplate;

	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public List<EmployeeEntity> getAll() {
		String SQL = "SELECT * FROM employee";
			List<EmployeeEntity> empEntityList = namedParameterJdbcTemplate.query(
					SQL, new UserMapper());
				return empEntityList;
	}

	public void insertEmployeeData(SqlParameterSource sqlParameterSource,
			EmployeeEntity employeeEntity) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String SQL = "INSERT INTO employee(EMPNAME,EMPNUM,EMPMAIL,EMPCITY,EMPAGE) "
				+ "VALUES ( :empname, :empnum, :empmail, :empcity, :empage)";
		namedParameterJdbcTemplate.update(SQL, sqlParameterSource, keyHolder);
		employeeEntity.setId(keyHolder.getKey().intValue());
		RestClientBuilder rs=RestClient.builder(new HttpHost("localhost", 9200, "http"),new HttpHost("localhost", 9201, "http"));		
//		RestHighLevelClient restHighLevelClient= new RestHighLevelClient(rs.build());
//		 Map<String, Object> dataMap = new HashMap<String, Object>();
//		     dataMap.put("personId", "1003");
//		     dataMap.put("personName", "ajith");
//		IndexRequest indexRequest = new IndexRequest("training", "check", "1002").source(dataMap);
//		 try {
//			         IndexResponse response = restHighLevelClient.index(indexRequest);
////			         Request req=new Request(method, endpoint, parameters, entity)
//			         
//			         
//			     Response reps=    rs.build().performRequest("GET", "http://localhost:9200/training/check/1001");
//			         System.out.println(reps.getEntity());
//			         System.out.println(reps);
//			     } catch(ElasticsearchException e) {
//			         e.getDetailedMessage();
//			     } catch (java.io.IOException ex){
//			         ex.getLocalizedMessage();
//			     }
		
	}
	
}
	
