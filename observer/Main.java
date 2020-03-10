import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

class TV extends Observable {
	
	private int numberChannel = 0;
	private boolean isChanged = false;
	private List<Eyes> eyes_list = new ArrayList<Eyes>();
	
	protected void setChanged()
	{
		this.isChanged = true;
	}
	
	protected void clearChanged()
	{
		this.isChanged = false;
	}
	
	protected boolean getChanged() 
	{
		return this.isChanged;
	}
	
	public void notifyObservers() 
	{
		if (this.isChanged == true)
		{
			for (Eyes e: this.eyes_list)
			{
				e.update(this, "New channel is "+this.getChannel()+", notifying to "+e.getFrom());
			}
			this.clearChanged();
		}
		
	}
	
	void addObserver(Eyes eyes) 
	{
		this.eyes_list.add(eyes);
	}
	
	void deleteObserver(Eyes eyes) 
	{
		this.eyes_list.remove(eyes);
	}
	
	void setNewChannel(int number)
	{
		this.numberChannel = number;
		this.setChanged();
	}
	
	int getChannel() 
	{
		return this.numberChannel;
	}
	
}

class Eyes implements Observer {
	
	private int channel;
	private String from;
	
	Eyes(){}
	
	Eyes(String from) 
	{
		this.channel = 0;
		this.from = from;
	}
	
	@Override
	public void update(Observable tv, Object msg) 
	{
		if (tv instanceof TV) 
		{
			TV tv_aux = (TV) tv;
			this.channel = tv_aux.getChannel();
			System.out.println(msg);
		}
	}
	
	protected String getFrom() {
		return this.from;
	}
}

class Main {
	
	static TV tv;
	
	public static void main(String... args)
	{
		tv = new TV();
		
		tv.addObserver(new Eyes("Marcio"));
		tv.addObserver(new Eyes("Michael"));
		tv.addObserver(new Eyes("Neymar"));
		tv.addObserver(new Eyes("Peter"));
		
		tv.setNewChannel(4);
		tv.notifyObservers();
		
		tv.setNewChannel(10);
		tv.notifyObservers();
		
	}
	
}