package unsw.goals;
import unsw.entites.*;

import java.util.ArrayList;
import java.util.List;


public class KillEnemyGoal extends Leaf{
	List<Entity> entities = new ArrayList<Entity>();
	/**
	 * 
	 * @param entities list in dungeon
	 * @param player in dungeon
	 */
	public KillEnemyGoal(List<Entity> entities) {
		this.entities = entities;
		
	}
	/**
	 * Checks if KillEnemyGoal is accomplished
	 */
	public boolean checkGoal() {
		for(Entity entity : entities){
			if(entity instanceof Enemy) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Informs player of goal on the side pane, to complete the game
	 * (all enemies destroyed)
	 * @return
	 */
	public String toString() {
		String returner = null;
		
		returner = "*Destroy all enemies";
		
		return returner;
	}
}
