package ms3.train.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import ms3.train.objects.Employee;
import ms3.train.objects.Skillset;

// Some functions that connect to the employee API and either get or post stuff.
// Most of this is copied and tweaked from the Trouble Ticket class of the same(ish) name.
public class RESTservices {
	private static OkHttpClient client = new OkHttpClient();
	public String apiEndPoint;
	
	public RESTservices() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RESTservices(String apiEndPoint) {
		super();
		this.apiEndPoint = apiEndPoint;
	}
	
// this returns all of the employees in the api. Used for letting a user select themselves to get the employee id.
	public List<Employee> getAllEmployees(String employeeEndpoint) {
		String employeeListEndPoint = employeeEndpoint+"employees/contact";
		String json = null;
		JSONArray jsonArray = null;
		//JSONObject jsonObject = null;


		try{
			Request req = new Request.Builder().url(employeeListEndPoint).build();
			Response resp = client.newCall(req).execute();
			json = resp.body().string();
		}catch(Exception e){
			System.out.println("error reowireorweiruweioruweoruiweouroiweuroweur");
			e.printStackTrace();
			json = "{}";
		}
		jsonArray = new JSONArray(json);
			List<Employee> employees = new ArrayList<Employee>();
// I made an employee object to save these parameters.
		for (int x = 0; x < jsonArray.length(); x++) {
			JSONObject obj = jsonArray.getJSONObject(x);
			Employee emp = new Employee();
			emp.setFirstName(obj.optString("FIRSTNAME"));
			emp.setLastName(obj.optString("LASTNAME"));
			emp.setEmployeeId(obj.optString("EMPLOYEEID"));
			
			employees.add(emp);
		}
		if (employees.size() > 0) {
			Collections.sort(employees, new Comparator<Employee>() {
				@Override
				public int compare(final Employee object1, final Employee object2) {
					return object1.getFirstName().compareTo(object2.getFirstName());
				}
			});
		}
		return employees;
	}
	
// uses the employee id to associate the skills of a course with that employee. It checks if the skill is already in there for them and does not repeat.
	public String saveSkill(String employeeEndPoint, int employeeId, String skill) {
		String skillsetEndPoint = employeeEndPoint+"employees/skillset/";
		System.out.println("skill end: "+skillsetEndPoint);
//make sure not to repeat any entries
		
		URL url = null;
		String json = "";
		JSONArray jsonArray = null;
		try {
			Request req = new Request.Builder().url(skillsetEndPoint).build();
			Response resp = client.newCall(req).execute();
			json = resp.body().string();
			jsonArray = new JSONArray(json);
			url = new URL(skillsetEndPoint);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
        HttpURLConnection conn;
		try {
			for(int i= 0; i < jsonArray.length(); i++) {
				JSONObject obj = jsonArray.getJSONObject(i);
				if(obj.optString("Skill").equals(skill) && obj.optInt("Employeeid") == employeeId) {
					return "Duplicate Skill Entry";
				}
			}
// check the skillset object in ms3.train.objects if you'd like. it just associates these qualities together.
			Skillset skillset = new Skillset(skill, employeeId);
// this converts the java object to json.
			Gson gsonSkillset = new GsonBuilder().disableHtmlEscaping().create();
			String postBody = gsonSkillset.toJson(skillset)+"\n";
			
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
	        String output;
	        String response = "";

	        OutputStream os = conn.getOutputStream();
	        os.write(postBody.getBytes());
	        os.flush();
	        if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
	           //throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
	        	 BufferedReader br = new BufferedReader(new InputStreamReader((conn.getErrorStream())));
	        	 System.out.println("Error from Server .... \n");
	        	 while ((output = br.readLine()) != null) {
	 	            //System.out.println(output);	
	 	            response +=output;
	 	        }
	        	 conn.disconnect();
	        	 System.out.println("response: " + response);
	        	
	        }
	        else {
	        	//System.out.println("read response: ");
	 	        BufferedReader br = new BufferedReader(new InputStreamReader(
	 	                (conn.getInputStream())));
	 	       
	 	       // System.out.println("Output from Server .... \n");
	 	        while ((output = br.readLine()) != null) {
	 	            //System.out.println(output);
	 	        }
	 	        
	 	       conn.disconnect();
	        }
	        		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Success";
		
	}
}
