import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

// Implementation of Uniform Cost Search.

public class UCS implements Search {

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
	
public void getPath(ArrayList recorder, State goal) {
		
		if(goal.getParent() != null) {
			recorder.add(goal.getParentMove());
			getPath(recorder, goal.getParent());
		}
	}

	@Override
	public State searchGoal(State currentState) {
		
		startTime = System.nanoTime();
		
		// pass goal back up
		// pass frontier down

		if(checkGoal(currentState) == true) {
			return currentState;
		}
		
		frontier.add(currentState);
		
		while(frontier.size() != 0) {
			
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
			
			totalNodesGenerated++;

			Collections.sort(frontier, new SortQueueViaLowestCost());
			
			State temp = frontier.get(0);  //pop the head
			visited.add(temp);
			
			State lc = Actions.goLeft(temp, Actions.getPlayerPosition(temp));
			State rc = Actions.goRight(temp, Actions.getPlayerPosition(temp));
			State uc = Actions.goUp(temp, Actions.getPlayerPosition(temp));
			State dc = Actions.goDown(temp, Actions.getPlayerPosition(temp));

			if(!visited.contains(lc) && !frontier.contains(lc) && lc != null) {
				if(checkGoal(lc)) {
					return lc;
				}
				temp.addChild(lc);
				this.frontier.add(lc);
			}
			
			if(visited.contains(lc)) {
				nodesGeneratedPreviously++;
			}
			
			if(!visited.contains(rc) && !frontier.contains(rc) && rc != null) {
				if(checkGoal(rc)) {
					return rc;
				}
				temp.addChild(rc);
				this.frontier.add(rc);
			}
			
			if(!visited.contains(uc) && !frontier.contains(uc) && uc != null) {
				if(checkGoal(uc)) {
					return uc;
				}
				temp.addChild(uc);
				this.frontier.add(uc);
			}
			
			if(!visited.contains(dc) && !frontier.contains(dc) && dc != null) {
				if(checkGoal(dc)) {
					return dc;
				}
				temp.addChild(dc);
				this.frontier.add(dc);
			}

		}
		
		return null;
		
	}

}