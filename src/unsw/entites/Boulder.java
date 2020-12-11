package unsw.entites;
import unsw.dungeon.*;


public class Boulder extends Entity implements PhysicalEntities{
	
	String name = "boulder";
    Dungeon dungeon;
    Movement move;
    
    /**
	 * 
	 * @param x sets x coordinate of boulder
	 * @param y sets y coordinate of boulder
	 */
	public Boulder(int x, int y,Dungeon dungeon) {
        super(x, y);
        this.dungeon = dungeon;
        move = new Movement(getX(), getY(),dungeon,this);
    }
	
	/**
	 * @return name of Entity
	 */
	@Override
    public String getName() {
    	return name;
    
	}
	
	/**
	 * @return true if player can get across Entity
	 */
    public Boolean transparency(){
    	return false;
    }
    
    /**
     * Moves the boulder and lets player move.
     * @param player 
     * @return true if player can get to the position requested 
     */
	@Override
	public Boolean playeradjacent(Player player) {
		if(player.getY() -1 == player.getNextMoveY()) {
			if(!this.move.moveUp()) {
				return false;
			}else {
				updatemove();
			}
		}
		if(player.getY() +1 == player.getNextMoveY()) {
			if(!this.move.moveDown()) {
				return false;
			}else {
				updatemove();
			}
		}
		if(player.getX() +1 == player.getNextMoveX()) {
			if(!this.move.moveRight()) {
				return false;
			}else {
				updatemove();
			}
		}
		if(player.getX() -1 == player.getNextMoveX()) {
			if(!this.move.moveLeft()) {
				return false;
			}else {
				updatemove();
			}
		}
		return true;
	}
	
	/**
	 * Movement parameter is updated
	 */
	private void updatemove() {
		move = new Movement(getX(), getY(),dungeon,this);
	}

}