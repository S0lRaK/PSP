package exemplethreads;

public class Proces extends Thread
{
	private String numero;
	
	public Proces (String text)
	{
		numero = text;
	}
	
	public void run()
	{
		int num = (int) (Math.random() * 100000000);
		for(int i = 0; i < num; i++)
		{
			if(i % 10000000 == 0)
			{
				System.out.println(numero + ", " + num);
			}
		}
		System.out.println("Final: " + numero + ", " + num);
	}
}
