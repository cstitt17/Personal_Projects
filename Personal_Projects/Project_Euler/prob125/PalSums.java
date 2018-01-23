package prob125;

public class PalSums {
	public static void main(String[] args) {
		double sum = 0;
		
		for (int n=2; n<100000000; n++) {
			if (!isPalindrome(n)) {
				continue;
			}
			
			boolean sumPres = false;
			
			for (int s = 1; s < n; s++) {
				int sqs = 0;
				boolean squareSum = true;
				int count = 0;
				
				for (int i = s; i <= n; i++) {
					sqs = sqs + i * i;
					count++;
					
					if (sqs > n) {
						squareSum = false;
					}

					if (sqs >= n && count > 1) {
						break;
					}
				}
				
				if (squareSum) {
					sumPres = true;
					break;
				}
			}
			
			if (sumPres) {
				System.out.println(sum + " + " + n + " = " + (sum+n));
				sum = sum + n;
			}
		}
	}
	
	private static boolean isPalindrome(int n) {
		String str = ""+n;
		
		for (int i=0; i<str.length()/2; i++) {
			if (str.charAt(i) != str.charAt(str.length()-(i+1))) {
				return false;
			}
		}
		
		return true;
	}
}