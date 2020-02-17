package melo_problem1;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI_5 {
	//Declaration of numbers to use with the SecureRandom object
	Scanner s = new Scanner(System.in);
	private SecureRandom sr = new SecureRandom();
	//ansCount keeps track of the number of questions asked and rightAns is used to calculate score
	private int ansCount, rightAns, level, pick;
	//Array is going to contain the arithmetic symbols for the mixture problem set
	private char symbols[]= new char[4];
	
	//Main method
	public static void main (String[]args) {
		CAI_5 c5 = new CAI_5();
		c5.quiz();
	}

	/*Quiz method asks the question through askQuestion, receives a response through readResponse()
	and passes said response into the isAnswerCorrect method*/
	void quiz() {
		if(ansCount==0){
			//Method is only called when no questions have been asked yet
			level = readDifficulty();
			pick = readProblemType();
		}else if(ansCount==10) {
			displayCompletitionMessage();
			askToContinue();
		}
		int num1 = generateQuestionArgument(level);
		int num2 = generateQuestionArgument(level);
		//Key is the arithmetic symbol which is passed on to determine if the answer is correct
		char key = askQuestion(num1,num2);
		int ans = readResponse();
		isAnswerCorrect(ans, num1, num2, key);
	}
	
	private int readDifficulty() {
		System.out.println("Enter a difficulty level (1-4):");
		int level = s.nextInt();
		return level;
	}
	
	private int readProblemType() {
		System.out.println("What kind of problem set would you like to solve?");
		System.out.println("1. Addition\r\n2. Multiplication\r\n3. Subtraction\r\n4. Division\r\n5. Mixed");
		int p = s.nextInt();
		return p;
	}

	//Calculates score and display the right message
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
	
	//Refactored my old method to generate the number and used a switch statement
	private int generateQuestionArgument(int level) {
		int n = 0;
		switch(level) {
		case 1:
			n = sr.nextInt(9);
			break;
		case 2:
			n = sr.nextInt(99);
			break;
		case 3:
			n = sr.nextInt(999);
			break;
		case 4:
			n = sr.nextInt(9999);
			break;
		}
		return n;
	}
	
	private char askQuestion(int num1, int num2) {
		char key = 0;
		symbols[0] = '+';
		symbols[1] = '*';
		symbols[2] = '-';
		symbols[3] = '/';
		
		switch(pick){
		case 1:
			System.out.println("How much is "+num1+" + "+num2+"?");
			break;
		case 2:
			System.out.println("How much is "+num1+" * "+num2+"?");
			break;
		case 3:			
			System.out.println("How much is "+num1+" - "+num2+"?");
			break;
		case 4:
			System.out.println("How much is "+num1+" / "+num2+"?");
			break;
		case 5:
			//setKey simply generates a random index for the question to be asked
			key = symbols[setKey()];
			System.out.println("How much is "+num1+" "+key+" "+num2+"?");
			break;
		}
		return key;
	}
	
	private int setKey() {
		int n = sr.nextInt(3);
		return n;
	}

	private int readResponse() {
		int ans = s.nextInt();
		return ans;
	}
	
	//Method uses key only if the user picked 5 for the type of problem set
	void isAnswerCorrect(int ans, int num1, int num2, char key) {
		if(pick==5) {
			if(key=='+' && (ans==(num1+num2))) {
				displayCorrectResponse();
			}else if(key=='*' && (ans==(num1*num2))) {
				displayCorrectResponse();
			}else if(key=='-' && (ans==(num1-num2))) {
				displayCorrectResponse();
			}else if(key=='/' && (ans==(num1/num2))) {
				displayCorrectResponse();
			}else {
				displayIncorrectResponse();
			}
		}else if((ans==(num1+num2)) && pick==1) {
			displayCorrectResponse();
		}else if((ans==(num1*num2)) && pick==2) {
			displayCorrectResponse();
		}else if((ans==(num1-num2)) && pick==3) {
			displayCorrectResponse();
		}else if((ans==(num1/num2)) && pick==4) {
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
