package Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import controller.ConnectDB;
import controller.InterestRate.InterestRateDAOImp;
import controller.bankSavingBookDAO.BankSavingDAOImp;
import controller.userDAO.UserDAOImp;
import model.BankSavingBook;
import model.InterestRate;
import model.User;

public class BankSavingDAOImpTest {

	Connection con;
	BankSavingDAOImp bsdi;
	User user;
	InterestRate ir;
	BankSavingBook bsb;
	InterestRateDAOImp irdi;
	UserDAOImp udi;
	
	@BeforeEach
	void setUp()
	{
		bsdi= new BankSavingDAOImp();
		irdi = new InterestRateDAOImp();
		udi = new UserDAOImp();
		con = ConnectDB.connection();

		int id = 8;
		String userFullname="Tran Tien DUng";
		String username="dunghoi";
		String password="123456";
		String address = "hongthuan";
		String dob = "2021-04-23";
		String phonenumber = "443543";
		String email = "trantiendung101999@gmail.com";
		String role="khach hang";
		String idcard = "123";
		user=new User();
		user.setId(id);
		user.setFullname(userFullname);
		user.setUsername(username);
		user.setPassword(password);
		user.setAddress(address);
		user.setDob(dob);
		user.setPhonenumber(phonenumber);
		user.setEmail(email);
		user.setRole(role);
		user.setIdCard(idcard);
		
		int irId = 1;
		String typeofsaving = "tiet kiem thuong";
		int time = 1;
		double interestrate = 2.55;
		ir = new InterestRate();
		ir.setId(irId);
		ir.setTypeOfSaving(typeofsaving);
		ir.setTime(time);
		ir.setInterestRate(interestrate);
		
		double money = 10000000;
		String branch = " Ha Dong , Ha NOI";
		String typeofsaving2="tiet kiem thuong";
		int interestTerm = 1;
		int perodic = 1;
		String startDate="2021-05-20";
		bsb = new BankSavingBook();
		bsb.setBranch(branch);
		bsb.setInterestRate(ir);
		bsb.setInterestTerm(interestTerm);
		bsb.setMoney(money);
		bsb.setPeriodic(perodic);
		bsb.setStartDate(startDate);
		bsb.setTypeOfSaving(typeofsaving2);
		bsb.setUser(user);
		
	}
	
	// ------------------- Test t??m s??? theo m??----------------------
	// Trong DB ch??? c?? m?? 49-78 v??o th???i ??i???m Test
	//--------------------------------------------------------------
	
	// T??m h???p l??? 
	
	@Test
	@DisplayName("T??m s??? theo m?? s??? t???n t???i bi??n d?????i  ") 
	
	void searchBook()
	{
	
		BankSavingBook bsb = bsdi.searchBook(49);
		assertNotNull(bsb);
		assertEquals("H?? ????ng,H?? N???i", bsb.getBranch());
		assertEquals(49, bsb.getId());
		assertEquals(irdi.getInterestRateByID(1).toString(), bsb.getInterestRate().toString());
		assertEquals(1,bsb.getInterestTerm());
		assertEquals(10000000, bsb.getMoney());
		assertEquals(0, bsb.getPeriodic());
		assertEquals("2021-05-29", bsb.getStartDate());
		assertEquals("tiet kiem thuong", bsb.getTypeOfSaving());
		assertEquals(udi.getUserByID(6).toString(), bsb.getUser().toString());
	}
	
	@Test
	@DisplayName("T??m s??? theo m?? s??? t???n t???i bi??n tr??n  ") 
	
	void searchBook2()
	{
		BankSavingBook bsb = bsdi.searchBook(78);
		assertNotNull(bsb);
		assertEquals("H?? ????ng,H?? N???i", bsb.getBranch());
		assertEquals(78, bsb.getId());
		assertEquals(irdi.getInterestRateByID(1).toString(), bsb.getInterestRate().toString());
		assertEquals(1,bsb.getInterestTerm());
		assertEquals(100000000, bsb.getMoney());
		assertEquals(0, bsb.getPeriodic());
		assertEquals("2021-05-30", bsb.getStartDate());
		assertEquals("tiet kiem thuong", bsb.getTypeOfSaving());
		assertEquals(udi.getUserByID(88).toString(), bsb.getUser().toString());
	}
	
	//--------------------------------------------------------------
	// T??m kh??ng h???p l??? 
	
	@Test
	@DisplayName("T??m s??? theo m?? s??? kh??ng t???n t???i bi??n d?????i  ")
	void searchBook3()
	{
		BankSavingBook bsb = bsdi.searchBook(48);
		assertNull(bsb);
	}
	
	@Test
	@DisplayName("T??m s??? theo m?? s??? kh??ng t???n t???i bi??n tr??n  ")
	void searchBook4()
	{
		BankSavingBook bsb = bsdi.searchBook(79);
		assertNull(bsb);
	}
	
	//---------------------------Test th??m s??? -----------------------------------
	
	
	@Test
	@DisplayName("Th??m s??? th??nh c??ng ")
	void insertBook() throws SQLException
	{
		con.setAutoCommit(false);
		try {
			bsdi.con = con;
		assertTrue(bsdi.insertBook(bsb));
		assertNotNull(bsdi.searchBook(bsb.getId()));
		assertEquals(bsdi.searchBook(bsb.getId()).toString(), bsb.toString());
		}
		finally {
			con.rollback();
			con.close();
		}
	}
	
	@Test
	@DisplayName("Th??m s??? kh??ng th??nh c??ng ")
	void insertBook2() throws SQLException
	{
		con.setAutoCommit(false);
		try {
			bsdi.con = con;
		assertFalse(bsdi.insertBook(null));
		assertNull(bsdi.searchBook(bsb.getId()));
		}
		finally {
			con.rollback();
			con.close();
		}
	}
	
	//----------------------------Test r??t so----------------------------------
	
	
	@Test
	@DisplayName("R??t s??? kh??ng t???n t???i ")
	void delBook1() throws SQLException
	{
		con.setAutoCommit(false);
		try {
			bsdi.con = con;
			bsb.setId(8);
		assertFalse(bsdi.rutSo(bsb));
		}
		finally {
			con.rollback();
			con.close();
		}
	}
	
	@Test
	@DisplayName("R??t s??? th??nh c??ng  ")
	void delBook2() throws SQLException
	{
		con.setAutoCommit(false);
		try {
			bsdi.con = con;
			bsb.setId(50);
		assertTrue(bsdi.rutSo(bsb));
		assertTrue(bsdi.searchBook(bsb.getId()).getCheckk()==1);
		}
		finally {
			con.rollback();
			con.close();
		}
	}
	
	
	
}
