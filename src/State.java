import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


public class State {
	
	ArrayList<ArrayList<String>> data;
	private State parent;
	private List<State> children;
	char parentMove;
	private int cost;
	
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
	
//	public boolean equals(Object obj) {
//		//if the object is a state
//		//if it's not, return false
//		//if it is, start to compare the contents
//		//compare data
//		//if this.data.equals(input object data) return true
//		//else return false
//		
//		if(!(obj instanceof State)) {
//			return false;
//		}
//		
//		State temp = (State) obj;
//		
//		if (this.data.equals(temp.data)) {
//			return true;	
//		} else {
//			return false;
//		}
//	}
	
	public boolean equals(final Object obj){
	    if(obj instanceof State){
	        final State other = (State) obj;
	        return new EqualsBuilder()
	            .append(data, other.data)
	            .isEquals();
	    } else{
	        return false;
	    }
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
	
//	public int hashCode() {
//		return new HashCodeBuilder(17, 37).
//		append(data).
//		append(parent).
//		append(children).
//		append(parentMove).
//		append(cost).
//		toHashCode();
//		
//	}
	
	//FIX THIS
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + 7;
		result = prime * result + ((Character.toString(parentMove) == null) ? 0 : Character.toString(parentMove).hashCode());
//		result = prime * result + Arrays.hashCode(data);
		result = prime * result + 44729;
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		return result;
	}
	
}
