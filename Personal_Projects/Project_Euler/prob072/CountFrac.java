package prob072;

public class CountFrac {
	public static void main(String[] args) {
		int count = 0;
		for (int d = 2; d <= 1000000; d++) {
			count++;
			for (int n = 2; n < d; n++) {
				if (gcd(d,n) == 1) {
					count++;
				}
			}
			System.out.println(d + ": " + count);
		}
		
		System.out.println("\n"+count);
	}
	
	private static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a%b);
		}
	}
}