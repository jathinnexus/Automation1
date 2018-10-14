package script;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import page.LoginPage;

public class TestCMS extends BaseTest {
	@Test
	public void testA() {
		Reporter.log("testA",true);
	}
      @Test
      public void TestLogin() {
    	  LoginPage  l=new LoginPage(driver);
    	  l.setUserName("admin");
    	  l.setPassword("admin123");
    	  l.clickLogin();
      }
    	  
      }

