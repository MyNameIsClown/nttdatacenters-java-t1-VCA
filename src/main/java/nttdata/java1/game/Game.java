package nttdata.java1.game;

import java.util.Scanner;

/**
 * Game
 * 
 * @author Victor Carrasco Artacho
 *
 */
public class Game {
	/** scene */
	private GameScene scene;
	/** player01 */
	private Player player01;
	/** ball */
	private Ball ball;

	/**
	 * Constructor
	 */
	public Game() {
		super();
		this.scene = new GameScene();
		this.player01 = new Player();
		this.ball = new Ball();
	}

	/**
	 * Launch And Start
	 */
	public static void launchAndStart() {

		// Inicializacion del juego
		Game gm = new Game();

		// Generar las casillas con los puntos repartidos aleatoriamente
		gm.scene.fillScene();

		// Posicion inicial aleatoria
		int initialPosition = (int) (Math.random() * GameScene.getWIDTH());
		gm.ball.setPosition(initialPosition);

		// Mostrar menu
		System.out.println(gm.showMenu(gm));
		Scanner sc1 = new Scanner(System.in);
		int opt = sc1.nextInt();
		// Se ejecuta hasta que pida salir introduciendo un 4 o de GameOver
		while (opt != 4 && !gm.player01.checkGameOver()) {
			switch (opt) {
			case 1:
				gm.changePlayerName(gm);
				break;
			case 2:
				if (gm.player01.getMoney() == 0) {
					System.out.println("Lo siento, pero no te queda dinero");
				} else {
					gm.buyBalls(gm);
				}
				break;
			case 3:
				if (gm.player01.getNumBalls() == 0) {
					System.out.println("No te quedan tiradas, prueba a comprar un buen par de bolas");
				} else {
					gm.playTimes(gm);
				}
				break;
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("Opcion no Valida");
			}

			if (!gm.player01.checkGameOver()) {
				System.out.println(gm.showMenu(gm));
				opt = sc1.nextInt();
			} else {
				System.out.println();
				System.out.println("###########");
				System.out.println("GAME OVER");
				System.out.println("###########");
				System.out.println(gm.player01);
			}
		}
	}

	/**
	 * Se ejecuta una tirada
	 * 
	 * @param gm
	 * @return devuelve el dinero ganado en esa tirada
	 */
	public static int play(Game gm) {
		int dineroGanado = 0;
		gm.ball.setScore(0);
		// se cambiara de posicion tantas veces sea de alto el tablero
		for (int i = 0; i < GameScene.getHIGHT(); i++) {
			Game.printFotogram(gm, i);
			System.out.println("################");
			gm.ball.setNextPosition();
			if (gm.scene.checkPointsOnSite(i, gm.ball.getPosition())) {
				gm.ball.addScore();
			}
		}
		dineroGanado = gm.ball.getScore() * 2;
		System.out.println("Puntuacion: " + gm.ball.getScore());
		System.out.println("Dinero ganado: " + dineroGanado);
		gm.player01.addMoney(dineroGanado);
		return dineroGanado;
	}

	/**
	 * Se ejecuta el metodo play tantas veces diga el usuario
	 * 
	 * @param gm
	 */
	public void playTimes(Game gm) {
		// total de dinero ganado en todas las tiradas
		int totalDineroGanado = 0;

		Scanner sc3 = new Scanner(System.in);
		System.out.println("¿Cuantas bolas quieres gastar(tienes " + gm.player01.getNumBalls() + ")?");
		int numTiradas = sc3.nextInt();

		if (numTiradas == 0 || numTiradas > gm.player01.getNumBalls()) {
			System.out.println("##############################");
			System.out.println("Numero de tiradas invalidas");
			System.out.println("##############################");

		} else {

			for (int i = 1; i <= numTiradas; i++) {
				System.out.println("Tirada nº " + i);
				System.out.println("/////////////////////////////\n");
				int dineroGanado = Game.play(gm);
				totalDineroGanado += dineroGanado;
				gm.player01.addToTotalPoints(dineroGanado / 2);
				System.out.println();
			}
			gm.player01.setNumBalls(gm.player01.getNumBalls() - numTiradas);
			System.out.println("Has ganado en total --> " + totalDineroGanado + "$");
			System.out.println("Has ganado en total --> " + totalDineroGanado / 2 + " puntos");
		}
	}

	/**
	 * Se pinta el fotograma actual del mapa, incluyendo la posicion en el eje x de
	 * la bola
	 * 
	 * @param gm
	 * @param positionY
	 */
	private static void printFotogram(Game gm, int positionY) {
		for (int i = 0; i < GameScene.getHIGHT(); i++) {
			for (int j = 0; j < GameScene.getWIDTH(); j++) {
				// se pinta una "P" simbolizando al jugador, en la posicion donde se encuentre
				if (j == gm.ball.getPosition() && i == positionY) {
					if (gm.scene.checkPointsOnSite(i, j)) {
						// mayuscula para cuando esta en una casilla con un punto
						System.out.print("P");
					} else {
						// minuscula para cuando esta en una casilla sin punto
						System.out.print("p");
					}
				} else {
					// para el resto de posiciones se pinta la casilla correspondiente
					System.out.print(gm.scene.getLogicScene()[i][j]);
				}
			}
			// siguiente nivel
			System.out.println();
		}
	}

	/**
	 * PrintMenu
	 * 
	 * @return
	 */
	private String showMenu(Game gm) {
		return "BIENVENIDO AL PACHINKO '" + gm.player01.getName() + "'\n" + "\t1) Cambiar nombre de jugador\n"
				+ "\t2) Comprar tiradas\n" + "\t3) Jugar\n" + "\t4) Salir\n";
	}

	/**
	 * Se cambia el nombre del jugador
	 * 
	 * @param gm
	 */
	private void changePlayerName(Game gm) {
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Que nombre quieres usar?");
		gm.player01.setName(sc.next());
	}

	/**
	 * Comprar tiradas
	 * 
	 * @param gm
	 */
	private void buyBalls(Game gm) {
		System.out.println("INFO\n------");
		System.out.println(gm.player01);
		System.out.println("1x bola --> 2$");
		Scanner sc2 = new Scanner(System.in);
		System.out.println("¿Cuantas bolas quieres comprar?");
		int numBolas = sc2.nextInt();
		if (numBolas == 0) {
			System.out.println("Ninguna bola comprada");
		} else if (numBolas * 2 <= gm.player01.getMoney()) {
			gm.player01.addBalls(numBolas);
			gm.player01.quitMoney(numBolas * 2);
		} else {
			System.out.println("No tienes suficiente dinero");
		}
	}
}
