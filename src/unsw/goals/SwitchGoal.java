package unsw.goals;

import unsw.entites.*;
import unsw.dungeon.*;


public class SwitchGoal extends Leaf{
	
	Dungeon dungeon;
	/**
	 * 
	 * @param entities list in dungeon
	 * @param player in dungeon
	 */
	public SwitchGoal(Dungeon dungeon) {
		this.dungeon = dungeon;
		
	}
	@Override
	/**
	 * Checks if SwitchGoal is accomplished
	 */
	public boolean checkGoal() {
		// TODO Auto-generated method stub
		for(Entity entity : dungeon.getEntity()) {
			if(entity instanceof Floorswitch) {
				if(!((Floorswitch) entity).triggered(dungeon)) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Informs player of goal on the side pane, to complete the game
	 * (all switches have boulders on them)
	 * @return
	 */
	@Override
	public String toString() {
		String returner = null;
		
		returner = "*Move all boulders to switch";
		
		return returner;
	}

}
