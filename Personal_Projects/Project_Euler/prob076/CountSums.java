package prob076;

import java.util.ArrayList;

public class CountSums {
	public static void main(String[] args) {
		ArrayList<String> sums = new ArrayList<>();
		double limit = 100;
		int count = 0;
		
		for (int i=((int) limit)-1; i>=((int) Math.ceil(limit/2)); i--) {
			sums.add(i+"+"+(((int) limit) - i));
			count++;
			System.out.println(i+"+"+(((int) limit) - i));
			ArrayList<String> eqs = recurSums(i+"+"+(((int) limit) - i));
			
			for (String eq : eqs) {
				eq = sortEq(eq);
				if (!sums.contains(eq)) {
					sums.add(eq);
					count++;
					System.out.println(eq);
				}
			}
		}
		
		System.out.println(count);
	}
	
	private static ArrayList<String> recurSums(String eq) {
		String[] terms = eq.split("\\+"); // Insert "\\" because it is a reserved character
		ArrayList<String> eqs = new ArrayList<>();
		
		for (int i=0; i<terms.length; i++) {
			int num = Integer.parseInt(terms[i]);
			if (num==1) {
				continue;
			}
			
			String sum = ""+(num-1);
			for (int j=0; j<terms.length; j++) {
				if (j<i) {
					sum = terms[j] + "+" + sum;
				} else if (j>i) {
					sum = sum + "+" + terms[j];
				}
			}
			sum = sum + "+1";
			eqs.add(sum);
			eqs.addAll(recurSums(sum));
		}
		
		return eqs;
	}
	
	private static String sortEq(String eq) {
		String[] nums = eq.split("\\+");
		ArrayList<Integer> sort = new ArrayList<>();
		
		for (int i=0; i<nums.length; i++) {
			sort.add(Integer.parseInt(nums[i]));
		}
		
		sort.sort(null);
		String res = "";
		for (int i=sort.size()-1; i>=0; i--) {
			res = res + sort.get(i) + "+";
		}
		
		return res.substring(0,res.length()-1);
	}
}