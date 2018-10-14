package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Utility implements IAutoConst {
	public static String getPropertyValue(String path, String key) {
		String v = "";
		try {
			Properties p = new Properties();
			p.load(new FileInputStream(path));
			v = p.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return v;
	}

	public static void writeToXL(String path, String sheet, int pass, int fail) {
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			wb.getSheet(sheet).getRow(1).getCell(0).setCellValue(pass);
			wb.getSheet(sheet).getRow(1).getCell(1).setCellValue(fail);
			wb.write(new FileOutputStream(path));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getXLData(String path, String sheet, int r, int c) {
		String xlpath ="";
		Workbook wb;
		try {
			wb = WorkbookFactory.create(new FileInputStream(path));
			xlpath = wb.getSheet(sheet).getRow(r).getCell(c).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xlpath;
		}

	public static int getXLRowCount(String path, String sheet) {
		int rowCount = 0;
		Workbook wb;
		try {
			wb = WorkbookFactory.create(new FileInputStream(path));
			rowCount = wb.getSheet(sheet).getLastRowNum();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;

	}

	public static int getXLCellCount(String path, String sheet, int r) {
		int columnCount = 0;
		Workbook wb;
		try {
			wb = WorkbookFactory.create(new FileInputStream(path));
			columnCount = wb.getSheet(sheet).getRow(r).getLastCellNum();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return columnCount;
	}

	public static String getPhoto(WebDriver driver, String folder) {
		Date d = new Date();
		String date = d.toString();
		String dateTime = date.replaceAll(":", "_");
		String path = folder + "/" + dateTime + ".png";
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File(path);
			FileUtils.copyFile(src, dest);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return path;
	}

	public static WebDriver openBrowser(WebDriver driver, String ip, String browser) {
		if (ip.equals("localhost")) {
			if (browser.equals("chrome")) {
				driver = new ChromeDriver();
			} else {
				driver = new FirefoxDriver();
			}
		} else {
			try {
				URL url = new URL("http://" + ip + ":4444/wd/hub");
				DesiredCapabilities dc = new DesiredCapabilities();
				dc.setBrowserName(browser);
				driver = new RemoteWebDriver(url, dc);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return driver;
	}
}
