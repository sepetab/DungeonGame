package Testing;

import static org.junit.Assert.assertTrue;


import org.junit.jupiter.api.Test;

import unsw.dungeon.Dungeon;
import unsw.entites.Boulder;
import unsw.entites.Player;
import unsw.entites.Wall;

class TestBarriers {

	@Test
	void testWall() {
		
		Dungeon dungeon = new Dungeon(10,10);
		
		Player player = new Player(dungeon, 5, 5);
		dungeon.addEntity(player);
		dungeon.setPlayer(player);
		
		Wall wall = new Wall(6, 5);
		Wall wall2 = new Wall(4,5);
		Wall wall3 = new Wall(5,4);
		Wall wall4 = new Wall(5,6);
		dungeon.addEntity(wall);
		dungeon.addEntity(wall2);
		dungeon.addEntity(wall3);
		dungeon.addEntity(wall4);
				
		player.moveRight();
		player.moveLeft();
		player.moveUp();
		player.moveDown();
		//System.out.println(player.getX() + " " +player.getY());
		
		assertTrue(player.getX() == 5 && player.getY() == 5);
	}
	
	@Test
	void testBoulder() {
		
		Dungeon dungeon = new Dungeon(10,10);
		
		Player player = new Player(dungeon, 5, 5);
		dungeon.addEntity(player);
		dungeon.setPlayer(player);
		
		Boulder boulder = new Boulder(6, 5, dungeon);
		Boulder boulder2 = new Boulder(4, 5, dungeon);
		Boulder boulder3 = new Boulder(5, 4, dungeon);
		Boulder boulder4 = new Boulder(5, 6, dungeon);
		dungeon.addEntity(boulder);
		dungeon.addEntity(boulder2);
		dungeon.addEntity(boulder3);
		dungeon.addEntity(boulder4);
		Wall wall = new Wall(7, 5);
		Wall wall2 = new Wall(3,5);
		Wall wall3 = new Wall(5,3);
		Wall wall4 = new Wall(5,7);
		dungeon.addEntity(wall);
		dungeon.addEntity(wall2);
		dungeon.addEntity(wall3);
		dungeon.addEntity(wall4);
		
		
		player.moveRight();
		player.moveLeft();
		player.moveUp();
		player.moveDown();
		
		assertTrue(player.getX() == 5 && player.getY() == 5);
	}
}
