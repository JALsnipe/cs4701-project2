import java.util.ArrayList;
import java.util.Collections;

/**
 * Manhattan.java
 * Contains my Manhattan Distance heuristic function
 * @author jal2238
 *
 */

public class Manhattan {
	
	/**
	 * Calculates the Manhattan distance
	 * @param boxLocations, an ArrayList of box location coordinates
	 * @param goalLocations, an ArrayList of goal location coordinates
	 * @return the heuristic cost of the closest box-goal pair
	 */
	
	public static int ManhattanCalc (ArrayList<int[]> boxLocations, ArrayList<int[]> goalLocations) {
	
		ArrayList<Integer> manAverages = new ArrayList<Integer>();
		
		for(int i = 0; i < boxLocations.size(); i++) {
			int[] box = boxLocations.get(i);
			int[] goal = goalLocations.get(i);
			
			manAverages.add(Math.abs(box[0] - goal[0]) + Math.abs(box[1] - goal[0]));
			
		}
		
		Collections.sort(manAverages);
		return manAverages.get(0);
		
	}

}
