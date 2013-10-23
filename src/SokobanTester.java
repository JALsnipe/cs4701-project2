import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class SokobanTester {
	
	// Load the map text file into a 2D array
	public static ArrayList<ArrayList<String>> loadFile (String filename) {
		
		ArrayList<ArrayList<String>> puzzle = new ArrayList<ArrayList<String>>();

		try {
			System.out.println("Loading file puzzle.txt...");
			Scanner in = new Scanner(new File(filename));
			int lineNums = in.nextInt();
			in.nextLine();

			for(int i = 0; i < lineNums; i++) {
				ArrayList<String> line = new ArrayList<String>();
				String theString;
				theString = in.nextLine();
				//System.out.println(theString);

				char[] charArray = theString.toCharArray();
				//System.out.println(charArray);

				for(int j = 0; j < charArray.length; j++) {
					line.add(String.valueOf(charArray[j]));
				}

				puzzle.add(line);
			}
			
			System.out.println("File loaded!");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Load failed!  Make sure your puzzle is named puzzle.txt and is in the appropriate directory");
			e.printStackTrace();
		}
		return puzzle;
	}

	public static void main(String[] args) {
		
//		ArrayList<ArrayList<String>> puzzle = loadFile("puzzle.txt");
//		ArrayList<ArrayList<String>> puzzle = loadFile("left.txt");
//		ArrayList<ArrayList<String>> puzzle = loadFile("weird.txt");
		ArrayList<ArrayList<String>> puzzle = loadFile("easy11.txt");

		State parent = new State(puzzle);
		
		System.out.println("Welcome to Josh's Sokoban searcher!");
		System.out.println("1) Breadth first search");
		System.out.println("2) Depth first search");
		System.out.println("3) Uniform cost search");
		System.out.println("4) Greedy best first search");
		System.out.println("5) A* search");
		System.out.println("Please enter your selection: ");
		
		Scanner input = new Scanner(System.in);
		int selection = input.nextInt();
		
		if (selection == 1) {
			BFS bfs = new BFS();
			System.out.println("Goal State: " + bfs.searchGoal(parent));
		}
		
		else if (selection == 2) {
			DFS dfs = new DFS();
			System.out.println("Goal State: " + dfs.searchGoal(parent));
		} else {
			System.out.println("Invalid Input!");
			System.exit(1);
		}

		
		
	}

}
