package Testing;
import unsw.dungeon.*;



import unsw.entites.*;
import unsw.goals.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;



import org.junit.jupiter.api.Test;


@SuppressWarnings("unused")
class destroyallEnemiesGoal {
	/*
	 * GOAL ADDITION MOVED TO FRONTEND
	@Test
	void onlyreturntrueifallenemiesdestroyed() {
		Dungeon dungeon = new Dungeon(10,10);
		
		Player player = new Player(dungeon,5,5);
		dungeon.addEntity(player);	
		dungeon.setPlayer(player);
		Goal enemygoal = new KillEnemyGoal(dungeon.getEntity());
		dungeon.addAndGoals(enemygoal);
		Sword sword = new Sword(6,5);
		dungeon.addEntity(sword);
		Enemy enemy = new Enemy(9,5,dungeon);
		dungeon.addEntity(enemy);
		//System.out.println(player.getX()+"  " +player.getY() + "  " + enemy.getX()+"  " +enemy.getY());
		Enemy enemy2 = new Enemy(10,5,dungeon);
		dungeon.addEntity(enemy2);
		player.moveRight();
		assertFalse(dungeon.checkGoal());
		//System.out.println(player.getX()+"  " +player.getY() + "  " + enemy.getX()+"  " +enemy.getY());
		player.useSword();
		player.moveRight();
		assertFalse(dungeon.checkGoal());	
		player.useSword();
		assertTrue(dungeon.checkGoal());
		//Should fail when other goals are there
		Goal treasureGoal = new TreasureGoal(dungeon.getEntity());
		dungeon.addAndGoals(treasureGoal);
		assertTrue(dungeon.checkGoal());
		Treasure treasure = new Treasure(9,9);
		dungeon.addEntity(treasure);
		assertFalse(dungeon.checkGoal());
		

	}*/

}
