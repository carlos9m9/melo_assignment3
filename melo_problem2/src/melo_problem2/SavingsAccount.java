package melo_problem2;

public class SavingsAccount {
	private static double annualInterestRate;
	private double savingBalance;
	private double monthlyInterest;
	
	public SavingsAccount(double balance) {
		savingBalance = balance;
	}
	
	public static void modifyInterestRate(double newAnnual) {
		annualInterestRate = newAnnual;
	}
	
	public void calculateMonthlyInterest() {
		monthlyInterest = (savingBalance * annualInterestRate)/12;
		System.out.printf("Monthly interest: $%.2f\r\n",monthlyInterest);
	}
	
	public void calculateBalance() {
		savingBalance += monthlyInterest;
		System.out.printf("Your balance is: $%.2f\r\n\r\n",savingBalance);
	}
}
