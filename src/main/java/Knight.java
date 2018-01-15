public class Knight extends Piece {
    int number = 4;

    public Knight(){//コンストラクタ
    }

    public void can_Movement(BoardMake board,int x1,int y1,int x2,int y2){
        if (Promote == false) {
            if (Player_Piece == false) {
                if ((x2 == X + 2| x2 == X - 2) & y2 == Y + 4) {
                    Movement(x2, y2);
                    boardUpdate(board,x1,y1,x2,y2,number);
                }
                else {
                    System.out.println("そこには動かせないよ(>Д<)");
                }
            }
            else if (Player_Piece == true) {
                if ((x2 == X + 2 | x2 == X - 2) & y2 == Y - 4) {
                    Movement(x2, y2);
                    boardUpdate(board,x1,y1,x2,y2,number);
                }
                else {
                    System.out.println("そこには動かせないよ(>Д<)");
                }
            }
        }
        else if (Promote == true){//成り　金と同じ
            if (Player_Piece == false) {//後攻の動き
                if (x2 == X & (y2 == Y + 2 | y2 == Y - 2)) {
                    Movement(x2, y2);
                    boardUpdate(board,x1,y1,x2,y2,number);
                } else if (x2 == X + 2 & (y2 == Y | y2 == Y + 2)) {
                    Movement(x2, y2);
                    boardUpdate(board,x1,y1,x2,y2,number);
                } else if (x2 == X - 2 & (y2 == Y | y2 == Y + 2)) {
                    Movement(x2, y2);
                    boardUpdate(board,x1,y1,x2,y2,number);
                } else {
                    System.out.println("そこには動かせないよ(>Д<)");
                }
            }
            else if (Player_Piece == true){//先行の動き
                if (x2 == X & (y2 == Y + 2 | y2 == Y - 2)) {
                    Movement(x2, y2);
                    boardUpdate(board,x1,y1,x2,y2,number);
                } else if (x2 == X + 2 & (y2 == Y | y2 == Y - 2)) {
                    Movement(x2, y2);
                    boardUpdate(board,x1,y1,x2,y2,number);
                } else if (x2 == X - 2 & (y2 == Y | y2 == Y - 2)) {
                    Movement(x2, y2);
                    boardUpdate(board,x1,y1,x2,y2,number);
                } else {
                    System.out.println("そこには動かせないよ(>Д<)");
                }
            }
        }
    }
}
