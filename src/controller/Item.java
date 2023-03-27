package controller;

/**
* Class:  NextRoom
* @author : Serena Bonsu
* @version: 1.0
* Course: ITEC 3860, Spring, 2022
* Written:  March 15th, 2022
* 
* This class serves as a parent class for items in the game
* 
* Purpose:  This class contains the shared attributes and methods for item objects
*
*/
public class Item {
	private String name;
	private String description;
	
	
	/**
	 * full argument constructor
	 * 
	 * @param name
	 * @param desc
	 */
	public Item(String name, String description) {
		this.name = name;
		this.description = description;
		
	}
	
	//getter methods set
	
	public String getName()	{
		return name;
	}
	
	public String getDescription()	{
		return description;
	}
	
}