package SeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/bank/");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
		try {
			Thread.sleep(500);
			driver.close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
