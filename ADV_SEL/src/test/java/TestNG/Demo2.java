package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo2 {

	@Test
	public void apple() {
		Reporter.log("apple",true);
	}
	@Test
	public void Grapes() {
		Reporter.log("Grapes",true);
	}
	@Test
	public void banana() {
		Reporter.log("banana",true);
	}
	@Test
	public void Pear() {
		Reporter.log("Pear",true);
	}


}
