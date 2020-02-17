package melo_problem1;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI_3 {
	//Declaration of numbers to use with the SecureRandom object
	Scanner s = new Scanner(System.in);
	private SecureRandom sr = new SecureRandom();
	//ansCount keeps track of the number of questions asked and rightAns is used to calculate score
	private int ansCount = 0;
	private int rightAns = 0;
	
	//Main method
	public static void main (String[]args) {
		CAI_3 c3 = new CAI_3();
		c3.quiz();
	}

	/*Quiz method asks the question through askQuestion, receives a response through readResponse()
	and passes said response into the isAnswerCorrect method*/
	void quiz() {
		if(ansCount==10) {
			displayCompletitionMessage();
			askToContinue();
		}
		int num1 = setNum();
		int num2 = setNum();
		askQuestion(num1,num2);
		int ans = readResponse();
		isAnswerCorrect(ans, num1, num2);
	}
	
	//Calculates score and display the appropiat message
	private void displayCompletitionMessage() {
		double score = ((double)rightAns/10)*100;
		System.out.println("\r\nYour score is: "+score+"%");
		if(score<75) {
			System.out.println("Please ask your teacher for extra help.");
		}else if(score>=75){
			System.out.println("Congratulations, you are ready to go to the next level!");
		} 
	}
	
	//This method resets or terminates the program upon user input
	private void askToContinue() {
		System.out.println("Would you like to solve a new set? Y/N");
		char ans = s.next().charAt(0);
		
		if(Character.toUpperCase(ans) == 'Y') {
			//Reset program
			ansCount = 0;
			rightAns = 0;
			quiz();
		} else if (Character.toUpperCase(ans) == 'N') {
			System.exit(0);
		}
	}
	
	//Method generates random number when called
	private int setNum() {
		int n = sr.nextInt(9);
		return n;
	}
	
	void askQuestion(int num1, int num2) {
		System.out.println("How much is "+num1+" times "+num2+"?" );
	}
	
	private int readResponse() {
		int ans = s.nextInt();
		return ans;
	}
	
	//Simple if else statement to decide whether the answer was correct or not
	void isAnswerCorrect(int ans, int num1, int num2) {
		if(ans==(num1*num2)) {
			displayCorrectResponse();
		}else {
			displayIncorrectResponse();
		}
		
	}
	
	void displayCorrectResponse() {
		//Set a range for the random number generated used in the switch statement, set a range from 1-4
		int max = 4;
		int min = 1;
		int message = sr.nextInt((max - min) + 1) + min;
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
		rightAns++;
		ansCount++;
		quiz();
	}
	
	void displayIncorrectResponse() {
		//Set a range for the random number generated used in the switch statement, set a range from 1-4
		int max = 4;
		int min = 1;
		int message = sr.nextInt((max - min) + 1) + min;
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
		ansCount++;
		/*If the answer is incorrect we call the method quiz()
		to start back from the moment the question was asked*/
		quiz();
	}
}
