package com.control.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {


	public static final Random random = new Random();
	
	public static void main(String[] args) {
		TictactoeBoard  tB = new TictactoeBoard();
		Scanner sc = new Scanner(System.in);
		tB.displayBoard();
		System.out.println("Select turn:\n1. Computer (x) /2.User(O): ");
		
		int choice = sc.nextInt();
		
		if(choice == TictactoeBoard.PLAYER_X) {
			Point p = new Point(random.nextInt(3), random.nextInt(3));
			tB.makeMove(p, TictactoeBoard.PLAYER_X);
			tB.displayBoard();
		}
		
		while(!tB.isGameOver()) {
			boolean moveOk = true;
			do {
				if(!moveOk) {
					System.out.println("Cell already filled!");
				}
					System.out.println("Your move : ");
					Point userMove = new Point(sc.nextInt(), sc.nextInt());
					moveOk = tB.makeMove(userMove, TictactoeBoard.PLAYER_O);
				
			}while(!moveOk);
			
			tB.displayBoard();
			
			if(tB.isGameOver())
				break;
			
			tB.minimax(0,TictactoeBoard.PLAYER_X);
			System.out.println("Computer choses position: "+ tB.aiMove);
			
			tB.makeMove(tB.aiMove, TictactoeBoard.PLAYER_X);
			tB.displayBoard();
		}
		
		if(tB.checkWin(TictactoeBoard.PLAYER_X))
			System.out.println("You lost!");
		else if(tB.checkWin(TictactoeBoard.PLAYER_O))
			System.out.println("You win!");
		else
			System.out.println("Draw");
		
		sc.close();
	}
}
