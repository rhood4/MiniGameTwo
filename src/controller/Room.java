package controller;

import java.util.ArrayList;



public class Room {

	private String name;
	private String desc;
	private boolean hasVisited;
	
	private ArrayList<Exit> exits;
	private ArrayList<Item> items;
	
	
	/**
	 * No argument constructor
	 */
	
	
	public Room() {
		desc = "";
		name = "";
		hasVisited = false;
		exits = new ArrayList<Exit>();
		items = new ArrayList<Item>();
	}
	
	/**
	 * Partial argument constructor
	 * 
	 * @param name
	 * @param desc
	 */
	
	public Room(String name, String desc) {
		this.desc = desc;
		this.name = name;
		this.hasVisited = false;
		this.exits = new ArrayList<Exit>();
		this.items = new ArrayList<Item>();
		
	}
	
	/**
	 * Method to handle whether or not the room has been visited
	 * 
	 * @param hasVisited - boolean checking whether room was visited or not
	 */
	
	public void setHasVisited(boolean hasVisited) {
		if (this.hasVisited == true) {
			System.out.println("\nYou have previously entered this room.");
		}
		this.hasVisited = hasVisited;
	}
	
	//Getter and Setter methods written
	
	public boolean getHasVisited() {
		return hasVisited;
	}
	
	
	public String getName() {
		return name;
	}
	
	/**
	 * addNextRoom adds neighboring rooms to each room
	 * 
	 * @param direction - the direction of the neighboring room
	 * @param room - adds the rooms
	 */
	
	public void addExit(String direction, Room room) {
		this.exits.add(new Exit(direction, room));
	}
	
	/**
	 * addItem adds items to each room
	 * 
	 * @param name - the name of the item
	 * @param desc - the description of the item
	 */
	
	public void addItem(String name, String desc) {
		this.items.add(new Item(name, desc));
	}
	
	//An array list is created for the neighboring rooms
	
	public ArrayList<Exit> getExits() {
		return exits;
	}
	
	
	/**
	 * getItemsDescriptions prints the description of the items in the room
	
	 */
	
	public String getItemsDescription()	{
		if (items.isEmpty()) {
			return "There are no items in this room.";
			
		//converts item array to string description 
			
		} else {
			String itdesc = "";
			for (Item item: this.items) {
				if (!itdesc.isEmpty()) {
					itdesc = itdesc + ", ";
				}
				itdesc = itdesc + item.getName();
			}
			return "The room contains these item(s): " + itdesc;
		}
	}
	
	public void removeItem(int index) {
		this.items.remove(index);
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}
	
	//getter and setter methods
	
	public String getDesc() {
		return this.desc;
	}

	public void setRoomID(int roomNumber) {
	}

	public void setRoomName(String roomName) {
	}

	public void setRoomDescription(String roomDescription) {
	}

	public void setRoomVisited(String roomVisited) {
	}
}
