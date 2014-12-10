package runnables;

public class ExempleRunnable implements Runnable
{
	public static void main(String[] args)
	{
		for(int i = 0; i < 10; i++)
		{
			ExempleRunnable e = new ExempleRunnable();
			Thread t = new Thread(e);
			t.start();
		}
		System.out.println("Procés principal finalitzat");
	}

	@Override
	public void run()
	{
		int num = (int) (Math.random() * 100000000);
		int i = -1;
		
		System.out.println("Número aleatori: " + num);
		
		for(i = 0; i < num; i++)
		{
			if(i % 10000000 == 0)
			{
				System.out.println(num + ": " + i);
			}
		}
		
		System.out.println("Final " + num + ": " + i);
	}
}
