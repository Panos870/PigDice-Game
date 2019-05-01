import java.util.Scanner;
 
public interface Strategy {
 
	Move choose(Player player);
 
	static final Scanner str = new Scanner(System.in);
	static final Dice die = new Dice(2);
	static final int ROOF = 75;
	static final int FLOOR = 20;
	static final int BASEMENT = 10;
 

	//Determine whether to roll or hold based on the strategy for this player.
	public static final Strategy[] STRATEGIES = {
 
		//Strategy 0 is a user-defined strategy
		player -> {
			System.out.println("   Your turn points are " + player.getTurnPoints() + ". Your total is " + player.getPoints() + ". ");
			System.out.println("   The max points any player currently has is " + player.getMax() + ". (H)old or (R)oll?");
			System.out.println("   Enter 'h' to hold and 'r' to roll. ");
			while(true) {
				String input = null;
				if(str.hasNextLine()) {
					input = str.nextLine();
				}
				if(input.contains("r")) {
					return Move.ROLL;
				}
				else if(input.contains("h")) {
					return Move.HOLD;
				}
				else {
					System.out.println("  Enter an h or an r. \n");
					System.out.println(input);
				}
			}
		},
 
		
	};
 
}