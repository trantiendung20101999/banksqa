package model;

import java.util.Date;

public class BankSavingBook {

	private int id;
	private InterestRate interestRate;
	private User user;
	private double money;
	private String branch;
	private String typeOfSaving;
	private int interestTerm;
	private int periodic;
	private String startDate;
	private int checkk;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public InterestRate getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(InterestRate interestRate) {
		this.interestRate = interestRate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getTypeOfSaving() {
		return typeOfSaving;
	}
	public void setTypeOfSaving(String typeOfSaving) {
		this.typeOfSaving = typeOfSaving;
	}
	public int getInterestTerm() {
		return interestTerm;
	}
	public void setInterestTerm(int interestTerm) {
		this.interestTerm = interestTerm;
	}
	public int getPeriodic() {
		return periodic;
	}
	public void setPeriodic(int periodic) {
		this.periodic = periodic;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public int getCheckk() {
		return checkk;
	}
	public void setCheckk(int checkk) {
		this.checkk = checkk;
	}
	public BankSavingBook(InterestRate interestRate, User user, double money, String branch, String typeOfSaving,
			int interestTerm, int periodic, String startDate, int checkk) {
		super();
		this.interestRate = interestRate;
		this.user = user;
		this.money = money;
		this.branch = branch;
		this.typeOfSaving = typeOfSaving;
		this.interestTerm = interestTerm;
		this.periodic = periodic;
		this.startDate = startDate;
		this.checkk = checkk;
	}
	public BankSavingBook(int id, InterestRate interestRate, User user, double money, String branch,
			String typeOfSaving, int interestTerm, int periodic, String startDate, int checkk) {
		super();
		this.id = id;
		this.interestRate = interestRate;
		this.user = user;
		this.money = money;
		this.branch = branch;
		this.typeOfSaving = typeOfSaving;
		this.interestTerm = interestTerm;
		this.periodic = periodic;
		this.startDate = startDate;
		this.checkk = checkk;
	}
	public BankSavingBook() {
		super();
	}
	@Override
	public String toString() {
		return "BankSavingBook [id=" + id + ", interestRate=" + interestRate + ", user=" + user + ", money=" + money
				+ ", branch=" + branch + ", typeOfSaving=" + typeOfSaving + ", interestTerm=" + interestTerm
				+ ", periodic=" + periodic + ", startDate=" + startDate + ", checkk=" + checkk + "]";
	}
	
	public long tinhtienlaidinhky(double money,double interestRate, int term)
	{
		if(money < 1000000)
			return -1;
		double interestmoney=0;
		
		interestmoney = (money * term*30 * interestRate/100)/365;
		
		System.out.println(Math.round(interestmoney*10)/10);
		return Math.round(interestmoney*10)/10;
	}

	public long tinhtienlaihientai(double money,String date,double interestRate,int term)
	{
		if(money<1000000)
		{
			return -1;
		}
		
		double interestmoney=0;
		
		int day_instance = dayinstance(date);
		
		if(day_instance==-1)
		{
			return -1;
		}
		
		else if(day_instance <term*30)
		interestmoney = (money * day_instance * 1.5/100)/365 ;
		
		else
		{
			double interestmoney1 = (money * term * 30 * interestRate/100)/365;
			interestmoney = (interestmoney1 * day_instance * 1.5/100)/365 + interestmoney1;
		}
		System.out.println(day_instance);
		System.out.println(Math.round(interestmoney*10)/10);
		return Math.round(interestmoney*10)/10;
	}
	public int dayinstance(String date) 
	{
		
		int year = Integer.parseInt(date.substring(0, 4));
		int month =Integer.parseInt( date.substring(5, 7));
		int day =Integer.parseInt( date.substring(8,10));
		
		String datenow=java.time.LocalDate.now().toString();
		int yearnow =Integer.parseInt(datenow.substring(0, 4));
		int monthnow =Integer.parseInt(datenow.substring(5, 7));
		int daynow =Integer.parseInt(datenow.substring(8,10));
		
		int year_instance = yearnow-year;
		int month_instance=0;
		int day_instance=0;
		if(year_instance ==0)
		{
		month_instance = monthnow-month;
			if(month_instance==0)
			{
				day_instance = daynow-day;
				if(day_instance <0)
				{
					return -1;
				}
				else
				{
					return day_instance;
				}
			}
			else if(month_instance >0)
			{
				day_instance = month_instance*30+daynow-day;
			}
			else
			{
				return -1;
			}
		}
		else if(year_instance>0)
		{
			month_instance =year_instance*12 +monthnow-month;
			day_instance = month_instance*30+daynow-day;
		}
		else
		{
			return -1;
		}
		
		return day_instance;
		
	}
	
	
}
