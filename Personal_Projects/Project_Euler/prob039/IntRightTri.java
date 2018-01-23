package prob039;

import java.util.ArrayList;

public class IntRightTri {
	public static void main(String[] args) {
		int max = 0;
		int size = 0;
		for (int p=1; p<=1000; p++) {
			ArrayList<Integer> triples = new ArrayList<>();
			boolean doneMS = false, doneJO = false;
			int i = 1, o = 3, n = 1;
			
			while(!doneMS) {
				int a = o;
				int b = i*o + i;
				int c = b+1;
				
				if (a+b+c!=p) {
					doneMS=true;
				} else {
					i++;
					o+=2;
				}
			}
		}
	}
}