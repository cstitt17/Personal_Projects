package game;

public class ChessGame {
	private ChessBoard board;
	
	/**
	 * Constructs a new chess game.
	 */
	public ChessGame() {
		board = new ChessBoard();
	}
	
	/**
	 * Returns the chess board
	 * @return the chess board
	 */
	public ChessBoard getChessBoard() {
		return board;
	}
	
	/**
	 * Returns true if the king is in check
	 * @param kingIsWhite true if the king is white, false if it is black
	 * @return true if the king is in check
	 */
	public boolean check(boolean kingIsWhite) {
		ChessPiece king = null;
		for(ChessPiece p : board.getBoard())
			if (p.getType().equals("king") && p.getIsWhite() == kingIsWhite)
				king = p;
		
		for(ChessPiece p : board.getBoard())
			if (p.getIsWhite() != kingIsWhite && !p.getType().equals("king"))
				if (board.isValidMove(p, king.getLocation()))
					return true;
		return false;
	}
	
	/**
	 * Returns true if the king is in checkmate, false otherwise
	 * @param kingIsWhite true if the king is white, false otherwise
	 * @return true if the king is in checkmate, false otherwise
	 */
	public boolean checkmate(boolean kingIsWhite) {
		if (!check(kingIsWhite))
			return false;
		
		ChessPiece king = null;;
		for(ChessPiece p : board.getBoard())
			if (p.getType().equals("king") && p.getIsWhite() == kingIsWhite)
				king = p;
		
		for (int i = king.getLocation().charAt(0)-1; i <= king.getLocation().charAt(0)+1; i++)
			for (int j=king.getLocation().charAt(1)-1; j<=king.getLocation().charAt(1)+1; j++)
				if (board.isValidMove(king, ""+((char) i) + j)) {
					board.movePiece(king.getLocation(), ""+((char) i) + j);
					if (check(kingIsWhite))
						board.movePiece(""+((char) i) + j, king.getLocation());
					else
						return false;
				}
		return true;
	}
	
	/**
	 * Makes one move of a piece, if valid
	 * @param move A string in the format location + space + other location
	 */
	public void makeMove(String move) {
		String loc = move.substring(0, 2);
		String other = move.substring(3);
		board.movePiece(loc, other);
	}
}