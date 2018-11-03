
public class Level {
	private int numItems;
	private int enemySpeed;

	public Level(int numItems) {
		this.numItems = numItems;
	}
	
	public int nextLevel() {
		return 0;
	}
	
	public void setEnemySpeed(int enemySpeed) {
		this.enemySpeed = enemySpeed;
		
	}
	
	public int addItems() {
		return 0;
	}

}
