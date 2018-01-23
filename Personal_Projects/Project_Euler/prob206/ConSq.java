package prob206;

import java.util.ArrayList;

public class ConSq {
	public static void main(String[] args) {
		String square = "1_2_3_4_5_6_7_8_9_0";
		ArrayList<Double> digits;
		
		for (int n = 1058921220; n <= 1389026624; n+=10) {
			boolean done = false;
			digits = new ArrayList<>();
			digits.add((double) n);
			digits = toDigits(digits);
			
			for (int i=0; i<digits.size(); i++) {
				digits.set(i, digits.get(i)*n);
			}
			
			digits = toDigits(digits);
			
			ArrayList<Integer> digs = new ArrayList<>();
			
			for (double digit : digits) {
				digs.add((int) Math.round(digit));
			}
			
			if (digs.size() == square.length()) {
				if (digs.get(0)==0 && digs.get(2)==9 && digs.get(4)==8 && digs.get(6)==7 && digs.get(8)==6 &&
					digs.get(10)==5 && digs.get(12)==4 && digs.get(14)==3 && digs.get(16)==2 && digs.get(18)==1) {
					done = true;
				}
			}
			
			String str = "";
			for (int digit : digs) {
				str = digit + str;
			}
			
			System.out.println(n + ": " + str);
			
			if (done) {
				break;
			}
		}
	}
	
	private static ArrayList<Double> toDigits(ArrayList<Double> nums) {
		for (int i=0; i<nums.size(); i++) {
			while (nums.get(i) >= 10) {
				if (i==nums.size()-1) {
					nums.add(1d);
				} else {
					nums.set(i+1, nums.get(i+1)+1);
				}
				nums.set(i, nums.get(i)-10);
			}
		}
		
		return nums;
	}
}