package prob063;

public class PowDigCount {
	public static void main(String[] args) {
		long count = 0, pow;
		for (int exp = 1; exp < 30; exp++) {
			for (int base = 1; base < 10; base++) {
				pow = power(base,exp);
				if (pow < 0) {
					break;
				} else if ((""+pow).length()>exp) {
					break;
				} else if ((""+pow).length()==exp) {
					count++;
				}
				
				System.out.println(base+"^"+exp+": "+pow+" -- count = "+count);
			}
		}
	}
	
	private static long power(int base, int exp) {
		if (exp == 0) {
			return 1;
		} else {
			return base*power(base,exp-1);
		}
	}
}