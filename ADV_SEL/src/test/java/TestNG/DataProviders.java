package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {

	
	@Test(dataProvider = "details" )
	public void login(String un, String pwd) {
		System.out.println(un +"----------"+pwd);
	}
	
	
	
	
	
	
	
	
	@DataProvider
	public Object[][] details() {
		Object[][] obj = new Object[2][2];
		obj [0][0]= "Hi";
		obj [0][1]= "Hi123";
		obj [1][0]= "Hello";
		obj [1][1]= "Hello1234";
		
		return obj;
	}
	
}
