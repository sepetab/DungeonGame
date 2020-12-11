package unsw.dungeon;


/**
 * 
 * subject implementation for observer pattern
 *
 */

public interface Subject {
	public void attach(Observer observer);
	public void detach(Observer observer);
	public void notifys();
}
