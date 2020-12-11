package unsw.entites;


public class Exit extends Entity implements NonPhysEnt{
	
	String name = "exit";
	
	/**
	 * 
	 * @param x sets x coordinate of exit
	 * @param y sets y coordinate of exit
	 */
	public Exit(int x, int y) {
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
	 * dosent do anything since goals are checked everytime player moves
	 */
	@Override
	public void interaction(Player player) {
		
	}
	
	/**
	 * 
	 * @param player
	 * @return true if player is at the exit
	 */
	public boolean isPlayerHere(Player player) {
		return (player.getX() == this.getX() && player.getY() == this.getY());
	}
}