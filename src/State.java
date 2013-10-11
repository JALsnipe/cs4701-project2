import java.util.ArrayList;
import java.util.List;


public class State {
	
	private ArrayList<ArrayList<String>> data;
	private State parent;
	private List<State> children;
	
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
		return data.toString();
	}
	
	public State(ArrayList<ArrayList<String>> data) {
		
		this.data = data;
		children = new ArrayList<State>();
		
	}
	
}
