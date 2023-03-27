package view;
import java.util.ArrayList;
import java.util.Scanner;
import controller.GameLoader;
import controller.Item;
import controller.Player;
import controller.Room;
public class Adventure {
	public static void main(String[] args) {
		//Scanner object is created to read user input to start the game
		Scanner input = new Scanner(System.in);
		Scanner start = new Scanner(System.in);
		GameLoader game = new GameLoader();
		ArrayList<Room> rooms = game.getRooms();
		System.out.println("HELLO! WELCOME TO MY MINI-GAME 2 PART DUEX! You will navigate through rooms\n"
				+ "by typing directions into the console. Please check your spelling. \n"
				+ "Type 'BEGIN' To start the game. \n"
		+ "Enjoy.");
		String starter = start.nextLine();
		// the game begins when the user enters "Begin"
		if(starter.equalsIgnoreCase("Begin")) {
		game.loadGame();
		rooms = game.getRooms();
		System.out.println("\nThese are the rooms you will be navigating through: "
		+"\n Type: 'look, inspect' to look at the room," +
				" 'get' to pick an item and 'backpack' to look at the items you have.");
		for (Room room : rooms) {
			System.out.println(room.getName());
		}
		Room roomOne = rooms.get(0);
		
		Player player = new Player(roomOne);
		
		Room location = player.getLocation();
		
		String roomName = location.getName();
		String desc = location.getDesc();
		System.out.println("\n" + roomName  + "\n----------\n" + desc);
		
		//A while loop is created for the game to continue
		while (true) {
			String command = input.nextLine();
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
				else {
			player.move(command);
			location = player.getLocation();
			roomName = location.getName();
			desc = location.getDesc();
			System.out.println("\n" + roomName + "\n----------\n" + desc);
				}
		}
		}
	}
}
