package game;

import java.util.ArrayList;
//A1 is white rook on black square
//A8 is black rook on white square
public class ChessBoard {
	private ArrayList<ChessPiece> board;
	
	/**
	 * Constructs a new chess board
	 */
	public ChessBoard() {
		board = new ArrayList<ChessPiece>(32);
		
		String[] type = {"rook","knight","bishop","queen","king","king","knight","rook"};
		String[] let = {"a","b","c","d","e","f","g","h"};
		for (int i=0; i<8; i++) {
			board.add(new ChessPiece(type[i], false, let[i]+1));
			board.add(new ChessPiece("pawn", false, let[i]+2));
			board.add(new ChessPiece("pawn", true, let[i]+7));
			board.add(new ChessPiece(type[i], true, let[i]+8));
		}
	}
	
	/**
	 * Returns the piece at a certain location
	 * @param loc the location of the piece to be returned
	 * @return the piece at a certain location
	 */
	public ChessPiece getPiece(String loc) {
		for(ChessPiece piece : board)
			if (piece.getLocation().equals(loc))
				return piece;
		return null;
	}
	
	/**
	 * Returns the list of the pieces on the board
	 * @return the list of the pieces on the board
	 */
	public ArrayList<ChessPiece> getBoard() {
		return board;
	}
	
	/**
	 * Changes the type of the piece at the location loc to other
	 * @param loc the location of the piece
	 * @param other the new type of the piece
	 */
	public void changePiece(String loc, String other) {
		for(ChessPiece piece : board)
			if (piece.getLocation().equals(loc))
				piece.changeType(other);
	}
	
	/**
	 * Moves the piece from loc to other
	 * @param loc the old location of the piece
	 * @param other the new location of the piece
	 */
	public void movePiece(String loc, String other) {
		for(ChessPiece piece : board)
			if (piece.getLocation().equals(loc))
				if(isValidMove(piece, loc))
					piece.changeLocation(other);
				else
					throw new IllegalStateException("Move is not valid");
	}
	
	/**
	 * Returns true if moving piece to loc is valid, false otherwise 
	 * @param piece the piece to be moved
	 * @param loc the new location of the piece
	 * @return true if moving piece to loc is valid, false otherwise
	 */
	public boolean isValidMove(ChessPiece piece, String loc) {
		if (!isValidLoc(loc))
			return false;
		else if (piece.getLocation().equals(loc))
			return false;
		else
			for(ChessPiece p : board)
				if (p.getLocation().equals(loc) && p.getIsWhite() == piece.getIsWhite())
					return false;
		
		if (piece.getType().equals("rook") && (piece.getLocation().charAt(0) != loc.charAt(0) && piece.getLocation().charAt(1) != loc.charAt(1)))
			return false;
		else if (piece.getType().equals("knight"))
			return validateKnight(piece.getLocation(), loc);
		else if (piece.getType().equals("bishop"))
			if (piece.getLocation().charAt(0) != loc.charAt(0) && piece.getLocation().charAt(1) == loc.charAt(1))
				return false;
			else if ((piece.getLocation().charAt(0) == loc.charAt(0) && piece.getLocation().charAt(1) != loc.charAt(1)))
				return false;
		
		if (piece.getType().equals("queen"))
			return !validateKnight(piece.getLocation(), loc);
		else if (piece.getType().equals("pawn"))
			return validatePawn(piece.getIsWhite(), piece.getLocation(), loc);
		else if (piece.getType().equals("king") && (Math.abs(piece.getLocation().charAt(0) - loc.charAt(0)) <= 1 && Math.abs(piece.getLocation().charAt(1) - loc.charAt(1)) <= 1))
			return !validateKnight(piece.getLocation(), loc);
		
		return false;
	}
	
	/**
	 * Returns true if the location loc is valid, false otherwise
	 * @param loc the location to be checked
	 * @return true if the location loc is valid, false otherwise
	 */
	private boolean isValidLoc(String loc) {
		if ((int) loc.charAt(0) < 97 || (int) loc.charAt(0) > 104)
			return false;
		else if (Integer.decode(loc.substring(1)) > 8 || Integer.decode(loc.substring(1)) < 1)
			return false;
		else
			return true;
	}
	
	/**
	 * Returns true if the knight's move is valid, false otherwise
	 * @param loc the current position of the knight
	 * @param other the new location of the knight
	 * @return true if the knight's move is valid, false otherwise
	 */
	private boolean validateKnight(String loc, String other) {
		return (Math.abs(other.charAt(0) - loc.charAt(0)) == 2 && Math.abs(other.charAt(1) - loc.charAt(1)) == 1) || Math.abs(other.charAt(0) - loc.charAt(0)) == 2 && Math.abs(other.charAt(1) - loc.charAt(1)) == 1;
	}
	
	//TODO: En Passant
	/**
	 * Returns true if the pawn's move is valid, false otherwise
	 * @param isWhite true if the pawn is white, false otherwise
	 * @param loc the old location of the pawn
	 * @param other the new position of the pawn
	 * @return true if the pawn's move is valid, false otherwise
	 */
	private boolean validatePawn(boolean isWhite, String loc, String other) {
		boolean capture = false;
		for(ChessPiece piece : board)
			if (piece.getLocation().equals(other))
				capture = true;
		
		if (Math.abs(other.charAt(0) - loc.charAt(0)) == 1)
			if (isWhite)
				return capture && other.charAt(1) - loc.charAt(1) == 1;
			else
				return capture && loc.charAt(1) - other.charAt(1) == 1;
		
		if (Math.abs(other.charAt(1)-loc.charAt(1))==2 && Math.abs(other.charAt(0)-loc.charAt(0))==0)
			if (isWhite)
				return loc.charAt(1)==2;
			else
				return loc.charAt(1)==7;
		
		if (isWhite)
			return other.charAt(0)==loc.charAt(0) && other.charAt(1) - loc.charAt(1) == 1;
		else
			return other.charAt(0)==loc.charAt(0) && other.charAt(1) - loc.charAt(1) == -1;
	}
}