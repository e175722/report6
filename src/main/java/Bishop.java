public class Bishop extends Piece {

    public Bishop(){
    }

    public void can_Movement(int x,int y){
        if (Promote == false){
            if (Math.abs(X-x) == Math.abs(Y-y)){
                Movement(x,y);
            }
            else if (x == X & y == Y){
                System.out.println("そこには動かせないよ(>Д<)");
            }
            else {
                System.out.println("そこには動かせないよ(>Д<)");
            }
        }

        else if (Promote == true){
            if (Math.abs(X-x) == Math.abs(Y-y)){
                Movement(x,y);
            }
            else if (x == X & y == Y){
                System.out.println("そこには動かせないよ(>Д<)");
            }
            else if (x == X & (y == Y+1|y == Y-1)){
                Movement(x,y);
            }
            else if ((x == X+1|x == X-1) & y == Y){
                Movement(x,y);
            }
            else {
                System.out.println("そこには動かせないよ(>Д<)");
            }
        }
    }
}
