package game;

import processing.core.PApplet;
import processing.core.PImage;

public class ChessGUI extends PApplet{
	private ChessGame game;
	
	public void setup() {
		size(730,730); //728 = 8 * 91
		PImage background = loadImage("../../images/b4.png");
		image(background, 0, 0);
		
		game = new ChessGame();
	}
	
	public void draw() {
		PImage background = loadImage("../../images/b4.png");
		image(background, 0, 0);
		image(loadImage("../../images/blackrookwhite.PNG"), 0, 0);
	}
}