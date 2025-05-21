package RestAssured_Test;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Test04_Put {

	@Test
	public void test_01(){
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
		
		String id = given()
			.header("Content-Type", "application/json")
			.body(request.toJSONString())
		.when()
			.put("https://api.restful-api.dev/objects/ff80818196f2a23f0196f41a7954056c")
		.then()
			.statusCode(200)
			.log().all()
			.extract()
			.path("id");
		
		System.out.println(id);
	}
}
