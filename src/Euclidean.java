import java.util.ArrayList;
import java.util.Collections;

/**
 * Euclidean.java
 * Contains my Euclidean heuristic function
 * @author jal2238
 *
 */

public class Euclidean {
	
	/**
	 * Calculates the Euclidean algorithm
	 * 
	 * @param boxLocations, an ArrayList of box location coordinates
	 * @param goalLocations, an ArrayList of goal location coordinates
	 * @return the heuristic cost of the closest box-goal pair
	 */
	
	public static int EuclideanCalc (ArrayList<int[]> boxLocations, ArrayList<int[]> goalLocations) {
		ArrayList<Integer> eucAverages = new ArrayList<Integer>();
		
		for(int i = 0; i < boxLocations.size(); i++) {
			int[] box = boxLocations.get(i);
			int[] goal = goalLocations.get(i);
			
			eucAverages.add((int) Math.sqrt(Math.pow((box[0] - goal[0]), 2) + Math.pow((box[1] - goal[0]), 2)));
			
		}
		
		Collections.sort(eucAverages);
		return eucAverages.get(0);
		
	}

}
