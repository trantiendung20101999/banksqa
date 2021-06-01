package SeleniumTest;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import controller.ConnectDB;

public class TrangXemChiTietSoAD {

	ChromeDriver driver;
	
	@Test
	public void dangxuat() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.name("bookid")).sendKeys("55");
			driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
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
			driver.findElement(By.name("bookid")).sendKeys("55");
			driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
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
			driver.findElement(By.name("bookid")).sendKeys("55");
			driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			assertEquals("http://localhost:8080/bank/mosoform?username=admin&password=admin",driver.getCurrentUrl());

		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	@Test
	public void quay_lai_trang_xem_so() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.name("bookid")).sendKeys("55");
			driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			assertEquals("http://localhost:8080/bank/rutsoform?username=admin&password=admin",driver.getCurrentUrl());

		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	@Test
	public void rut_so() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.name("bookid")).sendKeys("55");
			driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[1]")).click();
			assertEquals("Rút sổ thành công",driver.findElement(By.xpath("/html/body/div/div/div[3]")).getText());

		}
		
		finally {
			String RUT_SO_SQL="UPDATE BankSavingBooks SET checkk=0 WHERE ID=?";
			Connection con = ConnectDB.connection();
			PreparedStatement pre;
			try {
				pre = con.prepareStatement(RUT_SO_SQL);
				pre.setInt(1, 55);
				pre.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			Thread.sleep(2000);
			driver.close();
		}

	}
	
	@Test
	public void tinhlai_truockyhan() throws InterruptedException
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
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[2]")).click();
			assertEquals("Tiền lãi tới thời điểm hiện tại : 12739", driver.findElement(By.xpath("/html/body/div/div/div[3]/p[9]")).getText());
		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	@Test
	public void tinhlai_saukyhan() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.name("bookid")).sendKeys("54");
			driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[2]")).click();
			assertEquals("Tiền lãi tới thời điểm hiện tại : 42074", driver.findElement(By.xpath("/html/body/div/div/div[3]/p[9]")).getText());
		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	
	@Test
	public void tinhlai_dungkyhan_tkthuong_1thang() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.name("bookid")).sendKeys("51");
			driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[3]")).click();
			assertEquals("Tiền lãi tới hết định kỳ: 209589", driver.findElement(By.xpath("/html/body/div/div/div[3]/p[9]")).getText());
		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	
	@Test
	public void tinhlai_dungkyhan_tkthuong_2thang() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.name("bookid")).sendKeys("54");
			driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[3]")).click();
			assertEquals("Tiền lãi tới hết định kỳ: 41917", driver.findElement(By.xpath("/html/body/div/div/div[3]/p[9]")).getText());
		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	@Test
	public void tinhlai_dungkyhan_tkthuong_3thang() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.name("bookid")).sendKeys("55");
			driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[3]")).click();
			assertEquals("Tiền lãi tới hết định kỳ: 70274", driver.findElement(By.xpath("/html/body/div/div/div[3]/p[9]")).getText());
		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	@Test
	public void tinhlai_dungkyhan_tkthuong_4thang() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.name("bookid")).sendKeys("56");
			driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[3]")).click();
			assertEquals("Tiền lãi tới hết định kỳ: 93698", driver.findElement(By.xpath("/html/body/div/div/div[3]/p[9]")).getText());
		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	@Test
	public void tinhlai_dungkyhan_tkthuong_5thang() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.name("bookid")).sendKeys("57");
			driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[3]")).click();
			assertEquals("Tiền lãi tới hết định kỳ: 117123", driver.findElement(By.xpath("/html/body/div/div/div[3]/p[9]")).getText());
		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	@Test
	public void tinhlai_dungkyhan_tkthuong_6thang() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.name("bookid")).sendKeys("58");
			driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[3]")).click();
			assertEquals("Tiền lãi tới hết định kỳ: 192328", driver.findElement(By.xpath("/html/body/div/div/div[3]/p[9]")).getText());
		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	@Test
	public void tinhlai_dungkyhan_tkthuong_7thang() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.name("bookid")).sendKeys("59");
			driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[3]")).click();
			assertEquals("Tiền lãi tới hết định kỳ: 224383", driver.findElement(By.xpath("/html/body/div/div/div[3]/p[9]")).getText());
		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	@Test
	public void tinhlai_dungkyhan_tkthuong_8thang() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.name("bookid")).sendKeys("60");
			driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[3]")).click();
			assertEquals("Tiền lãi tới hết định kỳ: 256438", driver.findElement(By.xpath("/html/body/div/div/div[3]/p[9]")).getText());
		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	@Test
	public void tinhlai_dungkyhan_tkthuong_9thang() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.name("bookid")).sendKeys("61");
			driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[3]")).click();
			assertEquals("Tiền lãi tới hết định kỳ: 288493", driver.findElement(By.xpath("/html/body/div/div/div[3]/p[9]")).getText());
		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	@Test
	public void tinhlai_dungkyhan_tkthuong_10thang() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.name("bookid")).sendKeys("62");
			driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[3]")).click();
			assertEquals("Tiền lãi tới hết định kỳ: 320547", driver.findElement(By.xpath("/html/body/div/div/div[3]/p[9]")).getText());
		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	@Test
	public void tinhlai_dungkyhan_tkthuong_11thang() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.name("bookid")).sendKeys("63");
			driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[3]")).click();
			assertEquals("Tiền lãi tới hết định kỳ: 352602", driver.findElement(By.xpath("/html/body/div/div/div[3]/p[9]")).getText());
		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	
	@Test
	public void tinhlai_dungkyhan_tkthuong_12thang() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.name("bookid")).sendKeys("64");
			driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[3]")).click();
			assertEquals("Tiền lãi tới hết định kỳ: 453698", driver.findElement(By.xpath("/html/body/div/div/div[3]/p[9]")).getText());
		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	@Test
	public void tinhlai_dungkyhan_tkphatloc_1thang() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.name("bookid")).sendKeys("66");
			driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[2]")).click();
			assertEquals("Tiền lãi tới hết định kỳ: 24657", driver.findElement(By.xpath("/html/body/div/div/div[3]/p[9]")).getText());
		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	@Test
	public void tinhlai_dungkyhan_tkphatloc_2thang() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.name("bookid")).sendKeys("67");
			driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[2]")).click();
			assertEquals("Tiền lãi tới hết định kỳ: 49315", driver.findElement(By.xpath("/html/body/div/div/div[3]/p[9]")).getText());
		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	@Test
	public void tinhlai_dungkyhan_tkphatloc_3thang() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.name("bookid")).sendKeys("68");
			driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[2]")).click();
			assertEquals("Tiền lãi tới hết định kỳ: 81369", driver.findElement(By.xpath("/html/body/div/div/div[3]/p[9]")).getText());
		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	@Test
	public void tinhlai_dungkyhan_tkphatloc_4thang() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.name("bookid")).sendKeys("69");
			driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[2]")).click();
			assertEquals("Tiền lãi tới hết định kỳ: 108493", driver.findElement(By.xpath("/html/body/div/div/div[3]/p[9]")).getText());
		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	@Test
	public void tinhlai_dungkyhan_tkphatloc_5thang() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.name("bookid")).sendKeys("70");
			driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[2]")).click();
			assertEquals("Tiền lãi tới hết định kỳ: 135616", driver.findElement(By.xpath("/html/body/div/div/div[3]/p[9]")).getText());
		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	@Test
	public void tinhlai_dungkyhan_tkphatloc_6thang() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.name("bookid")).sendKeys("71");
			driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[2]")).click();
			assertEquals("Tiền lãi tới hết định kỳ: 226849", driver.findElement(By.xpath("/html/body/div/div/div[3]/p[9]")).getText());
		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	@Test
	public void tinhlai_dungkyhan_tkphatloc_7thang() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.name("bookid")).sendKeys("72");
			driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[2]")).click();
			assertEquals("Tiền lãi tới hết định kỳ: 264657", driver.findElement(By.xpath("/html/body/div/div/div[3]/p[9]")).getText());
		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	@Test
	public void tinhlai_dungkyhan_tkphatloc_8thang() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.name("bookid")).sendKeys("73");
			driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[2]")).click();
			assertEquals("Tiền lãi tới hết định kỳ: 302465", driver.findElement(By.xpath("/html/body/div/div/div[3]/p[9]")).getText());
		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	@Test
	public void tinhlai_dungkyhan_tkphatloc_9thang() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.name("bookid")).sendKeys("74");
			driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[2]")).click();
			assertEquals("Tiền lãi tới hết định kỳ: 340274", driver.findElement(By.xpath("/html/body/div/div/div[3]/p[9]")).getText());
		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	@Test
	public void tinhlai_dungkyhan_tkphatloc_10thang() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.name("bookid")).sendKeys("75");
			driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[2]")).click();
			assertEquals("Tiền lãi tới hết định kỳ: 378082", driver.findElement(By.xpath("/html/body/div/div/div[3]/p[9]")).getText());
		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	@Test
	public void tinhlai_dungkyhan_tkphatloc_11thang() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.name("bookid")).sendKeys("76");
			driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[2]")).click();
			assertEquals("Tiền lãi tới hết định kỳ: 415890", driver.findElement(By.xpath("/html/body/div/div/div[3]/p[9]")).getText());
		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	@Test
	public void tinhlai_dungkyhan_tkphatloc_12thang() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
			driver.findElement(By.name("bookid")).sendKeys("77");
			driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[2]")).click();
			assertEquals("Tiền lãi tới hết định kỳ: 522739", driver.findElement(By.xpath("/html/body/div/div/div[3]/p[9]")).getText());
		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	
}
