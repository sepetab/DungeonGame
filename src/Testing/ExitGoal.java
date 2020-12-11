package Testing;
import unsw.dungeon.*;


import unsw.goals.*;
import unsw.entites.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

@SuppressWarnings("unused")
class ExitGoal {

	/*@Test
	 * GOAL ADDITION MOVED TO FRONTEND
	void exitsimpletest() {
		Dungeon dungeon = new Dungeon(10,10);
		Player player = new Player(dungeon,5,5);
		dungeon.addEntity(player);
		dungeon.setPlayer(player);
		Exit exit = new Exit(7,5);
		dungeon.addEntity(exit);
		Goal gategoal = new GateGoal(dungeon.getEntity(),player);
		dungeon.addAndGoals(gategoal);
		assertFalse(dungeon.checkGoal());
		player.moveRight();
		player.moveRight();
		assertTrue(dungeon.checkGoal());
		player.moveLeft();
		assertFalse(dungeon.checkGoal());
		
	}
	@Test
	void exitscombinationtest() {
		Dungeon dungeon = new Dungeon(10,10);
		Player player = new Player(dungeon,5,5);
		dungeon.addEntity(player);
		dungeon.setPlayer(player);
		Exit exit = new Exit(7,5);
		Treasure treasure = new Treasure(4,5);
		dungeon.addEntity(treasure);
		dungeon.addEntity(exit);
		Goal gategoal = new GateGoal(dungeon.getEntity(),player);
		Goal treasuregoal = new TreasureGoal(dungeon.getEntity());
		dungeon.addAndGoals(gategoal);
		dungeon.addAndGoals(treasuregoal);
		assertFalse(dungeon.checkGoal());
		player.moveRight();
		player.moveRight();
		assertFalse(dungeon.checkGoal());
		player.moveLeft();
		//assertFalse(dungeon.checkGoal());
		player.moveLeft();
		player.moveLeft();
		assertFalse(dungeon.checkGoal());
		player.moveRight();
		player.moveRight();
		player.moveRight();
		assertTrue(dungeon.checkGoal());
		
		
	}*/

}
