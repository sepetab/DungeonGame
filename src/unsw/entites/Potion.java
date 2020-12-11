package unsw.entites;
import unsw.dungeon.*;


public class Potion extends Entity implements NonPhysEnt,Observer{
	
	String name = "potion";
	private int steptracker;
	private boolean active = false;
	
	/**
	 * 
	 * @param x sets x coordinate of potion
	 * @param y sets y coordinate of potion
	 */
	public Potion(int x, int y,Player player) {
        super(x, y);
         steptracker=0;
        player.attach(this);
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
	 * Player gets invincible for 7 seconds
	 * @param player
	 * 
	 */
	@Override
	public void interaction(Player player) {
		if(steptracker == 0 && player.getInvincible() == false) {
			RemoveFromMap(player.getDungeon());
			active =true;
			player.setInvincible(true);
		}
	}

	/**
	 *Disappears from dungeon (UI) 
	 * @param dungeon
	 *
	 */
	public void RemoveFromMap(Dungeon dungeon) {
		dungeon.removeentity(getX(), getY(), name);	
	}
	
	/**
	 * responsible for tracking the potion's invincibility step limit
	 */
	@Override
	public void update(Object subject) {
		//System.out.println("Updated");
		if(subject instanceof Player) {
			Player player = (Player) subject;

			if(player.getInvincible() && active) {
				steptracker = steptracker +1;
				if(steptracker == 25) {
					player.setInvincible(false);
					active = false;
					player.getDungeon().deleteentity(getX(), getY(), name);
				}
			}		
		}
    }
}