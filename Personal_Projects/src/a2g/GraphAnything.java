package a2g;
import java.util.Scanner;
public class GraphAnything {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner eqtype = new Scanner(System.in);
		String eqFull = eqtype.nextLine();
		Grapher eqGraph = new Grapher(eqFull);
		eqGraph.GraphEquation();
	}
}