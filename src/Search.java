/**
 * Search.java
 * My search interface
 * @author jal2238
 *
 */
public interface Search {
	
	public State searchGoal(State currentState);
	
	public boolean checkGoal(State state);

}