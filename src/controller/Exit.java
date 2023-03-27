package controller;

import controller.Room;

/**
* Class:  NextRoom
* @author : Serena Bonsu
* @version: 1.0
* Course: ITEC 3860, Spring, 2022
* Written:  February 1st, 2022
* 
* This class serves as a parent class for the neighboring rooms of the game
* 
* Purpose:  This class contains the shared attributes and methods for neighboring room objects
*
*/

public class Exit {
	
	private String direction;
	private Room room;
	
	/**
	 * Full argument constructor
	 * 
	 * @param direction
	 * @param room
	 */
	
	public Exit(String direction, Room room) {
		this.direction = direction;
		this.room = room;
	}	
	
	//Get methods to retrieve the room and direction
	
	public String getDirection()	{
		return this.direction;
	}

	public Room getRoom()	{
		return this.room;
	}


}