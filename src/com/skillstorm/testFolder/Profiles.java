package com.skillstorm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Profiles {

//	public static void main(String[] args)
//	{
//		//create scene scores an int array 8 2by3 by calling the create score array method
//		int[][][] scoreArray = SceneScoreArray.createScoreArrays();
//		
//		//create scenes for the game, stored in Scene Class Array
//		Scene[] sceneArray = SceneScoreArray.createScenes(scoreArray[0], scoreArray[1],scoreArray[2], 
//				scoreArray[3],scoreArray[4], scoreArray[5],scoreArray[6], scoreArray[7]);
//		System.out.println();
//		
//		//if play again, start it from here | option 1
//		//open scanner for user input
//		Scanner scanner = new Scanner(System.in);
//		
//		//Output for User Welcome
//		System.out.println("Welcome aboard the Titanic! \nLet's see if you can survive.");
//
//		// get user name input
//		String nameString = userNameInput(scanner);
//        System.out.println("user name: " + nameString);
//        System.out.println();
//        
//        // get user profile input
//		//if play again, start it from here | option 2
//        Profile profileInput = userProfileInput(scanner, nameString);
//		profileInput.info();
//		System.out.println(profileInput.backStory);
//		System.out.println();
//		
//		//let the user play the game
//		PlayGame.playGame(scanner, sceneArray, profileInput);
//		
//		//print profile survival score array
//		System.out.println("Survial score accumulated points: " + profileInput.survivalScoreList);
//		
//		//calculate profile score array
//		int profileScore = profileInput.calcSurvival(profileInput.survivalScoreList) ;
//		System.out.println("Profile Score is: " + profileScore);
//		
//        scanner.close();
//        System.out.println("done");
//
//	}//end of main method

	//Methods
	//class Profiles Method 1 of 2 
	public static String userNameInput(Scanner scanner)
	{  /* 
		* input: scanner class for user input
		* output: user's name String
		* objective: get user's name
	    */
		
	    //instantiate variables
		String[] userNameArray = null;
        int i;
        ArrayList<String> nameArray = new ArrayList<>();
        String nameString = null;
        Boolean notValidName = true;
        String userInputName = null;
		
		//get user name and process it, do this until a valid name is entered
        System.out.println("What is your name? ");
        
        while(notValidName) //while true, do this
		{
	        userInputName = scanner.nextLine();
	        
	        if (userInputName.isBlank()) //check if empty or blank
	        	System.out.println("Name can not be empty or blank. \n");     
	        else if (userInputName.length()>=21) //check if <20 characters
	    		System.out.println("Name must be less than 21 characters. \n");
	        else //it is a valid input
	        	notValidName = false;
		} 
	    
		//trim white spaces and lower case, split all names by white spaces (white space is in between names)
		userNameArray = userInputName.trim().toLowerCase().split(" ");
   	
	   //for loop, if there is a blank space in the array, toss it, if not store the name in an ArrayList
       for (i=0; i < userNameArray.length; i++)
       {
       	if (userNameArray[i].isBlank()) //if the string is blank/white spaces
       		 continue; //do not include it, skip code and move to next iteration
       	else
       	{
       		//capitalize the first letter and add it to the ArrayList
       		String nameFixed = userNameArray[i].substring(0,1).toUpperCase() + userNameArray[i].substring(1);
       		nameArray.add(nameFixed);
       	}
       }
       
       //concatenate the name and assign it to nameString
       for (i=0; i < nameArray.size(); i++)
       {
       	if (i==0)
       		nameString = nameArray.get(i);
       	else
       		nameString = nameString + " " + nameArray.get(i);
       }
       
       return nameString;
		
	}
	
	//class Profiles Method 2 of 2 
	public static Profile userProfileInput(Scanner scanner, String nameString)
	{ /* input: scanner class for user input and user's name
	   * output: users chosen Profile object
	   * objective: get user's Profile selection
	   */
		
        //instantiate variables
        boolean notMet = true;
        int profileInput = 0;
        Profile profile = null;
        
        System.out.println("Pick your profile: (select 1, 2, or 3)" + "\n" + 
				"1. 1st Class Traveler\n" + 
				"2. 2nd Class Traveler\n" + 
				"3. 3rd Class Traveler" );
        
        //user must enter valid integers 1,2,3
        while (notMet) //while true, keep doing this loop
        {
	        //if the read line is an integer, else its invalid and input again
	        if (scanner.hasNextInt()) 
	        {
	        	profileInput = scanner.nextInt(); 
	        	
	        	if ((profileInput == 1) || (profileInput == 2) || (profileInput == 3))
	        	{
		        	notMet = false;
	        	}
	        	else
	        	{
			        System.out.println("Invalid input, you must enter the following: 1, 2, or 3. \n");
	        		System.out.println();
	        	}

	        }
	        else
	        {
		        System.out.println("Invalid input, you must enter the following: 1, 2, or 3. \n");
		        scanner.next();
	        }
	    } 
        
        //use switch statement to create the profile the user picked        
        switch(profileInput)
        {
	        case 1:
	        	{
	        		profile = new Profile(1, nameString, 3, 1, 2);
	        		profile.setBackStory(profileInput);
	        		break;
	        	}
	        case 2:
	        	{
	        		profile = new Profile(2, nameString, 2, 3, 1);
	        		profile.setBackStory(profileInput);
	        		break;
	        	}
	        case 3: 
	        	{
	        		profile = new Profile(3, nameString, 1, 2, 3);
	        		profile.setBackStory(profileInput);
	        	}
        }
        
        return profile;
	}

}//end of public class Profiles

//class Profile: 1 of 1
class Profile
{
	//properties
	final int ticketClass;
	final String name;
	final int money;
	final int survivalSkills;
	final int swim;
	List<Integer> survivalScoreList = new ArrayList<>(); //to store survival points through each scene
	public String backStory;
	
	//constructor
	public Profile(int ticketClass, String name, int money, int survivalSkills, int swim)
	{
		this.ticketClass = ticketClass;
		this.name = name;
		this.money = money;
		this.survivalSkills = survivalSkills;
		this.swim = swim;
	}
	
	//Methods
	//class Profile Method: 1 of 3
	public void info()
	{
		System.out.println("Profile Character (1-low, 2-mid, 3-high)" + "\n" +
						   "Ticket Class:     " + ticketClass + "\n" +
						   "Name:             " + name + "\n" + 
						   "Money:            " + money + "\n" +
						   "Survival Skills:  " + survivalSkills + "\n" + 
						   "Swim:             " + swim + "\n");
	}
	
	//class Profile Method: 2 of 3
	public void setBackStory(int profileInput)
	{
		switch(profileInput)
        {
	        case 1:
	        	{
	        		this.backStory = "Backstory: You are a fancy socialite, who loves shopping and will be draped in the finest dresses or tuxes. \nYour motto: \"I am a fashion icon!\"";
	        		break;
	        	}
	        case 2:
	        	{
	        		this.backStory = "Backstory: You are a prominent doctor, traveling to be a guest speaker at \'Surgeons of the World\' convention. \nYour motto: \"There's never a challenge too small!\"";
	        		break;
	        	}
	        case 3: 
	        	{
	        		this.backStory = "Backstory: You are starting a new life in America and am determined to build your own business. \nYour motto: \"I will not live a life I do not deserve!\"";
	        	}
        }
	}
	
	//class Profile Method: 3 of 3
	public int calcSurvival(List<Integer> survivalScoreList) 
	{
		int sum = 0;
		
        for (int i = 0; i < survivalScoreList.size(); i++)
            sum += survivalScoreList.get(i);

        return sum;
	}
	
}//end of Public class Profiles


