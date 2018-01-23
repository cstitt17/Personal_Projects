package prob026;

import java.math.BigDecimal;

public class RecipCyc {
	
	public static void main(String[] args) {
		int max = 0, dMax = 0;
		
		for (int d=999; d<1000; d++) {
			if (d%3!=0 && (d%2==0 || d%5==0)) {
				System.out.println(d+": "+0);
				continue;
			}
			
			String decimal = (new BigDecimal((1.0/d))).toString().substring(2);
			int len = -1, p=1;
			
			while (len==-1) {
				try {
					String left = decimal.substring(0, p);
					String right = decimal.substring(p, p + left.length());
					if (left.equals(right)) {
						len = p;
					}
					p++;
				} catch (Exception e) {
					decimal = decimal.substring(1);
					p=1;
				}
			}
			
			if (len > max) {
				max = len;
				dMax = d;
			}
			
			System.out.println(d+": "+len);
		}
		
		System.out.println(dMax + ": " + max);
	}
}