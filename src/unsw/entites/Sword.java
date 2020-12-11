package unsw.entites;
import unsw.dungeon.*;

import java.util.ArrayList;
import java.util.List;

public class Sword extends Entity implements NonPhysEnt{
	
	String name = "sword";
	private int swings =5;
	
	/**
	 * 
	 * @param x sets x coordinate of sword
	 * @param y sets y coordinate of sword
	 */
	public Sword(int x, int y) {
        super(x, y);
    }
	
    /**
     * @return name
     */
	@Override
    public String getName() {
    	return name;
    
	}
	
	/**
	 * @return transparency of sword
	 */
    public Boolean transparency(){
    	return true;
    }
    
    /**
     * sword interaction with player
     * @param player in dungeon
     * 
     */
	@Override
	public void interaction(Player player) {
		if(player.getSword() == null) {
			RemoveFromMap(player.getDungeon());
			player.setSword(this); 
		}
		
	}
	
	/**
	 * Sword usage depicted. Function limited to 5 for each sword entity.
	 * @param player in dungeon
	 */
	public void useSword(Player player) {
		Dungeon dungeon = player.getDungeon();
		swings= swings -1;
		List<Entity> enemies= new ArrayList<Entity>();
		enemies = dungeon.checkEntity(player.getX(),player.getY() - 1);
		enemies.addAll(dungeon.checkEntity(player.getX(),player.getY() + 1));
		enemies.addAll(dungeon.checkEntity(player.getX() + 1,player.getY()));
		enemies.addAll(dungeon.checkEntity(player.getX() - 1,player.getY()));
		for(Entity e : enemies) {
			if(e instanceof Enemy) {
				//System.out.println(e.getX() + "  " + e.getY() + "  " + player.getX() +   "  " + player.getY());
				((Enemy) e).enemydead(player);
				
			}
		}
		if(swings == 0) {
			player.removeSword(); 
			dungeon.deleteentity(getX(), getY(), name);
		}
		
	}
	
	/**
	 * removes from dungeon in UI
	 * @param dungeon
	 */
	public int getSwings() {
		return swings;
	}
	
	/**
	 * removes entity from map since it is 'picked' up by player
	 * @param dungeon
	 */
	public void RemoveFromMap(Dungeon dungeon) {
		//System.out.println(getX() + "  " + getY() + "  " + name);
		dungeon.removeentity(getX(), getY(), name);
	}
    

}