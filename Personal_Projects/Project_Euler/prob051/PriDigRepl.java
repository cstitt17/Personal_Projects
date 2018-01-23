package prob051;

public class PriDigRepl {
	public static void main(String[] args) {
		for (int i=11; i<=Integer.MAX_VALUE; i++) {
			if (!isPrime(i)) {
				continue;
			}
			
			String str = ""+i;
			for (int l=1; l<=str.length()-1; l++) {
				int comb = nCr(str.length()-1, l);
			}
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
	
	private static int nCr(int n, int r) {
		if (n==r || r==0) {
			return 1;
		}
		
		return (fact(n))/((fact(r))*(fact(n-r)));
	}
	
	private static int fact(int n) {
		if (n==1) {
			return 1;
		}
		
		return n*fact(n-1);
	}
}