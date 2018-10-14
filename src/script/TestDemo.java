package script;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import generic.BaseTest;

public class TestDemo extends BaseTest {
	@Test
	public void TestA() {
		Reporter.log("Testing A",true);
	}
	@Test
	public void TestB() {
		Reporter.log("Testing B",true);
		Assert.fail();
	}}
