package prob063;

public class PowDigCount {
	public static void main(String[] args) {
		int count = 0;
		int b = 0;
		
		while (true) {
			boolean done = false;
			
			for (int a = 1; a > 0; a++) {
				double exp = Math.pow(a, b);
				
				if (exp > Integer.MAX_VALUE) {
					done = true;
					break;
				}
				
				String str;
				if (!(""+exp).contains("E")) {
					str = ("" + exp).substring(0, ("" + exp).indexOf("."));
				} else {
					str = (""+exp).split("E")[0].substring(0, 1)+(""+exp).split("E")[0].substring(2);
					
					if (str.length()==2 && str.charAt(1)=='0') {
						str = str.substring(0, 1);
					}
					
					int len = Integer.parseInt((""+exp).substring((""+exp).length()-1));
					while (str.length() <= len) {
						str = str + "0";
					}
				}
				
				if (str.length()==b) {
					System.out.println(a+"^"+b+": "+exp);
					count++;
				} else if (str.length() > b) {
					break;
				}
			}
			
			b++;
			if (done) {
				break;
			}
		}
		
		System.out.println(count);
	}
}