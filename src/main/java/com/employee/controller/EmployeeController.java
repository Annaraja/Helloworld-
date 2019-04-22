package com.employee.controller;

import java.util.HashMap;
import java.util.List;












import java.util.Map;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.employee.elastic.service.SearchQueryBuilder;
import com.employee.entity.EmployeeEntity;
import com.employee.service.EmployeeService;
import com.employee.validator.EmployeeValidator;


@Controller
@RequestMapping("/employee")
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeValidator employeeValidator;
	
	
	@Autowired
	private  Client client;
//	private  Client client;	
//	
	public Client getClient() {
	    return client;
	}
	private	SearchQueryBuilder searchQueryBuilder;
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(employeeValidator);
	}
	
	@RequestMapping(value="/searchAll",method = RequestMethod.GET)
	public String searchAll(){
		
//		Settings settings = Settings.settingsBuilder().put("cluster.name", "elasticsearch1").build();
//	    TransportClient transportClient = TransportClient.builder().
//	            settings(settings).build().addTransportAddress(
//	            new InetSocketTransportAddress(InetAddress.getByName("172.16.2.95"), 9300));
	//	
		
		
		
		
		
		
		String indexName="library";
		Map<String,Object> dataMap=new HashMap<String,Object>();
		
		dataMap.put("title", "Angular");
		dataMap.put("version", "2");
		dataMap.put("author", "Annaraj kanister");
		dataMap.put("publishere", "Google");
		
		
		
		getClient().prepareIndex(indexName, "Technology", "3").setSource(dataMap).execute().actionGet();
		
//		getClient().prepareDelete(indexName,"check","1002").execute().actionGet();
		
//		 SearchRequestBuilder searchReq = getClient().prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery());
//		 SearchResponse searchResponse = searchReq.execute().actionGet();
//		 SearchHits searchHits= searchResponse.getHits();
//		 System.out.println("Hits :" +searchHits.totalHits);
	//	 System.out.println("Hits :" +searchResponse.);
		return "";
	}
	
	
	
	
	@RequestMapping(value="/getAllEmployee",method = RequestMethod.GET)
	public String getAllEmployee(Model model){
		List<EmployeeEntity> empEntities=employeeService.getAll();
		model.addAttribute("employeeList",empEntities);
		return "users/list";
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model){
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setEmpnumber("9474251454");
		employeeEntity.setEmpname("gaja");
		employeeEntity.setEmpmail("@gmail.com");
		employeeEntity.setEmpcity("tvn");
//		employeeEntity.setEmpage(25);
		model.addAttribute("employeeDetail",employeeEntity);
		return "users/addEmployee";
		
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String insert(@ModelAttribute("employeeDetail") @Validated EmployeeEntity employeeEntity, BindingResult rslt,Model model){
		if(rslt.hasErrors()){
			return "users/addEmployee";
		}
		else{
		employeeService.insertEmployeeData(employeeEntity);
		List<EmployeeEntity> empEntities=employeeService.getAll();
		model.addAttribute("employeeList",empEntities);
		return "users/list";
		}
	}
}
