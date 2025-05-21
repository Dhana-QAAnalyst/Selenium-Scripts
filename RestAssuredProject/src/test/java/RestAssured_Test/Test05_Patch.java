package RestAssured_Test;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Test05_Patch {

	@Test
	public void test_01(){
		

		JSONObject request = new JSONObject();
		request.put("name", "Samsung Pro 12 (updated)");
					
		System.out.println(request.toString());
		
		String id = given()
			.header("Content-Type", "application/json")
			.body(request.toJSONString())
		.when()
			.patch("https://api.restful-api.dev/objects/ff80818196f2a23f0196f41a7954056c")
		.then()
			.statusCode(200)
			.log().all()
			.extract()
			.path("id");
		
		System.out.println(id);
	}
}