public class King extends Piece {

    public King(){//コンストラクタ
    }

    public void can_Movement(int x,int y){
        if ((x == X |x == X+1|x == X-1) & (y == Y+1|y == Y-1)){
            Movement(x,y);
        }

        else if ((x == X+1|x == X-1) & y == Y){
            Movement(x,y);
        }

        else{
            System.out.println("そこには動かせないよ(>Д<)");
        }
    }
}
