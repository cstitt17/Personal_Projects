package prob057;

import java.util.Arrays;

public class SqRootConv {
	public static void main(String[] args) {
		int[] num = {1}, den = {1}, t;
		int count = 0;
		
		for (int i = 1; i <= 1000; i++) {
			t = Arrays.copyOf(num, num.length);
			int len = (num.length<=den.length?num.length:den.length);
			for (int j = 0; j < len; j++) {
				num[j+num.length-len] += 2*den[j+den.length-len];
				den[j+den.length-len] += t[j+num.length-len];
			}
			
			num = toDig(num);
			den = toDig(den);
			
			if (num.length > den.length) {
				count++;
			}
			System.out.println(i+": "+count/*+" -- "+Arrays.toString(num)+"/"+Arrays.toString(den)*/);
		}
	}
	
	private static int[] toDig(int[] num) {
		if (num.length == 1 && num[0]>9) {
			return (new int[] {num[0]/10, num[0]%10});
		}
		
		for (int j = num.length-1; j >= 0; j--) {
			if (num[j]>9) {
				if (j == 0) {
					num = shift(num);
					j++;
				}
				num[j-1] += num[j]/10;
				num[j]%=10;
			}
		}
		
		return num;
	}
	
	private static int[] shift(int[] num) {
		int[] res = new int[num.length+1];
		for (int i = 0; i < res.length; i++) {
			if (i==0) {
				res[i] = 0;
			} else {
				res[i] = num[i-1];
			}
		}
		return res;
	}
}