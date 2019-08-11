public class Organism {

double size;
double rate;

	public Organism(double initSize, double initRate){
		size = initSize;
		rate = initRate;
		}
	
	public void alterSize(double amount) {
		size += amount;
	}
	
	public void expire() {
		size = 0;
		rate = 0;
	}
	public double getRate() {
		return this.rate;
	}
	public double getSize() {
		return this.size;
	}
	
	public boolean isAlive() {
		if(size > 0) {
			return true;
		}
		return false;
	}
	
	public void setRate(double newRate) {
		if(size == 0) {
			newRate = 0;
		}
		rate = newRate;
	}
	
	public void simulateDay() {
		size = rate + size;
		if(size <= 0) {
			expire();
		}
	}
}
