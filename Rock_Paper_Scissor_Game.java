package tasks;

import java.util.Random;
import java.util.Scanner;

public class Rock_Paper_Scissor_Game 
{
	static Scanner sc = new Scanner(System.in);
	static Random r = new Random();
	static int match=0,userCount=0,systemCount=0,tiedCount=0;
	public void play()
	{
		while(true)
		{
			System.out.println("1.Play Game\t2.Game Statistics\t3.Stop Game");
			System.out.println("Select Your Option :");
			int option = sc.nextInt();
			switch(option)
			{
				case 1:
					this.selectChoice();
					break;
				case 2:
					System.out.println("Number of Matches You Played :"+match);
					System.out.println("Number of Matches You Won :"+userCount);
					System.out.println("Number of Matches You Lost :"+systemCount);
					System.out.println("Number of Matches Tied :"+tiedCount);
					System.out.println();
					System.out.println();
					this.play();
					break;
				case 3:
					System.out.println("Successfully Exit from Game ! ! !");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid option!!!!.....\nSelect Options in the following.....\n");
					this.play();
			}
		}
	}
	public void statistics()
	{
		
	}
	public void selectChoice() 
	{
		System.out.println("1.Rock\t2.Paper\t3.Scissor");
		System.out.println("Select Your Choice :");
		int choice = sc.nextInt();
		switch(choice)
		{
			case 1:
				System.out.println("You Selected Rock....");
				System.out.println();
				this.systemChoice(choice);
				break;
			case 2:
				System.out.println("You Selected Paper....");
				System.out.println();
				this.systemChoice(choice);
				break;
			case 3:
				System.out.println("You Selected Scissor....");
				System.out.println();
				this.systemChoice(choice);
				break;
			default:
				System.out.println("InValid Choice!!!\nSelect the following Options");
				System.out.println();
				this.selectChoice();
		}
	}
	public void systemChoice(int choice)
	{
		int systemChoice = r.nextInt(3);
		switch(systemChoice)
		{
			case 0:
				System.out.println("Computer Selected Rock....");
				System.out.println();
				this.comparision(choice,systemChoice);
				break;
			case 1:
				System.out.println("Computer Selected Paper....");
				System.out.println();
				this.comparision(choice,systemChoice);
				break;
			case 2:
				System.out.println("Computer Selected Scissor....");
				System.out.println();
				this.comparision(choice,systemChoice);
				break;	
		}
	}
	public void comparision(int c,int sys)
	{
		match++;
		if(c==1 && sys==0 || c==2 && sys==1 || c==3 && sys==2)
		{
			System.out.println("Match Draw....");
			tiedCount++;
			System.out.println();
		}
		else if(c==1 && sys==2 || c==2 && sys==0 || c==3 && sys==1)
		{
			System.out.println("You Won!!!!....");
			userCount++;
			System.out.println();
		}
		else
		{
			System.out.println("Computer Won!!!!....");
			systemCount++;
			System.out.println();
		}
	}
	public static void main(String[] args)
	{
		Rock_Paper_Scissor_Game rps = new Rock_Paper_Scissor_Game();
		rps.play();
	}
}
