package RestAssuredFramework.RestAssuredFramework;

import static org.testng.Assert.assertEquals;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class RestAPI {
	
	@Test
	void getweatherDetails()
	{
		
		//specify base URI
		RestAssured.baseURI="http://api.openweathermap.org";
		
		//Request Object
		RequestSpecification httprequest= RestAssured.given();
		
		//Response object
		Response response= httprequest.request(Method.GET,"/data/2.5/forecast?id=6619279&cnt=100&units=metric&APPID=f9140f2c8c3f6290ab01e000866710f8");
		
		//print response in console
		
		String responseBody= response.getBody().asString();
		System.out.println("Response Body is:" +responseBody);
		
		//status code validation
		int statuscode=response.getStatusCode();
		System.out.println("status code is:"+statuscode);
		Assert.assertEquals(statuscode, 200);
		
		//status line verification
		String statusline=response.getStatusLine();
		System.out.println("status line is:"+statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		
		Assert.assertEquals(responseBody.contains("2019-09-19 03:00:00"),true);
		Assert.assertEquals(responseBody.contains("City of Sydney"),true);
		//Assert.assertEquals(responseBody.contains("13.29"),true);
		
				
		JsonPath jsonpath= response.jsonPath();
		
		
		System.out.println(jsonpath.get("cod"));
		System.out.println(jsonpath.get("$.city//name"));
		System.out.println(jsonpath.get("dt_txt"));
		
		//Assert.assertEquals(jsonpath.get("name"), "200");
		
		
		
		
		
		
		//String t = ((Object) requestParams).getJSONObject("main").getString("temp");

		
		//Message
		int temp = 0;
		if(temp >= 5)
		{
			
			System.out.println("The temp is warmer and is more than 10 deg:" + temp);
			//System.out.println(temp);
		}
	}

}
