package prob043;

public class SubDiv {
	public static void main(String[] args) {
		double sum = 0;
		
		for (double i = 0123456789d; i <= 9876543210d; i++) {
			String str = ""+i;
			if (str.contains("E")) {
				str = str.substring(0, str.indexOf(".")) + str.substring(str.indexOf(".")+1, str.indexOf("E"));
			} else {
				str = str.substring(0, str.indexOf("."));
			}
			if (str.length()==9) {
				if (i<1000000000) {
					str = "0"+str;
				} else {
					str = str+"0";
				}
			}
			
			if (isNPandigital(str,9)) {
				if (Integer.parseInt(str.substring(7, 10))%17==0) {
					if (Integer.parseInt(str.substring(6, 9))%13==0) {
						if (Integer.parseInt(str.substring(5, 8))%11==0) {
							if (Integer.parseInt(str.substring(4, 7))%7==0) {
								if (Integer.parseInt(str.substring(3, 6))%5==0) {
									if (Integer.parseInt(str.substring(2, 5))%3==0) {
										if (Integer.parseInt(str.substring(1, 4))%2==0) {
											sum = sum + i;
											System.out.println("Added: "+i);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println(sum);
	}
	
	private static boolean isNPandigital(String str, int n) {
		if (str.length()!=n+1) {
			return false;
		}
		
		for (int i=0; i<=n; i++) {
			if (!(str.contains(""+i) && str.indexOf(""+i)==str.lastIndexOf(""+i))) {
				return false;
			}
		}
		
		return true;
	}
}