package unsw.entites;


import javafx.beans.property.BooleanProperty;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;


/**
 * An entity in the dungeon.
 * @author Robert Clifton-Everest
 *
 */
public class Entity /*implements Properties*/{

    private IntegerProperty x, y;
    private BooleanProperty removal;
    private BooleanProperty UIgnome;
    private BooleanProperty UIsword;
    private BooleanProperty UIDoor;
    private BooleanProperty UIGoal;
    private int id;


    /**
     * Create an entity positioned in square (x,y)
     * @param x the x coordinate of entity 
     * @param y the y coordinate of entity
     */
    public Entity(int x, int y) {
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        removal = new SimpleBooleanProperty(false);
        UIgnome = new SimpleBooleanProperty(false);
        UIsword = new SimpleBooleanProperty(false);
        UIDoor = new SimpleBooleanProperty(false);
        UIGoal = new SimpleBooleanProperty(false); 
    }
    
    /**
     * 
     * @return x the x coordinate of entity 
     */
    public IntegerProperty x() {
        return x;
    }
    
    /**
     * 
     * @return removal, responsible for removing of entities
     */
    public BooleanProperty removal() {
    	return removal;
    }
    
    /**
     * 
     * @return the UI controller for goal UI
     */
    public BooleanProperty UIGoal() {
    	return UIGoal;
    }
    
    /**
     * 
     * @return the UI for door
     */
    public BooleanProperty UIDoor() {
    	return UIDoor;
    }
    
    /**
     * 
     * @return the UI for player when under the 'invincibility potion' effect
     */
    public BooleanProperty UIgnome() {
    	return UIgnome;
    }
    
    /**
     * 
     * @return the UI for sword
     */
    public BooleanProperty UIsword() {
    	return UIsword;
    }
    
    /**
     * sets removal 
     * @param k
     */
    public void setRemoval(boolean k) {
    	this.removal.set(k); 
    }
    
    /**
     * 
     * @return y the y coordinate of entity 
     */
    public IntegerProperty y() {
        return y;
    }
    /**
     * 
     * @return x the x coordinate of entity 
     */
    public int getY() {
        return y().get();
    }
    
    /**
     * 
     * @return y the y coordinate of entity 
     */
    public int getX() {
        return x().get();
    }
    
    /**
     * @return name
     */
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
     * @return transparency
     */
	public Boolean transparency() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj == null) {return false;}
		if(this == obj) {return true;}
		if(!super.equals(obj)) {return false;}
		Entity equals = (Entity) obj;
		if(equals.getX() == this.getX() && equals.getY() == this.getY()) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * gets id
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * sets id
	 * @param i
	 */
	public void setId(int i) {
		this.id = i;
	}
	
}


