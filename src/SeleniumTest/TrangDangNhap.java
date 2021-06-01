package SeleniumTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TrangDangNhap {

	
	ChromeDriver driver;
	
	@Test
	public void login_cus() throws InterruptedException
	{
		try {
		System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/bank/");
		driver.findElement(By.name("username")).sendKeys("trantiendung101999");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
		}
		finally {
			Thread.sleep(2000);
			driver.close();
		}
	}
	@Test
	public void login_ad() throws InterruptedException
	{
		try {
		System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/bank/");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
		}
		finally {
			Thread.sleep(2000);
			driver.close();
		}
	}
	
	@Test
	public void login_account_not_exist() throws InterruptedException
	{
		try {
		System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/bank/");
		driver.findElement(By.name("username")).sendKeys("trantiendung1019992");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
		assertEquals("Tài khoản không tồn tại", driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/div")).getText());
		}
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	@Test
	public void login_password_wrong() throws InterruptedException
	{
		try {
		System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/bank/");
		driver.findElement(By.name("username")).sendKeys("trantiendung101999");
		driver.findElement(By.name("password")).sendKeys("1234562");
		driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
		assertEquals("Mật khẩu không chính xác", driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/div")).getText());
		}
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	
	@Test
	public void register() throws InterruptedException
	{
		try {
		System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/bank/");
		driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click();
		assertEquals("http://localhost:8080/bank/dangkyform",driver.getCurrentUrl());
		}
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	
}
