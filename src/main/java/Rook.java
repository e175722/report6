public class Rook extends Piece{
    int number = 2;

    public Rook(){
    }

    public void can_Movement(BoardMake board,int x1,int y1,int x2,int y2) {
        if (Promote == false) {
            if (x2 == X & ((2 <= y2 | y2 <= 18) & y2 != Y)) {
                Movement(x2, y2);
                boardUpdate(board,x1,y1,x2,y2,number);
            } else if (((1 <= x2 | x2 <= 17) & x2 != X) & y2 == Y) {
                Movement(x2, y2);
                boardUpdate(board,x1,y1,x2,y2,number);
            } else {
                System.out.println("そこには動かせないよ(>Д<)");
            }
        }

        else if (Promote == true){
            if (x2 == X & ((2 <= y2 | y2 <= 18) & y2 != Y)) {
                Movement(x2, y2);
                boardUpdate(board,x1,y1,x2,y2,number);
            } else if (((1 <= x2 | x2 <= 17) & x2 != X) & y2 == Y) {
                Movement(x2, y2);
                boardUpdate(board,x1,y1,x2,y2,number);
            } else if ((x2 == board.xChange(X+1)|x2 == board.xChange(X-1)) & (y2 == board.yChange(Y+1)|y2 == board.yChange(Y-1))){
                Movement(x2,y2);
                boardUpdate(board,x1,y1,x2,y2,number);
            }else {
                System.out.println("そこには動かせないよ(>Д<)");
            }
        }
    }
}
