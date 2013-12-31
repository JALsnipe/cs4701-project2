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

				char[] charArray = theString.toCharArray();

				for(int j = 0; j < charArray.length; j++) {
					line.add(String.valueOf(charArray[j]));
				}

				puzzle.add(line);
			}
			
			System.out.println("File loaded!");

		} catch (FileNotFoundException e) {
			System.out.println("Load failed!  Make sure your puzzle is named puzzle.txt and is in the appropriate directory");
			System.exit(1);
		}
		return puzzle;
	}

	public static void main(String[] args) {
		
		ArrayList<ArrayList<String>> puzzle = loadFile("puzzle.txt");

		State parent = new State(puzzle);
		
		System.out.println("Welcome to Josh's Sokoban searcher!");
		System.out.println("1) Breadth first search");
		System.out.println("2) Depth first search");
		System.out.println("3) Uniform cost search");
		System.out.println("4) Greedy best first search - Manhattan Distance");
		System.out.println("5) Greedy best first search - Euclidian Distance");
		System.out.println("6) A* search - Manhattan Distance");
		System.out.println("7) A* search - Euclidian Distance");
		System.out.println("Please enter your selection: ");
		
		Scanner input = new Scanner(System.in);
		int selection = input.nextInt();
		
		if (selection == 1) {
			BFS bfs = new BFS();
			bfs.searchGoal(parent);
		} else if (selection == 2) {
			DFS dfs = new DFS();
			dfs.searchGoal(parent);
		} else if (selection == 3) {
			UCS ucs = new UCS();
			ucs.searchGoal(parent);
		} else if (selection == 4) {
			GBFSMan gbfsMan = new GBFSMan();
			gbfsMan.searchGoal(parent);
		} else if (selection == 5) {
			GBFSEuc gbfsEuc = new GBFSEuc();
			gbfsEuc.searchGoal(parent);
		} else if (selection == 6) {
			AStarMan aStarMan = new AStarMan();
			aStarMan.searchGoal(parent);
		} else if (selection == 7) {
			AStarEuc aStarEuc = new AStarEuc();
			aStarEuc.searchGoal(parent);
		} else {
			System.out.println("Invalid Input!");
			System.exit(1);
		}
	}

}
