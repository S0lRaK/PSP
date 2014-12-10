package exemplethreads;

import java.util.ArrayList;

public class ExempleThread
{
	public static void main(String[] args)
	{
		ArrayList<Proces> processos = new ArrayList<Proces>();
		
		try
		{
			for(int i = 0; i < 10; i++)
			{
				Proces p = new Proces(i + "");
				p.start();
				processos.add(p);
			}
			
			for(int i = 0; i < 10; i++)
			{
				processos.get(i).join(0);
			}
			
			System.out.println("Fil pare finalitzat");
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
}
