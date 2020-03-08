class A 
{
  private static A a = null;
  private A() {  }
  public static A getInstance()
  {
   if (a == null) a = new A();
   return a;
  }
  protected void write (String msg) 
  {
    System.out.println("Single instance, by "+msg);
  }
}

class Main 
{
  public static void main(String... args)
  {
    A x = A.getInstance();
    A y = A.getInstance();
    x.write("x"); //Single instance, by x
    y.write("y"); //Single instance, by y
  }
}