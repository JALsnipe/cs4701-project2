import java.util.ArrayList;


public class Actions {
	
	public static ArrayList<ArrayList<String>> copy(ArrayList<ArrayList<String>> input) {
		
		ArrayList<ArrayList<String>> copy = new ArrayList<ArrayList<String>>();
		
		for(int i = 0; i < input.size(); i ++) {
			ArrayList<String> line = input.get(i);
			for(int j = 0; j < input.get(i).size(); j++) {
				line.set(j, input.get(i).get(j));
			}
		}
		
		return copy;
	}
	
	// have an action to get the player position?
	public static int[] getPlayerPosition(State state) {
		//TODO
		return null;
	}
	
	public static State goLeft (State state, int[] playerPosition) {
		
		ArrayList<ArrayList<String>> temp;
		temp = copy(state.getData());
		System.out.println("in left");
		
		System.out.println(SokobanTester.playerPosition[0] + " " + SokobanTester.playerPosition[1]);
		System.out.println("temp arraoy: " + temp);
		
		// 1
		// if the space to the left of you is free, you can move left
		// _@ -> @_
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("@") && 
				temp.get(playerPosition[0]).get(playerPosition[1] - 1).equals(" ")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], " ");
			temp.get(playerPosition[0]).set(playerPosition[1] - 1, "@");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			System.out.println(newState);
			return newState;
			
		}
		
		// 2
		// case for if the player is on a goal
		// _+ -> @.
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0]).get(playerPosition[1] - 1).equals(" ")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0]).set(playerPosition[1] - 1, "@");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			System.out.println(newState);
			return newState;
			
		}
		
		// 3
		// if you're pushing a box left, and the space to the left of the box is blank,
		// you can move left
		// _$@ -> $@_
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("@") && 
				temp.get(playerPosition[0]).get(playerPosition[1] - 1).equals("$") &&
				temp.get(playerPosition[0]).get(playerPosition[1] - 2).equals(" ")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], " ");
			temp.get(playerPosition[0]).set(playerPosition[1] - 1, "@");
			temp.get(playerPosition[0]).set(playerPosition[1] - 2, "$");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			System.out.println(newState);
			return newState;
			
		}
		
		// 4
		// player on goal case
		// _$+ -> $@.
		
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0]).get(playerPosition[1] - 1).equals("$") &&
				temp.get(playerPosition[0]).get(playerPosition[1] - 2).equals(" ")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0]).set(playerPosition[1] - 1, "@");
			temp.get(playerPosition[0]).set(playerPosition[1] - 2, "$");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			System.out.println(newState);
			return newState;
			
		}
		
		// 5
		// Moving a box onto a goal
		// .$@ -> *@_
		
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("@") && 
				temp.get(playerPosition[0]).get(playerPosition[1] - 1).equals("$") &&
				temp.get(playerPosition[0]).get(playerPosition[1] - 2).equals(".")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], " ");
			temp.get(playerPosition[0]).set(playerPosition[1] - 1, "@");
			temp.get(playerPosition[0]).set(playerPosition[1] - 2, "*");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			System.out.println(newState);
			return newState;
			
		}
		
		// 6
		// player on goal case
		// .$+ -> *@.
		
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0]).get(playerPosition[1] - 1).equals("$") &&
				temp.get(playerPosition[0]).get(playerPosition[1] - 2).equals(".")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0]).set(playerPosition[1] - 1, "@");
			temp.get(playerPosition[0]).set(playerPosition[1] - 2, "*");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			System.out.println(newState);
			return newState;
			
		}
		
		// 7
		// moving a box off of a goal
		// _*@ -> $+_
		
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("@") && 
				temp.get(playerPosition[0]).get(playerPosition[1] - 1).equals("*") &&
				temp.get(playerPosition[0]).get(playerPosition[1] - 2).equals(" ")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], " ");
			temp.get(playerPosition[0]).set(playerPosition[1] - 1, "+");
			temp.get(playerPosition[0]).set(playerPosition[1] - 2, "$");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			System.out.println(newState);
			return newState;
			
		}
		
		State newState = new State(temp);
		newState.setParent(state);
		state.addChild(newState);
		System.out.println(newState);
		return newState;

	}

	public static State goRight(State state, int[] playerPosition) {
		
		ArrayList<ArrayList<String>> temp;
		temp =  copy(state.getData());
		System.out.println("in right");
	
		// 1
		// if the space to the left of you is free, you can move left
		// @_ -> _@
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("@") && 
//				isBlank(puzzle, playerPosition[0], playerPosition[1] - 1)) {
				temp.get(playerPosition[0]).get(playerPosition[1] + 1).equals(" ")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], " ");
			temp.get(playerPosition[0]).set(playerPosition[1] + 1, "@");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			System.out.println(newState);
			return newState;
			
		}
		
		// 2
		// case for if the player is on a goal
		// +_ -> .@
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0]).get(playerPosition[1] + 1).equals(" ")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0]).set(playerPosition[1] + 1, "@");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			System.out.println(newState);
			return newState;
			
		}
		
		// 3
		// if you're pushing a box left, and the space to the left of the box is blank,
		// you can move left
		// @$_ -> _@$
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("@") && 
				temp.get(playerPosition[0]).get(playerPosition[1] + 1).equals("$") &&
				temp.get(playerPosition[0]).get(playerPosition[1] + 2).equals(" ")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], " ");
			temp.get(playerPosition[0]).set(playerPosition[1] + 1, "@");
			temp.get(playerPosition[0]).set(playerPosition[1] + 2, "$");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			return newState;
			
		}
		
		// 4
		// player on goal case
		// +$_ -> .@$
		
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0]).get(playerPosition[1] + 1).equals("$") &&
				temp.get(playerPosition[0]).get(playerPosition[1] + 2).equals(" ")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0]).set(playerPosition[1] + 1, "@");
			temp.get(playerPosition[0]).set(playerPosition[1] + 2, "$");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			return newState;
			
		}
		
		// 5
		// Moving a box onto a goal
		// @$. -> _@$
		
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("@") && 
				temp.get(playerPosition[0]).get(playerPosition[1] + 1).equals("$") &&
				temp.get(playerPosition[0]).get(playerPosition[1] + 2).equals(".")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], " ");
			temp.get(playerPosition[0]).set(playerPosition[1] + 1, "@");
			temp.get(playerPosition[0]).set(playerPosition[1] + 2, "*");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			return newState;
			
		}
		
		// 6
		// player on goal case
		// +$. -> .@*
		
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0]).get(playerPosition[1] + 1).equals("$") &&
				temp.get(playerPosition[0]).get(playerPosition[1] + 2).equals(".")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0]).set(playerPosition[1] + 1, "@");
			temp.get(playerPosition[0]).set(playerPosition[1] + 2, "*");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			return newState;
			
		}
		
		// 7
		// moving a box off of a goal
		// @*_ -> _+$
		
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("@") && 
				temp.get(playerPosition[0]).get(playerPosition[1] + 1).equals("*") &&
				temp.get(playerPosition[0]).get(playerPosition[1] + 2).equals(" ")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], " ");
			temp.get(playerPosition[0]).set(playerPosition[1] + 1, "+");
			temp.get(playerPosition[0]).set(playerPosition[1] + 2, "$");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			return newState;
			
		}
		
		// 8
		// player on goal case
		// +*_ -> .+$
		
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0]).get(playerPosition[1] + 1).equals("*") &&
				temp.get(playerPosition[0]).get(playerPosition[1] + 2).equals(" ")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0]).set(playerPosition[1] + 1, "+");
			temp.get(playerPosition[0]).set(playerPosition[1] + 2, "$");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			return newState;
			
		}
		
		// 9
		// moving onto a goal
		// @. -> _+
		
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("@") && 
				temp.get(playerPosition[0]).get(playerPosition[1] + 1).equals(".")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], " ");
			temp.get(playerPosition[0]).set(playerPosition[1] + 1, "+");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			return newState;
			
		}
		
		// 10
		// player on goal case
		// +. -> .+
		
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0]).get(playerPosition[1] + 1).equals(".")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0]).set(playerPosition[1] + 1, "+");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			return newState;
			
		}
		
		State newState = new State(temp);
		newState.setParent(state);
		state.addChild(newState);
		return newState;
	
	}

	public static State goDown(State state, int[] playerPosition) {
		
		ArrayList<ArrayList<String>> temp;
		temp =  copy(state.getData());
		System.out.println("in down");
	
		// 1
		// if the space to the left of you is free, you can move left
		// @_ -> _@
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("@") && 
//				isBlank(puzzle, playerPosition[0], playerPosition[1] - 1)) {
				temp.get(playerPosition[0] + 1).get(playerPosition[1]).equals(" ")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], " ");
			temp.get(playerPosition[0] + 1).set(playerPosition[1], "@");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			return newState;
			
		}
		
		// 2
		// case for if the player is on a goal
		// +_ -> .@
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0] + 1).get(playerPosition[1]).equals(" ")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0] + 1).set(playerPosition[1], "@");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			return newState;
			
		}
		
		// 3
		// if you're pushing a box left, and the space to the left of the box is blank,
		// you can move left
		// @$_ -> _@$
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("@") && 
				temp.get(playerPosition[0] + 1).get(playerPosition[1]).equals("$") &&
				temp.get(playerPosition[0] + 2).get(playerPosition[1]).equals(" ")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], " ");
			temp.get(playerPosition[0] + 1).set(playerPosition[1], "@");
			temp.get(playerPosition[0] + 2).set(playerPosition[1], "$");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			return newState;
			
		}
		
		// 4
		// player on goal case
		// +$_ -> .@$
		
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0] + 1).get(playerPosition[1]).equals("$") &&
				temp.get(playerPosition[0] + 2).get(playerPosition[1] + 2).equals(" ")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0] + 1).set(playerPosition[1], "@");
			temp.get(playerPosition[0] + 2).set(playerPosition[1], "$");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			return newState;
			
		}
		
		// 5
		// Moving a box onto a goal
		// @$. -> _@$
		
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("@") && 
				temp.get(playerPosition[0] + 1).get(playerPosition[1]).equals("$") &&
				temp.get(playerPosition[0] + 2).get(playerPosition[1]).equals(".")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], " ");
			temp.get(playerPosition[0] + 1).set(playerPosition[1], "@");
			temp.get(playerPosition[0] + 2).set(playerPosition[1], "*");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			return newState;
			
		}
		
		// 6
		// player on goal case
		// +$. -> .@*
		
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0] + 1).get(playerPosition[1]).equals("$") &&
				temp.get(playerPosition[0] + 2).get(playerPosition[1]).equals(".")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0] + 1).set(playerPosition[1], "@");
			temp.get(playerPosition[0] + 2).set(playerPosition[1], "*");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			return newState;
			
		}
		
		// 7
		// moving a box off of a goal
		// @*_ -> _+$
		
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("@") && 
				temp.get(playerPosition[0] + 1).get(playerPosition[1]).equals("*") &&
				temp.get(playerPosition[0] + 2).get(playerPosition[1]).equals(" ")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], " ");
			temp.get(playerPosition[0] + 1).set(playerPosition[1], "+");
			temp.get(playerPosition[0] + 2).set(playerPosition[1], "$");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			return newState;
			
		}
		
		// 8
		// player on goal case
		// +*_ -> .+$
		
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0] + 1).get(playerPosition[1]).equals("*") &&
				temp.get(playerPosition[0] + 2).get(playerPosition[1]).equals(" ")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0] + 1).set(playerPosition[1], "+");
			temp.get(playerPosition[0] + 2).set(playerPosition[1], "$");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			return newState;
			
		}
		
		// 9
		// moving onto a goal
		// @. -> _+
		
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("@") && 
				temp.get(playerPosition[0] + 1).get(playerPosition[1]).equals(".")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], " ");
			temp.get(playerPosition[0] + 1).set(playerPosition[1], "+");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			return newState;
			
		}
		
		// 10
		// player on goal case
		// +. -> .+
		
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0] + 1).get(playerPosition[1]).equals(".")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0] + 1).set(playerPosition[1], "+");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			return newState;
			
		}
		
		State newState = new State(temp);
		newState.setParent(state);
		state.addChild(newState);
		return newState;
	
	}

	public static State goUp (State state, int[] playerPosition) {
		
		ArrayList<ArrayList<String>> temp;
		temp =  copy(state.getData());
		System.out.println("in up");
		
		// 1
		// if the space to the left of you is free, you can move left
		// _@ -> @_
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("@") && 
				temp.get(playerPosition[0] - 1).get(playerPosition[1]).equals(" ")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], " ");
			temp.get(playerPosition[0] - 1).set(playerPosition[1], "@");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			return newState;
			
		}
		
		// 2
		// case for if the player is on a goal
		// _+ -> @.
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0] - 1).get(playerPosition[1]).equals(" ")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0] - 1).set(playerPosition[1], "@");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			return newState;
			
		}
		
		// 3
		// if you're pushing a box left, and the space to the left of the box is blank,
		// you can move left
		// _$@ -> $@_
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("@") && 
				temp.get(playerPosition[0] - 1).get(playerPosition[1]).equals("$") &&
				temp.get(playerPosition[0] - 2).get(playerPosition[1]).equals(" ")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], " ");
			temp.get(playerPosition[0] - 1).set(playerPosition[1], "@");
			temp.get(playerPosition[0] - 2).set(playerPosition[1], "$");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			return newState;
			
		}
		
		// 4
		// player on goal case
		// _$+ -> $@.
		
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0] - 1).get(playerPosition[1]).equals("$") &&
				temp.get(playerPosition[0] - 2).get(playerPosition[1]).equals(" ")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0] - 1).set(playerPosition[1], "@");
			temp.get(playerPosition[0] - 2).set(playerPosition[1], "$");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			return newState;
			
		}
		
		// 5
		// Moving a box onto a goal
		// .$@ -> *@_
		
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("@") && 
				temp.get(playerPosition[0] - 1).get(playerPosition[1]).equals("$") &&
				temp.get(playerPosition[0] - 2).get(playerPosition[1]).equals(".")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], " ");
			temp.get(playerPosition[0] - 1).set(playerPosition[1], "@");
			temp.get(playerPosition[0] - 2).set(playerPosition[1], "*");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			return newState;
			
		}
		
		// 6
		// player on goal case
		// .$+ -> *@.
		
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0] - 1).get(playerPosition[1]).equals("$") &&
				temp.get(playerPosition[0] - 2).get(playerPosition[1]).equals(".")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0] - 1).set(playerPosition[1], "@");
			temp.get(playerPosition[0] - 2).set(playerPosition[1], "*");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			return newState;
			
		}
		
		// 7
		// moving a box off of a goal
		// _*@ -> $+_
		
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("@") && 
				temp.get(playerPosition[0] - 1).get(playerPosition[1]).equals("*") &&
				temp.get(playerPosition[0] - 2).get(playerPosition[1]).equals(" ")) {
			
			temp.get(playerPosition[0]).set(playerPosition[1], " ");
			temp.get(playerPosition[0] - 1).set(playerPosition[1], "+");
			temp.get(playerPosition[0] - 2).set(playerPosition[1], "$");
			
			State newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			return newState;
			
		}
		
		State newState = new State(temp);
		newState.setParent(state);
		state.addChild(newState);
		return newState;

	}

	
}
