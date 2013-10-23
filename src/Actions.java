import java.util.ArrayList;
import java.util.Comparator;


public class Actions {

	public static ArrayList<ArrayList<String>> copy(ArrayList<ArrayList<String>> input) {

	    ArrayList<ArrayList<String>> copy = new ArrayList<ArrayList<String>>();

	    for(int i = 0; i < input.size(); i++) {
	        ArrayList<String> line = new ArrayList<String>();

	        for(int j = 0; j < input.get(i).size(); j++) {
	            line.add(input.get(i).get(j));
	        }

	        copy.add(line);
	    }
	    return copy;
	}

	// have an action to get the player position?
	public static int[] getPlayerPosition(State state) {
		int[] playerPosition = {0, 0};
		ArrayList<ArrayList<String>> temp;
		temp = copy(state.getData());
		for (int k = 0; k < temp.size(); k++) {
			for(int m = 0; m < temp.get(k).size(); m++) {
				if (temp.get(k).get(m).equals(String.valueOf('@'))) {
					playerPosition[0] = k;
					playerPosition[1] = m;
					//					return playerPosition;
				}
			}
		}
		return playerPosition;
	}
	
	public boolean isValidLeftMove (State state, int[] playerPosition) {
		
		ArrayList<ArrayList<String>> temp;
		temp =  copy(state.getData());
		
		if((temp.get(playerPosition[0]).get(playerPosition[1]).equals("@") ||
				temp.get(playerPosition[0]).get(playerPosition[1]).equals("+")) && 
				temp.get(playerPosition[0]).get(playerPosition[1] - 1).equals("#")) {
			
			return false;
			
		}
		
		if((temp.get(playerPosition[0]).get(playerPosition[1]).equals("@") ||
				temp.get(playerPosition[0]).get(playerPosition[1]).equals("+")) && 
				temp.get(playerPosition[0]).get(playerPosition[1] - 1).equals("$") &&
				temp.get(playerPosition[0]).get(playerPosition[1] - 2).equals("#")) {
			
			return false;
			
		}
		
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("@") && 
				temp.get(playerPosition[0]).get(playerPosition[1] - 1).equals("$") &&
				temp.get(playerPosition[0]).get(playerPosition[1] - 2).equals("$")) {
			
			return false;
			
		}
		
		return true;
		
	}

	public static State goLeft (State state, int[] playerPosition) {

		ArrayList<ArrayList<String>> temp;
		temp = copy(state.getData());
		State newState = null;
		//		System.out.println("in left");
		//		System.out.println("state: " + state.toString());
		//		System.out.println("temp array: " + temp);

		//		System.out.println(SokobanTester.playerPosition[0] + " " + SokobanTester.playerPosition[1]);
		//		System.out.println(Arrays.toString(Actions.getPlayerPosition(state)));
		//		System.out.println("temp array: " + temp);

		// 1
		// if the space to the left of you is free, you can move left
		// _@ -> @_
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("@") && 
				temp.get(playerPosition[0]).get(playerPosition[1] - 1).equals(" ")) {

			temp.get(playerPosition[0]).set(playerPosition[1], " ");
			temp.get(playerPosition[0]).set(playerPosition[1] - 1, "@");

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			//			System.out.println(newState);
			newState.setParentMove('l');
			newState.setCost(1);
			return newState;

		}

		// 2
		// case for if the player is on a goal
		// _+ -> @.
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0]).get(playerPosition[1] - 1).equals(" ")) {

			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0]).set(playerPosition[1] - 1, "@");

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			//			System.out.println(newState);
			newState.setParentMove('l');
			newState.setCost(1);
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

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			//			System.out.println(newState);
			newState.setParentMove('l');
			newState.setCost(2);
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

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			//			System.out.println(newState);
			newState.setParentMove('l');
			newState.setCost(2);
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

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			//			System.out.println(newState);
			newState.setParentMove('l');
			newState.setCost(2);
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

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			//			System.out.println(newState);
			newState.setParentMove('l');
			newState.setCost(2);
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

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			//			System.out.println(newState);
			newState.setParentMove('l');
			newState.setCost(2);
			return newState;

		}

		// 8
		// player on goal case
		// _*+ -> $+.

		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0]).get(playerPosition[1] - 1).equals("*") &&
				temp.get(playerPosition[0]).get(playerPosition[1] - 2).equals(" ")) {

			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0]).set(playerPosition[1] - 1, "+");
			temp.get(playerPosition[0]).set(playerPosition[1] - 2, "$");

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			//			System.out.println(newState);
			newState.setParentMove('l');
			newState.setCost(2);
			return newState;

		}

		// 9
		// moving onto a goal
		// .@ -> +_

		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("@") && 
				temp.get(playerPosition[0]).get(playerPosition[1] - 1).equals(".")) {

			temp.get(playerPosition[0]).set(playerPosition[1], " ");
			temp.get(playerPosition[0]).set(playerPosition[1] - 1, "+");

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			//			System.out.println(newState);
			newState.setParentMove('l');
			newState.setCost(1);
			return newState;

		}

		// 10
		// player on goal case
		// .+ -> +.

		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0]).get(playerPosition[1] - 1).equals(".")) {

			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0]).set(playerPosition[1] - 1, "+");

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			//			System.out.println(newState);
			newState.setParentMove('l');
			newState.setCost(1);
			return newState;

		}

		// 11
		// new case
		// _*+ -> $+.

		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0]).get(playerPosition[1] - 1).equals("*") &&
				temp.get(playerPosition[0]).get(playerPosition[1] - 2).equals(" ")) {

			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0]).set(playerPosition[1] - 1, "+");
			temp.get(playerPosition[0]).set(playerPosition[1] - 2, "$");

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			//			System.out.println(newState);
			newState.setParentMove('l');
			newState.setCost(2);
			return newState;

		}

		// 12
		// new case2
		// .*+ -> *+.

		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0]).get(playerPosition[1] - 1).equals("*") &&
				temp.get(playerPosition[0]).get(playerPosition[1] - 2).equals(".")) {

			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0]).set(playerPosition[1] - 1, "+");
			temp.get(playerPosition[0]).set(playerPosition[1] - 2, "*");

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			//			System.out.println(newState);
			newState.setParentMove('l');
			newState.setCost(2);
			return newState;

		}

		newState = new State(temp);
