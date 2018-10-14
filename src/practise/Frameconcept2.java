package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frameconcept2 {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://jqueryui.com/droppable/");
		WebElement frame = driver.findElement(By.xpath("(//iframe)[1]"));
		driver.switchTo().frame(frame);
		Actions act = new Actions(driver);
		WebElement src = driver.findElement(By.id("draggable"));
		WebElement dest = driver.findElement(By.id("droppable"));
		act.dragAndDrop(src, dest).perform();
		/*Thread.sleep(3000);
		WebElement dest2 = driver.findElement(By.xpath("//html[@lang=\"en\"]"));
		act.dragAndDrop(src, dest2).perform();*/
	}
}
