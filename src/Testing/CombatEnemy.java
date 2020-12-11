package Testing;
import unsw.dungeon.*;


import unsw.entites.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


class CombatEnemy {
	
	@Test
	void testGetSword() {
		Dungeon dungeon = new Dungeon(10,10);
		
		Player player = new Player(dungeon, 5, 5);
		
		dungeon.setPlayer(player);
		dungeon.getPlayer();
		
		dungeon.addEntity(player);
		
		//pick up sword
		Sword sword = new Sword(5,6);
		dungeon.addEntity(sword);
		player.moveDown();
		//use sword
		player.useSword();
		
		assertTrue(player.getSword()!=null);
	}
	
	
	
	@Test
	void testSwings() {
		
		Dungeon dungeon = new Dungeon(10,10);
		
		Player player = new Player(dungeon,5,5);
		
		dungeon.addEntity(player);
		
		dungeon.setPlayer(player);
		
		Sword sword = new Sword(6,5);
		dungeon.addEntity(sword);
		player.moveRight();
		
		//use sword a max 5 times
		player.useSword();
		assertTrue(player.getSword()!=null);
		player.useSword();
		assertTrue(player.getSword()!=null);
		player.useSword();
		assertTrue(player.getSword()!=null);
		player.useSword();
		assertTrue(player.getSword()!=null);
		player.useSword();
		
		assertTrue(player.getSword()==null);
	}
	@Test
	void testSingleSword(){
		
		Dungeon dungeon = new Dungeon(10,10);
		
		Player player = new Player(dungeon, 5, 5);
		
		dungeon.setPlayer(player);
		dungeon.getPlayer();
		
		dungeon.addEntity(player);
		
		//pick up sword
		Sword sword = new Sword(5,6);
		dungeon.addEntity(sword);
		Sword sword2 = new Sword(5,7);
		dungeon.addEntity(sword2);
		player.moveDown();
		
		//use sword
		player.useSword();
		player.useSword();
		player.useSword();
		player.useSword();
		player.moveDown();
		player.moveDown();
		player.useSword();
		assertTrue(player.getSword()==null);
		player.moveUp();
		assertTrue(player.getSword()!=null);
		//attempt to pick up second sword while 1st is activated
		

		
	}
	@Test
	void testKillEnemy() {
		
		Dungeon dungeon = new Dungeon(10,10);
		
		Player player = new Player(dungeon,5,5);
		
		dungeon.addEntity(player);
		
		dungeon.setPlayer(player);
		
		Sword sword = new Sword(6,5);
		dungeon.addEntity(sword);
		player.moveRight();
		
		//spawn enemy and attack
		Enemy enemy = new Enemy(6,6,dungeon);
		dungeon.addEntity(enemy);
		player.useSword();
		
		//enemy should be gone in dungeon
		List<Entity> entities = new ArrayList<Entity>();
		entities = dungeon.getEntity();
		for(Entity entity : entities){
			assertFalse(entity instanceof Enemy);
		}
	}
}
