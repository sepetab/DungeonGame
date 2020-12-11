package unsw.entites;
import unsw.dungeon.*;


import java.util.ArrayList;
import java.util.List;

/**
 * The player entity
 * @author Robert Clifton-Everest
 *
 */
public class Player extends Entity implements Subject{

    Dungeon dungeon;
    private Key key = null;
    private int NextMoveX = 0;
    private int NextMoveY = 0;
    private int steptracer = 0;
    private Sword sword = null;
    public Boolean invincible = false;
    List<Observer> observers = new ArrayList<Observer>();
    Movement move;

    /**
     * Create a player positioned in square (x,y)
     * @param x the x coordinate to set player 
     * @param y the y coordinate to set player
     */
    String name = "player";
   
    public Player(Dungeon dungeon, int x, int y) {
        super(x, y);
        this.dungeon = dungeon;
       move = new Movement(getX(), getY(),dungeon,this);

        //System.out.println(dungeon.getWidth());
    }
    
    /**
     * Player moves up if it is possible
     */
    public void moveUp() {
       if(!move.moveUp()) {
    	   if(physinteractor(getX(),getY()-1)) {
    		   move.moveUp();
    		   nonphysinteractor(getX(),getY());
    		   updatemove();
    	   }
       }else {
          	updatemove();
       	nonphysinteractor(getX(),getY());
       }
    }
    
    /**
     * Player moves down if it is possible
     */
    public void moveDown() {
    	 if(!move.moveDown()) {
    		 if(physinteractor(this.getX(),this.getY()+1)) {
    			 move.moveDown();
    			 nonphysinteractor(getX(),getY());
    			 updatemove();
    		 }
         }else {
          	updatemove();
         	nonphysinteractor(getX(),getY());
         }
    }
    
    /**
     * Player moves left if it is possible
     */
    public void moveLeft() {
    	if(!move.moveLeft()) {
    		if(physinteractor(getX()-1,getY())) {
    			move.moveLeft();
    			nonphysinteractor(getX(),getY());
    			updatemove();
    		}
        }else {
        	updatemove();
        	nonphysinteractor(getX(),getY());
        }
    }
    
    /**
     * Player moves right if it is possible
     */
    public void moveRight() {
    	
    	if(!move.moveRight()) {
    		if(physinteractor(getX()+1,getY())) {
    			move.moveRight();
    			nonphysinteractor(getX(),getY());
    			updatemove();
    		}
        }else {
        	//System.out.print("I moved right" + getX() + getY());
        	updatemove();
        	nonphysinteractor(getX(),getY());
        }
    }
    
    /**
     * @return players next X coordinate 
     */
    public int getNextMoveX() {
    	return NextMoveX;
    }
    
    /**
     * @return players next Y coordinate 
     */
    public int getNextMoveY() {
    	return NextMoveY;
    }
    
    /**
     * @return the transparency of object
     */
    public Boolean transparency() {
		return true;
	}
    
    /**
     * Sets the Attack status of player
     */
    public void setSword(Sword sword) {
    	if(this.sword == null) {
    		this.sword = sword;
    		this.UIsword().set(true);
    		dungeon.swordLeft().set("Sword Hits Left: 5\n");
    	}
	}
    
    /**
     * removes sword from player's possession once sword hit counter is 0
     */
    public void removeSword() {
    	this.sword =null;
    	this.UIsword().set(false);
    	dungeon.swordLeft().set("Sword Hits Left: 0\n");
    }
    
    /**
     * responsible for allowing sword to be used while swings is greater than 0
     */
    public void useSword() {
    
    	if(this.getSword() != null) {
    		dungeon.swordLeft().set("Sword Hits Left:" + " " + (this.sword.getSwings()-1) + "\n");
    		this.getSword().useSword(this);
    	}
    }
    
    /**
     * @return the key possessed by the player
     */
    public Key getkey() {
    	return this.key;
    }
    
