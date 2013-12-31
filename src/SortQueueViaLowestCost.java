import java.util.Comparator;

/**
 * SortQueueViaLowestCost.java
 * Sorts a queue from lowest cost to highest.
 * @author joshlieberman
 *
 */

public class SortQueueViaLowestCost implements Comparator {

    public int compare(Object o1, Object o2) {
    	State s1 = (State) o1; 
        State s2 = (State) o2;

        Integer i1 = (Integer) s1.getCost();
        Integer i2 = (Integer) s2.getCost();
        return i1.compareTo(i2);
    }
}