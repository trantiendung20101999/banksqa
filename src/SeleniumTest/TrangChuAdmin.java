package SeleniumTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TrangChuAdmin {

ChromeDriver driver;
	
	@Test
	public void logout() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[1]/div[4]/a")).click();
			assertEquals("http://localhost:8080/bank/backtoindex",driver.getCurrentUrl());

		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	@Test
	public void chuyen_trang_xem_so_ngan_hang() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			assertEquals("http://localhost:8080/bank/rutsoform?username=admin&password=admin",driver.getCurrentUrl());

		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	@Test
	public void chuyen_trang_mo_so_ngan_hang() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			assertEquals("http://localhost:8080/bank/mosoform?username=admin&password=admin",driver.getCurrentUrl());

		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	
}
