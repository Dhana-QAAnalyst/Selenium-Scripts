package RestAssured_Test;

	import org.testng.Assert;
	import org.testng.annotations.Test;
	import static io.restassured.RestAssured.*;
	import io.restassured.response.Response;
	import static io.restassured.matcher.RestAssuredMatchers.*;
	import static org.hamcrest.Matchers.*;

	public class Test01_GET {
		
		@Test
		public void test_01 () {
			Response response = get("https://api.restful-api.dev/objects");
			System.out.println(response.asString());
			System.out.println(response.getStatusLine());
			int statusCode = response.getStatusCode();
			Assert.assertEquals(statusCode, 200);
		}
		
		@Test
		public void test_02() {
			given()
				.get("https://api.restful-api.dev/objects")
			.then()
				.statusCode(200)
				.body("id[0]", equalTo("1"))
				.body("name", hasItem("Google Pixel 6 Pro"))
				.log().body();
		}
	}