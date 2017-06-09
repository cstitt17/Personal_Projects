package game;

import processing.core.PApplet;
import processing.core.PImage;
//1=49, a=97
//knight at b8 put king at e1 into checkmate
public class ChessGUI extends PApplet{
	private ChessGame game;
	private String move;
	private String win;
	private boolean isWhiteTurn;
	
	public void setup() {
		size(730,730); //728 = 8 * 91
		PImage background = loadImage("../../images/b4.png");
		image(background, 0, 0);
		
		game = new ChessGame();
		isWhiteTurn = true;
		move = "";
		win = "";
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
			
			textSize(20);
			text(win, 0, 0);
					
		}
	}
	
	public void keyPressed() {
		move += (char) keyCode;
		
		if (move.length() == 5) {
			preformMove(move.toLowerCase());
			move = "";
			
			/*if (game.check(true))
				if (game.checkmate(true))
					System.out.println("White is in checkmate!"); //win=
				else
					System.out.println("White is in check!");
			else if (game.check(false))
				if (game.checkmate(false))
					System.out.println("Black is in checkmate!");
				else
					System.out.println("Black is in check!");*/
		}
	}
	
	private void preformMove(String moveToMake) {
		if (isWhiteTurn)
			if (game.canCastle(isWhiteTurn, moveToMake.charAt(3) == 'g')) {
				if (moveToMake.substring(3).equals("g1") && game.getChessBoard().getPiece(moveToMake.substring(0, 2)).getType().equals("king"))
					game.castle(true, true);
			} else {
				if (moveToMake.substring(3).equals("c1") && game.getChessBoard().getPiece(moveToMake.substring(0, 2)).getType().equals("king"))
					game.castle(true, false);
			}
		else
			if (game.canCastle(isWhiteTurn, moveToMake.charAt(3) == 'g')) {
				if (moveToMake.substring(3).equals("g8") && game.getChessBoard().getPiece(moveToMake.substring(0, 2)).getType().equals("king"))
					game.castle(false, true);
			} else {
				if (moveToMake.substring(3).equals("c8") && game.getChessBoard().getPiece(moveToMake.substring(0, 2)).getType().equals("king"))
					game.castle(false, false);
			}
		
		if (game.canEnPassant(moveToMake.substring(0,2), moveToMake.substring(3)))
			game.enPassant(moveToMake.substring(0,2), moveToMake.substring(3));
		
		game.makeMove(moveToMake, false);
	}
}