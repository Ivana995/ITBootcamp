package Domaci7jun;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Zadatak1 {
//	Napisti TestNg test koji:
//		Ucitava stranicu https://www.udemy.com/
//		U delu za pretragu ukucajte tekst “Selenium” i lupite enter
//		Sortirajte rezultate pretrage prema rejtingu (Highest Rated)
//		Dohvatite rejting prvog rezultata pretrage
//		Dohvatite rejting zadnjeg rezultata pretrage 
//			[HELP] Dohvatite rejting kao listu  pa iz liste izvucite prvi i zadnji element.
//			//*[@data-purpose=\"rating-number\"]
//		Proverite da li je reting prvog veci od rejtinga zadnjeg rezultata
//		pretvaranje stringa u double link ce vam trebati za ovaj zadatak
	@Test
	public static void udemy() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.udemy.com/");
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name = 'q']")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@name = 'q']")).sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		Select sort = new Select(driver.findElement(By.name("sort")));
		sort.selectByVisibleText("Highest Rated");
		Thread.sleep(2000);

		List<WebElement> rating = driver
				.findElements(By.xpath("//span[@class ='udlite-heading-sm star-rating--rating-number--3lVe8']"));

		String last = rating.get(rating.size() - 1).getText();
		String first = rating.get(0).getText();

		double lastElement = Double.parseDouble(last);
		double firstElement = Double.parseDouble(first);
		boolean greaterNumber = false;
		if (Double.compare(lastElement, firstElement) <= 0) {
			greaterNumber = true;
		} else {
			greaterNumber = false;
		}
		Assert.assertTrue(greaterNumber, "The rating is not chronologically ranked");

	}
}
