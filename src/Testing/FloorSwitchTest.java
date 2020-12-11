package Testing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;




import org.junit.jupiter.api.Test;
import unsw.dungeon.*;
import unsw.entites.*;
class FloorSwitchTest {

	@Test
	void testFloorSwitchTransparent() {
		
		Dungeon dungeon = new Dungeon(10,10);
		
		Player player = new Player(dungeon, 5, 5);
		dungeon.addEntity(player);
		dungeon.setPlayer(player);
		
		Floorswitch floorswitch = new Floorswitch(6, 5);
		dungeon.addEntity(floorswitch);
		//player is next to boulder		
		player.moveRight();
		
		//show player is allowed on top of floorswitch
		//get player's x coordinate
		assertTrue(player.getX() == 6 && player.getY() == 5);
	}
	
	@Test
	void testTriggeruntruiggerSwitch() {
		
		Dungeon dungeon = new Dungeon(10,10);
		
		Player player = new Player(dungeon, 5, 5);
		dungeon.addEntity(player);
		dungeon.setPlayer(player);
		
		Boulder boulder = new Boulder(6, 5, dungeon);
		dungeon.addEntity(boulder);
		
		Floorswitch floorswitch = new Floorswitch(7,5);
		dungeon.addEntity(floorswitch);
		
		//player is next to boulder		
		player.moveRight();
		
		//get player's x coordinate
		assertTrue(player.getX() == 6 && player.getY() == 5);
		//get player's y coordinate
		
		//boulder should be on top of floorswitch
		//get boulder's x coordinate
		assertTrue(boulder.getX() == 7 && boulder.getY() == 5);
		
    	
		assertTrue(floorswitch.triggered(dungeon) == true);
		player.moveUp();
		player.moveRight();
		//System.out.println(player.getX() + "   " + player.getY() + "   " + boulder.getX() + "   " + boulder.getY());
		player.moveDown();
		assertFalse(floorswitch.triggered(dungeon));
		
	}

}
