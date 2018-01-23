package prob134;

public class PriPairConn {
	public static void main(String[] args) {
		double sum = 0;
		
		for (int p1 = 5; p1 <= 1000000; p1+=2) {
			if (!isPrime(p1)) {
				continue;
			}
			
			int p2 = nextPrime(p1);
			int s = 0;
			
			while (Double.parseDouble(s+""+p1)%p2 != 0) {
				s++;
			}
			
			sum = sum + Double.parseDouble(s+""+p1);
			System.out.println("("+p1+","+p2+") -- "+s+""+p1+" -- "+sum);
		}
	}
	
	private static boolean isPrime(int i) {
		if (i==1) {
			return false;
		}
		
		for (int x=2; x<i; x++)
			if (i%x==0)
				return false;
		return true;
	}
	
	private static int nextPrime(int p) {
		for (int n=p+1; n>0; n++) {
			if (isPrime(n)) {
				return n;
			}
		}
		
		return -1;
	}
}