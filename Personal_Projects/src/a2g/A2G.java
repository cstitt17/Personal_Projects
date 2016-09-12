package a2g;
import java.util.Scanner;
import java.lang.Math;
/**
 *
 * @author cstit
 */
public class A2G {
    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        System.out.println("What is the degrees measurement of the reference angle?");
        Scanner deg = new Scanner(System.in);
        double angle = deg.nextDouble();
        angle*=((Math.PI)/180);
        System.out.println("What is the total distance or hypotenuse of the triangle?");
        Scanner cval = new Scanner(System.in);
        double dist = cval.nextDouble();
        double cosa = Math.cos(angle);
        double sina = Math.sin(angle);
        double x = cosa*dist;
        double y = sina*dist;
        System.out.println("What roman-numeric quadrant of the graph?");
        Scanner area = new Scanner(System.in);
        String quad = area.nextLine();
        switch (quad) {
            case "I":
                System.out.println("About"+x+"units right and "+y+"units up.");
                break;
            case "II":
                System.out.println("About"+x+"units left and "+y+"units up.");
                break;
            case "III":
                System.out.println("About"+x+"units left and "+y+"units down.");
                break;
            case "IV":
                System.out.println("About"+x+"units right and "+y+"units down.");
                break;
            default:
                System.out.println("Not a valid quadrant.");
                break;
        }
    }
}