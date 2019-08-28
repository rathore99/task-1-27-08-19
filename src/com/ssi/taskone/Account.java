package com.ssi.taskone;

/************************** task 1 *********************************/
public class Account {
	/* instance variables of Account class */
	private int accountNo;
	private String accountHolderName;
	private double accountBalance;
	private String accountType;

	/*---------------- end instance var--------------*/

	/* class variables */
	public static double totalWithdrawalAmount;
	public static int withdrawalCount; // count withdrawals done by users
	public static double totalDepositAmount;
	public static int depositCount; // count deposits done by users
	public static double bankBalance; // to store total amount present in bank
	/*---------------------------end-----------------*/

	/*----------- constructors-------------------*/

	public Account(int accountNo, String accountHolderName, double accountBalance, String accountType) {

		this.accountNo = accountNo;
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
		this.accountType = accountType;
		bankBalance=bankBalance+accountBalance;
	}

	public Account() {
		// TODO Auto-generated constructor stub
	}

	/*------------------------end of constuctors-------------------*/

	/*----------------- getter and setter methods--------------*/
	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	/*------------------------ END getter setter ----------------*/

	/* method for initialization of account */
	public void createAccount(int accountNo, String accountHolderName, double accountBalance, String accountType) {
		this.setAccountNo(accountNo);
		this.setAccountHolderName(accountHolderName);
		this.setAccountBalance(accountBalance);
		this.setAccountType(accountType);
		bankBalance= bankBalance+this.getAccountBalance();
	}

	/* Method to display account info */
	public void showAccountdetails() {
		System.out.println("#--------------Account Details----------------------#\n");
		System.out.println("Account details are :");
		System.out.println("Acc. No: " + this.getAccountNo());
		System.out.println("Account Holder Name: " + this.getAccountHolderName());
		System.out.println("Balance: " + this.getAccountBalance());
		System.out.println("Account Type: " + this.getAccountType());
		System.out.println("#-------------------END----------------------------#\n");
		
	}

	/* method to withdraw amount */
	public void withdraw(double amount) {
		// check available balance is sufficient for withdrawal or not
		System.out.println("#----------Withdraw----------#");
		System.out.println("amount withdrawen: "+ amount);
		if (amount <= this.getAccountBalance()) {
			this.setAccountBalance(this.getAccountBalance() - amount);
			
			System.out.println(this.getAccountHolderName()+"("+this.getAccountNo()+")"+
					" your new account balance is\n balance: " + this.getAccountBalance());
				
				trackTransactions(amount, "withdraw");
		} else
			System.out.println("insufficint balance to withdraw ...bal:" + this.getAccountBalance()); // low balance
      System.out.println("#--------------END----------------------------------#\n");
	}

	/* method for depositing amount in bank */
	public void depositAmount(double amount) {
		System.out.println("#----------DEposit---------#");
		System.out.println("amount deposited: "+ amount);
		this.setAccountBalance(this.getAccountBalance() + amount);
		System.out.println(this.getAccountHolderName()+"("+this.getAccountNo()+")"+
				" your new account balance is balance: " + this.getAccountBalance());		
		trackTransactions(amount, "deposit"); // to update transaction details
		System.out.println("#---------END-------------------#\n");
	}
	
	/* method to  maintain records of total deposits and total withdrawals*/
	public static void trackTransactions(double amount, String transactionType)
	{
		if(transactionType =="withdraw"){
		totalWithdrawalAmount = totalWithdrawalAmount + amount;
		withdrawalCount += 1;
		bankBalance = bankBalance - amount;
		}
		else if(transactionType =="deposit"){
			depositCount += 1;
			totalDepositAmount = totalDepositAmount + amount;
			bankBalance = bankBalance + amount;
			}
	}
    /* method to display total deposits and total withdrawals*/
	public static void showTransactionDetails() {
		System.out.println("\n#---------Bank Info------------------------#__");
		System.out.println("No of withdrawals done by user is: " + withdrawalCount
				+ "\n Total amount  withdrawed from bank: " + totalWithdrawalAmount);
		System.out.println("total deposit operation done by user is: "+ depositCount
				+ " \nTotal amount  deposited in bank: " + totalDepositAmount);
		System.out.println("bank balance: "+ bankBalance);
		System.out.println("#--------------END----------------------#\n");
	}

	public static double calculateAvg(Account... users) {

		// Object user;
		double sum = 0;
		for (Account user : users) {
			sum = sum + user.getAccountBalance();
		}
		double avgValue = sum / users.length;
		return avgValue;
	}

}
