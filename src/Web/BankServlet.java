package Web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import controller.InterestRate.InterestRateDAOImp;
import controller.bankSavingBookDAO.BankSavingBookDAO;
import controller.bankSavingBookDAO.BankSavingDAOImp;
import controller.userDAO.UserDAOImp;
import model.BankSavingBook;
import model.InterestRate;
import model.User;

/**
 * Servlet implementation class BankServlet
 */
@WebServlet("/")
public class BankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserDAOImp userDAO= new UserDAOImp();
	private BankSavingDAOImp bookDAO = new BankSavingDAOImp();
	private InterestRateDAOImp interestDAO = new InterestRateDAOImp();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch(action)
		{
		case ("/dangkyform"):
		{
			showRegisterForm(request,response);
			
			break;
		}
		case ("/backtoindex"):
		{
			showIndexForm(request,response);
			break;
		}
		case ("/dangky"):
		{
			registerCustomer(request,response);
			break;
		}
		case ("/checklogin"):
		{
			checklogin(request,response);
			break;
		}
		case ("/xemso"):
		{
			xemSo(request,response);
			break;
		}
		case ("/xemthongtinso"):
		{
			xemThongTinSo(request,response);
			break;
		}
		case ("/tinhlaihientai"):
		{
			tinhLaiHienTai(request,response);
			break;
		}
		case ("/tinhlaihetdinhky"):
		{
			tinhLaiHetDinhKy(request,response);
			break;
		}
		case ("/mosoform"):
		{
			showMoso(request,response);
			break;
		}
		
		case ("/tinhlaiform"):
		{
			showTinhlai(request,response);
			break;
		}
		
		case ("/rutsoform"):
		{
			showRutso(request,response);
			break;
		}
		
		case("/timkiemso"):
		{
			timKiemso(request,response);
			break;
		}
		
		case("/rutso"):
		{
			rutso(request,response);
			break;
		}
		
		case("/moso"):
		{
			moso(request,response);
			break;
		}
		
		}
		
		
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	// hien thi giao dien dang ky
	private void showRegisterForm(HttpServletRequest request, HttpServletResponse response) {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// hien thi giao dien dang nhap
private void showIndexForm(HttpServletRequest request, HttpServletResponse response) {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
// dang ky khach hang
private void registerCustomer(HttpServletRequest request, HttpServletResponse response) {
	
	String fullname = request.getParameter("fullname");
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String address = request.getParameter("address");
	String dob = request.getParameter("dob");
	String phonenumber=request.getParameter("phonenumber");
	String email = request.getParameter("email");
	String idcard = request.getParameter("idcard");
	
	User user = userDAO.searchUserByidCard(idcard);
	if(user ==null)
	{
	user = new User(fullname,username,password,address,phonenumber,email,"khach hang",idcard,dob);
	if(userDAO.checkUsername(username)==false)
	{
	userDAO.insertUser(user);
	
	try {
		response.sendRedirect("/bank/backtoindex");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	else
	{
		String mistake="Tên tài khoản tồn tại ";
		request.setAttribute("mistake", mistake);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("register.jsp");
		
		try {
			requestDispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
	else
	{
		if(user.getUsername()==null)
		{
			user.setUsername(username);
			user.setPassword(password);
			if(userDAO.checkUsername(username)==false)
			{
				userDAO.addUsername(user);
				try {
					response.sendRedirect("/bank/backtoindex");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				String mistake="Tên tài khoản tồn tại ";
				request.setAttribute("mistake", mistake);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("register.jsp");
				
				try {
					requestDispatcher.forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else
		{
			String mistake="Thẻ căn cước đã được sử dụng  ";
			request.setAttribute("mistake", mistake);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("register.jsp");
			
			try {
				requestDispatcher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
// kiem tra dang nhap
private void checklogin(HttpServletRequest request, HttpServletResponse response) {
	
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	User user = userDAO.checkAccount(username, password);
	if(user==null)
	{
		String mistake="Tên tài khoản hoặc mật khẩu không chính xác  ";
		request.setAttribute("mistake", mistake);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
		
		try {
			requestDispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	else
	{
		if(user.getRole().equalsIgnoreCase("khach hang"))
		{
			request.setAttribute("user", user);
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("/customerscreen.jsp");
			try {
				requestdispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			request.setAttribute("user", user);
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("/staffscreen.jsp");
			try {
				requestdispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}

// xem so tiet kiem tu giao dien khach hang
private void xemSo(HttpServletRequest request, HttpServletResponse response) {
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	User user = userDAO.checkAccount(username, password);
	request.setAttribute("user", user);
	ArrayList<BankSavingBook> listbook = userDAO.getBankSavingBook(user);

	if(listbook.size()==0)
	{
		System.out.print(listbook.size());
		listbook=null;
	}
	
	request.setAttribute("listbook", listbook);
	
	RequestDispatcher requestdispatcher = request.getRequestDispatcher("/xemSo.jsp");
	try {
		requestdispatcher.forward(request, response);
	} catch (ServletException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
// xem chi tiet thong tin cua mot so tiet kiem
private void xemThongTinSo(HttpServletRequest request, HttpServletResponse response) {
	
	int bookID = Integer.parseInt(request.getParameter("bookid"));
	
	BankSavingBook bsb = bookDAO.searchBook(bookID);
	
	request.setAttribute("book", bsb);
	request.setAttribute("status1", "dsfdsfds");
	System.out.print(bsb.getTypeOfSaving());
	if(bsb.getTypeOfSaving().equalsIgnoreCase("tiet kiem thuong"))
	{
		request.setAttribute("status3", "dddd");
	}
	RequestDispatcher requestdispatcher = request.getRequestDispatcher("/xemthongtinso.jsp");
	try {
		requestdispatcher.forward(request, response);
	} catch (ServletException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

private void timKiemso(HttpServletRequest request, HttpServletResponse response) {
	
	int bookID = Integer.parseInt(request.getParameter("bookid"));
	
	BankSavingBook bsb = bookDAO.searchBook(bookID);
	
	if(bsb!=null)
	{
		if(bsb.getCheckk()==1)
		{
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User user = userDAO.checkAccount(username, password);
			request.setAttribute("user", user);
			String mistake="Sổ đã được rút ";
			request.setAttribute("mistake", mistake);
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("/rutso.jsp");
			try {
				requestdispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User user = userDAO.checkAccount(username, password);
			request.setAttribute("user", user);
			request.setAttribute("book", bsb);
			request.setAttribute("status2", "dsfdfsd");
			System.out.print(bsb.getTypeOfSaving());
			if(bsb.getTypeOfSaving().equalsIgnoreCase("tiet kiem thuong"))
			{
				request.setAttribute("status3", "dddd");
			}
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("/xemthongtinso.jsp");
			try {
				requestdispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	else
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userDAO.checkAccount(username, password);
		request.setAttribute("user", user);
		String mistake="Không có mã sổ tiết kiệm phù hợp ";
		request.setAttribute("mistake", mistake);
		RequestDispatcher requestdispatcher = request.getRequestDispatcher("/rutso.jsp");
		try {
			requestdispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}


//tinh tien lai cua so tiet kiem den thoi diem tinh lai
private void tinhLaiHienTai(HttpServletRequest request, HttpServletResponse response) {
	
	int bookid = Integer.parseInt(request.getParameter("bookid"));
	
	BankSavingBook bsb = bookDAO.searchBook(bookid);
	request.setAttribute("book", bsb);
	String Status = request.getParameter("status");
	if(Status.equalsIgnoreCase("1"))
	{
		request.setAttribute("status1", "fdsfds");
	}
	else
	{
		request.setAttribute("status2", "DSfsdfds");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userDAO.checkAccount(username, password);
		request.setAttribute("user", user);
	}
	long interestMoney;

	if(bsb.getTypeOfSaving().equalsIgnoreCase("tiet kiem thuong"))
	{
		request.setAttribute("status3", "dddd");
	}
	
	interestMoney = bsb.tinhtienlaihientai(bsb.getMoney(),bsb.getStartDate(),bsb.getInterestRate().getInterestRate(),bsb.getInterestTerm());

	request.setAttribute("tienlaihientai", interestMoney);
	RequestDispatcher requestdispatcher = request.getRequestDispatcher("/xemthongtinso.jsp");
	try {
		requestdispatcher.forward(request, response);
	} catch (ServletException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

//tinh tien lai cua so tiet kiem den thoi diem tinh lai

private void tinhLaiHetDinhKy(HttpServletRequest request, HttpServletResponse response) {
	
	int bookid = Integer.parseInt(request.getParameter("bookid"));
	String Status = request.getParameter("status");
	if(Status.equalsIgnoreCase("1"))
	{
		request.setAttribute("status1", "fdsfds");
	}
	else
	{
		request.setAttribute("status2", "DSfsdfds");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userDAO.checkAccount(username, password);
		request.setAttribute("user", user);
	}
	BankSavingBook bsb = bookDAO.searchBook(bookid);
	request.setAttribute("book", bsb);
	if(bsb.getTypeOfSaving().equalsIgnoreCase("tiet kiem thuong"))
	{
		request.setAttribute("status3", "dddd");
	}
	long interestMoney = bsb.tinhtienlaidinhky(bsb.getMoney(),bsb.getInterestRate().getInterestRate(),bsb.getInterestTerm());
	request.setAttribute("tienlaihetdinhky", interestMoney);
	RequestDispatcher requestdispatcher = request.getRequestDispatcher("/xemthongtinso.jsp");
	try {
		requestdispatcher.forward(request, response);
	} catch (ServletException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

private void showMoso(HttpServletRequest request, HttpServletResponse response) {
	
	
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	User user = userDAO.checkAccount(username, password);
	request.setAttribute("user", user);
	RequestDispatcher dispatcher = request.getRequestDispatcher("moso.jsp");
	try {
		dispatcher.forward(request, response);
	} catch (ServletException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

private void showRutso(HttpServletRequest request, HttpServletResponse response) {
	
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	User user = userDAO.checkAccount(username, password);
	request.setAttribute("user", user);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("rutso.jsp");
	try {
		dispatcher.forward(request, response);
	} catch (ServletException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

private void showTinhlai(HttpServletRequest request, HttpServletResponse response) {
	
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	User user = userDAO.checkAccount(username, password);
	request.setAttribute("user", user);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("rutso.jsp");
	try {
		dispatcher.forward(request, response);
	} catch (ServletException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

private void rutso(HttpServletRequest request, HttpServletResponse response) {
	
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	User user = userDAO.checkAccount(username, password);
	request.setAttribute("user", user);
	int bookid = Integer.parseInt(request.getParameter("bookid"));
	BankSavingBook bsb = bookDAO.searchBook(bookid);
	bookDAO.rutSo(bsb);
	RequestDispatcher requestdispatcher = request.getRequestDispatcher("/staffscreen.jsp");
	try {
		requestdispatcher.forward(request, response);
	} catch (ServletException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

private void moso(HttpServletRequest request, HttpServletResponse response) {
	
		String fullname = request.getParameter("fullname");
		String dob = request.getParameter("dob");
		String address = request.getParameter("address");
		String phonenumber = request.getParameter("phonenumber");
		String email = request.getParameter("email");
		String idcard = request.getParameter("idcard");
		String typeofsaving = request.getParameter("typeofsaving");
		if(typeofsaving.equalsIgnoreCase("Tiết kiệm thường"))
		{
			typeofsaving = "tiet kiem thuong";
		}
		else
		{
			typeofsaving="tiet kiem phat loc";
		}
		String branch = request.getParameter("branch");
		String term = request.getParameter("term");
		double money = Double.parseDouble(request.getParameter("money"));
		int time = Integer.parseInt(term);
		User user = userDAO.searchUserByidCard(idcard);
		if(user == null)
		{
		user= new User();
		user.setFullname(fullname);
		user.setDob(dob);
		user.setAddress(address);
		user.setPhonenumber(phonenumber);
		user.setEmail(email);
		user.setIdCard(idcard);
		user.setRole("khach hang");
		userDAO.addUser(user);
		}
		else
		{
			if(!user.getPhonenumber().equalsIgnoreCase(phonenumber))
			{
				user.setPhonenumber(phonenumber +" "+user.getPhonenumber());
			}
		}
		InterestRate ir = interestDAO.getInterestRateByTerm_Type(time, typeofsaving);
		BankSavingBook bsb = new BankSavingBook();
		bsb.setInterestRate(ir);
		bsb.setBranch(branch);
		bsb.setTypeOfSaving(typeofsaving);
		bsb.setMoney(money);
		bsb.setInterestTerm(time);
		bsb.setStartDate(java.time.LocalDate.now().toString());
		bsb.setPeriodic(0);
		bsb.setUser(user);
		bsb.setCheckk(0);
		bookDAO.insertBook(bsb);
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user2 = userDAO.checkAccount(username, password);
		request.setAttribute("user", user2);
		RequestDispatcher requestdispatcher = request.getRequestDispatcher("/staffscreen.jsp");
		try {
			requestdispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}





