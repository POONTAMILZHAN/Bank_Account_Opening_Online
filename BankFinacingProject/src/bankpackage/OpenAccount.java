package bankpackage;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class OpenAccount {
	String name;
	int accountNum;
	String accountType;
	String dob;
	String bank;
	
			

	public void createAccount() {
        Scanner sc =new Scanner(System.in);
        
        
		
		System.out.println("In which bank you want to open your account it: 1. SBI  2.HDFC 3.KVB ");
		int choiceBank =sc.nextInt();
		if(choiceBank==1) {
			bank="SBI";
		}
		if(choiceBank==2) {
			bank="HDFC";
		}
		if(choiceBank==3) {
			bank="KVB";
		}
		System.out.println("Please Enter your name :");
		sc.nextLine();
		name=sc.nextLine();
		
		System.out.println("Please Enter your Date of Birth :");
	    //sc.nextLine();
		dob=sc.nextLine();
		
		System.out.println("What Type of Account you Want to open : 1. Saving 2. Current");
		int choice =sc.nextInt();
		if(choice==1) {
			accountType="Saving";
			
		}
		if(choice==2) {
			accountType="Current";
		}
		
		System.out.println("Your account has been opened with the following details ");
		System.out.println("Bank Name :"+bank);
		System.out.println("Account Holder Name :"+name);
		System.out.println("Account Type :"+accountType);
		System.out.println("IFSC NO:IFSC"+Math.random());
		System.out.println("Account Number :"+ Math.random());
		
		System.out.println("\n");
		
		BankAccount obj1 =new BankAccount();
		obj1.ShowMenu();
		sc.close();
		
	}

	

}
