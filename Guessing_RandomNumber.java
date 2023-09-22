package game;
import java.util.Scanner;
import java.util.Random;

public class Guessing_RandomNumber 
{
	public static Scanner sc = new Scanner(System.in);
	public static Random r = new Random();
	
	public static void play()
	{
		int randome_Number = r.nextInt(100);
		int number = 101;
		int count=0;
		check(randome_Number,number,count);
	}
	public static void check(int randome_Number,int number,int count)
	{
		while(number != randome_Number)
		{
			System.out.println("Enter a Number Between 1 to 100 :");
			number = sc.nextInt();
			count++;
			result(randome_Number,number,count);
		}
	}
	public static void result(int randome_Number,int number,int count)
	{
		if(number == randome_Number)
		{
			System.out.println("Wow! Your guess is Correct......");
			System.out.println("You guess the number in "+count+" Attempts");
			System.out.println();
			System.out.println("=====XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX=====");
			System.out.println();
			playAgain();
		}
		else if(number > randome_Number)
		{
			System.out.println("Your Guess is Too high...Try again");
			check(randome_Number,number,count);
		}
		else
		{
			System.out.println("Your Guess is Too Low....Try again");
			check(randome_Number,number,count);
		}
	}
	public static void playAgain()
	{
		System.out.println("1.Play Again\n2.Exit");
		System.out.println("Select Your Option");
		int choice = sc.nextInt();
		switch(choice)
		{
			case 1:
				play();
				break;
			case 2:
				System.out.println("Game Terminated....");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Input....!\nSelect Correct Option");
				playAgain();	
		}
	}
	public static void main(String[] args)
	{
		play();
	}
}
