public class Piece {
    //VARIABLES
    private boolean isWhite;
    private int row,col;
    //CONSTRUCTOR
    public Piece (boolean isWhite, int row, int col) {
        System.out.println("=============PIECE INSTANCE=============");
        System.out.println("DEBUG: Created " + this.getClass().getSimpleName() + " with isWhite = " + isWhite);
        this.isWhite = isWhite;
        this.row = row;
        this.col = col;

        
    } 
       
    //GETTERS
    public int getRow() { return row; }
    public int getCol() { return col; }
    public boolean isWhite() { return isWhite; } 

    
   
    //METHODS

    @Override
    public String toString() {
        String letter = this.getClass().getSimpleName().substring(0,1);
        return letter;
    }

    boolean isValidMove(int newRow, int newCol, Board board) {
        Piece target = board.getPieceAt(newRow, newCol);
        System.out.println("DEBUG: Target " + target.getClass().getSimpleName() + " colour is white = " + target.isWhite());

        if (target != null && target.isWhite() == this.isWhite()) {
            System.out.println("DEBUG: Piece: " + this.getClass().getSimpleName() + " Invalid Move. ");
            return false;
        }
        return (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) && !(newRow == getRow() && newCol == getCol());
        
    }
    
    
}
