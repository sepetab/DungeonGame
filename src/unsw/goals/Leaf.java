package unsw.goals;


/**
 * 
 * Leaf interface for Composite goal pattern
 *
 */

public abstract class Leaf implements Goal{
	
		@Override
		public abstract boolean checkGoal();
		@Override
		public void addChild(Goal child) {
			
		}
		@Override
		public void removeChild(Goal child) {			
		}



}