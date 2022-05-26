package nttdata.java1.game;

/**
 * Player
 * 
 * @author Victor Carrasco Artacho
 *
 */
public class Player {
	/** name */
	private String name;
	/** money */
	private int money;
	/** balls */
	private int numBalls;
	/** totalPoints */
	private int totalPoints;

	/**
	 * GetName
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * SetName
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * GetMoney
	 * 
	 * @return
	 */
	public int getMoney() {
		return money;
	}

	/**
	 * SetMoney
	 * 
	 * @param money
	 */
	public void setMoney(int money) {
		this.money = money;
	}

	/**
	 * Constructor
	 */
	public Player() {
		this.name = "Player01";
		this.money = 10;
		this.numBalls = 2;
	}

	/**
	 * To String
	 */

	@Override
	public String toString() {
		return "Player [name=" + name + ", money=" + money + ", numBalls=" + numBalls + ", totalPoints=" + totalPoints
				+ "]";
	}

	/**
	 * AddBalls
	 * 
	 * @param num
	 */
	public void addBalls(int num) {
		this.numBalls = this.numBalls + num;
	}

	/**
	 * Rest money
	 * 
	 * @param num
	 */
	public void quitMoney(int num) {
		this.money = this.money - num;
	}

	/**
	 * AddMoney
	 * 
	 * @param num
	 */
	public void addMoney(int num) {
		this.money = this.money + num;
	}

	/**
	 * getter numBalls
	 * 
	 * @return
	 */
	public int getNumBalls() {
		return numBalls;
	}

	/**
	 * setter numBalls
	 * 
	 * @param numBalls
	 */
	public void setNumBalls(int numBalls) {
		this.numBalls = numBalls;
	}

	/**
	 * GameOver
	 * 
	 * @return
	 */
	public boolean checkGameOver() {
		boolean gameOver = false;
		if (this.money <= 1 && this.numBalls <= 0) {
			gameOver = true;
		}
		return gameOver;
	}

	/**
	 * total Points Getter
	 * 
	 * @return
	 */
	public int getTotalPoints() {
		return totalPoints;
	}

	/**
	 * total points setter
	 * 
	 * @param totalPoints
	 */
	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}

	/**
	 * Add points to totalPoints
	 * 
	 * @param points
	 */
	public void addToTotalPoints(int points) {
		this.totalPoints += points;
	}

}
