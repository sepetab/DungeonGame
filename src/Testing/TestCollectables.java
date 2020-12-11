package Testing;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import unsw.dungeon.Dungeon;
import unsw.entites.Player;
import unsw.entites.Treasure;
import unsw.entites.*;

class TestCollectables {

	@Test
	void testCollecting() {
		Dungeon dungeon = new Dungeon(10,10);
		
		Player player = new Player(dungeon, 5, 5);
		dungeon.addEntity(player);
		dungeon.setPlayer(player);
		
		@SuppressWarnings("unused")
		Treasure treasure = new Treasure(6, 5);
		
		player.moveRight();
		
		for(Entity entity : dungeon.getEntity()) {
			assertFalse(entity instanceof Treasure);
		}
	}

}
