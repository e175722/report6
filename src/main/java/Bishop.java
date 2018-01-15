public class Bishop extends Piece {
    int number = 1;

    public Bishop(){
    }

    public void can_Movement(BoardMake board,int x1,int y1,int x2,int y2){
        if (Promote == false){
            if (Math.abs(X-x2) == Math.abs(Y-y2)){
                Movement(x2,y2);
                boardUpdate(board,x1,y1,x2,y2,number);
            }
            else if (x2 == X & y2 == Y){
                System.out.println("そこには動かせないよ(>Д<)");
            }
            else {
                System.out.println("そこには動かせないよ(>Д<)");
            }
        }

        else if (Promote == true){
            if (Math.abs(X-x2) == Math.abs(Y-2)){
                Movement(x2,y2);
                boardUpdate(board,x1,y1,x2,y2,number);
            }
            else if (x2 == X & y2 == Y){
                System.out.println("そこには動かせないよ(>Д<)");
            }
            else if (x2 == X & (y2 == board.yChange(Y+1)|y2 == board.yChange(Y-1))){
                Movement(x2,y2);
                boardUpdate(board,x1,y1,x2,y2,number);
            }
            else if ((x2 == board.xChange(X+1)|x2 == board.xChange(X-1)) & y2 == Y){
                Movement(x2,y2);
                boardUpdate(board,x1,y1,x2,y2,number);
            }
            else {
                System.out.println("そこには動かせないよ(>Д<)");
            }
        }
    }
}
