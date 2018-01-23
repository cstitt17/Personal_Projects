package prob066;

import java.util.ArrayList;

public class DioEq { //x^2 - D*y^2 = 1
	public static void main(String[] args) {
		int square = 1;
		int nextDiff = 3;
		ArrayList<Integer> dVals = new ArrayList<>();
		ArrayList<Integer> squares = new ArrayList<>();
		
		for (int i=1; i<=1000; i++) {
			if (i==square) {
				squares.add(square);
				System.out.println("Added to squares: "+square);
				square = square + nextDiff;
				nextDiff = nextDiff + 2;
			} else {
				dVals.add(i);
			}
		}
		
		while (square + nextDiff > 0) {
			squares.add(square);
			System.out.println("Added to squares: "+square);
			square = square + nextDiff;
			nextDiff = nextDiff + 2;
		}
		
		int max = 0;
		int d = 0;
		
		for (int dVal : dVals) {
			for (int x=1; x<=Integer.MAX_VALUE; x++) {
				int y2 = ((x*x)-1)/dVal;
				int r = ((x*x)-1)%dVal;
				if (r==0 && squares.contains(y2)) {
					if (x>max) {
						max = x;
						d = dVal;
					}
					System.out.println(dVal + ": " + x);
					break;
				}
			}
		}
		
		System.out.println("MAX -- "+d+": "+max);
	}
}