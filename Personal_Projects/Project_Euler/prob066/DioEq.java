package prob066;

import java.util.ArrayList;

public class DioEq { //x^2 - D*y^2 = 1
	public static void main(String[] args) {
		ArrayList<Long> big = new ArrayList<>();
		
		long sqd = 1, od = 3, maxd = Long.MIN_VALUE, maxx = Long.MIN_VALUE;
		for (long d = 1; d <= 1000; d++) {
			if (d == sqd) {
				sqd += od;
				od += 2;
				continue;
			}
			
			for (long x = 2; x < Long.MAX_VALUE; x++) {
				if (x*x < 0) {
					System.out.println("Too big at "+d);
					big.add(d);
					break;
				}
				
				if ((x*x - 1)%d == 0) {
					long sq = (x*x - 1)/d;
					long rt = Math.round(Math.sqrt(sq));
					if (rt*rt == sq) {
						System.out.println(x+"^2 - "+d+" * "+rt+"^2 = 1");
						if (x > maxx) {
							maxx = x;
							maxd = d;
						}
						break;
					}
				}
			}
		}
		
		System.out.println("Xmax of "+maxx+" is at Dmax of "+maxd);
		System.out.println(big.toString());
	}
}