public class Board {
    
    public Piece enpassantVulnerable;
    private Piece[][] board;
    int row,col;
    
    public Board(Board board, int row, int col) {
        this.board = new Piece [8][8];
        this.row = row;
        this.col = col;

    }

    public Piece getPieceAt(int row, int col){
        if (row < 0 || row > 7 || col < 0 || col > 7 ) {
            return null;
        }
        return this.board[row][col]; 

    }

    public Piece setPieceAt(int row, int col, Piece piece) {
        if (row < 0 || row > 7 || col < 0 || col > 7 ) {
            return null;
        }
        return this.board[row][col] = piece;
    }

    public String getSymbols(Piece piece) {
        if (piece == null) {
            return ".";
        }
        return piece.toString();
    }
    
    public void printBoard () {
        System.out.println("0 1 2 3 4 5 6 7");
        for (int row = 7; row >= 0; row--) {
            for (int col = 0; col <= 7; col++) {
                System.out.print(getSymbols(board[row][col]) + " ");
            }
            System.out.println();
        }
        System.out.println("a b c d e f g h");
    }
    
}