package unsw.goals;


import java.util.ArrayList;


public abstract class CompositeGoals implements Goal {
	
	//Abstract class is used to extend the different composite classes
	ArrayList<Goal> children = new ArrayList<Goal>();
	
	/**
	 * @param child is the goal that is needed to add to the goal list
	 */
	public void addChild(Goal child) {
		children.add(child);
	}
	/**
	 * @param child is the goal that is needed to remove from the goal list
	 */
	public void removeChild(Goal child) {
		children.remove(child);
	}
	
	
}
