package RestAssured_Test;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Test04_Put {
	
	@Parameters({"id"})
	@Test
	public void test_01(String id){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("year", 2023);
		map.put("price", 1000.90);
		map.put("CPU model","Intel Core i5");
		map.put("Hard disk size", "2 TB");
		map.put("color", "green");
		
		JSONObject dataValue = new JSONObject(map);
		
		JSONObject request = new JSONObject();
		request.put("name", "Samsung Pro Max 12");
		request.put("data", dataValue);
				
		System.out.println(request.toString());
		
		given()
			.header("Content-Type", "application/json")
			.body(request.toJSONString())
		.when()
			.put("https://api.restful-api.dev/objects/"+id)
		.then()
			.statusCode(200)
			.log().all();

		
		System.out.println(id);
	}
}
