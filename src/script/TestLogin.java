package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import page.Homepage;
import page.LoginPage;

public class TestLogin  extends BaseTest{
	@	Test(priority=1, groups= {"login","smoke"})
	public void login()
	{
		LoginPage p=new LoginPage(driver);
		String sheet="TestLogin";
	   String un=Utility.getXLData(INPUT_PATH,sheet ,1,0);
		p.setUserName(un);
		
		String pw=Utility.getXLData(INPUT_PATH, sheet,1,1);
		p.setPassword(pw);
		p.clickLogin();
		Homepage homepage=new Homepage(driver);
		homepage.logout();
	}}
		
