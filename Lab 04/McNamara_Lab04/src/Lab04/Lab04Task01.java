// Timothy McNamara
// Lab 04
// 5/23/2024
// CIT 27000

package Lab04;

import java.util.Random;
import java.util.Scanner;


public class Lab04Task01 {
	public static void main(String[] args) {
		// The following two lines of code will create both a scanner for
		// the user's input and generate a random number. 
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        // These arrays are used as random message outputs that can 
        // occur based on the user's input. Either negative and positive
        // feedback will be shown. 
        String[] theMostPositiveFeedback = {"You are gifted.", 
        		"You're a God. Great Job.", "Keep it up buttercup!"};
        String[] theMostNegativeFeedback = {"Incorrect Loser, try again.", 
        		"Please be serious.", "Wow. Big L. Onto the next. Try again."};
        
        // This is the loop of the lab, this will not be broken out of 
        // unless the the user (elementary student) will answer no
        // to the prompt at the end of the ten questions. 
        while (true) {
        	// The following four lines of code will prompt
        	// the user for the level and problem type they
        	// would like to answer
            System.out.println("Pick a level (1, 2, or 3) please. ");
            int lvl = scanner.nextInt();
            System.out.println("Select a problem type. (1, 2, 3, or 4) ");
            int typeOProblemSelected = scanner.nextInt();

            // If the user enters a number outside of the alloted/given 
            // range, the string message will occur.
            if (lvl < 1 || lvl > 3 || typeOProblemSelected < 1 || typeOProblemSelected > 4) {
                System.out.println("READ again, Select a problem type. (1, 2, 3, or 4)");
                continue;
            }

            // This will count the number of correct answers
            int correctAnswerCount = 0;
            // This for loop is used to ask 10 questions. Depending on the
            // level of difficulty selected, it will use the switch case to 
            // determine the level of difficulty of problems.
            for (int i = 0; i < 10; i++) {
            	// The following three lines of code will  generate a random number
            	// based on the level selected. if level 1 is selected, then the
            	// range will be 0-9, level 2 is 0-99, and level 3 is 0-999
                int operand1 = (random.nextInt((int) Math.pow(10, lvl))-1);
                int operand2 = (random.nextInt((int) Math.pow(10, lvl))-1);
                int operand3 = (random.nextInt((int) Math.pow(10, lvl))-1);
                
                if (operand1 < 0)
                	operand1++;
                if (operand2 < 0)
                	operand2++;
                if (operand3 < 0)
                	operand3++;

                // This displays the problem to the user
                System.out.println("Problem Number " + (i+1) + ": ");
                System.out.println(operand1 + ", " + operand2 + ", " + operand3);

                // The correct answer is initialized to zero. The correct answer is then
                // calculated based upon the "difficulty" selected. The answer to the 
                // problems will either be the sum (1), sum divided by 3 equaling the 
                // average (2), selecting the largest number (3), or the smallest number
                // (4). The difficulty option is relative. 
                int correctAnswer = 0;
                switch (typeOProblemSelected) {
                    case 1:
                        correctAnswer = operand1 + operand2 + operand3;
                        break;
                    case 2:
                        correctAnswer = (operand1 + operand2 + operand3) / 3;
                        break;
                    case 3:
                        correctAnswer = Math.max(Math.max(operand1, operand2), operand3);
                        break;
                    case 4:
                        correctAnswer = Math.min(Math.min(operand1, operand2), operand3);
                        break;
                }

                // Retrieve the answer
                System.out.println("What is the solution? ");
                int userInputtedAnswer = scanner.nextInt();

                // If the answer inputed is the correct one,
                // the we will increment the number of correct answers.
                // A prompt will be shown to the user depending on their correct
                // or incorrect answer.
                if (userInputtedAnswer == correctAnswer) {
                    correctAnswerCount++;
                    System.out.println(theMostPositiveFeedback[random.nextInt(3)]);
                } else {
                    System.out.println(theMostNegativeFeedback[random.nextInt(3)]);
                }
            }

            // Display the number of correct answers.
            System.out.println(correctAnswerCount + " out of 10 correct.");

            // Querying the user if they want to play again
            System.out.println("Do you want to play again? (yes/no)");
            String playAgainOption = scanner.next();
            if (!playAgainOption.equals("yes") || !playAgainOption.equals("Yes")) {
            	// End the infinite while loop
                break;
            }
        }
	}
}
