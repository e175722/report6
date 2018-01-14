import java.io.*;

public class Main {
    public static void main(String[] args) {
        BoardMake Board = new BoardMake();
        Board.MakeBoard();//s
        Board.Location();
        Board.MakePiece();
        Judge judge = new Judge();
        //ここまで下準備、盤面を整える
        System.out.println("半角数字（横座標）、半角スペース、半角数字（縦座標）　の順に打ってください");
        while (Board.match) {
            Board.PlayFirstPlayer(Board,judge);
            Board.PlaySecondPlayer(Board,judge);
        }
    }
}

