package RestAssured_Test;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Test02_POST {

	@Test
	public void test_01(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("year", 2025);
		map.put("price", 1800.90);
		map.put("CPU model","Intel Core i9");
		map.put("Hard disk size", "1 TB");
		
		JSONObject dataValue = new JSONObject(map);
		
		JSONObject request = new JSONObject();
		request.put("name", "Samsung Pro 19");
		request.put("data", dataValue);
				
		System.out.println(request.toString());
		
		String id = given()
			.header("Content-Type", "application/json")
			.body(request.toJSONString())
		.when()
			.post("https://api.restful-api.dev/objects")
		.then()
			.statusCode(200)
			.extract()
			.path("id");
		
		System.out.println(id);
	}
}
