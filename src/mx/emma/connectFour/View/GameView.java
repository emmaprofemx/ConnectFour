package mx.emma.connectFour.View;

import java.util.Scanner;
import java.util.StringJoiner;

import mx.emma.connectFour.Model.Disc;
import mx.emma.connectFour.Model.Game;
import mx.emma.connectFour.Model.Player;
import mx.emma.connectFour.Model.PlayerType;

public class GameView {
	
	Scanner sc;

	public GameView() {
		sc = new Scanner(System.in);
	}

	public Game makeGame() {
		System.out.println("HOLA , BIENVENIDO AL JUEGO DE 4 EN FILA");
		System.out.println("************************************************************");
		System.out.println("JUGADOR NO.1 , INGRESA TU NOMBRE:");
		String firstPlayerName = sc.nextLine();
		System.out.println("JUGADOR NO.2 , INGRESA TU NOMBRE:");
		String secondPlayerName = sc.nextLine();
		Player player1 = new Player(firstPlayerName.toUpperCase(), PlayerType.PlayerOne),
				player2 = new Player(secondPlayerName.toUpperCase(), PlayerType.PlayerTwo);
		Game game = new Game(player1, player2);
		return game;
	}

	public void printBoard(Game game) {
		System.out.println("************************************************************");
		for (Disc[] row : game.getBoard()) {
			StringJoiner sj = new StringJoiner(" | ");
			for (Disc col : row) {
				if (col == null) {
					sj.add(" ");
				} else {
					sj.add(col.toString());
				}
			}
			System.out.println(sj.toString());
		}
	}

	public int playTurn(String playerName) throws NumberFormatException {
		System.out.println(
				"Es el turno de: " + playerName + " , por favor ingresa la columna");
		int columnToInsertIn;
		String input=sc.nextLine();
		try {
			columnToInsertIn = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("INGRESA UN NUMERO");
		}
		return columnToInsertIn;
	}
	
}//Fin de Game View
