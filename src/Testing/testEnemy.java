package Testing;


class testEnemy {

	/*@Test
	 * ENEMIES ARE ANIMATED NOW
	void testRunTowards() {
		Dungeon dungeon = new Dungeon(10,10);
		
		Player player = new Player(dungeon, 5, 5);
		dungeon.addEntity(player);
		dungeon.setPlayer(player);
						
		Enemy enemy = new Enemy(8, 5, dungeon);
		dungeon.addEntity(enemy);
		
		player.moveLeft();
		assertTrue(player.getX() == 4 && player.getY() == 5);
		assertTrue(enemy.getX() == 7 && enemy.getY() == 5);
		
	}
	
	@Test
	void testPlayerDead() {
		Dungeon dungeon = new Dungeon(10,10);
		
		Player player = new Player(dungeon, 5, 5);
		dungeon.addEntity(player);
		dungeon.setPlayer(player);
						
		Enemy enemy = new Enemy(6, 5, dungeon);
		dungeon.addEntity(enemy);
		player.moveRight(); //should print LOSE in console
		List<Entity> entities = new ArrayList<Entity>();
		entities = dungeon.getEntity();
		for(Entity entity : entities){
			assertFalse(entity instanceof Player);
		}
	}
	
	@Test
	void testRunAway() {
		Dungeon dungeon = new Dungeon(10,10);
		
		Player player = new Player(dungeon, 5, 5);
		dungeon.addEntity(player);
		dungeon.setPlayer(player);
		
		Potion potion = new Potion(6, 5,player);
		dungeon.addEntity(potion);
		player.moveRight();
		
		assertTrue(player.getInvincible()); //ASK TUTOR
				
		Enemy enemy = new Enemy(8, 5, dungeon);
		Wall wall = new Wall(9, 5);
		dungeon.addEntity(wall);
		dungeon.addEntity(enemy);
		player.moveRight();
		assertTrue(enemy.getX() == 8 && enemy.getY() == 4);
	}
	@Test
	void testBlock() {
		Dungeon dungeon = new Dungeon(10,10);
		Player player = new Player(dungeon, 5, 5);
		dungeon.addEntity(player);
		dungeon.setPlayer(player);
		Enemy enemy = new Enemy(7,5,dungeon);
		dungeon.addEntity(enemy);		
		Wall wall = new Wall(6,5);
		dungeon.addEntity(wall);
		player.moveLeft();
		assertTrue(enemy.getX() == 7 && enemy.getY() == 5);
		dungeon.deleteentity(6, 5, "wall");
		player.moveLeft();
		assertTrue(enemy.getX() == 6 && enemy.getY() == 5);
	}*/
}
