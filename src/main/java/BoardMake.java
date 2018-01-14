import java.awt.event.KeyListener;
        import java.util.Arrays;

//将棋盤を表示するクラス
public class BoardMake {
    String[][] block; //２次元配列のblockを用意
    boolean turn; //先行が打ってる時はtrue,後攻が打ってる時はfalse

    //使う駒たち
    Bishop bishop1;
    Bishop bishop2;
    Gold_General gold1;
    Gold_General gold2;
    Gold_General gold3;
    Gold_General gold4;
    King king1;
    King king2;
    Knight knight1;
    Knight knight2;
    Knight knight3;
    Knight knight4;
    Lance lance1;
    Lance lance2;
    Lance lance3;
    Lance lance4;
    Pawn pawn1;
    Pawn pawn2;
    Pawn pawn3;
    Pawn pawn4;
    Pawn pawn5;
    Pawn pawn6;
    Pawn pawn7;
    Pawn pawn8;
    Pawn pawn9;
    Pawn pawn10;
    Pawn pawn11;
    Pawn pawn12;
    Pawn pawn13;
    Pawn pawn14;
    Pawn pawn15;
    Pawn pawn16;
    Pawn pawn17;
    Pawn pawn18;
    Rook rook1;
    Rook rook2;
    Silver_General silver1;
    Silver_General silver2;
    Silver_General silver3;
    Silver_General silver4;

    //駒のまとまり
    Bishop[] bishops = new Bishop[2];
    Pawn[] pawns = new Pawn[18];
    Gold_General[] golds = new  Gold_General[4];
    King[] kings = new King[2];
    Knight[] knights = new Knight[4];
    Lance[] lances = new Lance[4];
    Rook[] rooks = new Rook[2];
    Silver_General[] silvers = new Silver_General[4];

    //JudgeクラスのpieceJudgeメソッドで使う変数
    String[][] Pieces = new String[3][8];



    //将棋盤の基盤となるものを２次元配列で表示するメソッド
    public void MakeBoard() {
        block = new String[20][20];
        int c, d, e, f, g, h, i, j, k, l, m, o, p, q, r, t;
        q = 9;
        e = 1;
        for (i = 0; i < 20; i++) {
            block[1][i] = "ー";
        }
        for (t = 1; t < 20; t++) {
            block[t][0] = "｜";
        }
        for (g = 2; g < 20; g = g + 2) {
            for (j = 2, h = 1; j < 20; h = h + 2, j = j + 2) {
                block[g][h] = " ";
                block[g][j] = "｜";
            }
        }
        for (k = 3; k < 20; k = k + 2) {
            for (l = 2, p = 1; l < 20; l = l + 2, p = p + 2) {
                block[k][p] = "ー";
                block[k][l] = "＋";
            }
        }
        for (m = 1; m < 20; m++) {
            block[m][18] = "｜";
        }
        for (f = 0; f < 20; f++) {
            block[19][f] = "ー";
        }
        for (r = 0; r < 20; r++) {
            block[0][r] = " ";
            block[r][19] = " ";
        }
        for (o = 1; o < 19; o = o + 2) {
            block[0][o] = hanNum2ZenNum(block[0][o] = String.valueOf(q));
            q--;
        }
        block[2][19] = "一";
        block[4][19] = "二";
        block[6][19] = "三";
        block[8][19] = "四";
        block[10][19] = "五";
        block[12][19] = "六";
        block[14][19] = "七";
        block[16][19] = "八";
        block[18][19] = "九";
    }

    public void PrintBoard(){
        int n;
        MakeBoard();
        for(n=0;n<20;n++){
            String[] test = block[n];
            String test2 = String.join("",test);
            System.out.println(test2);
        }
    }

