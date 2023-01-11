package main;									// For Future Development: Allow user to quit while playing.
import java.util.Scanner;							// Improve UI. Stats board breaks when game stats change from one to two digits.
import java.util.Random;							// Optimize code. Make it shorter and reduce nesting if possible.
import java.util.ArrayList;							// Set HP baseline to 0 (a.k.a. program doesn't display negative HP).
import boards.*;								
																			
public class Main													
{																	
	static String userMove, computerMove;							
	static boolean a, g, i, u;										
																	
	public static void main(String[] args) 							
	{																
		Scanner sc = new Scanner(System.in);
		Random randomize = new Random();
		DamageCalculator damage = new DamageCalculator();
		int finalDamage;											

		Player user = new Player();
		Player computer = new Player();
		user.healthPoint = 10; 	computer.healthPoint = 10;
		user.skillPoint = 0;	computer.skillPoint = 0;
		user.pendingDamage = 0; 	computer.pendingDamage = 0;
		
		ArrayList<String> userSkillSet = new ArrayList<String>();
		ArrayList<String> computerSkillSet = new ArrayList<String>();
		ArrayList<String> computerSkillKeys = new ArrayList<String>();
		computerSkillKeys.add("C");
		computerSkillKeys.add("S");
		computerSkillKeys.add("W");
		computerSkillKeys.add("A");
		computerSkillKeys.add("K");
		computerSkillKeys.add("M");
		
		int round = 0;
		
		// Game Menu
		System.out.println("Welcome to the Charge Game!");
		System.out.println("[O] Start [H] Help [X] Quit");
		
		// Validation: Game Menu Input (i)
		do 					
		{
			String userChoice = sc.nextLine();
			switch(userChoice.toLowerCase())
			{
				case "o":
					// Game Loop (g)
					do
					{
						round++;
						StatsBoard.display(round, user.healthPoint, user.skillPoint, computer.healthPoint, computer.skillPoint);
						
						System.out.println("YOUR TURN");
						System.out.println("Your Skillset: " + Skills.getAvailable(user.skillPoint, userSkillSet));
						System.out.print("Your Pick: ");
						
						do // Validation: User's Turn (u)
						{
							userMove = sc.next();
							if (userMove.equalsIgnoreCase("C"))																						
							{
								user.skillPoint++;
								user.pendingDamage = 0;
								g = false;
								u = true;
							}
							else if (userMove.equalsIgnoreCase("S"))
							{
								if (user.skillPoint < 1)
								{
									System.out.print("Invalid Move. Pick Again:");
									g = true;								
									u = false;								
								}
								else
								{
									user.skillPoint--;
									user.pendingDamage = 0;
									g = false;
									u = true;
								}
							}
							else if (userMove.equalsIgnoreCase("W"))
							{
								if (user.skillPoint < 1)
								{
									System.out.println("Invalid Move. Pick Again:");
									g = true;								
									u = false;								
								}
								else
								{
									user.skillPoint--;
									user.pendingDamage = 2;
									computer.healthPoint = computer.healthPoint - user.pendingDamage;
									g = false;
									u = true;
								}
							}
							else if (userMove.equalsIgnoreCase("A"))
							{
								if (user.skillPoint < 2)
								{
									System.out.print("Invalid Move. Pick Again:");
									g = true;								
									u = false;								
								}
								else
								{
									user.skillPoint-=2;
									user.pendingDamage = 3;
									computer.healthPoint = computer.healthPoint - user.pendingDamage;
									g = false;
									u = true;
								}
							}
							else if (userMove.equalsIgnoreCase("K"))
							{
								if (user.skillPoint < 4)
								{
									System.out.print("Invalid Move. Pick Again:");
									g = true;								
									u = false;								
								}
								else
								{
									user.skillPoint-= 4;
									user.pendingDamage = 6;
									computer.healthPoint = computer.healthPoint - user.pendingDamage;
									g = false;
									u = true;
								}
							}
							else if (userMove.equalsIgnoreCase("M"))
							{
								if (user.skillPoint < 5)
								{
									System.out.print("Invalid Move. Pick Again:");
									g = true;								
									u = false;								
								}
								else
								{
									user.skillPoint-=5;
									user.healthPoint+=5;
									user.pendingDamage = 0;
									continue;
								}
							}
							else 
							{
								System.out.print("Enter Correct Key: ");
								g = true;
								u = false;
							}
						}
						while (u == false);
						
						System.out.println("\nAI'S TURN");
						System.out.println("AI's Skillset: " + Skills.getAvailable(computer.skillPoint, computerSkillSet));
						
						do //Validation: AI's Turn (a)
						{
							int computerKeyEntry = randomize.nextInt(computerSkillKeys.size());
							String computerMove = computerSkillKeys.get(computerKeyEntry);
							
							if (computerMove.equalsIgnoreCase("C"))																						
							{
								System.out.println("AI's Pick: C");
								computer.skillPoint++;
								computer.pendingDamage = 0;
								g = false;
								a = true;
							}
							else if (computerMove.equalsIgnoreCase("S"))
							{
								if (computer.skillPoint < 1)
								{
									g = true;								
									a = false;								
								}
								else
								{
									System.out.println("AI's Pick: S");
									computer.skillPoint--;	
									computer.pendingDamage = 0;

									if (userMove.equalsIgnoreCase("S"))
									{
										g = false;
										a = true;
									}
									else if (userMove.equalsIgnoreCase("K"))
									{
										g = false;
										a = true;	
									}
									else if (!userMove.equalsIgnoreCase("K"))
									{
										computer.healthPoint = computer.healthPoint + user.pendingDamage;
										g = false;
										a = true;
									}
									g = false;
									a = true;
								}
							}
							else if (computerMove.equalsIgnoreCase("W"))
							{
								if (computer.skillPoint < 1)
								{
									g = true;								
									a = false;								
								}
								else
								{
									System.out.println("AI's Pick: W");
									computer.skillPoint--;
									computer.pendingDamage = 2;
									user.healthPoint = user.healthPoint - computer.pendingDamage;
									
									if (userMove.equalsIgnoreCase("S"))
									{
										user.healthPoint = user.healthPoint + computer.pendingDamage;
									}					
									g = false;
									a = true;
								}
							}
							else if (computerMove.equalsIgnoreCase("A"))
							{
								if (computer.skillPoint < 2)
								{
									g = true;								
									a = false;								
								}
								else
								{
									System.out.println("AI's Pick: A");
									computer.skillPoint-=2;
									computer.pendingDamage = 3;
									user.healthPoint = user.healthPoint - computer.pendingDamage;
									
									if (userMove.equalsIgnoreCase("S"))
									{
										user.healthPoint = user.healthPoint + computer.pendingDamage;
									}								
									g = false;
									a = true;
								}
							}
							else if (computerMove.equalsIgnoreCase("K"))
							{
								if (computer.skillPoint < 4)
								{
									g = true;								
									a = false;								
								}
								else
								{
									System.out.println("AI's Pick: K");
									computer.skillPoint-= 4;
									computer.pendingDamage = 6;
									user.healthPoint = user.healthPoint - computer.pendingDamage;
									g = false;
									a = true;
								}
							}
							else if (computerMove.equalsIgnoreCase("M"))
							{
								if (computer.skillPoint < 5)
								{
									g = true;								
									a = false;								
								}
								else
								{
									System.out.println("AI's Pick: M");
									computer.skillPoint-=5;
									computer.healthPoint+=5;
									computer.pendingDamage = 0;
									
									if (!userMove.equalsIgnoreCase("M"))
									{
										computer.healthPoint = computer.healthPoint + user.pendingDamage;
									}
									g = false;
									a = true;
								}
							}
							else 
							{
								g = false;
								a = true;
							}
							
							// User's Amen Negates Damage from Opponent
							if (userMove.equalsIgnoreCase("M") && !computerMove.equalsIgnoreCase("M"))
							{
								user.healthPoint = user.healthPoint + computer.pendingDamage;
							}
							
						} while (a == false);
						
						// Damage To Deal if Both Skills Used Were Damage-Inducing
						if (user.pendingDamage != 0 && computer.pendingDamage != 0)
						{
							if (user.pendingDamage > computer.pendingDamage)
							{
								finalDamage = user.pendingDamage - computer.pendingDamage;			
								System.out.println("Final Damage To AI: " + finalDamage);
								user.healthPoint = user.healthPoint + computer.pendingDamage;
								computer.healthPoint = computer.healthPoint + user.pendingDamage;
								computer.healthPoint = computer.healthPoint - finalDamage;
							}
							else if (user.pendingDamage < computer.pendingDamage)
							{
								finalDamage = computer.pendingDamage - user.pendingDamage;
								System.out.println("Final Damage To User: " + finalDamage);
								user.healthPoint = user.healthPoint + computer.pendingDamage;
								computer.healthPoint = computer.healthPoint + user.pendingDamage;
								user.healthPoint = user.healthPoint - finalDamage;
								
							}
							else if (user.pendingDamage == computer.pendingDamage)
							{
								System.out.println("Draw Round");
								user.healthPoint = user.healthPoint + computer.pendingDamage;
								computer.healthPoint = computer.healthPoint + user.pendingDamage;
							}
						}
					
						// Reset pendingDamage for next Round
						user.pendingDamage = 0;
						computer.pendingDamage = 0;	
						
						// Game Over Prompt
						if (user.healthPoint <= 0)
						{
							round++;
							StatsBoard.display(round, user.healthPoint, user.skillPoint, computer.healthPoint, computer.skillPoint);
							System.out.println("Game Over. AI wins!");
							System.exit(0);
							g = true;
						}
						else if (computer.healthPoint <= 0)
						{
							round++;
							StatsBoard.display(round, user.healthPoint, user.skillPoint, computer.healthPoint, computer.skillPoint);
							System.out.println("Game Over. You win!");
							System.exit(0);
							g = true;
						}
						else
						{
							g = false;
						}
						
					} while (g == false);	
					
					i = false;
					break;
					
				case "h":
					HelpBoard.display();
					System.out.println("\n[O] Start [H] Help [X] Quit");
					i = false;
					break;
					
				case "x":
					System.out.print("Thank you for playing!");
					System.exit(0);
					break;
					
				default:
					System.out.println("Invalid input. Try Again. \n\n[O] Start [H] Help [X] Quit");
					i = false;
			}
		}
		while (i == false);
	}
}
