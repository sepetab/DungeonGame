package unsw.goals;

import unsw.dungeon.Dungeon;

import unsw.entites.*;


public class TreasureGoal extends Leaf{
	Dungeon dungeon;
	/**
	 * 
	 * @param entities list in dungeon
	 * @param player in dungeon
	 */
	public TreasureGoal(Dungeon dungeon) {
		this.dungeon = dungeon;
		
	}
	@Override
	/**
	 * Checks if TreasureGoal is accomplished
	 */
	public boolean checkGoal() {
		for(Entity entity : dungeon.getEntity()){
			if(entity instanceof Treasure) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Informs viewer of the goal on the side pane, to complete the game
	 * (get all treasure)
	 * @return
	 */
	public String toString() {
		String returner = null;
		
		returner = "*Collect all treasure";
		
		return returner;
	}
	
}
