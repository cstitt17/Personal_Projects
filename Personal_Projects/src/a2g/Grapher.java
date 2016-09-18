package a2g;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.geom.*;
@SuppressWarnings("serial")
public class Grapher extends JComponent{
	private JFrame tst;
	private Graphics2D outline, line;
	private int x,y;
	public Grapher(int xLE, int yLE) {
		tst = new JFrame();
		//tst.setSize(1000,1000);
		tst.setMaximumSize(getMaximumSize());
		tst.setTitle("Your Graph");
		tst.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tst.setBackground(Color.WHITE);
		x=xLE;
		y=yLE;
	}
	public void GraphEquation() {
		Grapher linComp = new Grapher(x,y);
		tst.add(linComp);
		tst.setVisible(true);
	}
	public void paintComponent(Graphics g) {
		outline = (Graphics2D) g;
		line = (Graphics2D) g;
		int wid = tst.getWidth();
		int ht = tst.getHeight();
		Line2D.Double xAxis = new Line2D.Double(0,ht/2,wid,ht/2);
		Line2D.Double yAxis = new Line2D.Double(wid/2,0,wid/2,ht);
		outline.draw(yAxis);
		outline.draw(xAxis);
	}
}