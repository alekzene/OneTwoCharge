package main;

public class DamageCalculator 
{
	static int finalDamage;
	public static void dealFinalDamage(int userDamage, int computerDamage, int userHP, int computerHP)
	{
		if (userDamage != 0 && computerDamage != 0)
		{
			if (userDamage > computerDamage)
			{
				finalDamage = userDamage - computerDamage;			
				System.out.println("Final Damage To AI: " + finalDamage);
				userHP = userHP + computerDamage;
				computerHP = computerHP + userDamage;
				computerHP = computerHP - finalDamage;
			}
			else if (userDamage < computerDamage)
			{
				finalDamage = computerDamage - userDamage;
				System.out.println("Final Damage To User: " + finalDamage);
				userHP = userHP + computerDamage;
				computerHP = computerHP + userDamage;
				userHP = userHP - finalDamage;
				
			}
			else if (userDamage == computerDamage)
			{
				System.out.println("Draw Round");
				userHP = userHP + computerDamage;
				computerHP = computerHP + userDamage;
			}
		}	
	}
}

// DamageCalculator.dealFinalDamage(user.pendingDamage, computer.pendingDamage, user.healthPoint, computer.healthPoint);
