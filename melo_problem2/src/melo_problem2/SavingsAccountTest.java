package melo_problem2;

public class SavingsAccountTest {

	public static void main(String[] args) {
		SavingsAccount saver1 = new SavingsAccount(2000.00);
		SavingsAccount saver2 = new SavingsAccount(3000.00);
		
		SavingsAccount.modifyInterestRate(4);
		
		saver1.calculateMonthlyInterest();
		saver1.calculateBalance();
		
		saver2.calculateMonthlyInterest();
		saver2.calculateBalance();
		
		SavingsAccount.modifyInterestRate(5);
		
		saver1.calculateMonthlyInterest();
		saver1.calculateBalance();
		
		saver2.calculateMonthlyInterest();
		saver2.calculateBalance();
		
	}

}
