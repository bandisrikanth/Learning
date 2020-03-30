package seleniumgrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class seleniumgrid {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		WebDriver driver;
        
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setBrowserName("chrome");
        capability.setPlatform(Platform.WINDOWS);
        driver = new RemoteWebDriver(new URL("http://192.168.43.144:4455/wd/hub"), capability);
        	driver.get("http://automationpractice.com/index.php");
        	driver.manage().window().maximize();
    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    		driver.manage().window().maximize();
    		driver.findElement(By.xpath("//a[@class=\"login\"]")).click();

    		driver.findElement(By.cssSelector("#email_create")).sendKeys("srikanddddtd@gmail.com");
    		driver.findElement(By.xpath("//i[@class=\"icon-user left\"]")).click();

    		// create an account

    		driver.findElement(By.cssSelector("#id_gender1")).click();
    		driver.findElement(By.cssSelector("#customer_firstname")).sendKeys("srikanth");
    		driver.findElement(By.cssSelector("#customer_lastname")).sendKeys("bandi");
    		driver.findElement(By.cssSelector("#passwd")).sendKeys("srikanth123");
    		driver.findElement(By.cssSelector("#address1")).sendKeys("srikanth123");
    		driver.findElement(By.cssSelector("#address2")).sendKeys("srikanth1");
    		driver.findElement(By.cssSelector("#city")).sendKeys("srikanth123");

    		Select sState = new Select(driver.findElement(By.xpath("//*[@id='id_state']")));
    		sState.selectByVisibleText("Alabama");

    		driver.findElement(By.xpath("//*[@id='postcode']")).sendKeys("12345");

    		Select sCountry = new Select(driver.findElement(By.xpath("//*[@id='id_country']")));
    		sCountry.selectByVisibleText("United States");
    		driver.findElement(By.xpath("//*[@id='other']")).sendKeys("any other info");
    		driver.findElement(By.xpath("//*[@id='phone']")).sendKeys("123457876");
    		driver.findElement(By.xpath("//*[@id='phone_mobile']")).sendKeys("868768768768");
    		driver.findElement(By.xpath("//*[@id='alias']")).sendKeys("alias");

    		driver.findElement(By.xpath("//*[text()='Register']")).click();

    		String verifingacoount = driver.findElement(By.xpath("//h1[@class=\"page-heading\"]")).getText();

    		System.out.println(verifingacoount);
    		if (verifingacoount.equals("MY ACCOUNT")) {
    			System.out.println("Account got created sucessfully ");
    		} else {
    			System.out.println("Account not created sucessfully ");
    		}

    		driver.quit();
    		

        		
	}

}
