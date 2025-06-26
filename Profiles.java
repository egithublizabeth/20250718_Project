package com.skillstorm;

import java.util.Scanner;

public class Profiles {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		//using scanner to get user name
		Scanner scanner = new Scanner(System.in);
	       
		//get user name and process it
        System.out.println("What is your name? ");
        String userInputName = scanner.nextLine().toLowerCase().trim();
        String userName = userInputName.substring(0, 1).toUpperCase() + userInputName.substring(1);
       
        System.out.println("user name: " + userName);
        System.out.println("\n");
        
        //let user choose the profile
        //instantiate variables
        boolean notMet = true;
        int profileInput = 0;
        
        
        //user must enter valid integers 1,2,3
        do 
        {
	        System.out.println("Pick your profile: (select 1, 2, or 3)" + "\n" + 
	        					"1. First Class Traveler " + "\n" + 
	        					"2. Second Class Traveler " + "\n" + 
	        					"3. Worker Traveler " );
	        
	        //if the read line is an integer, else its invalid and input again
	        if (scanner.hasNextInt()) 
	        {
	        	profileInput = scanner.nextInt(); 
	        	
	        	if ((profileInput == 1) | (profileInput == 2) | (profileInput == 3))
		        	notMet = false;
	        }
	        else
	        {
		        System.out.println("Invalid input, must enter the following: 1, 2, or 3.");
		        scanner.next();
	        }
	     
//	    System.out.println("profile input: " + profileInput);
//	    System.out.println("notMet is: " + notMet);
	    System.out.println("\n");

        } while (notMet); //while true, keep doing this loop
        

        //use switch statement to create the profile the user picked
        //instantiate variable
        Profile profile = null;
        
        switch(profileInput)
        {
	        case 1:
	        	{
	        		profile = new Profile(userName, "1st Class", 3, 1, 1, 2);
	        		break;
	        	}
	        case 2:
	        	{
	        		profile = new Profile(userName, "2nd Class", 2, 3, 2, 3);
	        		break;
	        	}
	        case 3: 
	        	{
	        		profile = new Profile(userName, "Worker", 1, 2, 3, 1);
	        	}
        }
    
    
	    System.out.println("\n");
		profile.info();
        scanner.close();
        System.out.println("done");

	}

}

class Profile
{
	//properties
	final public String name;
	final public String traveler;
	final public int money;
	final public int smart;
	final public int strength;
	final public int swim;
	
	//constructors
	public Profile(String name, String traveler, int money, int smart, int strength, int swim)
	{
		this.name = name;
		this.traveler = traveler;
		this.money = money;
		this.smart = smart;
		this.strength = strength;
		this.swim = swim;
	}
	
	//methods
	public void info()
	{
		System.out.println("Profile Character (1-low, 2-mid, 3-high)" + "\n" +
						   "Name: " + name + "\n" + 
						   "Traveler: " + traveler + "\n" + 
						   "Money: " + money + "\n" +
						   "Smart: " + smart + "\n" + 
						   "Strength: " + strength + "\n" +
						   "Swim: " + swim + "\n");
	}
	

}


