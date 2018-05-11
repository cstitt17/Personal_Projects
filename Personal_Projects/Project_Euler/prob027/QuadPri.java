package prob027;

import java.util.ArrayList;

public class QuadPri {

	public static void main(String[] args) {
		ArrayList<Long> pri = new ArrayList<>();
		pri.add(2l);
		pri.add(3l);
		long[] max = {0,0,Integer.MIN_VALUE};
		for (int b = 2; b < 1000; b+=2) {
			for (int a = 2-b; a < 1000; a++) {
				
			}
			
			if (b == 2) {
				b--;
			}
		}
	}
	
	private static boolean isPri(long pc) {
		if (pc == 2) {
			return true;
		}
		
		for (long i = 2; i <= Math.round(Math.ceil(Math.sqrt(pc))); i+=2) {
			if (pc%i == 0) {
				return false;
			}
			
			if (i == 2) {
				i--;
			}
		}
		
		return true;
	}
}