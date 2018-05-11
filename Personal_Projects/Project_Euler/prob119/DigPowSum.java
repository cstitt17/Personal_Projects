package prob119;

public class DigPowSum {

	public static void main(String[] args) {
		int count = 1;
		for (long i=10; i<Long.MAX_VALUE; i++) {
			long j = i, sum = 0;
			while (j > 0) {
				sum += j%10;
				j /= 10;
			}
			if (sum > 1 && isPow(i,sum)) {
				System.out.println("a"+(count++)+" = "+sum+" --> "+i);
			}
			
			if (count == 17) {
				break;
			}
		}
		
		//3122.3x6 - 149051x5 + 3E+06x4 - 2E+07x3 + 1E+08x2 - 2E+08x + 1E+08
		int x = 30;
		double approx = (((((3122.3*x-149051)*x+3*Math.pow(10, 6))*x-2*Math.pow(10, 7))*x+Math.pow(10, 8))*x-2*Math.pow(10,8))*x+Math.pow(10, 8);
		System.out.println(approx);
	}
	
	private static boolean isPow(long exp, long base) {
		if (base <= 1 || exp%base != 0) {
			return false;
		}
		long orig = base;
		while (true) {
			if (base == exp) {
				return true;
			} else if (base > exp) {
				return false;
			} else {
				base *= orig;
			}
		}
	}
}