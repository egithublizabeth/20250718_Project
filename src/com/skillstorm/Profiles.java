package com.skillstorm;

public class Profiles {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		Profile profile1 = new Profile("Mary Sue", "1st Class", 3, 1, 1, 2);
		profile1.info();
		
		System.out.println("\n");
		Profile profile2 = new Profile("Amelia Evergreen", "2nd Class", 2, 3, 2, 3);
		profile2.info();
		
		System.out.println("\n");
		Profile profile3 = new Profile("Billy Joel", "Worker", 1, 2, 3, 1);
		profile3.info();


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


