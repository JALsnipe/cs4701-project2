import java.util.HashSet;
import java.util.Stack;


public class DFS implements Search {

	Stack<State> stack = new Stack<State>(); //stack for DFS, greedy + A* - priority queue
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
		
		System.out.println("in search");
		
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
		
		System.out.println(currentState.toString());
		stack.add(currentState);
		
		int count = 0;
		
		while(stack.size() != 0) {
			
			if(count == 4) {
				break;
			}
			count++;

			State temp = stack.pop();  //pop the head
			visited.add(temp);
			
			State lc = Actions.goLeft(temp, Actions.getPlayerPosition(temp));
			State rc = Actions.goRight(temp, Actions.getPlayerPosition(temp));
			State uc = Actions.goUp(temp, Actions.getPlayerPosition(temp));
			State dc = Actions.goDown(temp, Actions.getPlayerPosition(temp));

			if(!visited.contains(lc) && !stack.contains(lc) && lc != null) {
				if(checkGoal(lc)) {
					return lc;
				}
				temp.addChild(lc);
				this.stack.add(lc);
				System.out.println("lc action");
			}
			
			if(!visited.contains(rc) && !stack.contains(rc) && rc != null) {
				if(checkGoal(rc)) {
					return rc;
				}
				temp.addChild(rc);
				this.stack.add(rc);
				System.out.println("rc action");
			}
			
			if(!visited.contains(uc) && !stack.contains(uc) && uc != null) {
				if(checkGoal(uc)) {
					return uc;
				}
				temp.addChild(uc);
				this.stack.add(uc);
				System.out.println("uc action");
				System.out.println(uc);
			}
			
			if(!visited.contains(dc) && !stack.contains(dc) && dc != null) {
				if(checkGoal(dc)) {
					return dc;
				}
				temp.addChild(dc);
				this.stack.add(dc);
				System.out.println("dc action");
				System.out.println(uc);
			}

//			return searchGoal(currentState);

		}
		
		return null;
//		return searchGoal(currentState);
		
	}

}