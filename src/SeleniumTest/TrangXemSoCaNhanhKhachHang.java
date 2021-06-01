package SeleniumTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TrangXemSoCaNhanhKhachHang {

	ChromeDriver driver;
	@Test
	public void Xem_so_tiet_kiem_phat_loc() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("trantiendung101999");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[2]/td[8]/a")).click();
			
			assertEquals("Họ và tên khách hàng: Tran Tien DUng",driver.findElement(By.xpath("/html/body/div/div/div[3]/p[1]")).getText());
			assertEquals("CMTND/CCCD/Hộ chiếu: 111",driver.findElement(By.xpath("/html/body/div/div/div[3]/p[2]")).getText());
			assertEquals("Địa chỉ khách hàng : nam dinh",driver.findElement(By.xpath("/html/body/div/div/div[3]/p[3]")).getText());
			assertEquals("Số điện thoại : 21321412",driver.findElement(By.xpath("/html/body/div/div/div[3]/p[4]")).getText());
			assertEquals("Chi nhánh : Hà Đông,Hà Nội",driver.findElement(By.xpath("/html/body/div/div/div[3]/p[5]")).getText());
			assertEquals("Kiểu tiết kiệm : tiet kiem phat loc",driver.findElement(By.xpath("/html/body/div/div/div[3]/p[6]")).getText());
			assertEquals("Ngày phát hành : 2021-05-30",driver.findElement(By.xpath("/html/body/div/div/div[3]/p[7]")).getText());
			assertEquals("Kỳ hạn : 1 tháng",driver.findElement(By.xpath("/html/body/div/div/div[3]/p[8]")).getText());
			assertEquals("Tính lãi tới hết kỳ hạn",driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button")).getText());

		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	
	@Test
	public void Xem_so_tiet_kiem_thuong() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("trantiendung101999");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[3]/td[8]/a")).click();
			
			assertEquals("Họ và tên khách hàng: Tran Tien DUng",driver.findElement(By.xpath("/html/body/div/div/div[3]/p[1]")).getText());
			assertEquals("CMTND/CCCD/Hộ chiếu: 111",driver.findElement(By.xpath("/html/body/div/div/div[3]/p[2]")).getText());
			assertEquals("Địa chỉ khách hàng : nam dinh",driver.findElement(By.xpath("/html/body/div/div/div[3]/p[3]")).getText());
			assertEquals("Số điện thoại : 21321412",driver.findElement(By.xpath("/html/body/div/div/div[3]/p[4]")).getText());
			assertEquals("Chi nhánh : Hà Đông,Hà Nội",driver.findElement(By.xpath("/html/body/div/div/div[3]/p[5]")).getText());
			assertEquals("Kiểu tiết kiệm : tiet kiem thuong",driver.findElement(By.xpath("/html/body/div/div/div[3]/p[6]")).getText());
			assertEquals("Ngày phát hành : 2021-05-30",driver.findElement(By.xpath("/html/body/div/div/div[3]/p[7]")).getText());
			assertEquals("Kỳ hạn : 1 tháng",driver.findElement(By.xpath("/html/body/div/div/div[3]/p[8]")).getText());
			assertEquals("Tính lãi tới hết kỳ hạn",driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[2]")).getText());
			assertEquals("Tính lãi tới thời điểm hiện tại",driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[1]")).getText());

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
			driver.findElement(By.name("username")).sendKeys("trantiendung101999");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[1]/a")).click();
			assertEquals("http://localhost:8080/bank/checklogin?username=trantiendung101999&password=123456", driver.getCurrentUrl());
		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	@Test
	public void dang_xuat() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("trantiendung101999");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[1]/div[4]/a")).click();
			assertEquals("http://localhost:8080/bank/backtoindex", driver.getCurrentUrl());
		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	
}
