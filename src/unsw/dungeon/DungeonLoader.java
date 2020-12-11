package unsw.dungeon;
import unsw.entites.*;
import unsw.goals.*;


import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * Loads a dungeon from a .json file.
 *
 * By extending this class, a subclass can hook into entity creation. This is
 * useful for creating UI elements with corresponding entities.
 *
 * @author Robert Clifton-Everest
 *
 */
public abstract class DungeonLoader {

    private JSONObject json;
    private int keyId =0;
    private int doorId = 0;
    private int portalId =0;
    private int counter =0;

    public DungeonLoader(String filename) throws FileNotFoundException {
        json = new JSONObject(new JSONTokener(new FileReader("dungeons/" + filename)));
    }

    /**
     * Parses the JSON to create a dungeon.
     * @return
     */
    public Dungeon load() {
        int width = (json.getInt("width"));
        int height = (json.getInt("height"));

        Dungeon dungeon = new Dungeon(width, height);

        JSONArray jsonEntities = json.getJSONArray("entities");
        

        for (int i = 0; i < jsonEntities.length(); i++) {
            loadEntity(dungeon, jsonEntities.getJSONObject(i));
        }
        JSONObject goals = json.getJSONObject("goal-condition");
        Goal goal = addGoals(dungeon,goals);
        //System.out.println(goal.toString());
        dungeon.goals = goal;
        return dungeon;
    }
    
    /**
     * Parses JSON to process goals and subgoals strings 
     * @param dungeon
     * @param json
     * @return
     */
    private Goal addGoals(Dungeon dungeon,JSONObject json) {       
    	JSONObject	goals = json;
    	Goal returner = null;
    	//while(goals.length() != 0) {
    		
    			String condition = (String) goals.get("goal");
    			JSONArray subgoals = new JSONArray();
    			if(goals.has("subgoals")) {
    					subgoals = goals.getJSONArray("subgoals");
    			}
    			if(condition.equals("AND")) {
    				returner = new AndCompositeGoals();
    				returner = addAnd(dungeon,subgoals,returner);
    			}else if(condition.equals("OR")){
    				returner = new OrCompositeGoals();
    				returner = addOr(dungeon,subgoals,returner);
    			}else {
    				returner = new AndCompositeGoals();
    				JSONArray arraygoal = new JSONArray();
					arraygoal.put(goals);
					returner = addAnd(dungeon,arraygoal,returner);
    			}
    	//}
    	return returner;
    	
    }
    
    /**
     * Reads in the 'And' (compulsory) goals section
     * @param dungeon
     * @param array
     * @param returner
     * @return
     */
    private Goal addAnd(Dungeon dungeon,JSONArray array,Goal returner) {
    	for(Object goal : array) {
			JSONObject eachgoal = (JSONObject) goal;
			if((eachgoal.get("goal").equals("AND"))){
				JSONArray subgoals = new JSONArray();
				subgoals = eachgoal.getJSONArray("subgoals");
				Goal temp = new AndCompositeGoals();
				returner.addChild(addAnd(dungeon,subgoals,temp));
				
			}else if(eachgoal.get("goal").equals("OR")) {
				
				JSONArray subgoals = new JSONArray();
				subgoals = eachgoal.getJSONArray("subgoals");	
				Goal temp = new OrCompositeGoals();
				returner.addChild(addOr(dungeon,subgoals,temp));
			}
			else {
				String addand = (String) eachgoal.get("goal");
				switch(addand) {
				case "treasure":
						Goal TreasureGoal = new TreasureGoal(dungeon);
						addAndGoals(TreasureGoal,returner);
						break;
				case "enemies":
						Goal enemies = new KillEnemyGoal(dungeon.getEntity());
						addAndGoals(enemies,returner);
						break;
				case "exit":
						Goal exit = new GateGoal(dungeon.getEntity(),dungeon.getPlayer());
						addAndGoals(exit,returner);
						
						break;
				case "boulders":
					//System.out.println(returner.toString());
						Goal boulders = new SwitchGoal(dungeon);
						addAndGoals(boulders,returner);
						break;
				}
			}
		}
    	
    	return returner;
    }
    
