package tasks;

import java.util.Scanner;

public class Tic_Tac_Toe 
{
	static Scanner sc = new Scanner(System.in);
	static Tic_Tac_Toe currentPlayer;
	static char board[][];
	
	String name;
	char symbol;
	
	public static void start()
	{
		board = new char[3][3];
		makeEmptyBoard();
		Tic_Tac_Toe player1 = new Tic_Tac_Toe("Reddy", 'X');
		Tic_Tac_Toe player2 = new Tic_Tac_Toe("Bobby", 'O');
		currentPlayer = player1;
		while(true)
		{
			System.out.println(currentPlayer.name+"'s Turn");
			currentPlayer.makeMove();
			displayBoard();
			if(rowWinCheck() || coloumnWinCheck() || crossWinCheck())
			{
				System.out.println(currentPlayer.name+" has Won The Game...");
				System.out.println();
				System.out.println("----------------------");
				System.out.println("1.Press any number to Play Again \n2.Press '0' to Exit");
				System.out.println("Select Your Choice : ");
				String choice = sc.next();
				switch(choice)
				{
					case "0":
						System.out.println("Game Terminated....");
						System.exit(0);
					default:
							start();
				}
			}
			else if(drawCheck())
			{
				System.out.println("Game is Draw...");
				System.out.println();
				System.out.println("----------------------");
				System.out.println("1.Press any number to Play Again /n2.Press 0 to Exit");
				String choice = sc.next();
				switch(choice)
				{
					case "0":
						System.out.println("Game Terminated....");
						System.exit(0);
					default:
							start();
				}
			}
			else
			{
				if(currentPlayer == player1)
				{
					currentPlayer = player2;
				}
				else
				{
					currentPlayer = player1;
				}
			}
		}		
	}
	
	public static void makeEmptyBoard() 
	{
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[i].length;j++)
			{
				board[i][j]=' ';
			}
		}
	}
	
	public Tic_Tac_Toe(String name, char symbol) 
	{
		this.name = name;
		this.symbol = symbol;
	}
	
	public void makeMove()
	{
		System.out.println("Enter Row & coloumn Number :");
		int row = sc.nextInt();
		int coloumn = sc.nextInt();
		boolean k = isValidMove(row, coloumn);
		if(k)
		{
			placemark(row,coloumn,symbol);
		}
		else
		{
			if(row>=0 && row<3 && coloumn>=0 && coloumn<3)
			{
				System.out.println("Row "+row+ " and Coloumn "+coloumn+" is already Filled");
				System.out.println("Select another place");
				currentPlayer.makeMove();
			}
			else
			{
				System.out.println("Row "+row+ " and Coloumn "+coloumn+" is Out of Board");
				System.out.println("Choose the position within the board");
				currentPlayer.makeMove();
			}
		}
	}
	
	public boolean isValidMove(int row, int coloumn)
	{
		if(row>=0 && row<3 && coloumn>=0 && coloumn<3)
		{
			if(Tic_Tac_Toe.board[row][coloumn] == ' ')
			{
				return true;
			}
		}
		return false;
	}
	
	public static void placemark(int row,int coloumn,char symbol)
	{
		if(row>=0 && row<=2 && coloumn>=0 && coloumn<=2)
		{	
			board[row][coloumn] = symbol;
		}
	}
	
	public static void displayBoard()
	{
		System.out.println("-------------");
		for(int i=0;i<board.length;i++)
		{
			System.out.print("| ");
			for(int j=0;j<board[i].length;j++)
			{
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}

	public static boolean rowWinCheck()
	{
		for(int i=0;i<3;i++)
		{
			if(board[i][0]!=' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2])
			{
				return true;
			}
		}
		return false;
	}
	
	public static boolean coloumnWinCheck()
	{
		for(int j=0;j<3;j++)
		{
			if(board[0][j]!=' ' && board[0][j]==board[1][j] && board[1][j]==board[2][j])
			{
				return true;
			}
		}
		return false;
	}
	
	public static boolean crossWinCheck()
	{
		if(board[0][0]!=' ' && board[0][0]==board[1][1] && board[1][1]==board[2][2] 
				||  
				board[0][2]!=' ' && board[0][2]==board[1][1] && board[1][1]==board[2][0])
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean drawCheck()
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(board[i][j] == ' ')
				{
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args)
	{
		start();
	}
}
