package prob003;

public class MaxPrimeFactor {
	public static void main(String[] args) {
		long max = -1;
		for (long i=2; i<600851475143L; i++)
			if (600851475143L%i==0 && isPrime(i) && i > max)
				max = i;
		System.out.println(max);
	}
	
	public static boolean isPrime(long i) {
		for (long x=2; x<i; x++)
			if (i%x==0)
				return false;
		return true;
	}
}