    /**
     * Reads in the 'Or' (optional) goals section
     * @param dungeon
     * @param array
     * @param returner
     * @return
     */
	private Goal addOr(Dungeon dungeon,JSONArray array,Goal returner) {
    	Goal goal1 = null;
		Goal goal2 = null;
    	for(Object goal : array) {
			JSONObject eachgoal = (JSONObject) goal;
			if((eachgoal.get("goal").equals("AND"))){
				JSONArray subgoals = new JSONArray();
				subgoals = eachgoal.getJSONArray("subgoals");
				Goal temp = new AndCompositeGoals();
				if(goal1 != null) {
					goal2 =addAnd(dungeon,subgoals,temp);
					//System.out.println(goal2);
				}else {	
					goal1 = addAnd(dungeon,subgoals,temp);
				}
				
			}else if(eachgoal.get("goal").equals("OR")) {
				JSONArray subgoals = new JSONArray();
				subgoals = eachgoal.getJSONArray("subgoals");
				Goal temp = new OrCompositeGoals();
				if(goal1 != null) {
					goal2 =addOr(dungeon,subgoals,temp);
				}else {	
					goal1 = addOr(dungeon,subgoals,temp);
				}
			}
			else {
				String addand = (String) eachgoal.get("goal");
				switch(addand) {
				case "treasure":
					//System.out.println("KJBASDKJBSJKBFD");
						Goal TreasureGoal = new TreasureGoal(dungeon);
						if(goal1 != null) {
							goal2 =TreasureGoal;
						}else {	
							goal1 = TreasureGoal;
						}
						break;
				case "enemies":
					//System.out.println("KJBASDKJBSJKBFD");
						Goal enemies = new KillEnemyGoal(dungeon.getEntity());
						if(goal1 != null) {
							goal2 =enemies;
						}else {	
							goal1 = enemies;
						}
						break;
				case "exit":
						Goal exit = new GateGoal(dungeon.getEntity(),dungeon.getPlayer());
						if(goal1 != null) {
							goal2 =exit;
						}else {	
							goal1 = exit;
						}
						break;
				case "boulders":
						Goal boulders = new SwitchGoal(dungeon);
						if(goal1 != null) {
							goal2 =boulders;
						}else {	
							goal1 = boulders;
						}
						break;
				}
			}
		}
    	addOrGoals(goal1, goal2,returner);
    	//System.out.println(returner.toString());
    	return returner;
    }
	 /**
     * 
     * @param goal add an AND goal to the labs
     */
    public void addAndGoals(Goal goal,Goal goals) {
    	goals.addChild(goal);
    }
    /**
     * @param goal1 goal in Or argument 
     * @param goal2 goal in Or argument 
     */
    public void addOrGoals(Goal goal1, Goal goal2,Goal goals) {
    	goals.addChild(goal1);
    	goals.addChild(goal2);
    }
    
    /**
     * responsible for loading the specific entity depending on the JSON input reads
     * @param dungeon
     * @param json
     */
    private void loadEntity(Dungeon dungeon, JSONObject json) {
        String type = json.getString("type");
        int x = json.getInt("x");
        int y = json.getInt("y");

        Entity entity = null;
        switch (type) {
        case "player":
            Player player = new Player(dungeon, x, y);
            dungeon.setPlayer(player);
            onLoad(player);
            entity = player;
            break;
        case "wall":
            Wall wall = new Wall(x, y);
            onLoad(wall);
            entity = wall;
            break;
        case "treasure":
        	Treasure treasure = new Treasure(x,y);
        	onLoad(treasure);
        	entity = treasure;
        	break;
        case "invincibility":
        	Potion potion = new Potion(x,y,dungeon.getPlayer());
        	onLoad(potion);
        	entity = potion;
        	break;
        case "sword":
        	Sword sword = new Sword(x,y);
        	onLoad(sword);
        	entity = sword;
        	break;
        case "boulder": 	
        	Boulder boulder = new Boulder(x,y,dungeon);
        	onLoad(boulder);
        	entity = boulder;
        	break;
        case "switch":
        	Floorswitch swich = new Floorswitch(x,y);
        	onLoad(swich);
        	entity = swich;
        	break;
        case "exit":
        	Exit exit = new Exit(x,y);
        	onLoad(exit);
        	entity = exit;
        	break;
        case "key":
        	Key key = new Key(x,y);
        	onLoad(key);
        	entity = key;
        	key.setId(keyId);
        	keyId++;
        	break;
        case "door":
        	Door door = new Door(x,y,dungeon);
        	onLoad(door);
        	entity = door;
        	door.setId(doorId);
        	doorId++;
        	break;
        case "portal":
        	Portal portal = new Portal(x,y);
        	onLoad(portal);
        	entity = portal;
        	portal.setId(portalId);
        	counter++;
        	if(counter %2 ==0) {
        		portalId = portalId+1;
        	}
        	
        	break;
        case "enemy":
        	Enemy enemy = new Enemy(x,y,dungeon);
        	onLoad(enemy);
        	entity = enemy;
        	break;
        }
        dungeon.addEntity(entity);
    }

    public abstract void onLoad(Player player);
    public abstract void onLoad(Exit exit);
    public abstract void onLoad(Wall wall);
    public abstract void onLoad(Treasure treasure);
    public abstract void onLoad(Enemy enemy);
    public abstract void onLoad(Portal portal);
    public abstract void onLoad(Key key);
    public abstract void onLoad(Door door);
    public abstract void onLoad(Floorswitch swich);
    public abstract void onLoad(Sword sword);
    public abstract void onLoad(Potion potion);
    public abstract void onLoad(Boulder boulder);
    
    
    

    // TODO Create additional abstract methods for the other entities

}