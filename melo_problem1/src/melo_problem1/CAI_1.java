package melo_problem1;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI_1 {
	
	
	public static void main (String[]args) {
		Scanner s = new Scanner(System.in);
		SecureRandom r = new SecureRandom();
		int num1 = r.nextInt(9);
		int num2 = r.nextInt(9);
		
		
		int i=0;
		while(i==0) {
			System.out.println("How much is "+num1+" times "+num2+"?" );
			int answer = s.nextInt();
			if(answer == (num1*num2)) {
				System.out.println("Very good!");
				i++;
			}else{
				System.out.println("No, please try again.");
			}
		}
		s.close();
	}
}
