package boards;

public class HelpBoard 
{
	public static void display()
	{
		String help1 = "  ^-------------------------------------------------------------------------------------^\n";
		String help2 = "  ! 	  				TERMINOLOGY			     	   	!\n";
		String help3 = "  ! 		HP: Health Points 			SP: Skill Points    	 	!\n";
		String help4 = "  !                                                                	   	 	!\n";
		String help5 = "  ! 	  				  SKILLS			     	   	!\n";
		String help6 = "  ! 	   Charge: Adds 1 to your SP.	                            	   	 	!\n";
		String help7 = "  ! 	   Shield: Costs 1 SP. Blocks damage-dealing skills except Kamekameha.   	!\n";	
		String help8 = "  ! 	   Wave: Costs 1 SP. Deals 2.  			 			 	!\n";	
		String help9 = "  ! 	   Ax: Costs 2 SP. Deals 3 damage.  			 		 	!\n";	
		String help10 = "  ! 	   Kamekameha: Costs 4 SP. Deals 6 damage. Overwrites Shield.		 	!\n";
		String help11 = "  ! 	   Amen: Costs 5 SP. Negates damage received. Adds 5 HP.	 		!\n";	
		String help12 = "  ^-------------------------------------------------------------------------------------^\n";

		System.out.println(help1 + help2 + help3 + help4 + help5 + help6 + help7 + help8 + help9 + help10 + help11 + help12);
	}
}