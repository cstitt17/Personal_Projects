package prob030;

public class Dig5Pow {
	public static void main(String[] args) {
		double sum = 0;
		for (int i=2; i<=Integer.MAX_VALUE; i++) {
			int total = 0;
			String str = ""+i;
			for (int j=0; j<str.length(); j++) {
				total = total + (int) Math.pow(Integer.parseInt(str.substring(j, j+1)),5);
				if (total > i || total < 0) {
					break;
				} else if (total==i) {
					sum = sum + total;
					System.out.println("Added: "+total);
					break;
				}
			}
		}
		System.out.println(sum);
	}
}