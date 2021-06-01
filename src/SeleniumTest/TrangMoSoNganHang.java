package SeleniumTest;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import controller.ConnectDB;
import controller.InterestRate.InterestRateDAOImp;
import controller.userDAO.UserDAOImp;
import model.BankSavingBook;
import model.InterestRate;
import model.User;

public class TrangMoSoNganHang {

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
				driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
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
				driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
				driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[1]/a")).click();
				assertEquals("http://localhost:8080/bank/checklogin?username=admin&password=admin",driver.getCurrentUrl());
	
			}
			
			finally {
				Thread.sleep(2000);
				driver.close();
			}
	
		}
		@Test
		public void chuyen_sang_xem_so_ngan_hang() throws InterruptedException
		{
			try {
				System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
				driver = new ChromeDriver();
				driver.get("http://localhost:8080/bank/");
				driver.findElement(By.name("username")).sendKeys("admin");
				driver.findElement(By.name("password")).sendKeys("admin");
				driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
				driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
				driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
				assertEquals("http://localhost:8080/bank/rutsoform?username=admin&password=admin",driver.getCurrentUrl());
	
			}
			
			finally {
				Thread.sleep(2000);
				driver.close();
			}
	
		}
		@Test
		public void mo_so_thanh_cong_khi_chua_co_tai_khoan() throws InterruptedException, SQLException
		{
			try {
				System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
				driver = new ChromeDriver();
				driver.get("http://localhost:8080/bank/");
				driver.findElement(By.name("username")).sendKeys("admin");
				driver.findElement(By.name("password")).sendKeys("admin");
				driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
				driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
				driver.findElement(By.name("fullname")).sendKeys("Trần Tiến Dũng");
				driver.findElement(By.name("address")).sendKeys("x5 hông thuận giao thuỷ nam định");
				driver.findElement(By.name("phonenumber")).sendKeys("0868381642");
				driver.findElement(By.name("email")).sendKeys("trantiendung101999@gmail.com");
				driver.findElement(By.name("idcard")).sendKeys("2021");
				driver.findElement(By.name("money")).sendKeys("10000000");
				driver.findElement(By.name("dob")).sendKeys("20/10/1999");
				driver.findElement(By.xpath("/html/body/div/div/form/div[10]/select/option[1]")).click();
				driver.findElement(By.xpath("/html/body/div/div/form/div[11]/select/option[1]")).click();
				driver.findElement(By.xpath("/html/body/div/div/form/div[12]/select/option[1]")).click();
				driver.findElement(By.xpath("/html/body/div/div/form/button")).click();

				String CHECKDATA_SQL="SELECT * from banksavingbooks ORDER BY id DESC LIMIT 1";
				Connection con = ConnectDB.connection();
				PreparedStatement pre = con.prepareStatement(CHECKDATA_SQL);
				ResultSet rs = pre.executeQuery();
				InterestRateDAOImp interest = new InterestRateDAOImp();
				UserDAOImp userDAO = new UserDAOImp();
				BankSavingBook bsb = new BankSavingBook();
				if(rs.next())
				{
					User u = userDAO.getUserByID(rs.getInt("UsersID"));
					InterestRate interestRate = interest.getInterestRateByID(rs.getInt("InterestRateID"));
					double money = rs.getDouble("Money");
					String branch = rs.getString("branch");
					String typeofsaving = rs.getString("TypeOfSaving");
					int interestterm = rs.getInt("InterestTerm");
					String startDate = rs.getString("StartDate");
					int periodic = rs.getInt("periodic");
					int checkk = rs.getInt("checkk");
					bsb.setId(rs.getInt("ID"));
					bsb.setUser(u);
					bsb.setInterestRate(interestRate);
					bsb.setMoney(money);
					bsb.setBranch(branch);
					bsb.setTypeOfSaving(typeofsaving);
					bsb.setInterestTerm(interestterm);
					bsb.setStartDate(startDate);
					bsb.setPeriodic(periodic);
					bsb.setCheckk(checkk);
				}
				assertEquals("Trần Tiến Dũng", bsb.getUser().getFullname());
				assertEquals("x5 hông thuận giao thuỷ nam định", bsb.getUser().getAddress());
				assertEquals("0868381642", bsb.getUser().getPhonenumber());
				assertEquals("trantiendung101999@gmail.com", bsb.getUser().getEmail());
				assertEquals("2021", bsb.getUser().getIdCard());
				assertEquals("1999-10-20", bsb.getUser().getDob());
				assertEquals(1, bsb.getInterestRate().getId());
				
				assertEquals("Mở sổ thành công ", driver.findElement(By.xpath("/html/body/div/div/div[3]")).getText());



			}
			
			finally {
				String ROLLBACK_SQL="DELETE FROM banksavingbooks ORDER BY id DESC LIMIT 1";
				Connection con = ConnectDB.connection();
				try {
					PreparedStatement pre = con.prepareStatement(ROLLBACK_SQL);
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
		public void mo_so_thanh_cong_khi_da_co_tai_khoan() throws InterruptedException, SQLException
		{
			try {
				System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
				driver = new ChromeDriver();
				driver.get("http://localhost:8080/bank/");
				driver.findElement(By.name("username")).sendKeys("admin");
				driver.findElement(By.name("password")).sendKeys("admin");
				driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
				driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
				driver.findElement(By.name("idcard")).sendKeys("111");
				driver.findElement(By.name("money")).sendKeys("10000000");
				driver.findElement(By.xpath("/html/body/div/div/form/div[10]/select/option[1]")).click();
				driver.findElement(By.xpath("/html/body/div/div/form/div[11]/select/option[1]")).click();
				driver.findElement(By.xpath("/html/body/div/div/form/div[12]/select/option[1]")).click();
				driver.findElement(By.xpath("/html/body/div/div/form/button")).click();

				String CHECKDATA_SQL="SELECT * from banksavingbooks ORDER BY id DESC LIMIT 1";
				Connection con = ConnectDB.connection();
				PreparedStatement pre = con.prepareStatement(CHECKDATA_SQL);
				ResultSet rs = pre.executeQuery();
				InterestRateDAOImp interest = new InterestRateDAOImp();
				UserDAOImp userDAO = new UserDAOImp();
				BankSavingBook bsb = new BankSavingBook();
				if(rs.next())
				{
					User u = userDAO.getUserByID(rs.getInt("UsersID"));
					InterestRate interestRate = interest.getInterestRateByID(rs.getInt("InterestRateID"));
					double money = rs.getDouble("Money");
					String branch = rs.getString("branch");
					String typeofsaving = rs.getString("TypeOfSaving");
					int interestterm = rs.getInt("InterestTerm");
					String startDate = rs.getString("StartDate");
					int periodic = rs.getInt("periodic");
					int checkk = rs.getInt("checkk");
					bsb.setId(rs.getInt("ID"));
					bsb.setUser(u);
					bsb.setInterestRate(interestRate);
					bsb.setMoney(money);
					bsb.setBranch(branch);
					bsb.setTypeOfSaving(typeofsaving);
					bsb.setInterestTerm(interestterm);
					bsb.setStartDate(startDate);
					bsb.setPeriodic(periodic);
					bsb.setCheckk(checkk);
				}

				assertEquals("111", bsb.getUser().getIdCard());
				assertEquals("1",String.valueOf( bsb.getInterestRate().getId()));
				
				driver.findElement(By.xpath("/html/body/div/div/div[1]/div[4]/a")).click();
				
				driver.findElement(By.name("username")).sendKeys("trantiendung101999");
				driver.findElement(By.name("password")).sendKeys("123456");
				driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
				driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
				assertEquals(String.valueOf(bsb.getId()), driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[28]/td[1]")).getText());

			}
			
			finally {
				String ROLLBACK_SQL="DELETE FROM banksavingbooks ORDER BY id DESC LIMIT 1";
				Connection con = ConnectDB.connection();
				try {
					PreparedStatement pre = con.prepareStatement(ROLLBACK_SQL);
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
		public void mo_so_thanh_cong_sau_do_tao_tai_khoan() throws InterruptedException, SQLException
		{
			try {
				System.setProperty("webdriver.chrome.driver", "/Users/trandung/Downloads/chromedriver");
				driver = new ChromeDriver();
				driver.get("http://localhost:8080/bank/");
				driver.findElement(By.name("username")).sendKeys("admin");
				driver.findElement(By.name("password")).sendKeys("admin");
				driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
				driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
				driver.findElement(By.name("fullname")).sendKeys("Trần Tiến Dũng");
				driver.findElement(By.name("address")).sendKeys("x5 hông thuận giao thuỷ nam định");
				driver.findElement(By.name("phonenumber")).sendKeys("0868381642");
				driver.findElement(By.name("email")).sendKeys("trantiendung101999@gmail.com");
				driver.findElement(By.name("idcard")).sendKeys("2021");
				driver.findElement(By.name("money")).sendKeys("10000000");
				driver.findElement(By.name("dob")).sendKeys("20/10/1999");
				driver.findElement(By.xpath("/html/body/div/div/form/div[10]/select/option[1]")).click();
				driver.findElement(By.xpath("/html/body/div/div/form/div[11]/select/option[1]")).click();
				driver.findElement(By.xpath("/html/body/div/div/form/div[12]/select/option[1]")).click();
				driver.findElement(By.xpath("/html/body/div/div/form/button")).click();

				String CHECKDATA_SQL="SELECT * from banksavingbooks ORDER BY id DESC LIMIT 1";
				Connection con = ConnectDB.connection();
				PreparedStatement pre = con.prepareStatement(CHECKDATA_SQL);
				ResultSet rs = pre.executeQuery();
				InterestRateDAOImp interest = new InterestRateDAOImp();
				UserDAOImp userDAO = new UserDAOImp();
				BankSavingBook bsb = new BankSavingBook();
				if(rs.next())
				{
					User u = userDAO.getUserByID(rs.getInt("UsersID"));
					InterestRate interestRate = interest.getInterestRateByID(rs.getInt("InterestRateID"));
					double money = rs.getDouble("Money");
					String branch = rs.getString("branch");
					String typeofsaving = rs.getString("TypeOfSaving");
					int interestterm = rs.getInt("InterestTerm");
					String startDate = rs.getString("StartDate");
					int periodic = rs.getInt("periodic");
					int checkk = rs.getInt("checkk");
					bsb.setId(rs.getInt("ID"));
					bsb.setUser(u);
					bsb.setInterestRate(interestRate);
					bsb.setMoney(money);
					bsb.setBranch(branch);
					bsb.setTypeOfSaving(typeofsaving);
					bsb.setInterestTerm(interestterm);
					bsb.setStartDate(startDate);
					bsb.setPeriodic(periodic);
					bsb.setCheckk(checkk);
				}
				assertEquals("Trần Tiến Dũng", bsb.getUser().getFullname());
				assertEquals("x5 hông thuận giao thuỷ nam định", bsb.getUser().getAddress());
				assertEquals("0868381642", bsb.getUser().getPhonenumber());
				assertEquals("trantiendung101999@gmail.com", bsb.getUser().getEmail());
				assertEquals("2021", bsb.getUser().getIdCard());
				assertEquals("1999-10-20", bsb.getUser().getDob());
				assertEquals(1, bsb.getInterestRate().getId());
				driver.findElement(By.xpath("/html/body/div/div/div[1]/div[4]/a")).click();
				driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click();
				driver.findElement(By.name("fullname")).sendKeys("Trần Tiến Dũng");
				driver.findElement(By.name("username")).sendKeys("dungdung123");
				driver.findElement(By.name("password")).sendKeys("123456");
				driver.findElement(By.name("address")).sendKeys("x5 hông thuận giao thuỷ nam định");
				driver.findElement(By.name("dob")).sendKeys("20/10/1999");
				driver.findElement(By.name("phonenumber")).sendKeys("0868381642");
				driver.findElement(By.name("email")).sendKeys("trantiendung101999@gmail.com");
				driver.findElement(By.name("idcard")).sendKeys("2021");
				driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button[1]")).click();
				
				driver.findElement(By.name("username")).sendKeys("dungdung123");
				driver.findElement(By.name("password")).sendKeys("123456");
				driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/form/button")).click();
				driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
				assertEquals(String.valueOf(bsb.getId()), driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[1]/td[1]")).getText());
				
				
			}
			
			finally {
				String ROLLBACK1_SQL="DELETE FROM banksavingbooks ORDER BY id DESC LIMIT 1";
				Connection con = ConnectDB.connection();
				try {
					PreparedStatement pre = con.prepareStatement(ROLLBACK1_SQL);
					pre.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String ROLLBACK_SQL="DELETE FROM users WHERE idcard=?";
				try {
					PreparedStatement pre = con.prepareStatement(ROLLBACK_SQL);
					pre.setString(1,"2021");
					pre.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Thread.sleep(2000);
				driver.close();
			}
	
		}
		

}
