package com.ssi.taskone;

public class BankAccounts {
	
	
	public static void main(String[] args) {
		
	/*	
		System.out.println("----------------Welcome to xyz Bank----------------");
		System.out.println("Service available are ");
		System.out.println("1.Display Account Details ");
		System.out.println("2.Withdraw amount");
		System.out.println("3.Deposit amount");
		System.out.println("4.get balance ");
		System.out.println("5. toal withdrwal amount");
		System.out.println("6. toal deposited amount");
		*/
		Account objUser1 = new Account(2901,"Aman",0,"Saving");
		//System.out.println(objUser1.getAccountBalance());
		objUser1.showAccountdetails();
		objUser1.withdraw(500);
		objUser1.depositAmount(10000);
		objUser1.withdraw(500);
		Account.showTransactionDetails();
		System.out.println("Average of 1 user: "+Account.calculateAvg(objUser1));
		
		/* object 2-------------------*/
		Account objUser2 = new Account(2902,"anuj",10000,"Saving");
		//System.out.println(objUser1.getAccountBalance());
		objUser2.showAccountdetails();
		objUser2.withdraw(5000);
		objUser2.depositAmount(10000);
		objUser2.withdraw(150000);
		Account.showTransactionDetails();
		System.out.println("Average of 2 user: "+Account.calculateAvg(objUser1,objUser2));
		/* object 3------------------*/
		Account objUser3 = new Account(2909,"Rahul",98765,"Saving");
		//System.out.println(objUser1.getAccountBalance());
		objUser3.showAccountdetails();
		objUser3.withdraw(500);
		objUser3.depositAmount(10000);
		objUser3.withdraw(500);
		Account.showTransactionDetails();
		System.out.println("Average of 3 user: "+Account.calculateAvg(objUser1,objUser2,objUser3));
		
		/* object 4*/
		Account objUser4 = new Account(2901,"Vinod",0,"Saving");
		//System.out.println(objUser1.getAccountBalance());
		objUser4.showAccountdetails();
		objUser4.withdraw(500);
		objUser4.depositAmount(10000);
		objUser4.withdraw(500);
		Account.showTransactionDetails();
		System.out.println("Average of 4 user: "+Account.calculateAvg(objUser1,objUser2,objUser3,objUser4));
	}

}
