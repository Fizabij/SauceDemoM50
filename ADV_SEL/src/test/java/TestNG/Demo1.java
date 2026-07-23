package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo1 {

	@Test(groups="smoke")
	public void amazon() {
		Reporter.log("amazon",true);
	}
	@Test
	public void baskin() {
		Reporter.log("baskin",true);
	}
	@Test
	public void bigbasket() {
		Reporter.log("bigbasket",true);
	}
	@Test
	public void cricbuzz() {
		Reporter.log("cricbuzz",true);
	}


}
