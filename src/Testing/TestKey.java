package Testing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;




import unsw.dungeon.*;
import unsw.entites.*;
import org.junit.jupiter.api.Test;

class TestKey {

	@Test
	void testDoorOpen() {
		
		Dungeon dungeon = new Dungeon(10,10);
		
		Player player = new Player(dungeon, 5, 5);
		dungeon.addEntity(player);
		dungeon.setPlayer(player);
		
		Key key = new Key(6, 5);
		dungeon.addEntity(key);
		player.setKey(key);
		player.moveRight();
		Door door = new Door(7,5, dungeon);
		dungeon.addEntity(door);
		player.moveRight();
		assertTrue(door.transparency());
		//assertTrue(player.getX() == 8  && player.getY() == 5);
	}
	
	@Test
	void oneKeytoDoorTest() {
		Dungeon dungeon = new Dungeon(10,10);
		Player player = new Player(dungeon, 4, 5);
		dungeon.addEntity(player);
		dungeon.setPlayer(player);
		Key key = new Key(6, 5);
		Key key2 = new Key(5,5);
		dungeon.addEntity(key);
		dungeon.addEntity(key2);
		key.setId(0);
		key2.setId(2);
		player.moveRight();
		assertTrue(player.getkey().getId() == 2);
		player.moveRight();
		assertTrue(player.getkey().getId() == 2);
		Door door = new Door(7,5,dungeon);
		dungeon.addEntity(door);
		door.setId(1);
		player.moveRight();
		assertFalse(door.transparency());
		key2.setId(1);
		player.moveRight();
		assertTrue(door.transparency());
		//System.out.println(player.getX() + "  " + player.getY() );
		player.moveRight();
		player.moveLeft();
		assertTrue(player.getkey().getId() == 0);
		
	}
	
	@Test
	void threedoorkeyTest() {
		Dungeon dungeon = new Dungeon(10,10);
		Player player = new Player(dungeon, 4, 5);
		dungeon.addEntity(player);
		dungeon.setPlayer(player);
		Key key = new Key(6, 5);
		Key key2 = new Key(5,5);
		Key key3 = new Key(4,2);
		Door door = new Door(6, 5,dungeon);
		Door door2 = new Door(4, 5,dungeon);
		Door door3 = new Door(9, 5,dungeon);
		key.setId(0);
		key2.setId(1);
		key3.setId(2);
		door.setId(0);
		door2.setId(1);
		door3.setId(2);
		dungeon.addEntity(key);
		dungeon.addEntity(key2);
		dungeon.addEntity(key3);
		dungeon.addEntity(door);
		dungeon.addEntity(door2);
		dungeon.addEntity(door3);
	
		//System.out.println(key2.getId() + "  " + door2.getId() );
		assertTrue(key.getId() == door.getId());
		assertTrue(key2.getId() == door2.getId());
		assertTrue(key3.getId() == door3.getId());
		
	}
	

}
