package assignments;

import java.util.Scanner;
import java.util.Random;

class Guest // for scaling, use util.Random class and use nextInt(bound) method
{
	int guestNum;

	public int guessNumber() {
		Random sc = new Random();

		System.out.println("\t\tMatch Begins");
		System.out.println("Guesser has guessed the number in 0 to 9!!");
		System.out.println("Players' Chance");
		System.out.println("----------------------------------------");
		guestNum = sc.nextInt(10);
//		System.out.println(guestNum); // printing for checking
		return guestNum;

	}
}

class Player {
	int playerTry;
//	boolean won=false;

	public int playerNum() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Player, Make a guess : ");
		playerTry = sc.nextInt();
		return playerTry;

	}
}

class Umpire {
	// try idea: use constructor to pass number of players and then create array
	int numFromGuest;
	int numFromPlayer1;
	int numFromPlayer2;
	int numFromPlayer3;

	public void getFromGuest() {
		Guest g = new Guest();
		numFromGuest = g.guessNumber(); // here umpire knows what is guest's number
	}

	public void getFromPlayers() { // try idea: pass the number of player as parameter
		Player p1 = new Player();
		numFromPlayer1 = p1.playerNum();

		Player p2 = new Player();
		numFromPlayer2 = p2.playerNum();

		Player p3 = new Player();
		numFromPlayer3 = p3.playerNum();

	}

	public void compare() {
		if (numFromGuest == numFromPlayer1 && numFromGuest == numFromPlayer2) {
			if (numFromGuest == numFromPlayer3) {
				System.out.println("All players have won !!!");
			} else {
				System.out.println("Player 1 and Player 2 won the game !!");
			}
		} 
		else if (numFromGuest == numFromPlayer1) {
			if(numFromGuest == numFromPlayer3) {
				System.out.println("Player 1 and Player 3 won the game !!");
			}
			else
				System.out.println("Player 1 has won the game !!");
		}
		else if(numFromGuest==numFromPlayer2) {
			if(numFromGuest == numFromPlayer3) {
				System.out.println("Player 2 and Player 3 won the game !!");
			}
			else
				System.out.println("Player 2 has won the game !!");
		}
		else if (numFromGuest==numFromPlayer3) {
			System.out.println("Player 3 has won the game !!");
		}
		else
		{
			System.out.println("It's a tie, NO One guessed the number");
			System.out.println("The number was : "+numFromGuest);
		}
	}
}

public class Assignment2 {

	public static void main(String[] args) {

		Umpire u = new Umpire();
		u.getFromGuest();
		u.getFromPlayers();
		u.compare();
		
	}

}
