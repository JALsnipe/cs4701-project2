import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * GBFSMan.java
 * Implements Greedy Best-First Search with Manhattan Distance as the heuristic function.
 * @author jal2238
 *
 */

public class GBFSMan implements Search {

	int totalNodesGenerated = 0;
	int nodesGeneratedPreviously = 0;
	int nodesOnFringe = 0;
	int nodesOnExploredList = 0;
	
	long startTime;
	long endTime;
	long totalTime;
	double BILLION = 1000000000.0;
	
	ArrayList<State> frontier = new ArrayList<State>(); //greedy + A* - priority queue
	HashSet<State> visited = new HashSet<State>();

	/**
	 * checkGoal
	 * Checks if the specified state is a goal state.
	 *  
	 */
	
	public boolean checkGoal(State state) {

		for (int k = 0; k < state.getData().size(); k++) {
			for(int m = 0; m < state.getData().get(k).size(); m++) {
				if (state.getData().get(k).get(m).equals("$") || state.getData().get(k).get(m).equals(".")) {
					return false;
				}
			}
		}
		
		endTime = System.nanoTime();
		
		System.out.println("Reached goal state!");
		ArrayList<Character> path = new ArrayList<Character>();
		getPath(path, state);
		System.out.println("path: " + path);
		System.out.println("Nodes generated: " + totalNodesGenerated);
		System.out.println("nodes containing states that were generated previously: " + nodesGeneratedPreviously);
		nodesOnFringe = frontier.size();
		System.out.println("Nodes on fringe: " + nodesOnFringe);
		nodesOnExploredList = visited.size();
		System.out.println("Nodes on explored list: " + nodesOnExploredList);
		totalTime = endTime - startTime;
		double printTime = totalTime/BILLION; //nanoseconds / 1000000000 = seconds
		System.out.println("Run time in seconds: " + printTime);
		
		Collections.reverse(path);
		
		System.out.print("Path: ");
		for(int i = 0; i < path.size(); i++) {
			System.out.print(path.get(i) + ", ");
		}

		return true;

	}
	
	
	/**
	 * getPath
	 * @param recorder, an empty ArrayList
	 * @param goal, the goal state
	 * Adds the solution, a sequence of moves, to an ArrayList.
	 */
	public void getPath(ArrayList recorder, State goal) {
		
		if(goal.getParent() != null) {
			recorder.add(goal.getParentMove());
			getPath(recorder, goal.getParent());
		}
	}
	
	@Override
	/**
	 * searchGoal
	 * @param currentState, the current state
	 * @return a state
	 */
	public State searchGoal(State currentState) {
		
		// pass goal back up
		// pass frontier down
		
		if(checkGoal(currentState) == true) {
			return currentState;
		}
		
		frontier.add(currentState);
		
		while(frontier.size() != 0) {
			
			totalNodesGenerated++;
			
			if(totalNodesGenerated == 40000) {
				endTime = System.nanoTime(); 
				
				System.out.println("Traversed 40000 nodes without finding a solution");
				// I do this to avoid any Java heap memory errors.
				System.out.println("Nodes generated: " + totalNodesGenerated);
				System.out.println("nodes containing states that were generated previously: " + nodesGeneratedPreviously);
				nodesOnFringe = frontier.size();
				System.out.println("Nodes on fringe: " + nodesOnFringe);
				nodesOnExploredList = visited.size();
				System.out.println("Nodes on explored list: " + nodesOnExploredList);
				totalTime = endTime - startTime;
				double printTime = totalTime/BILLION; //nanoseconds / 1000000000 = seconds
				System.out.println("Run time in seconds: " + printTime);
				break;
			}

			Collections.sort(frontier, new SortQueueViaLowestCost());
			
			State temp = frontier.get(0);  //pop the head
			visited.add(temp);
			
			State lc = Actions.goLeft(temp, Actions.getPlayerPosition(temp));
			State rc = Actions.goRight(temp, Actions.getPlayerPosition(temp));
			State uc = Actions.goUp(temp, Actions.getPlayerPosition(temp));
			State dc = Actions.goDown(temp, Actions.getPlayerPosition(temp));
			
			if(visited.contains(lc)) {
				nodesGeneratedPreviously++;
			}

			if(!visited.contains(lc) && !frontier.contains(lc) && lc != null) {
				if(checkGoal(lc)) {
					return lc;
				}
				lc.setCost(Manhattan.ManhattanCalc(Actions.getBoxLocations(currentState), Actions.getGoalLocations(currentState)));
				temp.addChild(lc);
				this.frontier.add(lc);
			}
			
			if(visited.contains(rc)) {
				nodesGeneratedPreviously++;
			}
			
			if(!visited.contains(rc) && !frontier.contains(rc) && rc != null) {
				if(checkGoal(rc)) {
					return rc;
				}
				rc.setCost(Manhattan.ManhattanCalc(Actions.getBoxLocations(currentState), Actions.getGoalLocations(currentState)));
				temp.addChild(rc);
				this.frontier.add(rc);
			}
			
			if(visited.contains(uc)) {
				nodesGeneratedPreviously++;
			}
			
			if(!visited.contains(uc) && !frontier.contains(uc) && uc != null) {
				if(checkGoal(uc)) {
					return uc;
				}
				uc.setCost(Manhattan.ManhattanCalc(Actions.getBoxLocations(currentState), Actions.getGoalLocations(currentState)));
				temp.addChild(uc);
				this.frontier.add(uc);
			}
			
			if(visited.contains(dc)) {
				nodesGeneratedPreviously++;
			}
			
			if(!visited.contains(dc) && !frontier.contains(dc) && dc != null) {
				if(checkGoal(dc)) {
					return dc;
				}
				dc.setCost(Manhattan.ManhattanCalc(Actions.getBoxLocations(currentState), Actions.getGoalLocations(currentState)));
				temp.addChild(dc);
				this.frontier.add(dc);
			}

		}
		
		return null;
		
	}

}