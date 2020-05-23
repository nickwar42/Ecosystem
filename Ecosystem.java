import java.util.Vector;

public class Ecosystem {
	//Fish count
	private static final int INIT_FISH = 500;

	//Weed count
	private static final int MANY_WEEDS = 2000;
	
	private static final double WEED_SIZE = 15;
	private static final double WEED_RATE = 2.5;
	private static final double FISH_SIZE = 50;
	private static final double FRACTION = 0.5;
	private static final int AVERAGE_NIBBLES = 30;
	private static final double BIRTH_RATE = 0.05;
	private static final int MANY_DAYS = 31;
	
	
	public static void main (String[] args) {		
	
		//Organism blob = new Organism(100,50); //Making a blob
		
		//Animal cat = new Animal(160, 0, 30); //Making a cat
		
		Vector<Herbivore> fish = new Vector<Herbivore>(INIT_FISH); //Making a splish splash mother fricker
		Vector<Plant> weeds = new Vector<Plant>(MANY_WEEDS); //Making a seaweed plant.
				
		//Adding fish to pond.
		for(int i = 0; i < INIT_FISH; i++) {
			fish.addElement(new Herbivore(FISH_SIZE, 0 , FISH_SIZE * FRACTION));
		}
		//Adding weeds to pond.
		for(int i = 0; i< MANY_WEEDS; i++) {
			weeds.addElement(new Plant(WEED_SIZE, WEED_RATE));
		}
		
		//Printing all this garb
		System.out.println("Pond initialized. Simulating a month.");
		System.out.println("------------------------------");
		System.out.println("Day \tNumber \t Plant Mass");
		System.out.println("     \tof     \t(in ounces)");
		System.out.println("      \tFish");
		System.out.println("------------------------------");
		
		//Printing data
	for(int i = 1; i <= MANY_DAYS; i++) {
		pondWeek(fish, weeds);
		System.out.print(i + "\t");
		System.out.print(fish.size() + "\t");
		System.out.print((int) totalMass(weeds) + "\n");
		}
	}
	

	private static double totalMass(Vector<? extends Organism>organisms) {
		double answer = 0;
		for(Organism next : organisms) {
			if(next != null)
				answer += next.getSize();
		}
		return answer;
	}
	
	private static void pondWeek(Vector<Herbivore> fish, Vector<Plant> weeds) {
		int i;
		int manyIterations;
		int index;
		Herbivore nextFish;
		Plant nextWeed;
		
		manyIterations = AVERAGE_NIBBLES * fish.size();
		for(i = 0; i<manyIterations; i++) {
			index = (int) (Math.random() * fish.size());
			nextFish = fish.elementAt(index);
			index = (int) (Math.random() * weeds.size());
			nextWeed = weeds.elementAt(index);
			nextFish.nibble(nextWeed);
		}
		
		//Simulate the day for the fish:
		i = 0;
		while(i < fish.size()) {
			nextFish = fish.elementAt(i);
			nextFish.simulateDay();
			if(nextFish.isAlive())
				i++;
			else
				fish.removeElementAt(i);
		}
		
		//Simulate the day for the weeds
		for(i = 0; i <weeds.size(); i++) {
			nextWeed = weeds.elementAt(i);
			nextWeed.simulateDay();
		}
		
		//Create new fish
		manyIterations = (int) (BIRTH_RATE * fish.size());
		for(i = 0; i < manyIterations; i++)
			fish.addElement(new Herbivore(FISH_SIZE, 0, FISH_SIZE * FRACTION));
	}
}
