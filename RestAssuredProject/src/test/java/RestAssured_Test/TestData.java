package RestAssured_Test;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name = "DataforPost")
	public Object[][] paramPost(){
		return new Object[][] {
			{2030, 3000, "Fast CPU", "5 TB", "Apple 20"},
			{2040, 2000, "Fastest CPU", "3 TB", "Apple 24"},
		};
	}

}
