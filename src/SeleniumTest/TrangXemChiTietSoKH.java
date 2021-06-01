package SeleniumTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TrangXemChiTietSoKH {

	ChromeDriver driver;
	
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
			driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[2]/td[8]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[1]/a")).click();
			assertEquals("http://localhost:8080/bank/checklogin?username=trantiendung101999&password=123456", driver.getCurrentUrl());
		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	
	
	@Test
	public void dangxuat() throws InterruptedException
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
			driver.findElement(By.xpath("/html/body/div/div/div[1]/div[4]/a")).click();
			assertEquals("http://localhost:8080/bank/backtoindex", driver.getCurrentUrl());
		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	@Test
	public void Quay_lai_xem_so_ca_nhan() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("acx");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[1]/td[8]/a")).click();
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
	public void tinhlai_truockyhan() throws InterruptedException
	{
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("trantiendung101999");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[4]/td[8]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[1]")).click();
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
			driver.findElement(By.name("username")).sendKeys("trantiendung101999");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[5]/td[8]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[1]")).click();
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
			driver.findElement(By.name("username")).sendKeys("trantiendung101999");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[3]/td[8]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[2]")).click();
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
			driver.findElement(By.name("username")).sendKeys("trantiendung101999");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[5]/td[8]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[2]")).click();
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
			driver.findElement(By.name("username")).sendKeys("trantiendung101999");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[6]/td[8]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[2]")).click();
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
			driver.findElement(By.name("username")).sendKeys("trantiendung101999");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[7]/td[8]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[2]")).click();
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
			driver.findElement(By.name("username")).sendKeys("trantiendung101999");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[8]/td[8]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[2]")).click();
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
			driver.findElement(By.name("username")).sendKeys("trantiendung101999");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[9]/td[8]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[2]")).click();
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
			driver.findElement(By.name("username")).sendKeys("trantiendung101999");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[10]/td[8]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[2]")).click();
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
			System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/bank/");
			driver.findElement(By.name("username")).sendKeys("trantiendung101999");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[11]/td[8]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[2]")).click();
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
			driver.findElement(By.name("username")).sendKeys("trantiendung101999");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[12]/td[8]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[2]")).click();
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
			driver.findElement(By.name("username")).sendKeys("trantiendung101999");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[13]/td[8]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[2]")).click();
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
			driver.findElement(By.name("username")).sendKeys("trantiendung101999");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[14]/td[8]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[2]")).click();
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
			driver.findElement(By.name("username")).sendKeys("trantiendung101999");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[15]/td[8]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button[2]")).click();
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
			driver.findElement(By.name("username")).sendKeys("trantiendung101999");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[16]/td[8]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button")).click();
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
			driver.findElement(By.name("username")).sendKeys("trantiendung101999");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[17]/td[8]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button")).click();
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
			driver.findElement(By.name("username")).sendKeys("trantiendung101999");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[18]/td[8]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button")).click();
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
			driver.findElement(By.name("username")).sendKeys("trantiendung101999");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[19]/td[8]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button")).click();
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
			driver.findElement(By.name("username")).sendKeys("trantiendung101999");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[20]/td[8]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button")).click();
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
			driver.findElement(By.name("username")).sendKeys("trantiendung101999");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[21]/td[8]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button")).click();
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
			driver.findElement(By.name("username")).sendKeys("trantiendung101999");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[22]/td[8]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button")).click();
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
			driver.findElement(By.name("username")).sendKeys("trantiendung101999");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[23]/td[8]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button")).click();
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
			driver.findElement(By.name("username")).sendKeys("trantiendung101999");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[24]/td[8]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button")).click();
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
			driver.findElement(By.name("username")).sendKeys("trantiendung101999");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[25]/td[8]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button")).click();
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
			driver.findElement(By.name("username")).sendKeys("trantiendung101999");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[26]/td[8]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button")).click();
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
			driver.findElement(By.name("username")).sendKeys("trantiendung101999");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[27]/td[8]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button")).click();
			assertEquals("Tiền lãi tới hết định kỳ: 522739", driver.findElement(By.xpath("/html/body/div/div/div[3]/p[9]")).getText());
		}
		
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	
}