//		System.out.println("left: " + newState);
		newState.setParent(state);
		state.addChild(newState);
		//		System.out.println(newState);
		newState.setParentMove('l');
//		System.out.println("error");
		return null;

	}
	
	public static State goRight(State state, int[] playerPosition) {

		ArrayList<ArrayList<String>> temp;
		temp =  copy(state.getData());
		State newState;
		//		System.out.println("in right");

		// 1
		// if the space to the left of you is free, you can move left
		// @_ -> _@
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("@") && 
				//				isBlank(puzzle, playerPosition[0], playerPosition[1] - 1)) {
				temp.get(playerPosition[0]).get(playerPosition[1] + 1).equals(" ")) {

			temp.get(playerPosition[0]).set(playerPosition[1], " ");
			temp.get(playerPosition[0]).set(playerPosition[1] + 1, "@");

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			//			System.out.println(newState);
//			System.out.println("first right action");
//			System.out.println(newState);
			newState.setParentMove('r');
			newState.setCost(1);
			return newState;

		}

		// 2
		// case for if the player is on a goal
		// +_ -> .@
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0]).get(playerPosition[1] + 1).equals(" ")) {

			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0]).set(playerPosition[1] + 1, "@");

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			//			System.out.println(newState);
			newState.setParentMove('r');
			newState.setCost(1);
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

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			newState.setParentMove('r');
			newState.setCost(2);
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

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			newState.setParentMove('r');
			newState.setCost(2);
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

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			newState.setParentMove('r');
			newState.setCost(2);
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

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			newState.setParentMove('r');
			newState.setCost(2);
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

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			newState.setParentMove('r');
			newState.setCost(2);
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

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			newState.setParentMove('r');
			newState.setCost(2);
			return newState;

		}

		// 9
		// moving onto a goal
		// @. -> _+

		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("@") && 
				temp.get(playerPosition[0]).get(playerPosition[1] + 1).equals(".")) {

			temp.get(playerPosition[0]).set(playerPosition[1], " ");
			temp.get(playerPosition[0]).set(playerPosition[1] + 1, "+");

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			newState.setParentMove('r');
			newState.setCost(1);
			return newState;

		}

		// 10
		// player on goal case
		// +. -> .+

		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0]).get(playerPosition[1] + 1).equals(".")) {

			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0]).set(playerPosition[1] + 1, "+");

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			newState.setParentMove('r');
			newState.setCost(1);
			return newState;

		}

		// 11
		// new case
		// _*+ -> $+.

		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0]).get(playerPosition[1] + 1).equals("*") &&
				temp.get(playerPosition[0]).get(playerPosition[1] + 2).equals(" ")) {

			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0]).set(playerPosition[1] + 1, "+");
			temp.get(playerPosition[0]).set(playerPosition[1] + 2, "$");

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			//			System.out.println(newState);
			newState.setParentMove('r');
			newState.setCost(2);
			return newState;

		}

		// 12
		// new case2
		// .*+ -> *+.

		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0]).get(playerPosition[1] + 1).equals("*") &&
				temp.get(playerPosition[0]).get(playerPosition[1] + 2).equals(".")) {

			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0]).set(playerPosition[1] + 1, "+");
			temp.get(playerPosition[0]).set(playerPosition[1] + 2, "*");

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			//			System.out.println(newState);
			newState.setParentMove('r');
			newState.setCost(2);
			return newState;

		}

		newState = new State(temp);
