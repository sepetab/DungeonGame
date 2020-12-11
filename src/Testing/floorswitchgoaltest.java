package Testing;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;
import unsw.dungeon.*;
import unsw.entites.*;
import unsw.goals.*;

import org.junit.jupiter.api.Test;

@SuppressWarnings("unused")
class floorswitchgoaltest {
	/*
	//GOAL ADDITION MOVED TO FRONTEND LOADER
	@Test
	void switchgoaltest() {
		Dungeon dungeon = new Dungeon(10,10);
		Player player = new Player(dungeon,5,5);
		dungeon.addEntity(player);	
		dungeon.setPlayer(player);
		Goal switchgoal = new SwitchGoal(dungeon);
		dungeon.addAndGoals(switchgoal);
		Floorswitch floorswitch = new Floorswitch(7,3);
		Boulder boulder = new Boulder(7,3,dungeon);
		dungeon.addEntity(floorswitch);
		dungeon.addEntity(boulder);
		assertTrue(dungeon.checkGoal());
		Floorswitch floorswitch2 = new Floorswitch(9,5);
		Boulder boulder2 = new Boulder(3,4,dungeon);
		dungeon.addEntity(floorswitch2);
		dungeon.addEntity(boulder2);
		assertFalse(dungeon.checkGoal());
		player.moveLeft();
		player.moveLeft();
		player.moveLeft();
		player.moveUp();
		player.moveUp();
		player.moveRight();
		player.moveDown();
		player.moveLeft();
		player.moveDown();
		player.moveRight();
		player.moveRight();
		player.moveRight();
		player.moveRight();
		player.moveRight();
		player.moveRight();
		assertTrue(dungeon.checkGoal());
		//Should fail when other goals are there
		Goal treasureGoal = new TreasureGoal(dungeon.getEntity());
		dungeon.addAndGoals(treasureGoal);
		assertTrue(dungeon.checkGoal());
		Treasure treasure = new Treasure(9,9);
		dungeon.addEntity(treasure);
		assertFalse(dungeon.checkGoal());
		
		
		
		
	}*/
	//GOAL ADDITION MOVED TO FRONTEND LOADER

}
