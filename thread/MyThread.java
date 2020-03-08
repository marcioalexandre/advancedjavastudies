public class MyThread
{
	
	static int i = 0;
	
	public static void main(String... args) 
	{
		new Thread(thread1).start();
		new Thread(thread2).start();		
	}
	
	static Runnable thread1 = new Runnable() 
	{
		@Override
		public void run() 
		{
			for (int i=0; i <=3; i++)
				counter("first thread");
		}
	};
	
	static Runnable thread2 = new Runnable() 
	{
		@Override
		public void run() 
		{
			for (int i=0; i <=3; i++)
				counter("second thread");
		}
	};	
	
	private static void counter(String msg) 
	{
		i++;
		System.out.println(i+" , by "+msg);
	}	
}