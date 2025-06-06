package RestAssured_Test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Test03_DELETE {
	
	@Test
	public void Test_01(String id) {
		
		when()
			.delete("https://api.restful-api.dev/objects/6")
		.then()
			.statusCode(204)
			.log().all();
	}
}