package com.skillstorm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Profiles {

	public static void main(String[] args)
	{
		//create scene scores an int array 8 2by3 by calling the create score array method
		int[][][] scoreArray = SceneScoreArray.createScoreArrays();
		
		//create scenes for the game, stored in Scene Class Array
		Scene[] sceneArray = SceneScoreArray.createScenes(scoreArray[0], scoreArray[1],scoreArray[2], 
				scoreArray[3],scoreArray[4], scoreArray[5],scoreArray[6], scoreArray[7]);
		System.out.println();
		
		//if play again, start it from here | option 1
		//open scanner for user input
		Scanner scanner = new Scanner(System.in);
		
		//Output for User Welcome
		System.out.println("Welcome aboard the Titanic! \nLet's see if you can survive.");

		// get user name input
		String nameString = userNameInput(scanner);
        System.out.println("user name: " + nameString);
        System.out.println();
        
        // get user profile input
		//if play again, start it from here | option 2
        Profile profileInput = userProfileInput(scanner, nameString);
		profileInput.info();
		System.out.println(profileInput.backStory);
		System.out.println();
		
		//let the user play the game
		PlayGame.playGame(scanner, sceneArray, profileInput);
		
		//print profile survival score array
		System.out.println("Survial score accumulated points: " + profileInput.survivalScoreList);
		
		//calculate profile score array
		int profileScore = profileInput.calcSurvival(profileInput.survivalScoreList) ;
		System.out.println("Profile Score is: " + profileScore);
		
        scanner.close();
        System.out.println("done");

	}


	//Method: get user name input from player Method
	public static String userNameInput(Scanner scanner)
	{ /* input: scanner class for user input
		 output: user's name String
		 objective: Get user's name
	  */
	    //instantiate variables
		String[] userNameArray = null;
        int i;
        ArrayList<String> nameArray = new ArrayList<>();
        String nameString = null;
        Boolean validName = true;
        String userInputName = null;
		
		//get user name and process it, do this until a valid name is entered
        System.out.println("What is your name? ");
        
        while(validName) //while true, do this
		{
	        userInputName = scanner.nextLine();
	        
	        if (userInputName.isBlank()) //check if empty or blank
	        	{System.out.println("Name can not be empty or blank. \n");}      
	        else if (userInputName.length()>21) //check if <20 characters
	    		{System.out.println("Name must be less than 21 characters. \n");}
	        else //it is a valid input
	        	{validName = false;}
		} 
	    
		//trim white spaces and lower case
		userNameArray = userInputName.trim().toLowerCase().split(" ");
   	
		//for loop, if blank space in array, toss it, if not store name in an ArrayList
       for (i=0; i<userNameArray.length; i++)
       {
       	if (userNameArray[i].isBlank()) //if the string is blank/white spaces
       		{ continue; }//do not include it, iterate and move to next iteration
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
	
	//Method: get profile input selection from user
	public static Profile userProfileInput(Scanner scanner, String nameString)
	{ /* input: scanner class for user input and user's name
		 output: users chosen Profile object
		 objective: Get user's name Profile selection
	  */
		//let user choose the profile
        //instantiate variables
        boolean notMet = true;
        int profileInput = 0;
        
        System.out.println("Pick your profile: (select 1, 2, or 3)" + "\n" + 
				"1. 1st Class Traveler " + "\n" + 
				"2. 2nd Class Traveler " + "\n" + 
				"3. 3rd Class Traveler " );
        
        //user must enter valid integers 1,2,3
        while (notMet) //while true, keep doing this loop
        {
	        //if the read line is an integer, else its invalid and input again
	        if (scanner.hasNextInt()) 
	        {
	        	profileInput = scanner.nextInt(); 
	        	
	        	if ((profileInput == 1) | (profileInput == 2) | (profileInput == 3))
	        	{
		        	notMet = false;
	        	}
	        	else
	        	{
			        System.out.println("Invalid input, must enter the following: 1, 2, or 3. \n");
	        		System.out.println();
	        	}

	        }
	        else
	        {
		        System.out.println("Invalid input, must enter the following: 1, 2, or 3. \n");
		        scanner.next();
	        }
	    } 
        
        //use switch statement to create the profile the user picked
        //instantiate variable
        Profile profile = null;
        
        switch(profileInput)
        {
	        case 1:
	        	{
	        		profile = new Profile(1, nameString, 3, 1, 1, 2);
	        		profile.setBackStory(profileInput);
	        		break;
	        	}
	        case 2:
	        	{
	        		profile = new Profile(2, nameString, 2, 3, 2, 3);
	        		profile.setBackStory(profileInput);
	        		break;
	        	}
	        case 3: 
	        	{
	        		profile = new Profile(3, nameString, 1, 2, 3, 1);
	        		profile.setBackStory(profileInput);
	        	}
        }
        
        return profile;
	}

}

class Profile
{
	//properties
	final public int ticketClass;
	final public String name;
	final public int money;
	final public int survivalSkills;
	final public int strength;
	final public int swim;
	List<Integer> survivalScoreList = new ArrayList<>(); //to store survival points through each scene
	public String backStory;
	
	//constructors
	public Profile(int ticketClass, String name, int money, int survivalSkills, int strength, int swim)
	{
		this.ticketClass = ticketClass;
		this.name = name;
		this.money = money;
		this.survivalSkills = survivalSkills;
		this.strength = strength;
		this.swim = swim;
	}
	
	//methods
	public void info()
	{
		System.out.println("Profile Character (1-low, 2-mid, 3-high)" + "\n" +
						   "Ticket Class:     " + ticketClass + "\n" +
						   "Name:             " + name + "\n" + 
						   "Money:            " + money + "\n" +
						   "Survival Skills:  " + survivalSkills + "\n" + 
						   "Strength:         " + strength + "\n" +
						   "Swim:             " + swim + "\n");
	}
	
	//set backStory variable
	public void setBackStory(int profileInput)
	{
		switch(profileInput)
        {
	        case 1:
	        	{
	        		this.backStory = "Backstory: You are fancy socialite, who loves shopping and will be draped in the finest dresses or tuxes. \nYour motto: \"I am a fashion icon\"";
	        		break;
	        	}
	        case 2:
	        	{
	        		this.backStory = "Backstory: You are a prominent doctor, traveling to be a guest speaker at \'Surgeons of the World\' convention. \nYour motto: \"There's never a challenge too small\"";
	        		break;
	        	}
	        case 3: 
	        	{
	        		this.backStory = "Backstory: You are starting a new life in America and am determined to build your own business. \nYour motto: \"I will not live a life I do not deserve\"";
	        	}
        }
	}
	
	//calculate survival score
	public int calcSurvival(List<Integer> survivalScoreList) 
	{
		int sum = 0;
		
        for (int i = 0; i < survivalScoreList.size(); i++)
            sum += survivalScoreList.get(i);

        return sum;
        
        //add boolean later if under 8, you did not survive
	}
	

}


