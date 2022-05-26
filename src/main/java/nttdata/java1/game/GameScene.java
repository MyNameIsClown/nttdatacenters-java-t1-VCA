package nttdata.java1.game;

/**
 * GameScene
 * 
 * @author Victor Carrasco Artacho
 *
 */
public class GameScene {
	/** static final WIDTH */
	private static final int WIDTH = 10;
	/** static final HIGHT */
	private static final int HIGHT = 4;
	/** logicScene */
	private int[][] logicScene;

	/**
	 * Constructor
	 */
	public GameScene() {
		this.logicScene = new int[HIGHT][WIDTH];
	}

	/**
	 * Rellenado de la escena de forma aleatoria
	 */
	public void fillScene() {
		for (int i = 0; i < this.logicScene.length; i++) {
			for (int j = 0; j < this.logicScene[i].length; j++) {
				// Por probabilidad puede llegar a darse el caso de que exista alguna linea sin
				// puntos
				// esto no se ha tratado por falta de tiempo y por la poca probabilidad de la
				// misma
				if (checkPointsOnLine(i)) {
					this.logicScene[i][j] = 0;
				} else {
					this.logicScene[i][j] = (int) (Math.random() * 2);
				}
			}
		}
	}

	/**
	 * Se verifica la existencia de un punto en cada nivel de la scena puesto que
	 * solo puede existir un punto por nivel (el nivel es cada linea desde arriba a
	 * abajo)
	 * 
	 * @param lineNumber
	 * @return
	 */
	private boolean checkPointsOnLine(int lineNumber) {
		boolean pointsExists = false;
		// Se recorre el nivel pasado por parametro
		for (int i = 0; i < this.logicScene[lineNumber].length && !pointsExists; i++) {
			// Si algun elemento coincide con el uno, se considera que ya hay un punto en la
			// linea
			if (this.logicScene[lineNumber][i] == 1) {
				pointsExists = true;
			}
		}
		return pointsExists;
	}

	/**
	 * getWIDTH
	 * 
	 * @return
	 */
	public static int getWIDTH() {
		return WIDTH;
	}

	/**
	 * getHIGHT
	 * 
	 * @return
	 */
	public static int getHIGHT() {
		return HIGHT;
	}

	/**
	 * Se Verifica la si en la posicion pasada hay un punto o no
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	public boolean checkPointsOnSite(int i, int j) {
		boolean existsPoints = false;
		if (logicScene[i][j] == 1) {
			existsPoints = true;
		}
		return existsPoints;
	}

	/**
	 * Get Logic Scene
	 * 
	 * @return
	 */
	public int[][] getLogicScene() {
		return logicScene;
	}

	/**
	 * Set Logic Scene
	 * 
	 * @param logicScene
	 */
	public void setLogicScene(int[][] logicScene) {
		this.logicScene = logicScene;
	}
}
