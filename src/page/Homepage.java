package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	@FindBy(id="logoutlink")
	private WebElement clickLogout;
	
public  Homepage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public void logout() {
	clickLogout.click();
}}
