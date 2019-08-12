
public class Herbivore extends Animal{

	public Herbivore(double initSize, double initRate, double initNeed) {
		super(initSize, initRate, initNeed);
	}
	public void nibble(Plant meal) {
		
		final double PORTION = 0.5;
		final double MAX_FRACTION = 0.1;
		double amount;
		
		amount = PORTION * meal.getSize();
		if(amount > MAX_FRACTION * getNeed())
			amount = MAX_FRACTION * getNeed();
		if(amount > stillNeed())
			amount = stillNeed();
			
			eat(amount);
			meal.nibbledOn(amount);
			}
	}

