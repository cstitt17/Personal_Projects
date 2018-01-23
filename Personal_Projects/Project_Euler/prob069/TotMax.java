package prob069;

public class TotMax {
	public static void main(String[] args) {
		double maxQ = 0;
		int maxN = 0;
		
		for (int n = 2; n <= 10; n++) {
			double q = n/phi(n);
			System.out.println(n+": "+q);
			
			if (q>maxQ) {
				maxQ = q;
				maxN = n;
			}
		}
		
		System.out.println("Max -- "+maxN+": "+maxQ);
	}
	
	private static double phi(int n) {
		int count = 1;
		
		for (int i=2; i<n; i++) {
			for (int x=2; x<(n/2)+1; x++) {
				if (n%x!=i%x) {
					count++;
					break;
				}
			}
		}
		
		return count;
	}
}