public class Judge{
    //trueのターンにfalseの駒と重なったらfalseの駒をtrueに変える（逆も）
    public void Rob(Piece First_Attack,Piece After_Attack) {
        if (First_Attack.X == After_Attack.X & First_Attack.Y == After_Attack.Y) {
            if (a == true) {
                After_Attack.Player_Piece = true;
                After_Attack.Alive = false;
            }
            if(a == false){
                First_Attack.Player_Piece = false;]
                First_Attack.Alive = false;
            }
        }
    }
    //王が取られたら負け
    public void Settlement(int x,int y){
        King King1 = new King();
        King King2 = new King();
        King1.Player_Piece = true;
        King2.Player_Piece = false;
    }
    //進める場所に味方の駒がある時進めない表示をする

    //敵陣地3行以降に侵入したら成るかどうかの選択を与える

    //桂馬が敵陣地1行、2行に侵入したら選択肢を与えず成る

    //香車が敵陣地最奥についたら強制的に成る

    //敵陣地の1〜3行目で行動したら毎回成るかどうかの選択を問う

    //駒を置く時、他の駒がそこにあれば置けない表示をする

}