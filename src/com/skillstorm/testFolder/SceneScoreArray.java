package com.skillstorm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SceneScoreArray {

//	public static void main(String[] args) 
//	{
//		// TODO Auto-generated method stub
//
//		//create scene scores in an int array 8 2by3 by calling the create score array method
//		int[][][] scoreArray = createScoreArrays();
//		
//		//print each array for testing purposes
//		for (int i = 0; i<8;i++)
//			{
//				System.out.println("scene " + i);
//				printArrayInt2by3(scoreArray[i]);
//				System.out.println("\n");
//			}
//
//		//create scenes for the game, stored in Scene Class Array
//		Scene[] sceneArray = createScenes(scoreArray[0], scoreArray[1],scoreArray[2], 
//				scoreArray[3],scoreArray[4], scoreArray[5],scoreArray[6], scoreArray[7]);
//
//		System.out.println(sceneArray[0].toString());
//		System.out.println("\n");
//		
//		//print out array - 2D Array
//		printArrayInt2by3(sceneArray[1].getScenePointArray());
//		System.out.println("\n");
//		
//		//access the scene0 properties
//		System.out.println(sceneArray[3].getSceneNumber() + "\n");		
//		System.out.println(sceneArray[3].getSceneLocation() + "\n");		
//		System.out.println(sceneArray[3].getSceneDescription() + "\n");		
//		System.out.println(sceneArray[3].getInputFeedback(1) + "\n");
//		System.out.println(sceneArray[3].getInputFeedback(2) + "\n");
//
//
//		//test the scen0 getScore method with score1Arraay
//		System.out.println("test getScore method with sceneArray[1] score Array");
//		System.out.println(sceneArray[1].getScore(1,1)); //choice 1, class 1 
//		System.out.println(sceneArray[1].getScore(1,2)); //choice 1, class 2 
//		System.out.println(sceneArray[1].getScore(1,3)); //choice 1, class 3 
//		System.out.println(sceneArray[1].getScore(2,1)); //choice 2, class 1 
//		System.out.println(sceneArray[1].getScore(2,2)); //choice 2, class 2 
//		System.out.println(sceneArray[1].getScore(2,3)); //choice 2, class 3 
//		System.out.println("\n");
//
//		//test the add score to profile survival score array list
//		System.out.println("test the add method: add score to profile surival score array list");
//		List<Integer> survivalScoreList = new ArrayList<>(); //to store survival points through each scene
//		
//		sceneArray[1].addScore( sceneArray[1].getScore(2,1), survivalScoreList) ;
//		sceneArray[1].addScore( sceneArray[1].getScore(2,2), survivalScoreList) ;
//		sceneArray[1].addScore( sceneArray[1].getScore(2,3), survivalScoreList) ;
//
//		System.out.println("surival score accumulated points: " + survivalScoreList);
//		
//        System.out.println("done");	
//
//	}// end of class main method
	
	//Methods
	//class SceneScoreArray Method 1 of 4
	public static int[][] createArrayInt2By3(int a, int b, int c, int d, int e, int f)
	{
		/* inputs: 6 integers
		 * output: an integer array 2by3 (2 rows by 3 columns)
		 * objective: create a 2by3 integer array
		 */
		int[][] intArray = { {a,b,c},
							 {d,e,f}
						   };
		return intArray;
	}
	
	//class SceneScoreArray Method 2 of 4
	public static void printArrayInt2by3(int[][] array)
	{   /* inputs: a 2 dimensional integer array
		 * output: a print out of the array
		 * objective: print out a 2 dimensional array
		 */
		System.out.println("2D Array: 2 Rows with 3 Columns");
		for (int i=0; i<array.length; i++)
			System.out.println(Arrays.toString(array[i]));
	}
	
	//class SceneScoreArray Method 3 of 4
	public static int[][][] createScoreArrays()
	{ 	/* inputs: nothing
		 * output: returns a 3 dimensional integer array that holds 8 2by3 array, 
	               for every scene, points are recorded for each traveler class and each option
		 * objective: Create an array of score points for every scene. 
		 *            The array of score points does take into account of each traveler class
		 */
		//create scene scores in an integer array(2by3) by calling the createArrayInt2By3 method
		int[][] score0Array = createArrayInt2By3(0, 0, 0, 0, 0, 0);
		int[][] score1Array = createArrayInt2By3(0, 0, 0, 1, 1, 1);
		int[][] score2Array = createArrayInt2By3(0, 0, 1, 1, 1, 0);
		int[][] score3Array = createArrayInt2By3(1, 0, 0, 0, 1, 1);
		int[][] score4Array = createArrayInt2By3(1, 0, 0, 0, 1, 1);
		int[][] score5Array = createArrayInt2By3(1, 0, 0, 0, 1, 1);
		int[][] score6Array = createArrayInt2By3(1, 0, 1, 0, 1, 0);
		int[][] score7Array = createArrayInt2By3(0, 0, 0, 0, 0, 0);
		
		int[][][] scoreArray = { score0Array, score1Array, score2Array, score3Array,
								score4Array, score5Array, score6Array, score7Array};
		
		//System.out.println("create score array method is done");
		return scoreArray;
	}
	
	//class SceneScoreArray Method 4 of 4
	public static Scene[] createScenes(int[][] score0Array, int[][] score1Array,int[][] score2Array,int[][] score3Array,
			int[][] score4Array,int[][] score5Array,int[][] score6Array,int[][] score7Array)
	{
		/* input: an integer 2by3 array (2 rows by 3 columns)
		 * output: an array of scene objects, length of 8
		 * objective: create an array of scene objects
		 */
		Scene scene0 = new Scene(0, "Location: Welcome Screen", 
				"You have aboarded the Titanic, where would you like to visit?\n"
				+ "1. Deck\n"
				+ "2. Smoke Room", 
				"You have choosen to visit the Deck during the day.", "You have choosen to visit the Smoke Room.", score0Array);
		
		Scene scene1 = new Scene(1, "Location: Deck During the Day", 
				"As you are people watching on the deck, you see a 3rd class passenger drop a wallet, what do you do?\n"
				+ "1. Steal it\n"
				+ "2. Return it", 
				"You got caught and the item was returned to the owner.", "The owner thanks you.", score1Array);
		
		Scene scene2 = new Scene(2, "Location: Smoke Room", 
				"In the smoke room, you see a 1st class passeneger leave an expensive pocket watch, what do you do?\n"
				+ "1. Steal it\n"
				+ "2. Return it", 
				"You have succesfully stolen it but someone else noticed you and called you out.\n"
				+ "The item was rightfully returned to its owner.", 
				"The owner is grateful of the item and thanks you profusly.", score2Array);
		
		Scene scene3 = new Scene(3, "Location: The Grand Staircase", 
				"You heard about the amazing grand staircase and you went to take a look. It is amazing!\n"
				+ "You hear gossipers whisper about a woman from first class fratenizing with a 3rd class "
				+ "gentlemen, what do you do?\n"
				+ "1. Tell them to shut their pie holes and mind their own business.\n"
				+ "2. Say nothing.", 
				"The gossipers turn red and are so embarassed they storm up the stair case.", 
				"The gossipers are so engrossed in their gossip, they misstep on the staircase and "
				+ "everyone looks at them. "
				+ "\nEmbarassed, they hide their faces and quickly exit the room.", score3Array);
		
		Scene scene4 = new Scene(4, "Location: Dinner in the Dinner Room", 
				"It's now dinner time and the food is better than common food.\n"
				+ "The talk around the dinner table is iceburgs. What is your opinion?\n"
				+ "1. The boat will never sink. \n"
				+ "2. The boad could sink, we need to be alert.", 
				"Everyone agrees with you at the table because the boat is new.", 
				"Everyone thinks you are too pessimistic and are overthinking.", score4Array);
		
		Scene scene5 = new Scene(5, "Location: Deck During the Night", 
				"Oh no! The boat is sinking, the captain said \'every man for himself\', what do you do?\n"
				+ "1. Try to get on a lifeboat.\n"
				+ "2. Raid the bar and drink as much as you can.", 
				"Unfortunately, all the boats are filled and you miss your chance.", 
				"You partied like it's the 1920s!", 
				score5Array);
		
		Scene scene6 = new Scene(6, "Location: Atlantic Ocean", 
				"The boat has sank and you are now in the frigid Atlantic waters, what do you do?\n"
				+ "1. Swim to find debris to float on.\n"
				+ "2. Float & take out the flask you have hidden in your garments and start drinking.", 
				"You have found a piece of wood.", "You happen to come across a drifting piece of wood."
				, score6Array);
		
		Scene scene7 = new Scene(7, "Location: End Screen", 
				"Let\'s see if you survived, enter \'1\' or \'2\' to calculate your doom.\n", 
				"Survived!", "You have perished!", score7Array);

		Scene[] sceneArray = {scene0, scene1, scene2, scene3, scene4, scene5, scene6, scene7};
		
		//System.out.println("create scenes is done");
		return sceneArray;
	}
	

}//end of public class

