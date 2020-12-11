package Testing;
import unsw.dungeon.*;
import unsw.entites.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.jupiter.api.Test;


class BouldersTest {

	@Test
	void playerAdjacent() {
		Dungeon dungeon = new Dungeon(10,10);
		
		Player player = new Player(dungeon, 5, 5);
		dungeon.addEntity(player);
		dungeon.setPlayer(player);
		Boulder boulder = new Boulder(6, 5, dungeon);
		dungeon.addEntity(boulder);
		//player is next to boulder		
		player.moveRight();
		
		//get player's x coordinate
		assertTrue(player.getX() == 6 && player.getY() == 5);
		//get player's y coordinate
		
		//get boulder's x coordinate
		assertTrue(boulder.getX() == 7 && boulder.getY() == 5);
		//get boulder's y coordinate	
	}
	
	@Test
	void boulderObstructionByWall() {
		
		Dungeon dungeon = new Dungeon(10,10);
		
		Player player = new Player(dungeon, 5, 5);
		dungeon.addEntity(player);
		dungeon.setPlayer(player);
		
		Boulder boulder = new Boulder(6, 5, dungeon);
		dungeon.addEntity(boulder);
		
		Wall wall = new Wall(7, 5);
		dungeon.addEntity(wall);
		
		player.moveRight();
		
		//test that player has not moved because of wall
		assertFalse(player.getX() == 6 && player.getY() == 5);
		
		//test that boulder has not moved because of wall
		assertFalse(boulder.getX() == 7 && boulder.getY() == 5);
	}
	
	@Test
	void BoulderObstructionByboulder(){
		
		Dungeon dungeon = new Dungeon(10,10);
		
		Player player = new Player(dungeon, 5, 5);
		dungeon.addEntity(player);
		dungeon.setPlayer(player);
		
		Boulder boulder = new Boulder(6, 5, dungeon);
		dungeon.addEntity(boulder);
		
		Boulder boulder2 = new Boulder(7, 5, dungeon);
		dungeon.addEntity(boulder2);
		
		player.moveRight();
		
		//test that player has not moved because of enemy
		assertFalse(player.getX() == 6 && player.getY() == 5);
		
		//test that boulder has not moved because of enemy
		assertFalse(boulder.getX() == 7 && boulder.getY() == 5);
	}

}
