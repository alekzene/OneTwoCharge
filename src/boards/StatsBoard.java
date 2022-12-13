package boards;

public class StatsBoard 
{
	public static void display(int round, int userHP, int userSP, int compHP, int compSP)
	{
		
		System.out.println("\n                                 ROUND " + round);
		
		String stat1 = "  ^--------------------------------------------------------------------^\n";
		String stat2 = "  ! 	   Your HP: " + userHP + "  			AI'S HP: " + compHP +     "	       !\n";
		String stat3 = "  ! 	   Your SP: " + userSP + "  				AI's SP:  " + compSP + "	       !\n";
		String stat4 = "  ^--------------------------------------------------------------------^\n";
		
		System.out.println(stat1 + stat2 + stat3 + stat4);
	}
}