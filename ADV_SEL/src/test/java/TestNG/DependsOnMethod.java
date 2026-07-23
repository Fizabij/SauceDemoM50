package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DependsOnMethod {

	@Test
	public void createAcc() {
		Reporter.log("created acc", true);
	}

	@Test(dependsOnMethods = "createAcc")
	public void editAcc() {
		Reporter.log("edited acc", true);
	}
	
	@Test(dependsOnMethods = {"editAcc", "createAcc"})
	public void deletedAcc() {
		Reporter.log("created acc", true);
	}
}
