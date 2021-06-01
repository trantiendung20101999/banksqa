package SeleniumTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TrangChuKhachHang {

	
	
	ChromeDriver driver;
	
	@Test
	public void logout() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("acx");
			driver.findElement(By.name("password")).sendKeys("123456");
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
	public void Xem_so_ca_nhan_ton_tai() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("acx");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			
			assertEquals("78",driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr/td[1]")).getText());
			assertEquals("Trần tiên dũng",driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr/td[2]")).getText());
			assertEquals("1.0E8",driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr/td[3]")).getText());
			assertEquals("Hà Đông,Hà Nội",driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr/td[4]")).getText());
			assertEquals("tiet kiem thuong",driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr/td[5]")).getText());
			assertEquals("1",driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr/td[6]")).getText());
			assertEquals("2021-05-30",driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr/td[7]")).getText());
			assertEquals("Xem Sổ",driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr/td[8]")).getText());

			assertEquals("93",driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[2]/td[1]")).getText());
			assertEquals("Trần tiên dũng",driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[2]/td[2]")).getText());
			assertEquals("1.0E7",driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[2]/td[3]")).getText());
			assertEquals("Hà Đông,Hà Nội",driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[2]/td[4]")).getText());
			assertEquals("tiet kiem thuong",driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[2]/td[5]")).getText());
			assertEquals("1",driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[2]/td[6]")).getText());
			assertEquals("2021-06-01",driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[2]/td[7]")).getText());
			assertEquals("Sổ đã rút",driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[2]/td[8]")).getText());
			

		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	
	@Test
	public void Xem_so_ca_nhan_khong_ton_tai() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("0868381642");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			
			assertEquals("Bạn chưa mở sổ tiết kiệm hãy ra các chi nhánh ngân hàng để mở sổ",driver.findElement(By.xpath("/html/body/div/div/div[2]/div/h3")).getText());
		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	
}
