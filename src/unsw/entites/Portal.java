package unsw.entites;
import unsw.dungeon.*;



import java.util.ArrayList;
import java.util.List;



public class Portal extends Entity implements NonPhysEnt{
	
	String name = "portal";
    Dungeon dungeon;
    List<Entity> entities;
    
    /**
	 * 
	 * @param x sets x coordinate of portal
	 * @param y sets y coordinate of portal
	 */
	public Portal(int x, int y) {
        super(x, y);
        entities = new ArrayList<Entity>();
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
     * Teleports player to the other portal
     * @param player
     * 
     */
    @Override
	public void interaction(Player player) {
    	dungeon = player.getDungeon();
    	entities = dungeon.getEntity();
    	for(Entity entity : entities) {
    		if(entity instanceof Portal && entity!=this) {
    			if(entity.getId() == this.getId()) {
	    			player.x().set(entity.getX());
	    			player.y().set(entity.getY());
	    			player.updatemove();
	    			break;
    			}
    		}
    	}
    }
  
    
  
}