package unsw.goals;
import unsw.entites.*;

import java.util.ArrayList;
import java.util.List;

public class GateGoal extends Leaf{
	
	List<Entity> entities = new ArrayList<Entity>();
	Player player;
	/**
	 * 
	 * @param entities list in dungeon
	 * @param player in dungeon
	 */
	public GateGoal(List<Entity> entities,Player player) {
		this.entities = entities;
		this.player = player;
		
	}
	/**
	 * Checks if GateGoal is accomplished
	 */
	@Override
	public boolean checkGoal() {
		for(Entity entity : entities) {
			if(entity instanceof Exit) {
				return ((Exit) entity).isPlayerHere(player);
				
			}
		}
		return false;
	}
	
	/**
	 * Informs player of the goal on side pane, to complete the game
	 * (getting to exit)
	 * @return
	 */
	public String toString() {
		String returner = null;
		
		returner = "*Reach exit";
		
		return returner;
	}
	

}
