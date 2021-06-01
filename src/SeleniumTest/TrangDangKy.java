package SeleniumTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import controller.ConnectDB;
import controller.userDAO.UserDAOImp;
import model.User;

public class TrangDangKy {

ChromeDriver driver;
	
	@Test
	public void register_success() throws InterruptedException, SQLException
	{
		try {
		System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/bank/dangkyform");
		driver.findElement(By.name("fullname")).sendKeys("Trần Tiến Dũng");
		driver.findElement(By.name("username")).sendKeys("dungdung123");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("address")).sendKeys("x5 hông thuận giao thuỷ nam định");
		driver.findElement(By.name("dob")).sendKeys("20/10/1999");
		driver.findElement(By.name("phonenumber")).sendKeys("0868381642");
		driver.findElement(By.name("email")).sendKeys("trantiendung101999@gmail.com");
		driver.findElement(By.name("idcard")).sendKeys("734294235");
		driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button[1]")).click();

		UserDAOImp udi = new UserDAOImp();
		User user = udi.searchUserByidCard("734294235");
		assertEquals("Trần Tiến Dũng",user.getFullname());
		assertEquals("dungdung123",user.getUsername());
		assertEquals("123456",user.getPassword());
		assertEquals("x5 hông thuận giao thuỷ nam định",user.getAddress());
		assertEquals("1999-10-20",user.getDob());
		assertEquals("0868381642",user.getPhonenumber());
		assertEquals("trantiendung101999@gmail.com",user.getEmail());
		assertEquals("734294235",user.getIdCard());

		assertEquals("Đăng ký thành công", driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/div")).getText());

		}
		finally {
			String ROLLBACK_SQL="DELETE FROM users WHERE idcard=?";
			Connection con = ConnectDB.connection();
			try {
				PreparedStatement pre = con.prepareStatement(ROLLBACK_SQL);
				pre.setString(1,"734294235");
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
	public void register_failures_idcard_exist() throws InterruptedException, SQLException
	{
		try {
		System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/bank/dangkyform");
		driver.findElement(By.name("fullname")).sendKeys("Trần Tiến Dũng");
		driver.findElement(By.name("username")).sendKeys("dungdung123");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("address")).sendKeys("x5 hông thuận giao thuỷ nam định");
		driver.findElement(By.name("dob")).sendKeys("20/10/1999");
		driver.findElement(By.name("phonenumber")).sendKeys("0868381642");
		driver.findElement(By.name("email")).sendKeys("trantiendung101999@gmail.com");
		driver.findElement(By.name("idcard")).sendKeys("111");
		driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button[1]")).click();

		assertEquals("Thẻ căn cước đã được sử dụng", driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/div")).getText());

		}
		finally {
			Thread.sleep(2000);
			driver.close();
		}
	}
	
	@Test
	public void register_failures_username_exist() throws InterruptedException, SQLException
	{
		try {
		System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/bank/dangkyform");
		driver.findElement(By.name("fullname")).sendKeys("Trần Tiến Dũng");
		driver.findElement(By.name("username")).sendKeys("dunghoi1232");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("address")).sendKeys("x5 hông thuận giao thuỷ nam định");
		driver.findElement(By.name("dob")).sendKeys("20/10/1999");
		driver.findElement(By.name("phonenumber")).sendKeys("0868381642");
		driver.findElement(By.name("email")).sendKeys("trantiendung101999@gmail.com");
		driver.findElement(By.name("idcard")).sendKeys("1116435436433");
		driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button[1]")).click();

		assertEquals("Tên tài khoản tồn tại", driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/div")).getText());

		}
		finally {
			Thread.sleep(2000);
			driver.close();
		}
	}
	
	@Test
	public void cancel() throws InterruptedException
	{
		try {
		System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/bank/dangkyform");
		driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button[2]")).click();
		assertEquals("http://localhost:8080/bank/backtoindex?fullname=&username=&password=&address=&dob=&phonenumber=&email=&idcard=",driver.getCurrentUrl());
		}
		finally {
			Thread.sleep(2000);
			driver.close();
		}

	}
	
}
