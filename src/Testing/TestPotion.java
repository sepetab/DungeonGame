package Testing;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import unsw.dungeon.*;
import unsw.entites.*;

class TestPotion {

	@Test
	void testConsumption() {
		
		Dungeon dungeon = new Dungeon(10,10);
		
		Player player = new Player(dungeon, 5, 5);
		dungeon.addEntity(player);
		dungeon.setPlayer(player);
		
		Potion potion = new Potion(6, 5,player);
		dungeon.addEntity(potion);
		
		player.moveRight();

		assertTrue(player.getInvincible());
		player.moveRight();
		player.moveRight();
		player.moveRight();
		assertTrue(player.getInvincible());
		player.moveDown();
		player.moveDown();
		player.moveDown();
		player.moveDown();
		assertTrue(player.getInvincible());
		player.moveUp();
		player.moveUp();
		assertTrue(player.getInvincible());
		player.moveUp();
		
		
	}
	
	@Test
	void testKillEnemy() {
		Dungeon dungeon = new Dungeon(10,10);
		
		Player player = new Player(dungeon, 5, 5);
		dungeon.addEntity(player);
		dungeon.setPlayer(player);
		Potion potion = new Potion(6, 5,player);
		dungeon.addEntity(potion);
		player.moveRight();
		assertTrue(player.getInvincible());	
		Wall wall = new Wall(8,5);
		dungeon.addEntity(wall);
		Enemy enemy = new Enemy(7, 5, dungeon);
		dungeon.addEntity(enemy);
		player.moveRight();
		List<Entity> entities = new ArrayList<Entity>();
		entities = dungeon.getEntity();
		for(Entity entity : entities){
			assertFalse(entity instanceof Enemy);
		}
	}
}
