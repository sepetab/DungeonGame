package Testing;

import static org.junit.Assert.assertTrue;



import org.junit.jupiter.api.Test;

import unsw.dungeon.Dungeon;

import unsw.entites.Player;

class TestMovement {

	@Test
	void testUp() {
		Dungeon dungeon = new Dungeon(10,10);
		
		Player player = new Player(dungeon, 5, 5);
		dungeon.addEntity(player);
		dungeon.setPlayer(player);
			
		player.moveUp();
		
		//get player's y coordinate
		assertTrue(player.getX() == 5 && player.getY() == 4);
	
	}
	
	@Test
	void testDown() {
		Dungeon dungeon = new Dungeon(10,10);
		
		Player player = new Player(dungeon, 5, 5);
		dungeon.addEntity(player);
		dungeon.setPlayer(player);
			
		player.moveDown();
		
		//get player's y coordinate
		assertTrue(player.getX() == 5 && player.getY() == 6);
		
	}
	
	@Test
	void testRight() {
		Dungeon dungeon = new Dungeon(10,10);
		
		Player player = new Player(dungeon, 5, 5);
		dungeon.addEntity(player);
		dungeon.setPlayer(player);
			
		player.moveRight();
		
		//get player's x coordinate
		assertTrue(player.getX() == 6 && player.getY() == 5);
	
	}
	
	@Test
	void testLeft() {
		Dungeon dungeon = new Dungeon(10,10);
		
		Player player = new Player(dungeon, 5, 5);
		dungeon.addEntity(player);
		dungeon.setPlayer(player);
			
		player.moveLeft();
		
		//get player's x coordinate
		assertTrue(player.getX() == 4 && player.getY() == 5);
	
	}
	
}
