package controller;

import java.util.ArrayList;


public class Commands {
	
	GameLoader game = new GameLoader();
	ArrayList<Room> rooms = game.getRooms();
	Room roomOne = rooms.get(0);
	private Player player = new Player(roomOne);
	private Room location = player.getLocation();;
	private String command;

	
	
	
	public void inspect(String itemName) {
		
		// looks at all items in player's current location
		for (Item item: location.getItems()) {
			
			//print outs description of item that matches user input
			if (item.getName().equalsIgnoreCase(itemName)) {
				System.out.println(item.getDescription());
				return;
			}
			System.out.println("Item not found. ");
		}
		

	
	if (command.equalsIgnoreCase("look"))	{
		
		// prints description of, possible entries/exits, items in current room 
		location = player.getLocation();
		System.out.println("\n" + location.getName() + "\n----------\n" 
		+ location.getDesc() + " " + location.getItemsDescription());
	
	}
	
	else if (command.toLowerCase().startsWith("inspect"))	{
		
		// print description of item
		String item = command.split(" ")[1];
		player.inspect(item);
	
	}
	else if (command.toLowerCase().startsWith("get"))	{
			
			// add item to inventory
			String item = command.split(" ")[1];
			player.get(item);
			
	}
	else if (command.toLowerCase().startsWith("remove"))	{
		
		// remove item from inventory
		String item = command.split(" ")[1];
		player.remove(item);
		
	}
	else if (command.equalsIgnoreCase("backpack"))	{
		
		// print all items backpack
		for (Item item : player.getInventory() ) {
			System.out.println(item.getName());
		}

}
}
}
