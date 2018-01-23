package prob160;

import java.util.ArrayList;

public class FacTrailDig {
	public static void main(String[] args) {
		ArrayList<Long> digits = new ArrayList<>();
		digits.add(1l);
		
		for (long f = 1; f<=1000000000000l; f++) {
			for (int i=0; i<digits.size(); i++) {
				digits.set(i, digits.get(i)*f);
			}
			
			for (int j=0; j<digits.size(); j++) {
				while (digits.get(j) >= 10) {
					digits.set(j, digits.get(j)-10);
					if (j!=digits.size()-1) {
						digits.set(j+1, digits.get(j+1)+1);
					} else {
						digits.add(1l);
					}
				}
			}
			
			while (digits.get(0)==0) {
				digits.remove(0);
			}
			
			while (digits.size()>5) {
				digits.remove(5);
			}
			
			String res = "";
			for (int k = digits.size()-1; k >= 0; k--) {
				res = res + digits.get(k);
			}
			
			System.out.println("f("+f+") = "+res);
		}
	}
}