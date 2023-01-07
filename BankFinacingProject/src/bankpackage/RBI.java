package bankpackage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class RBI {
	public static void main(String[] args) {
	
		java.util.Date date =new java.util.Date();
		System.out.println("\n");
		System.out.println("************************************************************************************");
		System.out.println("\n");
	
		System.out.println("~~~~~~~~~~~~~~~~~~  Welcome to National of Banking System RBI  ~~~~~~~~~~~~~~~~~~~~ ");
		System.out.println("\n");
		System.out.println("************************************************************************************");
		System.out.println("\n");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("Have a nice Day ...!                          Date&Time: "+date);
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("\n");
		
		System.out.println("Do you want to open an Account : 1.Yes 2. No    |      You can say only 'YES' OR 'NO '");
		
		Scanner sc =new Scanner(System.in);
		String choice =sc.nextLine();
		
		if(choice.equalsIgnoreCase("yes")) {
			OpenAccount obj =new OpenAccount();
			obj.createAccount();
		}
		if(choice.equalsIgnoreCase("No")) {
			BankAccount obj1 =new BankAccount();
			obj1.ShowMenu();
		}
		
	}

}

class BankAccount{
	int balance;
	int previousTransction;
	String customerName;
	String customerId;
	String accountType;
	double totalInterest;
	double totalInterest1;
	
	void calculateInterest(double balance) {
		System.out.println("What Type of Account you have :1. Saving 2. Current");
		Scanner sc =new Scanner(System.in);
		int choice =sc.nextInt();
		
		if(choice==1) {
			accountType="Saving";
			int r =3;
			int t;
			System.out.println("Enter year to calculate Interest");
			t=sc.nextInt();
			
			double finalAmount =(balance*r*t)/100;
			
			totalInterest =finalAmount;
			System.out.println("Total Interest you Earned is :"+ totalInterest);
			
		}
		if(choice==2) {
			
			accountType="Current";
			int r =7;
			int t,n;
			System.out.println("Enter year to calculate Interest");
			t=sc.nextInt();
			System.out.println("Enter the frequency that interest has been compound in a year");
			n=sc.nextInt();
			
			try {
			
            double finalAmount1 = (balance*(Math.pow((1+r/n),n*t)));
			
			totalInterest1 =finalAmount1;
			System.out.println("Total Interest you Earned is :"+ totalInterest1);
			
			}catch (NoSuchElementException e) {
				System.out.println("Total Interest you Earned is :"+ totalInterest1);
			}
		}
	}
	void deposit(int amount ) {
		if(amount !=0)
		{
			balance = balance+amount;
			System.out.println("Balance after deposit :"+balance);
			previousTransction =amount;
		}
	}
	void withdraw(int amount) {
		if(amount != 0)
		{
			balance =balance-amount;
			System.out.println("Balance after Withdraw :"+balance);
			previousTransction =-amount;
		}
	}
	void getpreviousTransction() {
		FileOutputStream out;
		PrintStream p;
		
		try {
			out =new FileOutputStream ("test.txt");
			p =new PrintStream(out);
			
			if(previousTransction > 0) {
				p.append("Deposited: "+previousTransction);
				System.out.println("Deposited: "+previousTransction);
			}else if(previousTransction < 0) {
				p.append("WithDraw: "+previousTransction);
				System.out.println("WithDraw: "+Math.abs(previousTransction));
				
			}else {
				System.out.println("No Transaction Occured");
			}
			p.close();
		}catch (Exception e) {
			System.err.println("Error in Printing the data "+e);
		}
	}
	void ShowMenu() {
		char option ='\0';
		Scanner sc =new Scanner(System.in);
		System.out.println("Welcome to the Menu option which you want please Enter the Option ex : 'A' ");
		System.out.println("\n");
		System.out.println("A. Check Balance ");
		System.out.println("B. Deposit Amount");
		System.out.println("C. WithDraw Amount");
		System.out.println("D. See previous Transction");
		System.out.println("E. Calculate Interest");
		System.out.println("F. Exit ");
		
		do {
			System.out.println("********************************************************");
			System.out.println(" Enter a Menu Option to continue check status & details");
			System.out.println("********************************************************");
			option =sc.next().charAt(0);
			System.out.println("\n");
			
			switch (option) {
			case 'A':
				System.out.println("----------------------------------------------------------");
				System.out.println("Balance = "+balance);
				System.out.println("\n");
				break;
			case 'B':
				System.out.println("----------------------------------------------------------");
				System.out.println("Enter an amount to deposit :");
				int amount =sc.nextInt();
				deposit(amount);
				System.out.println("\n");
				break;
			case 'C':
				System.out.println("----------------------------------------------------------");
				System.out.println("Enter an amount to WithDraw :");
				int amount2 =sc.nextInt();
				withdraw(amount2);
				System.out.println("\n");
				break;
			case 'D':
				System.out.println("----------------------------------------------------------");
				getpreviousTransction();
				System.out.println("\n");
				break;
			case 'E':
				System.out.println("----------------------------------------------------------");
				calculateInterest(balance);
				System.out.println("\n");
				break;
			case 'F':
				System.out.println("----------------------------------------------------------");
				break;
			default :
				System.out.println("Entered the invalid option ..! please try again");
				break;
				
				
			}
		}while (option !='F');
		{
			System.out.println("Thanking you for using our services ");
			System.out.println(" Have a good day..!"); 
			System.out.println("----------------------------------------------------------");
			sc.close();
	}
	}
		
		
	}
	
	
			
		
		
		
		
		
		
		
		
		
		
		
		
		
	

