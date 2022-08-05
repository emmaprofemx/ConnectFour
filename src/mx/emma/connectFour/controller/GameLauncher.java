package mx.emma.connectFour.controller;

import mx.emma.connectFour.Model.Game;
import mx.emma.connectFour.View.GameView;
import mx.emma.connectFour.exceptions.ColumnlsFullException;
import mx.emma.connectFour.exceptions.InvalidColumnException;

public class GameLauncher {
	
	private Game game;
	GameView gameView;
	public GameLauncher() {
		gameView = new GameView();
		game=gameView.makeGame();
		boolean didGameEnd = false;
		while (true) {
			if (getGame().checkIfGameEnded()) {
				didGameEnd = true;
				break;
			}
			gameView.printBoard(getGame());
			int columnToInsertIn=-1;
			try {
				columnToInsertIn = gameView.playTurn(game.getTurnPlayer().getName());
			} catch (NumberFormatException e1) {
				System.out.println("INGRESA UN NUMERO");
			}
			try {
				if (getGame().insertDisc(columnToInsertIn)) {
					break;
				}
				getGame().endTurn();
			} catch (ColumnlsFullException e) {
				System.out.println("LA COLUMNA ESTA LLENA");
			}
			catch(InvalidColumnException e2) {
				System.out.println("Ingresa una posicion valida");
			}

		}
		if (didGameEnd) {
			System.out.println("EL JUEGO HA TERMINADO");
		} else {
			gameView.printBoard(getGame());
			System.out.println("************************************************************");
			System.out.println("************************************************************");
			System.out.println(getGame().getTurnPlayer() + " HAS GANADO!");
			System.out.println("************************************************************");
			System.out.println("************************************************************");
		}
	}//Fin de constructor
	public static void main(String[] args) {
		new GameLauncher();
	}
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
}
