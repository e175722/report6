public class Main {
    public static void main(String[] args) {
        BoadMake Boad = new BoadMake();
        Boad.MakeBoad();

        King King1 = new King();
        King King2 = new King();
        Piece King3 = new King();

        King1.Player_Piece =true;
        King2.Player_Piece =false;

        King1.X == King2.X
        King2.Promote =false;
    }

    public void judge(Piece a ,Piece b){
        a.X == b.X;
    }
}

