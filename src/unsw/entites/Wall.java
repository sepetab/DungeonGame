package unsw.entites;



public class Wall extends Entity {
	String name = "wall";
	
	/**
	 * 
	 * @param x sets x coordinate of wall
	 * @param y sets y coordinate of wall
	 */
    public Wall(int x, int y) {
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
    	return false;
    }

}
