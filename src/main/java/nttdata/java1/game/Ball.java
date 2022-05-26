package nttdata.java1.game;

/**
 * Ball
 * 
 * @author Victor Carrasco Artacho
 *
 */
public class Ball {
	/** Score */
	private int score;
	/** Position */
	private int position;

	/**
	 * Constructor
	 */
	public Ball() {
		this.score = 0;
		this.position = 0;
	}

	/**
	 * getScore
	 * 
	 * @return
	 */
	public int getScore() {
		return score;
	}

	/**
	 * setScore
	 * 
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * getPosition
	 * 
	 * @return
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * SetPosition
	 * 
	 * @param position
	 */
	public void setPosition(int position) {
		this.position = position;
	}

	/**
	 * Obtencion de las posibles siguientes posiciones de la pelota
	 * 
	 * @return
	 */
	public int[] getPosiblePositions() {
		int[] posiblePositions = null;
		// en cuyo caso se encuentre en la "pared izqd" las posiciones seran, la misma y
		// uno a la derecha
		if (this.position == 0) {
			int[] positionsOnLeftLimit = { 0, 1 };
			posiblePositions = positionsOnLeftLimit;
		}
		// si la pelota esta en la pared derecha, la misma y uno a la izqd
		else if (this.position == GameScene.getWIDTH() - 1) {
			int[] positionsOnRightLimit = { GameScene.getWIDTH() - 2, GameScene.getWIDTH() - 1 };
			posiblePositions = positionsOnRightLimit;
		}
		// si la pelota esta en cualquier otra, la misma, uno a la izqd y uno a la drch
		else {
			int[] othersPosiblePositions = { this.position - 1, this.position, this.position + 1 };
			posiblePositions = othersPosiblePositions;
		}
		return posiblePositions;
	}

	/**
	 * Se establece de forma aleatoria una posicion de las posibles
	 */
	public void setNextPosition() {
		int[] posiblePositions = getPosiblePositions();
		int indexOfRandomPosition = (int) (Math.random() * posiblePositions.length);
		this.position = posiblePositions[indexOfRandomPosition];
	}

	/**
	 * Se añade un punto
	 */
	public void addScore() {
		this.score++;
	}
}
