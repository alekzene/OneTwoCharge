package main;

import java.util.ArrayList;

public class Skills 
{
	public static ArrayList<String> getAvailable(int userSkillPoints, ArrayList<String>list)
	{
		list.clear();
		list.add("[C] Charge");
		
		if (userSkillPoints >= 1)
		{
			list.add("[S] Shield");
			list.add("[W] Wave");
		}
		if (userSkillPoints >= 2)
		{
			list.add("[A] Ax");
		}
		if (userSkillPoints >= 4)
		{
			list.add("[K] Kamekameha");
		}
		if (userSkillPoints >= 5)
		{
			list.add("[M] Amen");
		}
		return list;
	}
}