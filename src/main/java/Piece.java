public class Piece {

    boolean Player_turn; //先行の人はtrue　後攻の人はfalse
    int X; //X軸
    int Y; //Y軸
    boolean Alive; //持ち駒かどうか

    public Piece(){  //コンストラクタ
    }

    public void Movement(int x,int y){//駒を動かすメソッド
        X =  x;
        Y =  y;
    }
}