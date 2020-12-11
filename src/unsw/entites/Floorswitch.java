package unsw.entites;


import java.util.ArrayList;
import java.util.List;

import unsw.dungeon.Dungeon;

public class Floorswitch extends Entity implements NonPhysEnt{
	
	String name = "floorswitch";
	/**
	 * 
	 * @param x sets x coordinate of floorswitch
	 * @param y sets y coordinate of floorswitch
	 */
	public Floorswitch(int x, int y) {
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
     * @return transparency
     */
    public Boolean transparency(){
    	return true;
    }
    
    /**
     * 
     * @param entities list of entities in dungeon
     * @return true if this switch is triggered
     */
    public Boolean triggered(Dungeon dungeon) {
    	List<Entity> boulders = new ArrayList<Entity>();
    	boulders = dungeon.checkEntity(getX(), getY());
    	for(Entity b : boulders) {
    		if(b instanceof Boulder) {
    			return true;
    		}
    	}
    	return false;
    }
    
	/**
	 * Dosent do anything since it acts like a floor
	 */
	@Override
	public void interaction(Player player) {
		
	}

}