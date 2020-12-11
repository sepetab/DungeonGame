package unsw.goals;

/**
 * 
 * Composite pattern interface for goal
 *
 */
public interface Goal {
	boolean checkGoal();
	void addChild(Goal child);
	void removeChild(Goal child);

}
