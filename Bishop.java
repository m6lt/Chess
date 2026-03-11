public class Bishop extends Piece {

    public Bishop(boolean isWhite, int row, int col) {
        super(isWhite, row, col);
    }

    boolean moveIsDiagonal(int newRow, int newCol, Board board) {
        return (Math.abs(newRow - getRow()) == Math.abs(newCol - getCol()));
    }

    boolean pieceInPath(int newRow, int newCol, Board board) {
        int rowDirection = (getRow() < newRow) ? 1 : -1; 
        int colDirection = (getCol() < newCol) ? 1 : -1; 
        int currentRow = getRow() + rowDirection;
        int currentCol = getCol() + colDirection;

        while (currentRow != newRow  && currentCol != newCol) {
            Piece target = board.getPieceAt(currentRow , currentCol);
            if (target != null) {
                return true;
            }
            else {
                currentRow += rowDirection;
                currentCol += colDirection;
            }
        }
        return false;
    }
    
    @Override
    boolean isValidMove(int newRow, int newCol, Board board) {
        if (!super.isValidMove(newRow, newCol, board)) { 
            return false; 
        }
        return moveIsDiagonal(newRow, newCol, board) && !pieceInPath(newRow, newCol, board);

    }
}
