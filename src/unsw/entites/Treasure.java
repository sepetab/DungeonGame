package unsw.entites;


public class Treasure extends Entity implements NonPhysEnt{
	public int mate =0;
	String name = "treasure";
	
	/**
	 * 
	 * @param x sets x coordinate of treasure
	 * @param y sets y coordinate of treasure
	 */
	public Treasure(int x, int y) {
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
	 * When the player interacts, treasure disappears
	 */
	public void interaction(Player player) {
		player.getDungeon().setTc(player.getDungeon().getTc() + 1);
		player.getDungeon().treasure().set("All treasure collected:"  + " " + "("+player.getDungeon().getTc()+")" + "(NO)\n");
		player.getDungeon().removeentity(getX(), getY(), name);
		player.getDungeon().deleteentity(getX(), getY(), name);
		//BAD IDEA HERE:
		int flag =0;
		for(Entity entity : player.getDungeon().getEntity()){
			if(entity instanceof Treasure) {
				flag =1;
			}
		}
		if(flag == 0) {
			player.getDungeon().treasure().set("All treasure collected:"  + " " + "("+player.getDungeon().getTc()+")" + "(YES)\n");
		}
		//BAD IDEA END
		player.getDungeon().checkGoal();
	}

}