package melo_problem1;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI_2 {
	//Declaration of numbers to use with the SecureRandom object
	Scanner s = new Scanner(System.in);
	private SecureRandom sr = new SecureRandom();
	private int num1 = sr.nextInt(9);
	private int num2 = sr.nextInt(9);
	//Set a range for the random number generated used in the switch statement, set a range from 1-4
	private int max = 4;
	private int min = 1;
	private int message = sr.nextInt((max - min) + 1) + min;
	
	//Main method
	public static void main (String[]args) {
		CAI_2 c2 = new CAI_2();
		c2.quiz();
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
		switch(message) {
		case 1:
			System.out.println("Very good!");
			break;
		case 2:
			System.out.println("Excellent!");
			break;
		case 3:
			System.out.println("Nice Work!");
			break;
		case 4:
			System.out.println("Keep up the good work!");
			break;
		}
	}
	
	void displayIncorrectResponse() {
		switch(message) {
		case 1:
			System.out.println("No. Please try again.");
			break;
		case 2:
			System.out.println("Wrong. Try once more.");
			break;
		case 3:
			System.out.println("Don’t give up!");
			break;
		case 4:
			System.out.println("No. Keep trying.");
			break;
		}
		/*If the answer is incorrect we call the method quiz()
		to start back from the moment the question was asked*/
		quiz();
	}
}
