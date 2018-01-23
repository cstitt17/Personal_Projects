package prob057;

public class SqRootConv {
	public static void main(String[] args) {
		int count = 0;
		
		for (int i=1; i<=1000; i++) {
			String frac = "1+1/2";
			for (int j=1; j<i; j++) {
				frac = frac.substring(0, frac.lastIndexOf("2")) + "(2+1/2)" + frac.substring(frac.lastIndexOf("2")+1);
			}
			
			int open = frac.lastIndexOf("(");
			while (open!=-1) {
				int close = frac.indexOf(")");
				frac = frac.substring(0, open+1) + toMixed(frac.substring(open+1,close)) + frac.substring(close);
				
				close = frac.indexOf(")");
				int flip = frac.lastIndexOf("1/(");
				frac = frac.substring(0, flip) + flipFrac(frac.substring(flip, close+1)) + frac.substring(close+1);
				open = frac.lastIndexOf("(");
			}
			
			frac = toMixed(frac);
			String[] parts = frac.split("/");
			if (parts[0].length() > parts[1].length()) {
				count++;
			}
			System.out.println(i+": "+frac);
		}
		
		System.out.println(count);
	}
	
	private static String toMixed(String partial) {
		String[] parts = partial.split("\\+");
		int[] nums = {Integer.parseInt(parts[0]),Integer.parseInt(parts[1].split("/")[0]),Integer.parseInt(parts[1].split("/")[1])};
		int numer = nums[0]*nums[2]+nums[1];
		for (int i=nums[2]; i>=2; i--) {
			if (numer%i==0 && nums[2]%i==0) {
				numer = numer/i;
				nums[2] = nums[2]/i;
			}
		}
		
		return numer+"/"+nums[2];
	}
	
	private static String flipFrac(String frac) {
		String norm = frac.substring(frac.indexOf("(")+1, frac.indexOf(")"));
		return norm.split("/")[1]+"/"+norm.split("/")[0];
	}
}