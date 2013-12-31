import java.util.ArrayList;
import java.util.List;

/**
 * State.java
 * Defines a State Object
 * @author jal2238
 *
 */

public class State {
	
	ArrayList<ArrayList<String>> data;
	private State parent;
	private List<State> children;
	char parentMove;
	private int cost;
	private int h;
	
	public ArrayList<ArrayList<String>> getData() {
		return data;
	}
	public void setData(ArrayList<ArrayList<String>> data) {
		this.data = data;
	}
	
	public State getParent() {
		return parent;
	}
	public void setParent(State parent) {
		this.parent = parent;
	}
	public List<State> getChildren() {
		return children;
	}
	public void addChild(State child) {
		this.children.add(child);
	}
	
	public String toString() {
		for(ArrayList<String> temp : data) {
			System.out.println(temp);
		}
		return data.toString();
	}
	
	public State(ArrayList<ArrayList<String>> data) {
		
		this.data = data;
		children = new ArrayList<State>();
		
	}
	
	public boolean equals(Object obj) {
		//if the object is a state
		//if it's not, return false
		//if it is, start to compare the contents
		//compare data
		//if this.data.equals(input object data) return true
		//else return false
		
		if(!(obj instanceof State)) {
			return false;
		}
		
		State temp = (State) obj;
		
		if (this.data.equals(temp.data)) {
			return true;	
		} else {
			return false;
		}
	}
	
	public int hashCode() {
		String allData = "";
		for (ArrayList<String> tmp: this.data) {
			for (String tmpString: tmp) {
				allData = allData + tmpString;
			}
		}
		
		return allData.hashCode();
	}
	
	public char getParentMove() {
		return parentMove;
	}
	
	public void setParentMove(char parentMove) {
		this.parentMove = parentMove;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public void setH(int h) {
		this.h = h;
	}
	
	public int getH() {
		return h;
	}
	
	public int getValue() {
		return this.getH() + this.getCost();
	}
	
}
