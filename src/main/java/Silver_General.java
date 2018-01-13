public class Silver_General extends Piece {

    public Silver_General(){
    }

    public void can_Movement(int x,int y) {//銀の動ける範囲
        if (Promote == false) {//成ってない
            if (Player_Piece == false) {//後攻の動き
                if (x == X & y == Y + 1) {
                    Movement(x, y);
                } else if (x == X + 1 & (y == Y + 1 | y == Y - 1)) {
                    Movement(x, y);
                } else if (x == X - 1 & (y == Y + 1 | y == Y - 1)) {
                    Movement(x, y);
                } else {
                    System.out.println("そこには動かせないよ(>Д<)");
                }
            }
            if (Player_Piece == true){//先行の動き
                if (x == X & y == Y + 1) {
                    Movement(x, y);
                } else if (x == X + 1 & (y == Y + 1 | y == Y - 1)) {
                    Movement(x, y);
                } else if (x == X - 1 & (y == Y + 1 | y == Y - 1)) {
                    Movement(x, y);
                } else {
                    System.out.println("そこには動かせないよ(>Д<)");
                }
            }
        }
        else if (Promote == true){//成り　金と同じ
            if (Player_Piece == false) {//後攻の動き
                if (x == X & (y == Y + 1 | y == Y - 1)) {
                    Movement(x, y);
                } else if (x == X + 1 & (y == Y | y == Y + 1)) {
                    Movement(x, y);
                } else if (x == X - 1 & (y == Y | y == Y + 1)) {
                    Movement(x, y);
                } else {
                    System.out.println("そこには動かせないよ(>Д<)");
                }
            }
            else if (Player_Piece == true){//先行の動き
                if (x == X & (y == Y + 1 | y == Y - 1)) {
                    Movement(x, y);
                } else if (x == X + 1 & (y == Y | y == Y - 1)) {
                    Movement(x, y);
                } else if (x == X - 1 & (y == Y | y == Y - 1)) {
                    Movement(x, y);
                } else {
                    System.out.println("そこには動かせないよ(>Д<)");
                }
            }
        }
    }
}
