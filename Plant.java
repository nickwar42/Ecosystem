public class Plant extends Organism
{ 

   public Plant(double initSize, double initRate)
   {
      super(initSize, initRate);
   }
   
   public void nibbledOn(double amount)
   {
      if (amount < 0)
         throw new IllegalArgumentException("amount is negative");
      if (amount > getSize( ))
         throw new IllegalArgumentException("amount is more than size");
      alterSize(-amount);
   }
}
	
	
