package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@Listeners(Result.class)
public abstract class BaseTest implements IAutoConst {
	public WebDriver driver;// only public not static to run with all browsers
	public String url = Utility.getPropertyValue(CONFIG_PATH, "URL");
	String duration = Utility.getPropertyValue(CONFIG_PATH, "ITO");
	public long ITO = Long.parseLong(duration);
	static {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}

	@Parameters({ "ip", "browser" })
	@BeforeMethod(alwaysRun = true)
	public void openApplication(@Optional("localhost")String ip, @Optional("chrome")String browser) {
		driver = Utility.openBrowser(driver, ip, browser);
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		driver.get(url);
		
	}

	@AfterMethod(alwaysRun = true)
	public void closeApplication(ITestResult result) {
		String name = result.getName();
		int status = result.getStatus();
		if (status == 2) {
			Utility.getPhoto(driver, PHOTO_PATH);
			Reporter.log("Test:" + name + "  is failed", true);
		} else {
			Reporter.log("Test:" + name + "  is passed", true);
		}
		driver.close();
	}
}
