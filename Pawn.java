public class Pawn extends Piece {
    
    public Pawn (boolean isWhite, int row, int col) {
        super(isWhite, row, col);
    }

    boolean enPassant(int newRow, int newCol, Board board) {
        Piece neighbour = board.getPieceAt(getRow(), newCol);

        return (neighbour != null) 
             && neighbour == board.enpassantVulnerable
             && Math.abs(newRow - getRow()) == 1
             && Math.abs(newCol - getCol()) == 1
             && (getRow() == (isWhite() ? 4 : 3));
    } 

    boolean standardMove(int newRow, int newCol, Board board) {
        Piece target = board.getPieceAt(newRow, newCol);
        int direction = isWhite() ? 1 : -1;
        return (newRow == getRow() + direction && newCol == getCol()) && (target == null);
    } 

    boolean doubleMove (int newRow, int newCol, Board board) {
        int startRow = isWhite() ? 1 : 6; 
        int direction = isWhite() ? 1 : -1;
        if (getRow() == startRow && newCol == getCol() && newRow == getRow() + 2 * direction) {
            return board.getPieceAt(getRow() + direction, getCol()) == null && board.getPieceAt(newRow, newCol) == null;
        } 
        return false;
    }

    boolean diagonalMove(int newRow, int newCol, Board board) {
        Piece target = board.getPieceAt(newRow, newCol);
        int direction = isWhite() ? 1 : -1;
        return (newRow == getRow() + direction) && (Math.abs(newCol - getCol()) == 1) && (target != null); 
    }

    @Override
    boolean isValidMove(int newRow, int newCol, Board board) {
        if (!super.isValidMove(newRow, newCol, board)) {
            return false;
        }
        return standardMove(newRow, newCol, board) || doubleMove(newRow, newCol, board) || diagonalMove(newRow, newCol, board) || enPassant(newRow, newCol, board);
    }

}