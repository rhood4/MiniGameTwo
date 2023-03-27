package controller;

/**
* Class:  Game Loader
* @author : Serena Bonsu
* @version: 1.0
* Course: ITEC 3860, Spring, 2022
* Written:  February 1st, 2022
* 
* This class loads the data from the text files
* 
* Purpose:  This class is what stores information for the game
*
*/

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameLoader {
	
	private static ArrayList<Room> rooms;

	public GameLoader() {
		
		rooms = new ArrayList<Room>();
		
	}
	//make a function to load game from file
	
	public void loadGame()	{
		Scanner sc = null;
		
		// step 1 load rooms from file
		// read file and assign text to variables based on variable and text line order
		// first line is room's name
		// second line is description of room
		try {
			FileReader fr = new FileReader("Rooms.txt");
			sc = new Scanner(fr);
		}	catch (IOException e)	{
			System.out.println("File not found, exiting.");
			System.exit(2);
		} while (sc.hasNextLine())	{
			
			String roomName = sc.nextLine();
			String description = sc.nextLine();	
			
			// create object Room with variables from file
			
			Room room = new Room(roomName, description);
			
			// add room to collection of rooms
			rooms.add(room);

		}
		
		// step 2 load room connections
		//read file and assign text to variables based on variable and text line order
		// first line room's name
		// Second line direction of neighbor room
		// third line neighbor name
		
		try {
			FileReader fr = new FileReader("Connections.txt");
			sc = new Scanner(fr);
		}	catch (IOException e)	{
			System.out.println("File not found, exiting.");
			System.exit(2);
		} while (sc.hasNextLine())	{
			
			String roomName = sc.nextLine();
			String direction = sc.nextLine();
			String neighborName = sc.nextLine();
			
			// looping to match room names and neighbor rooms to create neighbors
			for (Room room: rooms )	{
				// looking for room name in collection matching room name from file
				if(room.getName().equalsIgnoreCase(roomName))	{
					
					// looking for room name from collection that matches neighbor name from file
					for (Room neighbor: rooms)	{
						if(neighbor.getName().equalsIgnoreCase(neighborName))	{
							
							// adding neighbor to room
							room.addExit(direction, neighbor);
						}
					}
				}
				
			}
			
		}
	
	try {
		FileReader fr = new FileReader("Items.txt");
		sc = new Scanner(fr);
	}	catch (IOException e)	{
		System.out.println("File not found, exiting.");
		System.exit(2);
	} while (sc.hasNextLine())	{
		
		String roomName = sc.nextLine();
		String name = sc.nextLine();
		String description = sc.nextLine();

		
		// looping to match room names and neighbor rooms to create neighbors
		for (Room room: rooms )	{
			// looking for room name in collection matching room name from file
			if(room.getName().equalsIgnoreCase(roomName))	{
				// adding neighbor to room
				room.addItem(name, description);
			}
			
		}
	}
		
	
}
	// return collection of rooms
	public ArrayList<Room> getRooms()	{
		return rooms;
	}

	}