//		System.out.println("right: " + newState);
		newState.setParent(state);
		state.addChild(newState);
		newState.setParentMove('r');
//		System.out.println("error");
		return null;

	}

	public static State goDown(State state, int[] playerPosition) {

		ArrayList<ArrayList<String>> temp;
		temp =  copy(state.getData());
		State newState = null;
		//		System.out.println("in down");

		// 1
		// if the space to the left of you is free, you can move left
		// @_ -> _@
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("@") && 
				//				isBlank(puzzle, playerPosition[0], playerPosition[1] - 1)) {
				temp.get(playerPosition[0] + 1).get(playerPosition[1]).equals(" ")) {

			temp.get(playerPosition[0]).set(playerPosition[1], " ");
			temp.get(playerPosition[0] + 1).set(playerPosition[1], "@");

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			newState.setParentMove('d');
			newState.setCost(1);
			return newState;

		}

		// 2
		// case for if the player is on a goal
		// +_ -> .@
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0] + 1).get(playerPosition[1]).equals(" ")) {

			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0] + 1).set(playerPosition[1], "@");

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			newState.setParentMove('d');
			newState.setCost(1);
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

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			newState.setParentMove('d');
			newState.setCost(2);
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

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			newState.setParentMove('d');
			newState.setCost(2);
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

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			newState.setParentMove('d');
			newState.setCost(2);
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

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			newState.setParentMove('d');
			newState.setCost(2);
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

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			newState.setParentMove('d');
			newState.setCost(2);
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

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			newState.setParentMove('d');
			newState.setCost(2);
			return newState;

		}

		// 9
		// moving onto a goal
		// @. -> _+

		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("@") && 
				temp.get(playerPosition[0] + 1).get(playerPosition[1]).equals(".")) {

			temp.get(playerPosition[0]).set(playerPosition[1], " ");
			temp.get(playerPosition[0] + 1).set(playerPosition[1], "+");

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			newState.setParentMove('d');
			newState.setCost(1);
			return newState;

		}

		// 10
		// player on goal case
		// +. -> .+

		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0] + 1).get(playerPosition[1]).equals(".")) {

			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0] + 1).set(playerPosition[1], "+");

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			newState.setParentMove('d');
			newState.setCost(1);
			return newState;

		}

		// 11
		// new case
		// _*+ -> $+.

		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0] + 1).get(playerPosition[1]).equals("*") &&
				temp.get(playerPosition[0] + 2).get(playerPosition[1]).equals(" ")) {

			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0] + 1).set(playerPosition[1], "+");
			temp.get(playerPosition[0] + 2).set(playerPosition[1], "$");

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			//			System.out.println(newState);
			newState.setParentMove('d');
			newState.setCost(2);
			return newState;

		}

		// 12
		// new case2
		// .*+ -> *+.

		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0] + 1).get(playerPosition[1]).equals("*") &&
				temp.get(playerPosition[0] + 2).get(playerPosition[1]).equals(".")) {

			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0] + 1).set(playerPosition[1], "+");
			temp.get(playerPosition[0] + 2).set(playerPosition[1], "*");

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			//			System.out.println(newState);
			newState.setParentMove('d');
			newState.setCost(2);
			return newState;

		}
		newState = new State(temp);
//		System.out.println("down: " + newState);
		newState.setParent(state);
		state.addChild(newState);
		newState.setParentMove('d');
