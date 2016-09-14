package drawtester;
import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;
@SuppressWarnings("serial")

/**
 * A class to test drawing things.
 * @author cstit
 */
public class DrawComponent extends JComponent {
	/**
	 * A method to draw things.
	 * @param g A Graphics object
	 */
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Rectangle box = new Rectangle(5,10,20,30);
		Ellipse2D.Double ell = new Ellipse2D.Double(5,10,20,30);
		Ellipse2D.Double cir = new Ellipse2D.Double(5,10,20,20);
		g2d.draw(box);
		g2d.draw(ell);
		g2d.draw(cir);
	}
}