    //半角数字を全角数字に変換するメソッド
    public static String hanNum2ZenNum(String s) {
        StringBuffer sb = new StringBuffer(s);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                sb.setCharAt(i, (char)(c - '0' + '０'));
            }
        }
        return sb.toString();
    }

    public void Location() {
        bishops = new Bishop[2];
        pawns = new Pawn[18];
        golds = new  Gold_General[4];
        kings = new King[2];
        knights = new Knight[4];
        lances = new Lance[4];
        rooks = new Rook[2];
        silvers = new Silver_General[4];

        bishops[0] = bishop1 = new Bishop();
        bishops[1] = bishop2 = new Bishop();
        golds[0] = gold1 = new Gold_General();
        golds[1] = gold2 = new Gold_General();
        golds[2] = gold3 = new Gold_General();
        golds[3] = gold4 = new Gold_General();
        kings[0] = king1 = new King();
        kings[1] = king2 = new King();
        knights[0] = knight1 = new Knight();
        knights[1] = knight2 = new Knight();
        knights[2] = knight3 = new Knight();
        knights[3] = knight4 = new Knight();
        lances[0] = lance1 = new Lance();
        lances[1] = lance2 = new Lance();
        lances[2] = lance3 = new Lance();
        lances[3] = lance4 = new Lance();
        pawns[0] = pawn1 = new Pawn();
        pawns[1] = pawn2 = new Pawn();
        pawns[2] = pawn3 = new Pawn();
        pawns[3] = pawn4 = new Pawn();
        pawns[4] = pawn5 = new Pawn();
        pawns[5] = pawn6 = new Pawn();
        pawns[6] = pawn7 = new Pawn();
        pawns[7] = pawn8 = new Pawn();
        pawns[8] = pawn9 = new Pawn();
        pawns[9] = pawn10 = new Pawn();
        pawns[10] = pawn11 = new Pawn();
        pawns[11] = pawn12 = new Pawn();
        pawns[12] = pawn13 = new Pawn();
        pawns[13] = pawn14 = new Pawn();
        pawns[14] = pawn15 = new Pawn();
        pawns[15] = pawn16 = new Pawn();
        pawns[16] = pawn17 = new Pawn();
        pawns[17] = pawn18 = new Pawn();
        rooks[0] = rook1 = new Rook();
        rooks[1] = rook2 = new Rook();
        silvers[0] = silver1 = new Silver_General();
        silvers[1] = silver2 = new Silver_General();
        silvers[2] = silver3 = new Silver_General();
        silvers[3] = silver4 = new Silver_General();


    }


    //JudgeクラスのpieceJudgeメソッドで使うためのpiece変数を作るためのメソッド
    //中身は駒の種類ごと順番よく並んでるので、順番よく取り出して使える
    public void MakePiece(){
        //先行の人の分
        Pieces[0][0] = "歩";
        Pieces[0][1] = "角";
        Pieces[0][2] = "飛";
        Pieces[0][3] = "香";
        Pieces[0][4] = "桂";
        Pieces[0][5] = "銀";
        Pieces[0][6] = "金";
        Pieces[0][7] = "王";

        //後攻の人の分
        Pieces[1][0] = "ふ";
        Pieces[1][1] = "か";
        Pieces[1][2] = "ひ";
        Pieces[1][3] = "こ";
        Pieces[1][4] = "け";
        Pieces[1][5] = "ぎ";
        Pieces[1][6] = "き";
        Pieces[1][7] = "お";

        //どの種類の駒のまとまりを取り出すか決めるときにつかうグループ
        //このクラスのuse_PiecdメソッドとcasterPieceメソッドで使う予定
        Pieces[2][0] = "p";
        Pieces[2][1] = "b";
        Pieces[2][2] = "r";
        Pieces[2][3] = "l";
        Pieces[2][4] = "kn";
        Pieces[2][5] = "s";
        Pieces[2][6] = "g";
        Pieces[2][7] = "k";
    }


    public Pawn[] getPawns(){
        return pawns;
    }

    public Bishop[] getBishop() {
        return bishops;
    }

    public Rook[] getRooks() {
        return rooks;
    }

    public Lance[] getLances() {
        return lances;
    }

    public Knight[] getKnights() {
        return knights;
    }

    public Silver_General[] getSilvers() {
        return silvers;
    }

    public Gold_General[] getGolds() {
        return golds;
    }

    public King[] getKings() {
        return kings;
    }

    public Pawn castPawns(Piece piece){
        return (Pawn)piece;
    }

    public Bishop castBishop(Piece piece) {
        return (Bishop)piece;
    }

    public Rook castRooks(Piece piece) {
        return (Rook)piece;
    }

    public Lance castLances(Piece piece) {
        return (Lance)piece;
    }

    public Knight castKnights(Piece piece) {
        return (Knight)piece;
    }

    public Silver_General castSilvers(Piece piece) {
        return (Silver_General)piece;
    }

    public Gold_General castGolds(Piece piece) {
        return (Gold_General)piece;
    }

    public King castKings(Piece piece) {
        return (King)piece;
    }


    //JudgeクラスのJudge_Pieceメソッドで使う
    //指定した種類の駒を取り出すメソッド
    public void use_Piece(String str,Piece[] pieces){
        switch (str){
            case "p":
                pieces = new Pawn[18];
                pieces = getPawns();
                break;
            case "b:":
                pieces = new Bishop[2];
                pieces = getBishop();
                break;
            case "r":
                pieces = new Rook[2];
                pieces = getRooks();
                break;
            case "l":
                pieces = new Lance[4];
                pieces = getLances();
                break;
            case "kn":
                pieces = new Knight[4];
                pieces = getKnights();
                break;
            case "s":
                pieces = new Silver_General[4];
                pieces = getSilvers();
                break;
            case "g":
                pieces = new Gold_General[4];
                pieces = getGolds();
                break;
            case "k":
                pieces = new King[2];
                pieces = getKings();
        }
    }

    //Pieceからいろんな型へcastするメソッド。　JudgeクラスのJudge_Pieceメソッドで使う
    //Piece型だとそれぞれの駒の動きを表すcan_Movementメソッドが使えないので、これをつかってcastする
    public void casterPiece(String str,Piece pieces, Pawn p,Bishop b,Rook r,Lance l,Knight kn,Silver_General s,Gold_General g, King k){
        switch (str){
            case "p":
                p = castPawns(pieces);
                break;
            case "b:":
                b = castBishop(pieces);
                break;
            case "r":
                r = castRooks(pieces);
                break;
            case "l":
                l = castLances(pieces);
                break;
            case "kn":
                kn = castKnights(pieces);
                break;
            case "s":
                s = castSilvers(pieces);
                break;
            case "g":
                g = castGolds(pieces);
                break;
            case "k":
                k = castKings(pieces);
        }
    }

    //作成中
    public void Play(int x, int y, String piece){

        System.out.println("先行の番です。動かす駒を選んでください");

    }


}