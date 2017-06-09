package game;

import processing.core.PApplet;
import processing.core.PImage;
//1=49, a=97
public class ChessGUI extends PApplet{
	private ChessGame game;
	private String move;
	private boolean isWhiteTurn;
	
	public void setup() {
		size(730,730); //728 = 8 * 91
		PImage background = loadImage("../../images/b4.png");
		image(background, 0, 0);
		
		game = new ChessGame();
		isWhiteTurn = true;
	}
	
	public void draw() {
		PImage background = loadImage("../../images/b4.png");
		image(background, 0, 0);
		
		String pieceTitle = "";
		
		for (ChessPiece piece : game.getChessBoard().getBoard()) {
			pieceTitle = "";
			
			if (piece.getIsWhite())
				pieceTitle += "white";
			else
				pieceTitle += "black";
			
			pieceTitle += piece.getType();
			
			int back = (((int) piece.getLocation().charAt(0))-96) + (((int) piece.getLocation().charAt(1))-48);
			if (back % 2 == 0)
				pieceTitle += "black";
			else
				pieceTitle += "white";
			
			image(loadImage("../../images/"+pieceTitle+".PNG"),(((int) piece.getLocation().charAt(0))-97)*91,(56-((int) piece.getLocation().charAt(1)))*91);
		}
	}
	
	public void keyPressed() {
		if (move.length() == 5) {
			preformMove(move);
			move = "";
		}
		
		move += (char) keyCode;
	}
	
	private void preformMove(String moveToMake) {
		if (isWhiteTurn)
			if (game.canCastle(isWhiteTurn, moveToMake.charAt(3) == 'g'))
				if (moveToMake.charAt(3) == 'g')
					
	}
}