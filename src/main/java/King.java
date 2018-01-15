public class King extends Piece {
    int number = 7; //BoardMakeクラスのPieceの中での番号

    public King(){//コンストラクタ
    }

    public void can_Movement(BoardMake board,int x1,int y1,int x2,int y2){
        if ((x2 == X |x2 == X+2|x2 == X-2) & (y2 == Y+2|y2 == Y-2)){
            Movement(x2,y2);
            boardUpdate(board,x1,y1,x2,y2,number);
        }

        else if ((x2 == X+2|x2 == X-2) & y2 == Y){
            Movement(x2,y2);
            boardUpdate(board,x1,y1,x2,y2,number);
        }

        else{
            System.out.println("そこには動かせないよ(>Д<)");
        }
    }
}
