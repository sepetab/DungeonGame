package unsw.dungeon;
import unsw.entites.*;



import java.util.ArrayList;
import java.util.List;

public class Movement {
	private int x;
	private int y;
	private Dungeon dungeon;
	private Entity entity;
	/**
	 * 
	 * @param x the x coordinate of player
	 * @param y the y coordinate of player
	 * @param dungeon the dungeon in game
	 * @param entity the entity to move
	 */
	public Movement(int x, int y, Dungeon dungeon,Entity entity){
		this.x = x;
		this.y = y;
		this.dungeon = dungeon;
		this.entity = entity;
		//System.out.println(dungeon.getWidth());
	}
	/**
	 * 
	 * @return true if it is possible to move up
	 */
	 public Boolean moveUp() {
	        if (y > 0 && canMove(x,y - 1)) {
	        	 entity.y().set(y - 1);  	        	 
	        	 return true;
	        }
	        return false;
	    }
	 	/**
		 * 
		 * @return true if it is possible to move down
		 */
		 
	    public Boolean moveDown() {
	        if (y < dungeon.getHeight() - 1 && canMove(x,y + 1)) {
	            entity.y().set(y + 1);
	            return true;
	        }   
	        
	        return false;
	    }
	    /**
		 * 
		 * @return true if it is possible to move left
		 */
	    public Boolean moveLeft() {
	        if (x > 0 && canMove(x -1 ,y)) {
	            entity.x().set(x - 1);
	            return true;
	        }    
	        
	        return false;
	    }
	    /**
		 * 
		 * @return true if it is possible to move right
		 */
	    public Boolean moveRight() {
	    	//System.out.print("From" + x + y);
	        if (x < dungeon.getWidth() - 1 && canMove(x + 1,y) ) {
	            entity.x().set(x + 1);
	            return true;
	        }
	        return false;
	    }

	    /**
	     * 
	     * @param x the x coordinate of the next move 
	     * @param y the y coordinate of the next move 
	     * @return true if move is  possible
	     */
	    private Boolean canMove(int x, int y) {
	    	
	    	//System.out.println(dungeon.getWidth());
	    	List<Entity> entities =new ArrayList<Entity>();
	    	entities = dungeon.checkEntity(x, y);
	    	for(Entity entity:entities) {
	    		if(!entity.transparency()) {
	    			return false;
	    		}
	    	}
	    	return true;
	    }
	}

