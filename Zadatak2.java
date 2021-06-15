package Domaci04_06;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		
		List <WebElement> links = driver.findElementsByXPath("//*[@class=\"central-featured\"]/div/a");
		for(int i=0;i<links.size();i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.open(arguments[0])", links.get(i).getAttribute("href"));
		}
		
		driver.close();

	}

}
