package edu.jsu.mcis;

import java.util.Scanner;

public class TicTacToe {
	
	private char[][] board = new char[3][3];
	private char playerTurn = 'X';
	protected int turnCounter;
	
	public TicTacToe(){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j ++){
				board[i][j] = '#';
			}
		}
		turnCounter = 0;
	}
	
	
	public void markLocation(int x, int y){
		if(board[x][y] == '#'){
			board[x][y] = playerTurn;
			if(playerTurn == 'X') playerTurn = 'O';
			else playerTurn = 'X';
			turnCounter++;
		}
	}
	
	public String getMark(int x, int y){	
		return Character.toString(board[x][y]);
	}
	
	public String getWinner(){
		if(board[0][0] == 'X' && board[0][0] == board[0][1] && board[0][0] == board[0][2]) return "X";
		else if(board[1][0] == 'X' && board[1][0] == board[1][1] && board[1][0] == board[1][2]) return "X";
		else if(board[2][0] == 'X' && board[2][0] == board[2][1] && board[2][0] == board[2][2]) return "X";
		
		else if(board[0][0] == 'X' && board[0][0] == board[1][0] && board[0][0] == board[2][0]) return "X";
		else if(board[0][1] == 'X' && board[0][1] == board[1][1] && board[0][1] == board[2][1]) return "X";
		else if(board[0][2] == 'X' && board[0][2] == board[1][2] && board[0][2] == board[2][2]) return "X";
		
		else if(board[0][0] == 'X' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) return "X";
		else if(board[0][2] == 'X' && board[0][2] == board[1][1] && board[0][2] == board[2][0]) return "X";
		
		else if(board[0][0] == 'O' && board[0][0] == board[0][1] && board[0][0] == board[0][2]) return "O";
		else if(board[1][0] == 'O' && board[1][0] == board[1][1] && board[1][0] == board[1][2]) return "O";
		else if(board[2][0] == 'O' && board[2][0] == board[2][1] && board[2][0] == board[2][2]) return "O";
		
		else if(board[0][0] == 'O' && board[0][0] == board[1][0] && board[0][0] == board[2][0]) return "O";
		else if(board[0][1] == 'O' && board[0][1] == board[1][1] && board[0][1] == board[2][1]) return "O";
		else if(board[0][2] == 'O' && board[0][2] == board[1][2] && board[0][2] == board[2][2]) return "O";
		
		else if(board[0][0] == 'O' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) return "O";
		else if(board[0][2] == 'O' && board[0][2] == board[1][1] && board[0][2] == board[2][0]) return "O";
		
		else if (turnCounter == 9) return "TIE";
		
		else return "NONE";
	}
	
	public static void main(String[] args) {
		TicTacToe t = new TicTacToe();
		
		Scanner playerInput = new Scanner(System.in);
		int x, y;
		
		String winner = t.getWinner();
		
		while(t.turnCounter < 9){
			for(int i = 0; i < 3; i++){
				for(int j = 0; j < 3; j ++){
					System.out.println(t.board[i][j]);
				}
			}
			System.out.println("Player " + Character.toString(t.playerTurn)
			+ ", Input the coordinates of the space you want to mark, seperated by a space: ");
			x = playerInput.nextInt();
			y = playerInput.nextInt();
			
			if(t.board[x][y] == '#'){
				t.markLocation(x,y);
				
				winner = t.getWinner();
				
				if(winner == "X" || winner == "O") break;
			}
			
			else t.turnCounter--;
			
		}
		
		System.out.println("The winner is " + winner + "!");
			
	}
}
