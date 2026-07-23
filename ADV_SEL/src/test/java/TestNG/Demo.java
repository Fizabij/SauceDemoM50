package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo {

	@Test(groups="regression")
	public void a10() {
		Reporter.log("a10",true);
	}
	@Test
	public void a11() {
		Reporter.log("a11",true);
	}
	@Test
	public void a9() {
		Reporter.log("a9",true);
	}
	@Test
	public void a2() {
		Reporter.log("a2",true);
	}

}
