package unsw.entites;
import unsw.dungeon.*;

public class Door extends Entity implements NonPhysEnt{
	
	String name = "door";
	Dungeon dungeon;
	private Boolean transparency = false;
	
	/**
	 * 
	 * @param x sets x coordinate of door
	 * @param y sets y coordinate of door
	 */
	public Door(int x, int y,Dungeon dungeon) {
        super(x, y);
        this.dungeon = dungeon;
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
    	return transparency;
    }
    
    /**
     * 
     * @param k sets transparency 
     */
    public void Settransparency(Boolean k){
    	transparency = k;
    	this.UIDoor().set(true);
    }
    
    /**
     * Only happens when open. Nothing happens
     */
	@Override
	public void interaction(Player player) {
		// TODO Auto-generated method stub
		
	}
   

}