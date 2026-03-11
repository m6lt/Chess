public class Knight extends Piece {

    public Knight(boolean isWhite, int row, int col ){
        super(isWhite, row, col);
    }

    @Override
    public String toString() {
        return "N";
    }
    
    boolean isValidMove(int newRow, int newCol, Board board) {
        if (!super.isValidMove(newRow, newCol, board)){
            return false;
        }
        
        boolean optionA = (Math.abs(newRow - getRow()) == 2 && (Math.abs(newCol - getCol()) == 1)); 
        boolean optionB = (Math.abs(newCol - getCol()) == 2 && (Math.abs(newRow - getRow()) == 1)); 

        return optionA || optionB;

    }

}
