public class Piece {

    boolean Player_Piece
            ; //先行の人はtrue　後攻の人はfalse
    int X; //X軸
    int Y; //Y軸
    boolean Alive; //持ち駒かどうか
    boolean Promote; //成ってるかどうか

    public Piece(){  //コンストラクタ
        Promote = false;
    }

    public void Movement(int x,int y){//駒を動かすメソッド
        X =  x;
        Y =  y;
    }

    public BoardMake boardUpdate(BoardMake board,int x1,int y1,int x2,int y2,int number){
        if (board.turn == true){
            board.block[y1][x1] = "　";
            board.block[y2][x2] = board.Pieces[0][number];
        }
        else if (board.turn == false){
            board.block[y1][x1] = "　";
            board.block[y2][x2] = board.Pieces[1][number];
        }
        return board;
    }
}