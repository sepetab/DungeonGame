package unsw.entites;


import java.util.ArrayList;
import java.util.List;

public class Key extends Entity implements NonPhysEnt{
	
	String name = "key";
	/**
	 * 
	 * @param x sets x coordinate of key
	 * @param y sets y coordinate of key
	 */
	public Key(int x, int y) {
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
     * responsible for making door entity transparent (player can move through)
     * once the key id and door id in interaction are matching
     */
	@Override
	public void interaction(Player player) {
		
		if(player.getkey() == null) {
			player.getDungeon().removeentity(getX(), getY(), name);
			player.setKey(this);
		}
		List<Entity> doors = new ArrayList<Entity>();
		doors = player.getDungeon().checkEntity(player.getNextMoveX(), player.getNextMoveY());
		for(Entity door : doors) {
			if(door instanceof Door) {
				if((door.getId() ==  player.getkey().getId())) {
					((Door) door).Settransparency(true);
					player.getDungeon().deleteentity(player.getkey().getX(),player.getkey().getY(), name);
					player.removeKey();
				}
			}
		}
		
		
	}
   

}