//		System.out.println("error");
		return null;

	}

	public static State goUp (State state, int[] playerPosition) {

		ArrayList<ArrayList<String>> temp;
		temp =  copy(state.getData());
		State newState = null;
		//		System.out.println("in up");

		// 1
		// if the space to the left of you is free, you can move left
		// _@ -> @_
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("@") && 
				temp.get(playerPosition[0] - 1).get(playerPosition[1]).equals(" ")) {

			temp.get(playerPosition[0]).set(playerPosition[1], " ");
			temp.get(playerPosition[0] - 1).set(playerPosition[1], "@");

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			newState.setParentMove('u');
//			System.out.println("newState char: " + newState.getParentMove());
			newState.setCost(1);
			return newState;

		}

		// 2
		// case for if the player is on a goal
		// _+ -> @.
		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0] - 1).get(playerPosition[1]).equals(" ")) {

			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0] - 1).set(playerPosition[1], "@");

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			newState.setParentMove('u');
			newState.setCost(1);
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

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			newState.setParentMove('u');
			newState.setCost(2);
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

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			newState.setParentMove('u');
			newState.setCost(2);
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

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			newState.setParentMove('u');
			newState.setCost(2);
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

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			newState.setParentMove('u');
			newState.setCost(2);
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

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			newState.setParentMove('u');
			newState.setCost(2);
			return newState;

		}

		// 8
		// player on goal case
		// +*_ -> .+$

		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0] - 1).get(playerPosition[1]).equals("*") &&
				temp.get(playerPosition[0] - 2).get(playerPosition[1]).equals(" ")) {

			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0] - 1).set(playerPosition[1], "+");
			temp.get(playerPosition[0] - 2).set(playerPosition[1], "$");

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			newState.setParentMove('u');
			newState.setCost(2);
			return newState;

		}

		// 9
		// moving onto a goal
		// @. -> _+

		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("@") && 
				temp.get(playerPosition[0] - 1).get(playerPosition[1]).equals(".")) {

			temp.get(playerPosition[0]).set(playerPosition[1], " ");
			temp.get(playerPosition[0] - 1).set(playerPosition[1], "+");

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			newState.setParentMove('u');
			newState.setCost(1);
			return newState;

		}

		// 10
		// player on goal case
		// +. -> .+

		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0] - 1).get(playerPosition[1]).equals(".")) {

			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0] - 1).set(playerPosition[1], "+");

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			newState.setParentMove('u');
			newState.setCost(1);
			return newState;

		}

		// 11
		// new case
		// _*+ -> $+.

		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0] - 1).get(playerPosition[1]).equals("*") &&
				temp.get(playerPosition[0] - 2).get(playerPosition[1]).equals(" ")) {

			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0] - 1).set(playerPosition[1], "+");
			temp.get(playerPosition[0] - 2).set(playerPosition[1], "$");

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			//					System.out.println(newState);
			newState.setParentMove('u');
			newState.setCost(2);
			return newState;

		}

		// 12
		// new case2
		// .*+ -> *+.

		if(temp.get(playerPosition[0]).get(playerPosition[1]).equals("+") && 
				temp.get(playerPosition[0] - 1).get(playerPosition[1]).equals("*") &&
				temp.get(playerPosition[0] - 2).get(playerPosition[1]).equals(".")) {

			temp.get(playerPosition[0]).set(playerPosition[1], ".");
			temp.get(playerPosition[0] - 1).set(playerPosition[1], "+");
			temp.get(playerPosition[0] - 2).set(playerPosition[1], "*");

			newState = new State(temp);
			newState.setParent(state);
			state.addChild(newState);
			//					System.out.println(newState);
			newState.setParentMove('u');
			newState.setCost(2);
			return newState;

		}
		
//		System.out.println("up: " + newState);
		newState = new State(temp);
		newState.setParent(state);
		state.addChild(newState);
		newState.setParentMove('u');
//		System.out.println("error");
		return null;

	}
	
	// FIX THIS
	public class SortQueueViaLowestCost implements Comparator {

	    public int compare(Object o1, Object o2){
	        State s1 = (State) o1; 
	        State s2 = (State) o2;

	        if( s1 == null || s2 == null ){
	            if( s1 == s2 ) return 0;
	            else if( s2 == null) return +1;
	                else return -1;
	        }

	    Integer i1 = (Integer) s1.getCost();
	    Integer i2 = (Integer) s2.getCost();
	    return i2.compareTo(i1); // Not sure this is right.
	    }
	}


}
