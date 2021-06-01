package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Web.BankServlet;
import model.BankSavingBook;

class TinhLaiTest {
	BankSavingBook bs;
	
	@BeforeEach
	void setUp()
	{
		bs = new BankSavingBook();
	}
	
	// ----Kiểm tra tính khoảng cách ngày từ ngày mở sổ đến ngày hiện test ------
	// Mỗi tháng coi như có 30 ngày , 1 năm có 365 ngày 
	//-------- Test vào ngày 31/05/2021 ------------ 
	
	@Test
	@DisplayName("Kiểm tra tính khoảng cách ngày từ ngày mở sổ đến ngày test cùng năm cùng tháng sau ngày mở sổ ")
	void day_instance()
	{
		int dayinstance = bs.dayinstance("2021-05-29");
		assertEquals(dayinstance,2);
	}

// Khong xay ra 
//	@Test
//	@DisplayName("Kiểm tra tính khoảng cách ngày từ ngày mở sổ đến ngày test cùng năm cùng tháng trước ngày mở sổ ")
//	void day_instance2()
//	{
//		int dayinstance = bs.dayinstance("2021-06-11");
//		assertEquals(dayinstance,-1);
//	}
	
	@Test
	@DisplayName("Kiểm tra tính khoảng cách ngày từ ngày mở sổ đến ngày test cùng năm trước tháng  ")
	void day_instance3()
	{
		int dayinstance = bs.dayinstance("2021-05-20");
		assertEquals(dayinstance,11);
	}
	
//Khong xay ra 
//	@Test
//	@DisplayName("Kiểm tra tính khoảng cách ngày từ ngày mở sổ đến ngày test cùng năm sau tháng mở sổ ")
//	void day_instance4()
//	{
//		int dayinstance = bs.dayinstance("2021-09-29");
//		assertEquals(dayinstance,-1);
//	}
	
	@Test
	@DisplayName("Kiểm tra tính khoảng cách ngày từ ngày mở sổ đến ngày test năm test lớn hơn năm mở sổ ")
	void day_instance5()
	{
		int dayinstance = bs.dayinstance("2020-04-29");
		System.out.println(dayinstance);
		assertEquals(dayinstance,392);
	}
	
	
// Khong xay ra 	
//	@Test
//	@DisplayName("Kiểm tra tính khoảng cách ngày từ ngày mở sổ đến ngày test năm test nhỏ hơn năm mở sổ ")
//	void day_instance6()
//	{
//		int dayinstance = bs.dayinstance("2022-04-29");
//		System.out.println(dayinstance);
//		assertEquals(dayinstance,-1);
//	}
	
	
	//---------------Kiểm tra tính lãi đến thời điểm tính lãi ---------------
	
	// ----------- Test vào ngày 31/05/2021 ------------------ 
	
	@Test
	@DisplayName("Kiểm tra số tiền nhập vào nhỏ hơn 1 triệu  ")
	void testLai()
	{
		double s=bs.tinhtienlaihientai(999999, "2021-04-30", 2.5, 3);
		assertEquals(s, -1);
	}
	
// Khong xay ra 
//	@Test
//	@DisplayName("Kiểm tra ngày bắt đầu lớn hơn ngày hiện tại  ")
//	void testLai2()
//	{
//		double s=bs.tinhtienlaihientai(10000000, "2021-07-30", 2.5, 3);
//		assertEquals(s, -1);
//	}
	
	@Test
	@DisplayName("Kiểm tra số tiền nhập vào không nhỏ hơn 1 triệu trước kỳ hạn  ")
	void testLai3()
	{
		int s=(int)bs.tinhtienlaihientai(1000000, "2021-05-28", 2.5, 1);
		assertEquals(s,123);
	}
	
	@Test
	@DisplayName("Kiểm tra số tiền nhập vào không nhỏ hơn 1 triệu sau kỳ hạn  ")
	void testLai4()
	{
		int s=(int)bs.tinhtienlaihientai(1000000, "2020-01-30", 2.5, 1);
		assertEquals(s,2095);
	}

	
	//---------------------------Kiểm tra tính lãi tới hết kỳ hạn -------------------------
	// Test vào ngày 31/05/2021 
	
	@Test
	@DisplayName("Tính lãi hết kỳ hạn với số nhỏ hơn 1 triệu   ")
	void testLai5()
	{
		double s=bs.tinhtienlaidinhky(999999, 2.5, 1);
		assertEquals(s,-1);
	}
	
	@Test
	@DisplayName("Tính lãi hết kỳ hạn hợp lệ ")
	void testLai6()
	{
		int s=(int)bs.tinhtienlaidinhky(1000000, 2.5, 1);
		assertEquals(s,2054);
	}
}
