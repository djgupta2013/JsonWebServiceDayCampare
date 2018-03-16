package com.dhananjay;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

import bean.DateNTime;

@Path("hello")
public class MainClass {
	DateNTime dateNTime=null;
	Verify verify=null;
	String msg=null;
	
	@Path("data1")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String getJSONdata(String json) {
		
		return msg;
		
	}
	
 
	
	@Path("insert")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String getInsert(String json) {
		verify=new Verify();
		JSONObject JObject = new JSONObject(json);
	    JSONArray result = JObject.getJSONArray("DATE");
	    //System.out.println(result.length());
	    for(int i=0;i<result.length();i++) {

			dateNTime=new DateNTime(result.getJSONObject(i).getString("startMonth"), 
			result.getJSONObject(i).getString("startYear"),result.getJSONObject(i).getString("endMonth"),
			result.getJSONObject(i).getString("endYear"));
	    	
	    	//System.out.println(dateNTime.getStartMonth());
	    		
			msg=verify.getVerify(dateNTime);
	    		
	    		
	    	}
	    if(msg.equals("success"))
	    {
	    	return "{'msg' : 'success'}";
	    }
	    else if(msg.equals("fail"))
	    	return "{'msg' : 'fail'}";
	    else if(msg.equals("Please enter correct month"))
	    	return "Please enter correct month";
	    else {
	    	return "{'msg' : 'fail'}";
	    }
		
	    	
	    			
	    			
	    }
	
}
	
	
	


