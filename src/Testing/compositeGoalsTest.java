package Testing;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import unsw.dungeon.Dungeon;
import unsw.entites.Boulder;
import unsw.entites.Exit;
import unsw.entites.Floorswitch;
import unsw.entites.Player;
import unsw.entites.Treasure;
import unsw.goals.GateGoal;
import unsw.goals.Goal;
import unsw.goals.SwitchGoal;
import unsw.goals.TreasureGoal;

@SuppressWarnings("unused")
class compositeGoalsTest {
	/*
	 * GOAL ADDITION MOVED TO FRONTEND
	@Test
	void compositetest() {
		Dungeon dungeon = new Dungeon(10,10);
		Player player = new Player(dungeon,5,5);
		dungeon.addEntity(player);	
		dungeon.setPlayer(player);
		Goal switchgoal = new SwitchGoal(dungeon);
		Goal treasureGoal = new TreasureGoal(dungeon.getEntity());
		dungeon.addOrGoals(switchgoal,treasureGoal);
		Floorswitch floorswitch = new Floorswitch(7,3);
		Boulder boulder = new Boulder(6,3,dungeon);
		dungeon.addEntity(floorswitch);
		dungeon.addEntity(boulder);
		assertTrue(dungeon.checkGoal());
		Treasure treasure = new Treasure(6,5);
		dungeon.addEntity(treasure);
		assertFalse(dungeon.checkGoal());
		player.moveRight();
		assertTrue(dungeon.checkGoal());
		Exit exit = new Exit(7,5);
		dungeon.addEntity(exit);
		Goal gategoal = new GateGoal(dungeon.getEntity(),player);
		dungeon.addAndGoals(gategoal);
		assertFalse(dungeon.checkGoal());
		player.moveRight();
		assertTrue(dungeon.checkGoal());
		
	}*/

}
