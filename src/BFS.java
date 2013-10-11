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

		return true;

	}

	@Override
	public State searchGoal(State state) {
		// TODO Auto-generated method stub

		if(checkGoal(state)) {
			return state;
		}

		queue.add(state);
		while(queue.size() != 0) {

			State temp = queue.poll();
			
			System.out.println(temp);

			State lc = Actions.goLeft(temp, SokobanTester.playerPosition);
			State rc = Actions.goRight(temp, SokobanTester.playerPosition);
			State uc = Actions.goUp(temp, SokobanTester.playerPosition);
			State dc = Actions.goDown(temp, SokobanTester.playerPosition);

			temp.addChild(lc);
			temp.addChild(rc);
			temp.addChild(uc);
			temp.addChild(dc);

			this.queue.add(lc);
			this.queue.add(rc);
			this.queue.add(uc);
			this.queue.add(dc);

			searchGoal(temp);

		}
		
		return null;
		
	}

}