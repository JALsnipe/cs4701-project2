import java.util.ArrayList;
import java.util.Collections;


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

	public static int[] getPlayerPosition(State state) {
		int[] playerPosition = {0, 0};
		ArrayList<ArrayList<String>> temp;
		temp = copy(state.getData());
		for (int k = 0; k < temp.size(); k++) {
			for(int m = 0; m < temp.get(k).size(); m++) {
				if (temp.get(k).get(m).equals(String.valueOf('@'))) {
					playerPosition[0] = k;
					playerPosition[1] = m;
				}
			}
		}
		return playerPosition;
	}
	
	public static State goLeft (State state, int[] playerPosition) {

		ArrayList<ArrayList<String>> temp;
		temp = copy(state.getData());
		State newState = null;


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
			newState.setParentMove('l');
			newState.setCost(2);
			return newState;

		}

		newState = new State(temp);
		newState.setParent(state);
		state.addChild(newState);
		newState.setParentMove('l');
		newState.setCost(0);
		return newState;

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
		newState.setCost(0);
//		System.out.println("error");
		return newState;

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
		newState.setCost(0);
//		System.out.println("error");
		return newState;

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
		newState.setCost(0);
//		System.out.println("error");
		return newState;

	}

	/**
	 * Gets all the box locations from a state
	 * @param state
	 * @return boxList - an ArrayList of box coordinate pairs
	 */
	public static ArrayList<int[]> getBoxLocations(State state) {
		ArrayList<int[]> boxList = new ArrayList<int[]>();
		int[] boxPosition = {0, 0};
		ArrayList<ArrayList<String>> temp;
		temp = copy(state.getData());
		for (int k = 0; k < temp.size(); k++) {
			for(int m = 0; m < temp.get(k).size(); m++) {
				if (temp.get(k).get(m).equals("$")) {
					boxPosition[0] = k;
					boxPosition[1] = m;
					boxList.add(boxPosition);
					continue;
				}
			}
			
			for(int m = 0; m < temp.get(k).size(); m++) {
				if (temp.get(k).get(m).equals("*")) {
					boxPosition[0] = k;
					boxPosition[1] = m;
					boxList.add(boxPosition);
					continue;
				}
			}
		}
		
		return boxList;
		
	}
	
	/**
	 * Gets all the goal locations from a state
	 * @param state
	 * @return goalList - an ArrayList of goal coordinate pairs
	 */
	public static ArrayList<int[]> getGoalLocations(State state) {
		ArrayList<int[]> goalList = new ArrayList<int[]>();
		int[] goalPosition = {0, 0};
		ArrayList<ArrayList<String>> temp;
		temp = copy(state.getData());
		for (int k = 0; k < temp.size(); k++) {
			for(int m = 0; m < temp.get(k).size(); m++) {
				if (temp.get(k).get(m).equals(".")) {
					goalPosition[0] = k;
					goalPosition[1] = m;
					goalList.add(goalPosition);
					continue;
				}
			}
			
			for(int m = 0; m < temp.get(k).size(); m++) {
				if (temp.get(k).get(m).equals("*")) {
					goalPosition[0] = k;
					goalPosition[1] = m;
					goalList.add(goalPosition);
					continue;
				}
			}
		}
		
		return goalList;
		
	}
	
}
