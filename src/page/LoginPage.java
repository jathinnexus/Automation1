package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(id = "txtUsername")
	private WebElement unTB;

	@FindBy(id = "txtPassword")
	private WebElement pwTB;

	@FindBy(id = "btnLogin")
	private WebElement clickLogin;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setUserName(String username) {
		unTB.sendKeys(username);
	}

	public void setPassword(String password) {
		pwTB.sendKeys(password);
	}

	public void clickLogin() {
		clickLogin.click();
	}
}
