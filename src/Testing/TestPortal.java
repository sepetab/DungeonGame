package Testing;

import static org.junit.Assert.assertTrue;

import unsw.dungeon.*;
import unsw.entites.*;

import org.junit.jupiter.api.Test;


class TestPortal {

	@Test
	void testPortal() {
		
		Dungeon dungeon = new Dungeon(10,10);
		
		Player player = new Player(dungeon, 5, 5);
		dungeon.addEntity(player);
		dungeon.setPlayer(player);
		
		Portal portal = new Portal(6, 5);
		Portal portal2 = new Portal(8,3);
		dungeon.addEntity(portal);
		dungeon.addEntity(portal2);
		
		player.moveRight();
				
		assertTrue(player.getX() == 8 && player.getY() == 3);
		player.moveRight();
		assertTrue(player.getX() == 9 && player.getY() == 3);
		player.moveLeft();
		assertTrue(player.getX() == 6 && player.getY() == 5);
	}

}
