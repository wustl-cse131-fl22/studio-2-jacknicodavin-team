package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("How much money do you start with?");
		double startAmount = in.nextDouble();
		System.out.println("Whats your win chance?");
		double winChance = in.nextDouble();
		System.out.println("Whats your win limit?");
		double winLimit = in.nextDouble();
		System.out.println("How many days are you going to gamble?");
		int totalSimulations = in.nextInt();
		
		
		double todaysTotal = startAmount;
		System.out.println(todaysTotal);
		int timesPlayed=0;
		int i = 0;
		int losses = 0;
		int wins = 0;
		double expectedRuin = 0;
		double x = (1-winChance)/winChance;
		if(winChance == .5) {
			expectedRuin = 1 - (startAmount/winLimit);
			
		}else {
			expectedRuin = ((Math.pow(x, startAmount))-(Math.pow(x, winLimit)))/(1-(Math.pow(x, winLimit)));
		}
		while (i < totalSimulations) {
			timesPlayed = 0;
			while (todaysTotal > 0 && todaysTotal< winLimit) {
				
				if(Math.random()>winChance) {
					todaysTotal--;
				
				}else {
					todaysTotal++;
				}
				timesPlayed++;
				
		}
		
		if(todaysTotal == 0) {
			System.out.println("Simulation" + i + ": " + timesPlayed + " LOSE");
			
			losses ++;
		}else {
			System.out.println("Simulation" + i + ": " + timesPlayed + " WIN");
			wins ++;
		}
		/*System.out.println(todaysTotal);
		System.out.println(timesPlayed + " times played today");
		*/
		i++;
		todaysTotal = startAmount;
	}
		System.out.println("Losses: "+ losses + " Simulations: "+totalSimulations);
		System.out.println("Your expected ruin rate is: "+ expectedRuin);
	}
}
