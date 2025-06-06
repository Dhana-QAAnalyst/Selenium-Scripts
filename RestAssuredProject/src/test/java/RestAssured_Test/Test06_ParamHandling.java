package RestAssured_Test;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test06_ParamHandling extends TestData{
	

	@Test(dataProvider = "DataforPost")
	public void test_01(int year, float price, String CPU, String size, String name){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("year", year);
		map.put("price", price);
		map.put("CPU model",CPU);
		map.put("Hard disk size", size);
		
		JSONObject dataValue = new JSONObject(map);
		
		JSONObject request = new JSONObject();
		request.put("name", name);
		request.put("data", dataValue);
				
		given()
			.header("Content-Type", "application/json")
			.body(request.toJSONString())
		.when()
			.post("https://api.restful-api.dev/objects")
		.then()
			.statusCode(200)
			.log().all();

	}
}
