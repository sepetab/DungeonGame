package unsw.goals;

public class AndCompositeGoals extends CompositeGoals{
	
	/**
	 * @return If all goals accomplished
	 */
	@Override
	public boolean checkGoal() {
		boolean returner = true;
		for(Goal x : children) {
			if(!(x.checkGoal())) {
				returner = false;
				break;
			}
		}
		return returner;
	}
	/**
	 * displays 'And' goals in the side pane
	 * @return
	 */
	public String toString() {
		String returner = "Requirment: Compulsory\n";
		for(Goal x : children) {
		
				returner = returner + "\n" + x.toString() + "\n";
		}
		
		return returner;
	}

}
