import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class SokobanTester {
	public static int[] playerPosition = new int[2];

	// Load the map text file into a 2D array
	public static ArrayList<ArrayList<String>> loadFile (String filename) {
		
		ArrayList<ArrayList<String>> puzzle = new ArrayList<ArrayList<String>>();

		try {
			Scanner in = new Scanner(new File(filename));
			int lineNums = in.nextInt();
			in.nextLine();
			//System.out.println(lineNums);

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

			//System.out.println("Start print test:");
			//System.out.println(puzzle);
			//System.out.println("End test.");
			
			for (int k = 0; k < puzzle.size(); k++) {
				for(int m = 0; m < puzzle.get(k).size(); m++) {
					if (puzzle.get(k).get(m).equals(String.valueOf('@'))) {
						playerPosition[0] = k;
						playerPosition[1] = m;
					}
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return puzzle;
	}

	public static void main(String[] args) {
		
		ArrayList<ArrayList<String>> puzzle = loadFile("puzzle.txt");
		Actions.copy(puzzle);
		System.out.println("copy test");
		System.out.println(puzzle);
		System.out.println("end copy");
		State parent = new State(puzzle);
		
		BFS bfs = new BFS();
		System.out.println(bfs.searchGoal(parent));
		
		for (int i = 0; i < playerPosition.length; i++) {
			System.out.println(playerPosition[i]);
		}
		
		System.out.println("printing puzzle");
		System.out.println(loadFile("right.txt"));
		System.out.println("end print puzzle");
		
//		System.out.println(goLeft(loadFile("left.txt")));
		System.out.println("printing right");
//		System.out.println(goRight(loadFile("right.txt")));
		System.out.println("end print right");

	}

}
