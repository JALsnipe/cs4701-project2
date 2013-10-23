import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

public class UCS implements Search {

	int count = 0;
	
	PriorityQueue<State> frontier = new PriorityQueue<State>(); //stack for DFS, greedy + A* - priority frontier
	HashSet<State> visited = new HashSet<State>();

	public boolean checkGoal(State state) {

		for (int k = 0; k < state.getData().size(); k++) {
			for(int m = 0; m < state.getData().get(k).size(); m++) {
				if (state.getData().get(k).get(m).equals("$") || state.getData().get(k).get(m).equals(".")) {
					return false;
				}
			}
		}
	
		System.out.println("Reached Goal State!!");
		System.out.println("in checkGoal");
		ArrayList<Character> path = getPath(state);
		System.out.println("path: " + getPath(state));
		System.out.println("path copy: " + path);
		System.out.println("count: " + count);
		
		Collections.reverse(path);
		
		System.out.print("Path: ");
		for(int i = 0; i < path.size()/2; i++) {
			System.out.print(path.get(i) + ", ");
		}
		System.out.println();
//		System.out.println(path);
//		int SIZE = path.size();
//		System.out.println("Path: ");
//		for(int i = SIZE - 1; i > 0; i--) {
//			System.out.print(path.get(i));
//		}
//		System.out.println("Path: " + getPath(state));
		return true;

	}
	
	ArrayList<Character> path = new ArrayList<Character>();
	public ArrayList<Character> getPath(State goal) {
		
		System.out.println("in getPath");
		
		if(goal.getParent() != null) {
//			System.out.println("in getpath if");
//			System.out.println("goal.getParentMove(): " + goal.getParentMove());
			path.add(goal.getParentMove());
//			System.out.println("path.size(): " + path.size());
			getPath(goal.getParent());
		}
		
		return path;
	}

	@Override
	public State searchGoal(State currentState) {
		
		// pass goal back up
		// pass frontier down
		
		// TODO Auto-generated method stub
		
		System.out.println("in searchGoal");

		if(checkGoal(currentState) == true) {
			System.out.println("here");
//			System.out.println("current state: " + currentState);
//			System.out.println("goal state: " + goalState);
//			goalState = currentState;
//			currentState = goalState;
//			System.out.println("poop");
//			System.out.println("Path: " + getPath(currentState));
			return currentState;
		}
		
		frontier.add(currentState);
		
		while(frontier.size() != 0) {
			
			count++;
//			System.out.println("char: " + currentState.getParentMove());

			State temp = frontier.poll();  //pop the head
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

//			return searchGoal(currentState);

		}
		
		return null;
//		return searchGoal(currentState);
		
	}

}