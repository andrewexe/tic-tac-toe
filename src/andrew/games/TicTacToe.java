package andrew.games;
import java.util.Scanner;

public class TicTacToe {

	private Piece[][] board = new Piece[3][3];
	
	public void drawBoard() {
		for(int i = 0; i < board.length; i++) {
			System.out.print("| ");
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] == null) {
					System.out.print(" | ");
				}
				else {
					System.out.print(board[i][j].getType() + "| ");
				}
			}
			System.out.println();
		}
		System.out.println("---------------");
	}
	
	public void playerTurn() {
		Scanner kb = new Scanner(System.in);
		int row = 0;
		int col = 0;
		while(row < 1 || row > 3 || col < 1 || col > 3 || board[row - 1][col - 1] != null) {
			System.out.println("Pick a row");
			row = kb.nextInt();
			System.out.println("Pick a column");
			col = kb.nextInt();
		}
		board[row - 1][col - 1] = new X();
	}
	
	public void computerTurn() {
		int row = (int)(Math.random()*3);
		int col = (int)(Math.random()*3);
		while(board[row][col] != null) {
			row = (int)(Math.random()*3);
			col = (int)(Math.random()*3);
		}
		board[row][col] = new O();
	}
	
	public boolean gameOver(boolean player) {
		for(int i = 0; i < board.length - 1; i++) {			
			if(board[i][0] != null && board[i][1] != null && board[i][2] != null && board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2])) {
				if(player) {
					System.out.println("You win");
				}
				else {
					System.out.println("CPU wins");
				}
				return true;
			}
		}
		
		for(int j = 0; j < board[0].length - 1; j++) {
			if(board[0][j] != null && board[1][j] != null && board[2][j] != null && board[0][j].equals(board[1][j]) && board[1][j].equals(board[2][j])) {
				if(player) {
					System.out.println("You win");
				}
				else {
					System.out.println("CPU wins");
				}
				return true;
			}
		}
		
		if(board[0][0] != null && board[1][1] != null && board[2][2] != null && board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) {
			if(player) {
				System.out.println("You win");
			}
			else {
				System.out.println("CPU wins");
			}
			return true;
		}
		
		if(board[0][2] != null && board[1][1] != null && board[2][0] != null && board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])) {
			if(player) {
				System.out.println("You win");
			}
			else {
				System.out.println("CPU wins");
			}
			return true;
		}
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] == null) {
					return false;
				}
			}
		}
		System.out.println("Cat's game");
		return true;
	}
	
	public void playGame() {
		drawBoard();
		for(int i = 0; i < 9; i++) {
			if(i % 2 == 1) {
				computerTurn();
				drawBoard();
				if(gameOver(false)) {
					return;
				}
			}
			else {
				playerTurn();
				drawBoard();
				if(gameOver(true)) {
					return;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		game.playGame();
	}
}
