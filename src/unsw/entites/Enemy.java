package unsw.entites;
import unsw.dungeon.*;

public class Enemy extends Entity implements NonPhysEnt{
	
	String name = "enemy";
	Dungeon dungeon;
	Movement move;
	Run runaway;
	Run runtowards;
	public boolean dead = false;
	/**
	 * 
	 * @param x sets x coordinate of enemy
	 * @param y sets y coordinate of enemy
	 */
	public Enemy(int x, int y,Dungeon dungeon) {
        super(x, y);
        this.dungeon = dungeon;
        move  = new Movement(getX(), getY(),dungeon,this);
        runaway = new RunAway(dungeon.getPlayer(),this);
        runtowards = new RunTowards(dungeon.getPlayer(),this);
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
     * used to remove entity from deungeon
     */
	public void enemydead(Player player) {
		//System.out.println("ENEMY DELETION");
		this.dead = true;
		player.getDungeon().removeentity(getX(), getY(), name);
		dungeon.deleteentity(getX(),getY(),name);
		
		
	}
	
	/**
	 * update method for observer pattern
	 */
	public void run(Player player) {
		//System.out.println("Updated");
		
			
			if(player.getInvincible() == true) {
				if(!((player.getX() == this.getX()) && (player.getY() == this.getY()))) {

					runaway.move();
					updatemove();
				}else {
					
					this.enemydead(player);
					player.getDungeon().checkGoal();

				}
			}else if(player.getInvincible() == false) {
				
				if(!((player.getX() == this.getX()) && (player.getY() == this.getY()))) {
					//System.out.println(player.getInvincible() + "   " + player.getX() + "   " + getX() + "   " + player.getY() + "   " + getY());

					runtowards.move();
					updatemove();
				}else {
					if(!this.dead) {
						player.killPlayer();
					}
				
				}
			
			}
		
		
	}
	
	/**
	 * 
	 * @return Movement object
	 */
	public Movement move() {
		return move;
	}
	
	/**
	 * updates Move whenever enemy moves
	 */
	private void updatemove() {
		move = new Movement(getX(), getY(),dungeon,this);
	}
	
	/**
	 * Enemy dies or kills when in contact with player
	 */
	@Override
	public void interaction(Player player) {
		if(player.getInvincible()) {
			enemydead(player);
			player.getDungeon().checkGoal();

		}else {
			player.killPlayer();
		}
		
	}
	

}