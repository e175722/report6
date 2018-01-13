public class Rook extends Piece{

    public Rook(){
    }

    public void can_Movement(int x,int y) {
        if (Promote == false) {
            if (x == X & ((1 <= y | y <= 9) & y != Y)) {
                Movement(x, y);
            } else if (((1 <= x | x <= 9) & x != X) & y == Y) {
                Movement(x, y);
            } else {
                System.out.println("そこには動かせないよ(>Д<)");
            }
        }

        else if (Promote == true){
            if (x == X & ((1 <= y | y <= 9) & y != Y)) {
                Movement(x, y);
            } else if (((1 <= x | x <= 9) & x != X) & y == Y) {
                Movement(x, y);
            } else if ((x == X+1|x == X-1) & (y == Y+1|y == Y-1)){
                Movement(x,y);
            }else {
                System.out.println("そこには動かせないよ(>Д<)");
            }
        }
    }
}
