public class Piece {

    boolean Player_Piece
            ; //先行の人はtrue　後攻の人はfalse
    int X; //X軸
    int Y; //Y軸
    boolean Alive; //持ち駒かどうか
    boolean Promote; //成ってるかどうか

    public Piece(){  //コンストラクタ
    }

    public void Movement(int x,int y){//駒を動かすメソッド
        X =  x;
        Y =  y;
    }

    public void Piece_Promote_gold(int x,int y){//成り 金と同じ動き
        if(x == X & (y == Y+1|y == Y-1)){
            Movement(x,y);
        }
        else if(x == X+1 & (y == Y|y == Y+1)){
            Movement(x,y);
        }
        else if(x == X-1 & y == Y|y == Y+1){
            Movement(x,y);
        }
        else{
            System.out.println("そこには動かせないよ(>Д<)");
        }
    }
}