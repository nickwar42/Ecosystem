public class Animal extends Organism{

	private double needEachDay;
	private double eatenToday;
	
	public Animal(double initSize, double initRate, double initNeed) {
		super(initSize, initRate);
		if(initNeed < 0)
			throw new IllegalArgumentException("negative need"); 
		needEachDay = initNeed;
		//eatenToday will be given its default value of zero.
	}
	public void assignNeed(double newNeed) {
		needEachDay = newNeed;
	}
	public void eat(double amount) {
		eatenToday = amount + eatenToday;
	}
	public double getNeed() {
		return needEachDay;
	}
	public double stillNeed() {
		if(eatenToday >= needEachDay)
			return 0;
		else
			return needEachDay - eatenToday;
	}
	public void simulateDay() {
		super.simulateDay();
		if(eatenToday < needEachDay) {
			expire();
			eatenToday = 0;
		}
	}

}
