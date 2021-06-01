package SeleniumTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TrangXemSoTietKiemAD {

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
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[1]/div[4]/a")).click();
			assertEquals("http://localhost:8080/bank/backtoindex",driver.getCurrentUrl());

		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	@Test
	public void quay_lai_trang_chu() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[1]/a")).click();
			assertEquals("http://localhost:8080/bank/checklogin?username=admin&password=admin",driver.getCurrentUrl());

		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	@Test
	public void quay_lai_trang_mo_so() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			assertEquals("http://localhost:8080/bank/mosoform?username=admin&password=admin",driver.getCurrentUrl());

		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	
	@Test
	public void timkiem_so_khong_ton_tai() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.name("bookid")).sendKeys("100");
			driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
			assertEquals("Không có mã sổ tiết kiệm phù hợp", driver.findElement(By.xpath("/html/body/div/div/div[3]")).getText());


		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	@Test
	public void timkiem_so_da_rut() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.name("bookid")).sendKeys("49");
			driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
			assertEquals("Sổ đã được rút", driver.findElement(By.xpath("/html/body/div/div/div[3]")).getText());


		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	@Test
	public void timkiem_so_hop_le() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.name("bookid")).sendKeys("53");
			driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
			assertEquals("http://localhost:8080/bank/timkiemso?username=admin&password=admin&bookid=53", driver.getCurrentUrl());


		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	
}
