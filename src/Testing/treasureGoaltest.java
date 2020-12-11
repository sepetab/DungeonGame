package Testing;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;
import unsw.dungeon.*;
import unsw.entites.*;
import unsw.goals.*;

import org.junit.jupiter.api.Test;

@SuppressWarnings("unused")
class treasureGoaltest {
	/*
	 * GOAL ADDITION MOVED TO FRONTEND
	@Test
	void testfortreasuregoal() {
		Dungeon dungeon = new Dungeon(10,10);
		Player player = new Player(dungeon,5,5);
		dungeon.addEntity(player);	
		dungeon.setPlayer(player);
		Goal treasureGoal = new TreasureGoal(dungeon.getEntity());
		dungeon.addAndGoals(treasureGoal);
		assertTrue(dungeon.checkGoal());
		Treasure treasure = new Treasure(7,6);
		Treasure treasure2 = new Treasure(6,5);
		dungeon.addEntity(treasure);
		dungeon.addEntity(treasure2);
		assertFalse(dungeon.checkGoal());
		player.moveRight();
		assertFalse(dungeon.checkGoal());
		player.moveRight();
		player.moveDown();
		assertTrue(dungeon.checkGoal());
		//Should fail when other goals are there
		Goal switchgoal = new SwitchGoal(dungeon);
		dungeon.addAndGoals(switchgoal);
		assertTrue(dungeon.checkGoal());
		Floorswitch breaker = new Floorswitch(9,9);
		dungeon.addEntity(breaker);
		assertFalse(dungeon.checkGoal());
		
		
	}*/

}
