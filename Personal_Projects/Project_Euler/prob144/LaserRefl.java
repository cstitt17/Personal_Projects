package prob144;

public class LaserRefl {

	public static void main(String[] args) {
		double xS = 0, yS = 10.1, xB = 1.4, yB = -9.6;
		int n = 0;
		while ((Math.abs(xB-0.01)>0.001)&&(Math.abs(yB-10)>0.001)) {
			n++;
			System.out.println("Bounce number "+n+" from ("+xS+","+yS+") to ("+xB+","+yB+")");
			double theta = Math.atan(-4*xB/yB);
			double mB = Math.tan(Math.PI + 2*theta - Math.atan((yS-yB)/(xS-xB)));
			double alpha = yB - mB*xB;
			double cts = (alpha*mB)/(mB*mB+4);
			
			double xP = cts + Math.sqrt(100 - alpha*alpha + cts*cts), xN = cts - Math.sqrt(100 - alpha*alpha + cts*cts);
			double[] y = new double[] {Math.sqrt(100 - 4*xP*xP), -1*Math.sqrt(100 - 4*xP*xP), Math.sqrt(100 - 4*xN*xN), -1*Math.sqrt(100 - 4*xN*xN)};
			double[] yX = new double[] {mB*(xP-xB)+yB, mB*(xN-xB)+yB};
			int[] minDiffs = new int[] {-1, -1};
			double diff = Double.MAX_VALUE;
			
			for (int i=0; i<y.length; i++) {
				for (int j=0; j<yX.length; j++) {
					if (y[i] == Double.NaN) {
						break;
					}
					
					double d = Math.abs(y[i]-yX[j]);
					if (d < diff) {
						diff = d;
						minDiffs[0] = i;
						minDiffs[1] = j;
					}
				}
			}
			
			xS = xB;
			yS = yB;
			yB = y[minDiffs[0]];
			xB = minDiffs[1]==0?xP:xN;
		}
		
		System.out.println("Bounced out after "+n+" bounces.");
	}

}
