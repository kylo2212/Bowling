/*	Kirstie O'Connell
		 * 	10/06/2018
		 * 	Bowling program Project #2 and Midterm 
		 * 	This program takes the score input for each frame of bowling as each roll is made.
		 *  The score is calculated for each frame and as a running total and then 
		 *  output in a scorecard to be seen by user. 
		 */
import java.util.Scanner; //used to create scanner for input of scores
import java.lang.String;

public class BowlingMidterm {

	public static void main(String[] args) {
		
		int roll1 = 0;	//holds number of pins down for scoring on first roll of frame
		int roll2 = 0;  //holds number of pins down for scoring on second roll of frame
		int fillBall = 0; //holds number for the last ball of 10th frame if needed
		int score = 0;  //holds total for that frame
		int [] gameFrame = new int [10];	//array to display the frame number of play
		String [] results = new String [] {"--","--","--","--","--","--","--","--","--","--"};	//initialized 
																	//array to show the results of frame
		int [] fScore = new int [10]; //array to show the score for that frame 
		int [] runScore = new int [10]; //array to show the running total score of game
		int frameCounter = 0; //holds which frame presently in for each iteration
		int runTotal = 0;	//holds the running score total
		//int frameScore = 0; //holds the score to figure the strike or spare calculations
		String frameResult = "";	//holds the score string result from the number form 
		
		Scanner pinsDown = new Scanner(System.in);	//creates input for pins down
		
		//The three following for loops initializes the respective arrays
		for (int idx = 0; idx < gameFrame.length; idx++)   //filling in frames array with loop
		{
			gameFrame[idx] = 1 + idx;
		}
		for (int idx = 0; idx < fScore.length; idx++)   //initializing in fScore array with loop
		{
			fScore[idx] = 0;
		}
		for (int idx = 0; idx < runScore.length; idx++)   //initializing in fScore array with loop
		{
			runScore[idx] = 0;
		}
		
		//displayAll(gameFrame, results, fScore, runScore);	//displays the initialized scoreboard
		
		//output to user 
		System.out.printf("%n%n%s%n","Welcome to Galaxy Bowling!");
		System.out.println("This is the score keeper.");
		System.out.println();

		//The beginning of the do..while loop for the game frame by frame
		do
		{
			do
			{	//out put to user and input for score
				System.out.println();
				System.out.printf("%s %d %s%n", "Frame", (frameCounter+1), "::Enter number of pins down on 1st roll: ");
				System.out.println("To exit game enter 999");
				roll1 = pinsDown.nextInt();
		
				if (roll1 == 999)	//if statement for sentinel that exits loop
				{
					System.out.println("Sorry to see you go! Come back to the Galaxy to bowl again!");
					break;
				}
				if (roll1 < 0 || roll1 > 10)	//if statement for checking validity
				{								//and using another do..while to continue 
					do 							//until a valid number is entered for roll1 of frame
					{
						System.out.println("Not a possible score. Please check numbers and reenter: ");
						roll1 = pinsDown.nextInt();
					}while(roll1<0 || roll1>10);
				}
	
				if (roll1==10)	//STRIKE
				{
					score = 10; //initial score for strike to be calculated with next frame later
					frameResult = "X";
					results[frameCounter] = "X";	//puts the frameResult into the array results
					System.out.printf("%s %d %s%s%n%n%n", "Results of Frame ", (frameCounter+1), ":  ", "STRIKE!!");	//shows the score for frame to user
					fScore[frameCounter] = score;	//enters the score value into the scoreboard in the fScore array
					gameDisplay(gameFrame, results);	//displays the scoreboard to the user
					frameCounter++;		//bumps up the count for the loop iteration for the game frames
					continue;	//to the Strike method and continues with loop iterations
				}
					
				//output to user for second roll of frame if no strike made
				System.out.printf("%s %d %s%n", "Frame", (frameCounter+1), "::Enter number of pins down on 2nd roll: ");
				roll2 = pinsDown.nextInt();	//input for second roll
				
				if ((roll2 + roll1)<0 || (roll2 + roll1)>10)	//if statement to check validity 
				{												//and using another do..while to continue
					do											//until a valid number is entered for roll2 of frame
					{
						System.out.println("Not a possible score. Please check numbers and reenter: ");
						roll2 = pinsDown.nextInt();
					}while(((roll2+roll1)<0) || ((roll2-+roll1)>10));
				}
				
				if ((roll1 + roll2)==10)	//SPARE
				{
					score = 10; //initial score for spare to be calculated with next frame later
					frameResult = (Integer.toString(roll1)+" " + "/");
					results[frameCounter] = frameResult;	//puts the frameResult into the array results
					System.out.printf("%s %d %s%s%n%n%n", "Results of Frame", (frameCounter+1), ":  ", "SPARE!!");	//shows the score for frame to user
					fScore[frameCounter] = score;	//enters the score value into the scoreboard in the fScore array
					gameDisplay(gameFrame, results);	//displays the scoreboard to the user
					frameCounter++;		//bumps up the count for the loop iteration for the game frames
					continue;	//to the Spare method and continues with loop iterations
				}	
							
				if  ((roll1 + roll2)<10)	//OPEN
				{
					score = (roll1 + roll2);	//adds the rolls to get the frame score 
					frameResult = (Integer.toString(roll1)+" "+(Integer.toString(roll2)));	//puts result string into a variable 
					System.out.printf("%s %d %s%s%n%n%n", "Results of Frame", (frameCounter+1), ":  ", frameResult);	//shows the score for frame to user
					results[frameCounter] = frameResult;	//puts the frameResult into the array results
					fScore[frameCounter] = score;	//enters the score value into the scoreboard in the fScore array
				}
				
				gameDisplay(gameFrame, results);	//displays the scoreboard to the user
				frameCounter++;		//bumps up the count for the loop iteration for the game frames
				
				
			}while(frameCounter < 9);	//when counter for the game reaches 10 the game is done
			
			if(frameCounter == 9)
			{
				results[9] = "";
				score = 0;
				//out put to user and input for score
				System.out.println();
				System.out.printf("%s %d %s%n", "Frame", (frameCounter+1), "::Enter number of pins down on 1st roll: ");
				System.out.println("To exit game enter 999");
				roll1 = pinsDown.nextInt();
			
				if (roll1 == 999)	//if statement for sentinel that exits loop
				{
					System.out.println("Sorry to see you go! Come back to the Galaxy to bowl again!");
					break;
				}
				if (roll1 < 0 || roll1 > 10)	//if statement for checking validity
				{								//and using another do..while to continue 
					do 							//until a valid number is entered for roll1 of frame
					{
						System.out.println("Not a possible score. Please check numbers and reenter: ");
						roll1 = pinsDown.nextInt();
					}while(roll1<0 || roll1>10);
				}
											
				if (roll1==10) //STRIKE
				{
					score = 10; //initial score for strike to be calculated with next frame later
					frameResult = "X";
					results[9] += frameResult;	//puts the frameResult into the array results
					//System.out.printf("%s %d %s%s%n%n%n", "Results of Frame ", (frameCounter +1), ":  ", "STRIKE!!");	//shows the score for frame to user
					fScore[9] += score;	//enters the score value into the scoreboard in the fScore array
					//gameDisplay(gameFrame, results);	//displays the scoreboard to the user
					//frameCounter++;		//bumps up the count for the loop iteration for the game frames
					//continue;	//to the Strike method and continues with loop iterations
				}
						
				//output to user for second roll of frame if no strike made
				System.out.printf("%s %d %s%n", "Frame", (frameCounter+1), "::Enter number of pins down on 2nd roll: ");
				roll2 = pinsDown.nextInt();	//input for second roll
				
				
				if (roll2==10) //STRIKE
				{
					score = 10; //initial score for strike to be calculated with next frame later
					frameResult = "X";
					results[9] += frameResult;	//puts the frameResult into the array results
					//System.out.printf("%s %d %s%s%n%n%n", "Results of Frame ", (frameCounter +1), ":  ", "STRIKE!!");	//shows the score for frame to user
					fScore[9] += score;	//enters the score value into the scoreboard in the fScore array
					//gameDisplay(gameFrame, results);	//displays the scoreboard to the user
					//frameCounter++;		//bumps up the count for the loop iteration for the game frames
					//continue;	//to the Strike method and continues with loop iterations
				}
				
				if ((roll2 + roll1)<0 || (roll2 + roll1)>10)	//if statement to check validity 
				{												//and using another do..while to continue
					do											//until a valid number is entered for roll2 of frame
					{
						System.out.println("Not a possible score. Please check numbers and reenter: ");
						roll2 = pinsDown.nextInt();
					}while(((roll2+roll1)<0) || ((roll2-+roll1)>10));
				}	
				
				if ((roll1 + roll2)==10)	//SPARE
				{
					score = 10; //initial score for spare to be calculated with next frame later
					frameResult = (Integer.toString(roll1)+ "/");
					results[9] += frameResult;	//puts the frameResult into the array results
					//System.out.printf("%s %d %s%s%n%n%n", "Results of Frame", (frameCounter +1), ":  ", "SPARE!!");	//shows the score for frame to user
					fScore[9] = score;	//enters the score value into the scoreboard in the fScore array
					//gameDisplay(gameFrame, results);	//displays the scoreboard to the user
					//frameCounter++;		//bumps up the count for the loop iteration for the game frames
					//continue;	//to the Spare method and continues with loop iterations
				}	
								
				if  ((roll1 + roll2)<10)	//OPEN
				{
					score = (roll1 + roll2);	//adds the rolls to get the frame score 
					frameResult = (Integer.toString(roll1)+" "+(Integer.toString(roll2)));	//puts result string into a variable 
					//System.out.printf("%s %d %s%s%n%n%n", "Results of Frame", (frameCounter +1), ":  ", frameResult);	//shows the score for frame to user
					results[9] += frameResult;	//puts the frameResult into the array results
					fScore[9] += score;	//enters the score value into the scoreboard in the fScore array
					//continue;
				}
				if(fScore[9]==20 || fScore[9]==10)	//for the 10th frame fill ball calculations
				{
					//output to user for fill ball roll of frame if score so far is 20 
					System.out.printf("%s %d %s%n", "Frame", (frameCounter+1), "::Enter number of pins down on fill ball: ");
					fillBall = pinsDown.nextInt();	//input for fill ball roll
					
					if ((fillBall)<0 || (fillBall)>11)	//if statement to check validity 
					{												//and using another do..while to continue
						do											//until a valid number is entered for roll2 of frame
						{
							System.out.println("Not a possible score. Please check numbers and reenter: ");
							fillBall = pinsDown.nextInt();
						}while((fillBall)<0 || (fillBall)>11);
					}
					//score = fillBall + score;
					if (fillBall < 10)
					{
						score = fillBall;
						frameResult = (Integer.toString(fillBall));
						fScore[9] += score;	//enters the score value into the scoreboard in the fScore array
					}
					else 
					{
						score = fillBall;
						frameResult = "X";
						fScore[9] += score;	//enters the score value into the scoreboard in the fScore array
					}
					results[9] += frameResult;	//puts the frameResult into the array results
					//continue;	//to the Strike method and continues with loop iterations
				}				
			}
					
					gameDisplay(gameFrame, results);	//displays the scoreboard to the user
					frameCounter++;		//bumps up the count for the loop iteration for the game frames
					
				
		break;  //the break for the game loop so it will not be stuck in the sentinel control loop after game is done
					
							
	}while(roll1!=999);	//exits game loop when sentinel is entered by user
	
			
		//following loop searches for the values of scores and calculates the 
		//running total and enters the score of each frame in the corresponding arrays 
		//for the final scorebaord.
		char aChar = ' ';
		for (int idx = 0; idx < results.length; idx++)	
		{
			if (fScore[idx] == 10)
		
		
			if (results[idx] == "X")	//the calculations for the Strike
			{
				fScore[idx] = 10 + 10; //(fScore[idx+1]);
				if (results[idx+1]=="X")
				{
					fScore[idx] += fScore[idx+2]; 
					//idx++;
					continue;
				}
			}
			if((fScore[idx +1] == 10) && (results[idx] != "X"))	//This calculates if the next frame 
			//for (idx = 0; idx < 9; idx++)					//is a spare
			//{
				for (idx = 0; idx < 9; idx++)
				{
					aChar = ' ';
					frameResult = results[idx+1];
					aChar = frameResult.charAt(0);	//get the first number from the result string
					if (aChar != 'X');
					{
						char x = '0';
						int y = aChar - x; 
						fScore[idx] = fScore[idx] + y;
						idx++;
						continue;
					}
				}
				//fScore[idx] = 10 + (fScore[idx+1]);
			
		
			//THIS IS SUPPPOSE TO ADD THE NEXT FRAME ball 1 TO THE SPARE SCORE.
		for ( idx = 0; idx < fScore.length; idx++)	
		if (fScore[idx] < 10)
			{
				for (idx = 0; idx < 9; idx++)
				{
					aChar = ' ';
					frameResult = results[idx+1];
					aChar = frameResult.charAt(0);	//get the first number out of the string result
					if (aChar != 'X');
					{
						char x = '0';
						int y = aChar - x; 
						fScore[idx] = fScore[idx] + y;
						
					}
				}
			}		
		for ( idx = 0; idx < fScore.length; idx++)	//This is suppose to just keep the score already there. 
		if (fScore[idx] < 10)
		{
			fScore[idx] = fScore[idx];
			
		}
		}
		//for (int idx = 0; idx < fScore.length; idx++)
		
		
		for (int idx = 0; idx < runScore.length; idx++)	//The running score calculations	
		{
			runTotal += fScore[idx];
			runScore[idx] = runTotal ;
		}
	
	
		
	
	System.out.println();
	displayAll(gameFrame, results, fScore, runScore);	//displays the final scoreboard to the user
	System.out.println();
	System.out.println();
	System.out.println("Thank you for bowling the Galaxy! Come back again!");
}	
						
//End of main 


				
//game scores output during game
public static void gameDisplay(int [] gameFrame, String[] results)
{
	int idx = 0; //for counting the index in arrays 
	//int score = 0;
	System.out.printf("%-15s", "Frame #:");
	for (idx = 0; idx < gameFrame.length; idx++)		//horizontal print of frame number
	{
		System.out.printf("%4d |",gameFrame[idx]);
	}
	System.out.println();
	System.out.printf("%-15s", "Results:");
	for (idx = 0; idx < results.length; idx++)		//horizontal print of results for frame
	{
		System.out.printf("%4s |", results[idx]);
	}
	System.out.println();
}

//end of game scoreboard output
public static void displayAll(int[] gameFrame, String[] results, int[] fScore, int[] runScore)
{
	int idx = 0; //for counting the index in arrays 
	//int score = 0;
	System.out.printf("%-15s", "Frame #:");
	for (idx = 0; idx < gameFrame.length; idx++)		//horizontal print of frame number
	{
		System.out.printf("%4d |",gameFrame[idx]);
	}
	System.out.println();
	System.out.printf("%-15s", "Results:");
	for (idx = 0; idx < results.length; idx++)		//horizontal print of results for frame
	{
		System.out.printf("%4s |", results[idx]);
	}
	System.out.println();
	System.out.printf("%-15s", "Frame Score:");
	for (idx = 0; idx < fScore.length; idx++)		//horizontal print for frame score
	{
		System.out.printf("%4d |", fScore[idx]);
	}
	System.out.println();
	System.out.printf("%-15s", "Running Score:");
	for (idx = 0; idx < runScore.length; idx++)		//horizontal print for running score per frame
	{
		System.out.printf("%4d |", runScore[idx]);
	}
	System.out.println();
}



}


//The following are just things I tried but did not want to delete 
//DON'T KNOW == TRYING TO FIND CHAR IN A STRING TO DO CALCULATION ON STRIKE OR SPARE
		/*	for (int idx = 0; idx < results.length; idx++)
		{
			String myString = results[idx];
				if (myString.contains("X")) 
					
				{
					fScore[idx] = 10 + (fScore[idx+1]);
					myString = results[idx+1];
					if (myString.contains("X"));
					{
						fScore[idx] = 10 + 10 + (fScore[idx+2]);
						
					}
				}
		    
		}
		*/

/*frameResult = results[idx];
aChar = frameResult.charAt(1);
if (aChar == '/')
{
	aChar = ' ';
	frameResult = results[idx+1];
	aChar = frameResult.charAt(0);
	if (aChar != 'X');
	{
		char x = '0';
		int y = aChar - x; 
		fScore[idx] = fScore[idx] + y;
	}
}*/

