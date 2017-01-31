package prob004;

public class ThreeDigitPalindrome {

	public static void main(String[] args) {
		for (int x = 100; x < 1000; x++) {
			for (int y=100; y<1000; y++) {
				int z = x*y;
				String zTest = Integer.toString(z);
				for (int c=0; c<zTest.length()/2; c++)
					if (zTest.charAt(c) != zTest.charAt(zTest.length()-c-1))
						continue;
					else
						System.out.println(z);
			}
		}
	}

}
