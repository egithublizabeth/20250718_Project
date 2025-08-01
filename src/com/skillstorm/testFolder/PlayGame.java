package com.skillstorm;
import java.util.Scanner;

public class PlayGame {

	public static void main(String[] args) 
	{
		//create 'scene scores' an integer array 8 2by3 by calling the create score array method
		int[][][] scoreArray = SceneScoreArray.createScoreArrays();
		
		//create scenes for the game, stored in Scene Class Array
		Scene[] sceneArray = SceneScoreArray.createScenes(scoreArray[0], scoreArray[1],scoreArray[2], 
				scoreArray[3],scoreArray[4], scoreArray[5],scoreArray[6], scoreArray[7]);
		System.out.println();
		
		//open scanner for user input
		Scanner scanner = new Scanner(System.in);
		
		//Output for User Welcome
		System.out.println("Welcome aboard the Titanic! \nLet's see if you can survive.");
		System.out.println();
		
		//get user name input
		String nameString = Profiles.userNameInput(scanner);
		System.out.println();

		//allow user to play multiple times
		boolean keepPlaying = true;
		
		do 
		{
	        // get user profile input
	        Profile profileInput = Profiles.userProfileInput(scanner, nameString);
	        System.out.println();
			profileInput.info();
			System.out.println(profileInput.backStory);
			System.out.println();
			
			//let the user play the game
			playGame(scanner, sceneArray, profileInput);
			
			//print profile survival score array
			System.out.println("Survial score accumulated points: " + profileInput.survivalScoreList);
			
			//calculate profile score array
			int profileScore = profileInput.calcSurvival(profileInput.survivalScoreList) ;
			System.out.println("Profile Score is: " + profileScore);
			
			//Would you like to play another round?
			System.out.println("Would you like to play another round?(select 1 or 2)\n1.No\n2.Yes");
			
			int keepPlayingChoice = inputChoice(scanner);
			
			if (keepPlayingChoice == 1)
				keepPlaying = false;
			
			System.out.println();

		} while(keepPlaying);
		
		//close the scanner
        scanner.close();
        System.out.println("*** End of the Game ***");

	}
	
	//Methods
	//class PlayGame Method: 1 of 2
	public static int inputChoice(Scanner scanner) 
	{
		/* input: scanner class for user to input choice
		 * output: returns an integer 1 or 2
		 * objective: Get user input, can only input & return 1 or 2.
		 */
		boolean keepGoing = true;
		int choice = 0;
		
		do 
		{
			if (scanner.hasNextInt())
	        {
	        	choice = scanner.nextInt(); 
	        	
	        	if (choice == 1 || choice ==2)
	        		keepGoing = false;
	        	else
	        	{
		        	System.out.println("Invalid integer input, you must enter the following: 1 or 2\n");
	            	System.out.println();
	        	}
	        }
	        else
	        {
	        	System.out.println("Invalid non-integer input, you must enter the following: 1 or 2\n");
		        scanner.next();
	        }
		
		} while(keepGoing);
		
		return choice;
	}

	//class PlayGame Method: 2 of 2
	public static void playGame(Scanner scanner, Scene[] sceneArray, Profile profileInput)
	{ /* input: scanner for user input, an array that holds Scene objects, a Profile object
		 output: void
		 objective: allows user to play the game and stores the survival points
	  */
		//initiate & declare choice variable for for loop use
        int choice = 0;

		for (int i = 0; i<sceneArray.length; i++)
		{
			//scene divider
			if (i!=0) System.out.println("*******************************************");
			
			//print scene description to console
			System.out.println(sceneArray[i].getSceneDescription());
			
			//user must enter valid integers 1 or 2    
	        choice = inputChoice(scanner);
			System.out.println();
			
			//if we are on the last iteration
			if (i == (sceneArray.length - 1) )
			{
				//calculate survival score
				int profileScore = profileInput.calcSurvival(profileInput.survivalScoreList);

				//show survival feedback
				if (profileScore >= 3)
					System.out.println(sceneArray[i].getInputFeedback(1));
				else
					System.out.println(sceneArray[i].getInputFeedback(2));
			}
			else
			{
				//show choice feedback
				System.out.println(sceneArray[i].getInputFeedback(choice));
				System.out.println(); 
				
				//add score to the Profile Score Array
				sceneArray[i].addScore( sceneArray[i].getScore(choice, profileInput.ticketClass), profileInput.survivalScoreList);
			}
			
			/* Because we allow users to enter scene 1 or 2 from scene 0, we need to 
			 * add extra iteration logic for continuity
			 * if we are on iteration 1/scene 1, we need to jump to iteration 3/scene 3
			 */
			if (i==1)
				i = 2; 
			
			//if we are on iteration 0/scene 0 and users choose scene 2, we need to jump
			//to scene 2 (iteration 2)
			if ( (i == 0) && (choice == 2) )
				i = 1;
			
		} //end of for loop
	}//end of method

}//end of Public class PlayGame
