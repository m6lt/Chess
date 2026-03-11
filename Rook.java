public class Rook extends Piece {

    public Rook (boolean isWhite, int row, int col) {
        super(isWhite, row, col);
    }

    @Override
    boolean isValidMove(int newRow, int newCol, Board board) {
        if (!super.isValidMove(newRow, newCol, board)) {return false;}
        int changeinRow = Math.abs(getRow() - newRow);
        int changeinCol = Math.abs(getCol() - newCol);

        if (changeinRow != 0 && changeinCol == 0 || changeinRow == 0 && changeinCol != 0) {
            int rowDirection = (getRow() < newRow) ? 1 : -1;
            int colDirection = (getCol() < newCol) ? 1 : -1;
            int currentRow = getRow();
            int currentCol = getCol();

            if (currentCol != newCol) {
                currentCol += colDirection;
                while (currentCol != newCol) {
                    Piece target = board.getPieceAt(currentRow, currentCol);
                    if (target != null) {
                        return false;
                    }
                    currentCol += colDirection;
                }
                return true;
            }
            else {
                currentRow += rowDirection;
                while (currentRow != newRow) {
                    Piece target = board.getPieceAt(currentRow, currentCol);
                    if (target != null) {
                        return false;
                    }
                    currentRow += rowDirection;
                }
                return true;

            }
        }
        return false;
    }
    
}
