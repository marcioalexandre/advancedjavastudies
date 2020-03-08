interface ExistingClassInterface 
{
	 String getSentence();
}


class ExistingClass implements ExistingClassInterface 
{
	@Override
	public String getSentence()
	{
		return "A";
	}

}


interface AdapterInterface 
{
	String getSentence();

}


class AdapterClass implements AdapterInterface 
{
	ExistingClassInterface a = null;
	
	AdapterClass (){ }
	
	AdapterClass (ExistingClassInterface a)
	{
		this.a = a;
	}

	@Override
	public String getSentence() 
	{
		return this.getNewSentence();
	}

	private String getNewSentence() 
	{
		return a.getSentence()+" & B";
	}
}



class Main 
{
	public static void main(String[] args) 
	{

		ExistingClassInterface existingClass = new ExistingClass();
		AdapterInterface existingClassAdapter = new AdapterClass(existingClass);

		System.out.println(existingClass.getSentence()); //A
		System.out.println(existingClassAdapter.getSentence()); //A & B

	}
}