//class Scene: 1 of 1
class Scene
{
	//properties
	final int sceneNumber;
	final String sceneLocation;
	final String sceneDescription;
	final String inputFeedback1;
	final String inputFeedback2;
	int[][] scenePointArray = new int[3][2];

	//constructor
	public Scene (int sceneNumber, String sceneLocation, String sceneDescription, String inputFeedback1, 
			       String inputFeedback2, int[][] scenePointArray)
	{
		this.sceneNumber = sceneNumber;
		this.sceneLocation = sceneLocation;
		this.sceneDescription = sceneDescription;
		this.inputFeedback1 = inputFeedback1;
		this.inputFeedback2 = inputFeedback2;
		this.scenePointArray = scenePointArray;
	}

	//Methods
	//class Scene Method 1 of 8
	@Override
	public String toString() 
	{
		return "Scene [sceneNumber=" + sceneNumber + ", sceneLocation=" + sceneLocation + ", sceneDescription="
				+ sceneDescription + ", inputFeedback1=" + inputFeedback1 + ", inputFeedback2=" + inputFeedback2
				+ ", scenePointArray=" + Arrays.toString(scenePointArray) + "]";
	}

	//class Scene Method 2 of 8
	public int getSceneNumber() {return this.sceneNumber;}
	
	//class Scene Method 3 of 8
	public String getSceneLocation() {return this.sceneLocation;}
	
	//class Scene Method 4 of 8
	public String getSceneDescription() {return this.sceneDescription;}
	
	//class Scene Method 5 of 8
	public String getInputFeedback(int choice) 
	{
		if (choice == 1)
			return this.inputFeedback1;
		else //choice == 2
			return this.inputFeedback2;
	}
	
	//class Scene Method 6 of 8
	public int[][] getScenePointArray() {return this.scenePointArray;}
	
	//class Scene Method 7 of 8
	public int getScore(int sceneInput, int profileInput) 
	{
		/*
		 * inputs: profileINput = 1, 2, 3rd class profile
		 *         sceneINput = choices 1 or 2
		 * output: score assigned to profile and scene input
		 * score matrix is 2x3
		 */
		
		int row = sceneInput - 1;
		int column = profileInput - 1;
		
		int score = this.scenePointArray[row][column];

		return score;
	}
	
	//class Scene Method 8 of 8
	public void addScore(int score, List<Integer> survivalScoreList) 
	{
		/*
		 * inputs: score = integer
		 *         survivalScoreList an arrayList
		 * output: nothing, a number is added to an arraylist
		 */
		
		survivalScoreList.add(score);
	}

}//end of public class




