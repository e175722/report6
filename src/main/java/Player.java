import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {

    public Player(){
    }

    public BoardMake PlayFirstPlayer(BoardMake Board, Judge judger) {
        String test = null;
        String test2 = null;
        Board.PrintBoard(Board);
        System.out.println("先行の番です、動かしたい駒を選んでください");
        try {
            BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
            test = new String(inp.readLine());
            System.out.println("次にどこに動かすか選んでください");
            test2 = new String(inp.readLine());

        } catch (IOException e) {
            System.out.println("era-");
        }
        String[] nowCoordinate = test.split(" ",0);
        String[] nextCoordinate = test2.split(" ",0);

        Board.Coordinate[0] = Integer.parseInt(nowCoordinate[0]);
        Board.Coordinate[1] = Integer.parseInt(nowCoordinate[1]);
        Board.Coordinate[2] = Integer.parseInt(nextCoordinate[0]);
        Board.Coordinate[3] = Integer.parseInt(nextCoordinate[1]);

        BoardMake test3 = judger.Judge_Piece(Board,Board.xChange(Board.Coordinate[0]),Board.yChange(Board.Coordinate[1]),Board.xChange(Board.Coordinate[2]),Board.yChange(Board.Coordinate[3]));
        Board.turn = false;
        return test3;
    }

    public BoardMake PlaySecondPlayer(BoardMake Board, Judge judger) {
        String test = null;
        String test2 = null;
        String[] nowCoordinate = null;
        String[] nextCoordinate = null;
        Board.PrintBoard(Board);
        System.out.println("後攻の番です、動かしたい駒を選んでください");
        try {
            BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
            test = new String(inp.readLine());
            System.out.println("次にどこに動かすか選んでください");
            test2 = new String(inp.readLine());

        } catch (IOException e) {
            System.out.println("era-");
        }
        try {
            nowCoordinate = test.split(" ", 0);
            nextCoordinate = test2.split(" ", 0);
        }
        catch (NullPointerException e){
            //作成中
        }
        Board.Coordinate[0] = Integer.parseInt(nowCoordinate[0]);
        Board.Coordinate[1] = Integer.parseInt(nowCoordinate[1]);
        Board.Coordinate[2] = Integer.parseInt(nextCoordinate[0]);
        Board.Coordinate[3] = Integer.parseInt(nextCoordinate[1]);

        BoardMake test3 = judger.Judge_Piece(Board,Board.xChange(Board.Coordinate[0]),Board.yChange(Board.Coordinate[1]),Board.xChange(Board.Coordinate[2]),Board.yChange(Board.Coordinate[3]));
        Board.turn = true;
        return test3;
    }
}