    /**
     * @param key to set for the player
     */
    public void setKey(Key key) {
    	if(this.key == null) {
    	 this.key = key;
    	 dungeon.keyLeft().set("Key possession: Yes\n");
    	}
    }
    /**
     * Removes key held by player
     */
    public void removeKey() {
    	this.key =null;
    	dungeon.keyLeft().set("Key possession: No\n");
    }
  
    /**
     * @return dungeon
     */
    public Dungeon getDungeon() {
    	return dungeon;
    }
    
    /**
     * @return name 
     */
    public String getName() {
    	return name;
    }
    
    /**
     * Interacts with non physical entities
     * @param x coordinate of player
     * @param y coordinate of player
     * 
     */
    public void nonphysinteractor(int x, int y){
    	//System.out.println(NextMoveX+ "  " + NextMoveY  + "  " + getX() + "  " + getY());
    	NextMoveY = y;
    	NextMoveX =x;
    	
    	List<Entity> entities = new ArrayList<Entity>();
    	entities = dungeon.checkEntity(x, y);
    	for(Entity c : entities) {
    		if(!(c instanceof Player)) {
    			//System.out.println(c.getName());
    			//if(c.getName().equals("enemy")) {
    			//	System.out.println("bakslnasjdhb");
        		//}
	    			((NonPhysEnt) c).interaction(this);
	    		
    		}
    	}
    }
    
    /**
     * Interacts with physical entities
     * @param x coordinate of player
     * @param y coordinate of player
     * 
     */
    public Boolean physinteractor(int x, int y) {
    	NextMoveY = y;
    	NextMoveX =x;
    	List<Entity> entities = new ArrayList<Entity>();
    	entities = dungeon.checkEntity(x, y);
    	Entity entity = null;
    	for(Entity z:entities) {
    		if(!z.transparency()) {
    			entity = z;
    			break;
    		}
    	}
    	if(!(entity instanceof Wall)) {
	    	if(entity instanceof Door) {
	    		//System.out.println("BAHAHAHAHA");
	    		if(this.getkey() !=null) {
	    			this.getkey().interaction(this);
	    		}
	    	}else {
		    	PhysicalEntities phye = (PhysicalEntities) entity;
		    	
	    		if(phye.playeradjacent(this)) {
	    			return true;
	    		}
		 
	    	}
    	}
    	return false;
    }
    
    /**
     * Player is removed from dungeon
     */
    public void killPlayer() {
    	dungeon.removeentity(getX(), getY(), name);
    		dungeon.deleteentity(getX(),getY(),name);
    		//System.out.println("YOU LOSE MAMA");
    		//System.exit(0);
    		
    }
    
    /**
     * 
     * @return invincibility status of player
     */
    public boolean getInvincible() {
    	if(this.invincible) {
    		return true;
    	}
    	return false;
    }
    
    /**
     * 
     * sets invincibility status of player
     */
    public void setInvincible(boolean i) {
    	this.invincible = i;
    	this.UIgnome().set(i);
    	if(!i) {
    		this.steptracer = 0;
    	}else {
    		dungeon.invincibilityLeft().set("Invincibility Steps: 25\n");
    	}
    }
    
    /**
     * 
     * @return attack status of player
     */
    public Sword getSword() {
    	return this.sword;
    }
    
    /**
     * Attaches observer
     */
	@Override
	public void attach(Observer observer) {
		observers.add(observer);
		
	}
	
	/**
	 * removes observer
	 */
	@Override
	public void detach(Observer observer) {
		observers.remove(observer);
		
	}
	
	/**
	 * Notify's its status to observers
	 */
	@Override
	public void notifys() {
		for(Observer observer : observers) {
			observer.update(this);
		}
	}
	
	/**
	 * Gets updated whenever player moves
	 */
	public void updatemove() {
		move = new Movement(getX(), getY(),dungeon,this);
		//System.out.println("Updated");
		notifys();
		if(this.getInvincible()) {
			steptracer++;
		}
		dungeon.checkGoal();
	}
	public int getStepTracer() {
		return (24-steptracer);
	}
}


