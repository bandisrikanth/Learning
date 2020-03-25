package testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class multibtest {

	@Test
	public void executSessionOne() {

		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@class=\"login\"]")).click();

		driver.findElement(By.cssSelector("#email_create")).sendKeys("srikanddtd@gmail.com");
		driver.close();
	}

	@Test
	public void executeSessionTwo() {
		// Second session of WebDriver
		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@class=\"login\"]")).click();

		driver.findElement(By.cssSelector("#email_create")).sendKeys("srikanddtd@gmail.com");
		driver.close();

	}

	@Test
	public void executSessionThree() {
		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@class=\"login\"]")).click();

		driver.findElement(By.cssSelector("#email_create")).sendKeys("srikanddtd@gmail.com");
		driver.close();

	}
}
