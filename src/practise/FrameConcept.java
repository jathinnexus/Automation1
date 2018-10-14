package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameConcept {
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/jathin/Desktop/page1.html");
		driver.findElement(By.id("t1")).sendKeys("abcd");
		driver.switchTo().frame(0);
		driver.findElement(By.id("t2")).sendKeys("xyz");
		driver.switchTo().parentFrame();
		Thread.sleep(3000);
		driver.findElement(By.id("t1")).clear();
		driver.switchTo().frame("f1");
		driver.findElement(By.id("t2")).clear();
		driver.switchTo().defaultContent();
		WebElement e = driver.findElement(By.xpath("//iframe"));
		driver.switchTo().frame(e);
		Thread.sleep(3000);
		driver.findElement(By.id("t2")).sendKeys("xyz");
		
	}
}
