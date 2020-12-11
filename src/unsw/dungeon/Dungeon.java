/**
 *
 */
package unsw.dungeon;
import unsw.entites.*;

import unsw.goals.*;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

//8,7 3,5

/**
 * A dungeon in the interactive dungeon player.
 *
 * A dungeon can contain many entities, each occupy a square. More than one
 * entity can occupy the same square.
 *
 * @author Robert Clifton-Everest
 *
 */
public class Dungeon implements Observer{

    private int width, height;
    private List<Entity> entities;
    private Player player;
    private int tc = 0;
    //private DungeonController controller;
    Goal goals = new AndCompositeGoals();
    private StringProperty swordLeft;
    private StringProperty invincibilityLeft;
    private StringProperty keyLeft;
    private StringProperty treasure;
    public Dungeon(int width, int height) {
        this.width = width;
        this.height = height;
        this.entities = new ArrayList<>();
        this.player = null;
        this.swordLeft = new SimpleStringProperty("Sword Hits Left: 0\n");
        this.invincibilityLeft = new SimpleStringProperty("Invincibility Steps: 0\n");
        this.keyLeft = new SimpleStringProperty("Key possession: No\n");
        this.treasure = new SimpleStringProperty("All treasure collected: (0) NO\n");
    }
    
    /**
     * 
     * @return the width of the dungeon
     */
    public StringProperty treasure(){
    	return treasure;
    }
    public StringProperty keyLeft(){
    	return keyLeft;
    }
    public StringProperty swordLeft() {
    	return swordLeft;
    }
    public StringProperty invincibilityLeft() {
    	return  invincibilityLeft;
    }
    public int getWidth() {
        return width;
    }
    public void setTc(int c) {
    	tc =c;
    }
    public int getTc() {
    	return tc;
    }
    /**
     * 
     * @return an original list of entities
     */
    public List<Entity> getEntity(){
    	return entities;
    }
    /**
     * 
     * @return the height of the dungeon
     */
    public int getHeight() {
        return height;
    }
    
    /**
     * 
     * @return the player of the game
     */
    public Player getPlayer() {
        return player;
    }
    
    /**
     * 
     * @param player the player to set
     */
    public void setPlayer(Player player) {
        this.player = player;
        player.attach(this);
    }
    
    /**
     * 
     * @param entity the entity to add to the list
     */
    public void addEntity(Entity entity) {
        entities.add(entity);
    }
    /**
     * 
     * @param x the x position of the required entity
     * @param y the y position of the required entity
     * @return list of entity that is in that specified coordinates
     */
    public List<Entity> checkEntity(int x, int y) {
    	List<Entity> returner =new ArrayList<Entity>();
    	for(Entity entity : entities) {
    		if(entity!=null) {
	        	if(entity.getX() == x && entity.getY() == y) {
	        		//System.out.println(entity.getName());
	        		
	        		returner.add(entity);
	        	}
    		}
       	}
    	return returner;
    }
    /**
     * 
     * @param x the x position to delete entity
     * @param y the y position to delete entity
     * @param name the name of the entity to delete
     */
    public void deleteentity(int x, int y, String name) {
    	Entity toremove = null;
    	for(Entity z:entities) {
    		if(z.getX() == x && z.getY() == y && z.getName() == name) {
    			
    			//z.disable.set(true);
    			toremove = z;
    			//z =null;
    			break;
    		}
    	}
    	//System.out.println(entities.size());
    	if(toremove!=null) {
    		//System.out.println(toremove.getX() + "  " + toremove.getY() + "  " + name);
    		//System.out.println(entities.remove(toremove));
    		entities.remove(toremove);
    		
    	}
    	//System.out.println(entities.size());
    	
    	
    }
    /**
     * 
     * @param x the x position to remove entity from map
     * @param y the y position to remove entity from map
     * @param name the name of the entity to remove from the dungeon map
     */
    public void removeentity(int x, int y, String name) {
    	for(Entity z:entities) {
    		if(z.getX() == x && z.getY() == y && z.getName() == name) {
    			z.setRemoval(true);
    		}
    	}
    }
   
    /**
     * if all goals are accomplished, then the game is won
     */
    public Boolean checkGoal() {
    	 //System.out.println(goals);
    	if(goals.checkGoal()) {
    		for(Entity entity : entities) {
    			if(entity instanceof Enemy) {
        			((Enemy) entity).dead = true;
        		}
    		}
    		getPlayer().UIGoal().set(true);
    		return true;
    	}
    	//System.out.print(treasure);
    	return false;
    }
    
    /**
     * tracks and updates the number of steps left for invincibility potion
     * (observer pattern implemented) 
     */
	@Override
	public void update(Object subject) {
		if(subject instanceof Player) {
			Player player = (Player) subject;
			if(player.getInvincible()) {
				this.invincibilityLeft.set("Invincibility Steps:" + " " + player.getStepTracer() + "\n");
			}

		}
    }   
}
