public class Main {
    
    public static void main(String[] args){
        //PIECES
        Board b = new Board(null, 0, 0);
        Pawn p1 = new Pawn(true, 3, 5);
        Pawn p2 = new Pawn(true, 4, 4);
        Pawn p3 = new Pawn(true, 3, 7);
        Bishop bs1 = new Bishop(true, 1, 7);
        Rook r1 = new Rook(false, 2, 7);
        

        //DECLARATIONS
        b.setPieceAt(p2.getRow(), p2.getCol(), p2);
        b.setPieceAt(p1.getRow(), p1.getCol(), p1);
        b.setPieceAt(p3.getRow(), p3.getCol(), p3);
        b.setPieceAt(bs1.getRow(), bs1.getCol(), bs1);
        b.setPieceAt(r1.getRow(), r1.getCol(), r1);
        

        //TESTS
        System.out.println("===================TESTS===================");
        

        //ROOK TESTS
        System.out.println("DEBUG: Rook Position: " +  " Column: " + r1.getCol() + " Row: " + r1.getRow());
        System.out.println("DEBUG: Rook Test " + r1.isValidMove(p3.getRow(), p3.getCol(), b));



        System.out.println("===========================================");
        

        //BOARD
        System.out.println("===================GAME===================");
        b.printBoard();

        
    }
    
}
