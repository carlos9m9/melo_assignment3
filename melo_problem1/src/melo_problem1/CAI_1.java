package melo_problem1;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI_1 {
	//Declaration of numbers to use with the SecureRandom object
	Scanner s = new Scanner(System.in);
	private SecureRandom sr = new SecureRandom();
	private int num1 = sr.nextInt(9);
	private int num2 = sr.nextInt(9);
	
	//Main method
	public static void main (String[]args) {
		CAI_1 c1 = new CAI_1();
		c1.quiz();
	}

	/*Quiz method asks the question through askQuestion, receives a response through readResponse()
	and passes said response into the isAnswerCorrect method*/
	void quiz() {
		askQuestion();
		int ans = readResponse();
		isAnswerCorrect(ans);
	}
	
	void askQuestion() {
		System.out.println("How much is "+num1+" times "+num2+"?" );
	}
	
	private int readResponse() {
		int ans = s.nextInt();
		return ans;
	}
	
	//Simple if else statement to decide whether the answer was correct or not
	void isAnswerCorrect(int ans) {
		if(ans==(num1*num2)) {
			displayCorrectResponse();
		}else {
			displayIncorrectResponse();
		}
		
	}
	
	void displayCorrectResponse() {
		System.out.println("Very good!");
	}
	
	void displayIncorrectResponse() {
		System.out.println("No, please try again.");
		/*If the answer is incorrect we call the method quiz()
		to start back from the moment the question was asked*/
		quiz();
	}
}
