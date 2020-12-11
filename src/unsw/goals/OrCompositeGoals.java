package unsw.goals;


public class OrCompositeGoals extends CompositeGoals{

	/**
	 * checks Each goal in children and returns true if at least 1 is accomplished
	 */
	@Override
	public boolean checkGoal() {
		for(Goal x : children) {
			if(x.checkGoal()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * displays 'Or' goals in the side pane
	 * @return
	 */
	public String toString() {
		String returner = "Requirement: Complete One \n";
		
		for(Goal x : children) {
	
				returner = returner + "\n" + x.toString() + "\n";
			
		}
		//returner = returner + "\n";
		return returner;
	}

}
