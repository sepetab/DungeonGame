package unsw.dungeon;
import unsw.entites.*;

public class RunTowards implements Run{
	Enemy enemy;
	Player player;
	/**
	 * 
	 * @param player to set 
	 * @param enemy to set 
	 */	
	public RunTowards(Player player, Enemy enemy) {
		this.player = player;
		this.enemy = enemy;
	}
	/**
	 * Makes the move for enemy based on players movement
	 */
	@Override
	public void move() {

		if(player.getY() > enemy.getY() && enemy.move().moveDown()) {					
		}else if(player.getY() < enemy.getY() && enemy.move().moveUp()) {			
		}else if(player.getX() < enemy.getX() &&enemy.move().moveLeft()) {			
		}else if(player.getX() > enemy.getX() && enemy.move().moveRight()) {			
		}else if(enemy.move().moveRight()) {			
		}else if(enemy.move().moveLeft()) {			
		}else if(enemy.move().moveUp()) {			
		}else if(enemy.move().moveDown()) {			
		}
	}

}
