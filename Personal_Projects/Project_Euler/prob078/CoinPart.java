package prob078;

public class CoinPart {

	public static void main(String[] args) {
		for (int n = 111; n < Integer.MAX_VALUE; n++) {
			long val = f2(n, n);
			System.out.println(n+": "+val);
			if (val % 1000000 == 0) {
				break;
			}
		}
	}
	
	private static long f2(int n, int k) {
		if (n<0 || k<1) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			return f2(n, k-1) + f2(n-k,k);
		}
	}
}