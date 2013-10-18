import java.util.HashSet;
import java.util.LinkedList;


public class BFS implements Search {

	LinkedList<State> queue = new LinkedList<State>(); //stack for DFS, greedy + A* - priority queue
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
		return true;

	}

	@Override
	public State searchGoal(State currentState) {
		
		// pass goal back up
		// pass queue down
		
		// TODO Auto-generated method stub

		if(checkGoal(currentState)) {
			System.out.println("here");
//			System.out.println("current state: " + currentState);
//			System.out.println("goal state: " + goalState);
//			goalState = currentState;
//			currentState = goalState;
			return currentState;
		}
		
		
		queue.add(currentState);
		
		while(queue.size() != 0) {

			State temp = queue.poll();  //pop the head
			visited.add(temp);
			
			State lc = Actions.goLeft(temp, Actions.getPlayerPosition(temp));
			State rc = Actions.goRight(temp, Actions.getPlayerPosition(temp));
			State uc = Actions.goUp(temp, Actions.getPlayerPosition(temp));
			State dc = Actions.goDown(temp, Actions.getPlayerPosition(temp));

			if(!visited.contains(lc) && !queue.contains(lc) && lc != null) {
				if(checkGoal(lc)) {
					return lc;
				}
				temp.addChild(lc);
				this.queue.add(lc);
			}
			
			if(!visited.contains(rc) && !queue.contains(rc) && rc != null) {
				if(checkGoal(rc)) {
					return rc;
				}
				temp.addChild(rc);
				this.queue.add(rc);
			}
			
			if(!visited.contains(uc) && !queue.contains(uc) && uc != null) {
				if(checkGoal(uc)) {
					return uc;
				}
				temp.addChild(uc);
				this.queue.add(uc);
			}
			
			if(!visited.contains(dc) && !queue.contains(dc) && dc != null) {
				if(checkGoal(dc)) {
					return dc;
				}
				temp.addChild(dc);
				this.queue.add(dc);
			}

//			return searchGoal(currentState);

		}
		
		return null;
//		return searchGoal(currentState);
		
	}

}