import java.io.*;

public class Main {
    public static void main(String[] args) {
        BoardMake Board = new BoardMake();
        Board.MakeBoard();//s
        Board.Location();
        Board.MakePiece();
        Board.turn =true;
        Judge judge = new Judge();
        Player firstPlayer = new Player();
        Player secondPlayer = new Player();
        BoardMake test1;
        BoardMake test2 = Board;
        //ここまで下準備、盤面を整える
        System.out.println("半角数字（横座標）、半角スペース、半角数字（縦座標）　の順に打ってください");
        while (test2.match) {
            test1 = firstPlayer.PlayFirstPlayer(test2,judge);
            test2 = secondPlayer.PlaySecondPlayer(test1,judge);
        }
    }
}

