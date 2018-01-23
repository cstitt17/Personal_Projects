package prob028;

public class NumSpiDiag {
	public static void main(String[] args) {
		int[][] square = new int[1001][1001];
		
		square[500][500]=1;
		int ind=1, size=1, r=500, c=500, change=0, side=1;
		
		while (r!=0 && c!=1000) {
			if (ind == size*size) {
				c++;
				size+=2;
				ind++;
			}
			
			square[r][c] = ind;
			System.out.println("Added "+ind+" at ("+r+","+c+").");
			ind++;
			
			change++;
			
			if (change == size-1) {
				change=0;
				side++;
				if (side==4) {
					side=0;
				}
			}
			
			if (side==1) {
				r++;
			} else if (side==2) {
				c--;
			} else if (side==3) {
				r--;
			} else if (side==0) {
				c++;
			}
		}
		
		double sum = 1;
		
		for (int row = 0; row<square.length; row++) {
			if (square[row][row] != 1) {
				sum = sum + square[row][row];
				System.out.println("Added ("+row+","+row+") to sum.");
			}
			
			if (square[row][1000-row] != 1) {
				sum = sum + square[row][1000-row];
				System.out.println("Added ("+row+","+(1000-row)+") to sum.");
			}
		}
		
		System.out.println(sum);
	}
}