package a2g;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.geom.*;
@SuppressWarnings("serial")
public class Grapher extends JComponent{
	private JFrame tst;
	private Graphics2D outline;
	private double x=0,y=0;
	//private String equation="";
	public Grapher(double xLE, double yLE) {
		tst = new JFrame();
		tst.setSize(650,650);
		tst.setTitle("Your Graph");
		tst.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tst.setBackground(Color.WHITE);
		x=xLE;
		y=yLE;
	}
	public Grapher(String eq) {
		//equation = eq;
	}
	public void GraphEquation() {
		Grapher linComp = new Grapher(x,y);
		tst.add(linComp);
		tst.setVisible(true);
	}
	public void paintComponent(Graphics g) {
		outline = (Graphics2D) g;
		Line2D.Double xen10 = new Line2D.Double(0,0,0,600);
		Line2D.Double xen9 = new Line2D.Double(30,0,30,600);
		Line2D.Double xen8 = new Line2D.Double(60,0,60,600);
		Line2D.Double xen7 = new Line2D.Double(90,0,90,600);
		Line2D.Double xen6 = new Line2D.Double(120,0,120,600);
		Line2D.Double xen5 = new Line2D.Double(150,0,150,600);
		Line2D.Double xen4 = new Line2D.Double(180,0,180,600);
		Line2D.Double xen3 = new Line2D.Double(210,0,210,600);
		Line2D.Double xen2 = new Line2D.Double(240,0,240,600);
		Line2D.Double xen1 = new Line2D.Double(270,0,270,600);
		Line2D.Double yAxis = new Line2D.Double(300,0,300,600);
		Line2D.Double xe1 = new Line2D.Double(330,0,330,600);
		Line2D.Double xe2 = new Line2D.Double(360,0,360,600);
		Line2D.Double xe3 = new Line2D.Double(390,0,390,600);
		Line2D.Double xe4 = new Line2D.Double(420,0,420,600);
		Line2D.Double xe5 = new Line2D.Double(450,0,450,600);
		Line2D.Double xe6 = new Line2D.Double(480,0,480,600);
		Line2D.Double xe7 = new Line2D.Double(510,0,510,600);
		Line2D.Double xe8 = new Line2D.Double(540,0,540,600);
		Line2D.Double xe9 = new Line2D.Double(570,0,570,600);
		Line2D.Double xe10 = new Line2D.Double(600,0,600,600);
		
		Line2D.Double yen10 = new Line2D.Double(0,0,600,0);
		Line2D.Double yen9 = new Line2D.Double(0,30,600,30);
		Line2D.Double yen8 = new Line2D.Double(0,60,600,60);
		Line2D.Double yen7 = new Line2D.Double(0,90,600,90);
		Line2D.Double yen6 = new Line2D.Double(0,120,600,120);
		Line2D.Double yen5 = new Line2D.Double(0,150,600,150);
		Line2D.Double yen4 = new Line2D.Double(0,180,600,180);
		Line2D.Double yen3 = new Line2D.Double(0,210,600,210);
		Line2D.Double yen2 = new Line2D.Double(0,240,600,240);
		Line2D.Double yen1 = new Line2D.Double(0,270,600,270);
		Line2D.Double xAxis = new Line2D.Double(0,300,600,300);
		Line2D.Double ye1 = new Line2D.Double(0,330,600,330);
		Line2D.Double ye2 = new Line2D.Double(0,360,600,360);
		Line2D.Double ye3 = new Line2D.Double(0,390,600,390);
		Line2D.Double ye4 = new Line2D.Double(0,420,600,420);
		Line2D.Double ye5 = new Line2D.Double(0,450,600,450);
		Line2D.Double ye6 = new Line2D.Double(0,480,600,480);
		Line2D.Double ye7 = new Line2D.Double(0,510,600,510);
		Line2D.Double ye8 = new Line2D.Double(0,540,600,540);
		Line2D.Double ye9 = new Line2D.Double(0,570,600,570);
		Line2D.Double ye10 = new Line2D.Double(0,600,600,600);
		outline.setColor(Color.BLACK);
		outline.draw(yAxis);
		outline.draw(xAxis);
		outline.setColor(Color.LIGHT_GRAY);
		outline.draw(yen10);
		outline.draw(yen9);
		outline.draw(yen8);
		outline.draw(yen7);
		outline.draw(yen6);
		outline.draw(yen5);
		outline.draw(yen4);
		outline.draw(yen3);
		outline.draw(yen2);
		outline.draw(yen1);
		outline.draw(ye10);
		outline.draw(ye9);
		outline.draw(ye8);
		outline.draw(ye7);
		outline.draw(ye6);
		outline.draw(ye5);
		outline.draw(ye4);
		outline.draw(ye3);
		outline.draw(ye2);
		outline.draw(ye1);
		outline.draw(xen10);
		outline.draw(xen9);
		outline.draw(xen8);
		outline.draw(xen7);
		outline.draw(xen6);
		outline.draw(xen5);
		outline.draw(xen4);
		outline.draw(xen3);
		outline.draw(xen2);
		outline.draw(xen1);
		outline.draw(xe10);
		outline.draw(xe9);
		outline.draw(xe8);
		outline.draw(xe7);
		outline.draw(xe6);
		outline.draw(xe5);
		outline.draw(xe4);
		outline.draw(xe3);
		outline.draw(xe2);
		outline.draw(xe1);
		
		outline.setColor(Color.BLUE);
		Line2D.Double xyLine = new Line2D.Double(300,300,300+30*x,300-30*y);
		outline.draw(xyLine);
	}
}