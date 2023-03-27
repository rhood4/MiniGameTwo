package controller;

/**
* Class:  Player
* @author : Serena Bonsu
* @version: 1.0
* Course: ITEC 3860, Spring, 2022
* Written:  February 1st, 2022
* 
* This class serves as a parent class for the players of the game
* 
* Purpose:  This class contains the shared attributes and methods for players
*
*/
import java.util.ArrayList;


public class Player {
	
	private Room location;
	private ArrayList<Item> inventory;
	
	/**
	 * No argument constructor
	 */
	
	public Player() {
		location = new Room();
		inventory = new ArrayList<Item>();
	}
	
	/**
	 * Full argument constructor
	 * 
	 * @param location
	 */
	
	public Player(Room location) {
		this.location = location;
		this.inventory = new ArrayList<Item>();
	}
	
	public void inspect(String itemName) {
		
		// looks at all items in player's current location
		for (Item item: location.getItems()) {
			
			//print outs description of item that matches user input
			if (item.getName().equalsIgnoreCase(itemName)) {
				System.out.println(item.getDescription());
				return;
			}
		}
		System.out.println("Item not found. ");
	}
	
	/*
	 *  picks up item in room and places in player inventory and removes item from room
	 */
	public void get(String itemName) {
		
		// check each item in the room
		for (int i = 0; i < itemName.length(); i++) {
			Item item = location.getItems().get(i);
			
			// find the item in the room that matches user input
			if (item.getName().equalsIgnoreCase(itemName)) {
				
				// add item to inventory
				inventory.add(item);
				
				// remove item from room
				location.removeItem(i);
				System.out.println(itemName + " has been picked up from the room and successfully added to the player inventory. ");
				return;
			}
		}
		System.out.println("Item not found. ");
	}
	
	/*
	 *  removes items from player inventory and places item in room
	 */
	public void remove(String itemName) {
		// check each item in inventory
		for (int i = 0; i < itemName.length(); i++) {
			Item item = this.inventory.get(i);
			
			// find item in inventory that matches user input
			if (item.getName().equalsIgnoreCase(itemName)) {
				
				// add item to room
				location.addItem(item.getName(), item.getDescription());
				
				// remove item from inventory
				inventory.remove(i);
				System.out.println(itemName + " has been dropped and placed in " + location.getName() + ".");
				return;
			}
		}
		System.out.println("Item not found. ");
	}
	
	public ArrayList<Item> getInventory()	{
		return inventory;
	}
	
	//Getter and Setter methods created
	
	public Room getLocation() {
		return this.location;
	}
	
	public void setLocation(Room location) {
		this.location = location;
	}
	
	/**
	 * move Method to handle the player's movement
	 * @param direction - Checks the user's spelling of the direction and moves the player to this position
	 */
	
	public void move(String direction) {
		
		for (Exit room: location.getExits()) {
			
			if(direction.equalsIgnoreCase(room.getDirection())) {
				
				this.location = room.getRoom();
				
				this.location.setHasVisited(true);
				return;
			}
		}
		
		System.out.println("This move is invalid. Please check your spelling.");
	}
	
}


