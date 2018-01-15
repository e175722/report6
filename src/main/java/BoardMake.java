import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//将棋盤を表示するクラス
public class BoardMake {
    String[][] block; //２次元配列のblockを用意
    boolean turn; //先行が打ってる時はtrue,後攻が打ってる時はfalse
    boolean match = true; //trueの間は試合が続く、falseになったら試合終了
    int[] Coordinate = new int[4];

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
    Gold_General[] golds = new Gold_General[4];
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
                block[g][h] = "　";
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
            block[0][r] = "　";
            block[r][19] = "　";
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

    public void PrintBoard(BoardMake board) {
        int n;
        for (n = 0; n < 20; n++) {
            String[] test = board.block[n];
            String test2 = String.join("", test);
            System.out.println(test2);
        }
    }

    //半角数字を全角数字に変換するメソッド
    public static String hanNum2ZenNum(String s) {
        StringBuffer sb = new StringBuffer(s);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                sb.setCharAt(i, (char) (c - '0' + '０'));
            }
        }
        return sb.toString();
    }

    public void Location() {
        int u, v, w, z;

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

        //歩の駒配置
        for (u = 0; u < 18; u++) {
            if (u <= 8) {
                pawns[u].Player_Piece = true;
                pawns[u].Movement(xChange(u + 1), yChange(7));
            } else {
                pawns[u].Player_Piece = false;
                pawns[u].Movement(xChange(u - 8), yChange(3));
            }
        }
        for (v = 0; v < 18; v++) {
            if (pawns[v].Player_Piece == true) {
                block[yChange(7)][xChange(v + 1)] = "歩";
            } else if (pawns[v].Player_Piece == false) {
                block[yChange(3)][xChange(v - 8)] = "ふ";
            }
        }

        //王の駒配置
        kings[0].Player_Piece = true;
        kings[0].Movement(xChange(5), yChange(9));
        kings[1].Player_Piece = false;
        kings[1].Movement(xChange(5), yChange(1));
        for (w = 0; w < 2; w++) {
            if (kings[w].Player_Piece == true) {
                block[yChange(9)][xChange(5)] = "王";
            } else if (kings[w].Player_Piece == false) {
                block[yChange(1)][xChange(5)] = "お";
            }
        }

        //角の駒配置
        bishops[0].Player_Piece = true;
        bishops[0].Movement(xChange(8), yChange(8));
        bishops[1].Player_Piece = false;
        bishops[1].Movement(xChange(2), yChange(2));
        for (w = 0; w < 2; w++) {
            if (bishops[w].Player_Piece == true) {
                block[yChange(8)][xChange(8)] = "角";
            } else if (kings[w].Player_Piece == false) {
                block[yChange(2)][xChange(2)] = "か";
            }
        }

        //飛車の駒配置
        rooks[0].Player_Piece = true;
        rooks[0].Movement(xChange(2), yChange(8));
        rooks[1].Player_Piece = false;
        rooks[1].Movement(xChange(8), yChange(2));
        for (w = 0; w < 2; w++) {
            if (rooks[w].Player_Piece == true) {
                block[yChange(8)][xChange(2)] = "飛";
            } else if (rooks[w].Player_Piece == false) {
                block[yChange(2)][xChange(8)] = "ひ";
            }
        }

        //金の駒配置
        for (u = 0; u < 4; u++) {
            if (u <= 1) {
                golds[u].Player_Piece = true;
                golds[u].Movement(xChange((u * 2) + 4), yChange(9));
            } else {
                golds[u].Player_Piece = false;
                golds[u].Movement(xChange(((u - 2) * 2) + 4), yChange(1));
            }
        }
        for (v = 0; v < 4; v++) {
            if (golds[v].Player_Piece == true) {
                block[yChange(9)][xChange((v * 2) + 4)] = "金";
            } else if (golds[v].Player_Piece == false) {
                block[yChange(1)][xChange(((v - 2) * 2) + 4)] = "き";
            }
        }

        //銀の駒配置
        for (u = 0; u < 4; u++) {
            if (u <= 1) {
                silvers[u].Player_Piece = true;
                silvers[u].Movement(xChange((u * 4) + 3), yChange(9));
            } else {
                silvers[u].Player_Piece = false;
                silvers[u].Movement(xChange(((u - 2) * 4) + 3), yChange(1));
            }
        }
        for (v = 0; v < 4; v++) {
            if (golds[v].Player_Piece == true) {
                block[yChange(9)][xChange((v * 4) + 3)] = "銀";
            } else if (golds[v].Player_Piece == false) {
                block[yChange(1)][xChange(((v - 2) * 4) + 3)] = "ぎ";
            }
        }
        //桂馬の駒配置
        for (u = 0; u < 4; u++) {
            if (u <= 1) {
                knights[u].Player_Piece = true;
                knights[u].Movement(xChange((u * 6) + 2), yChange(9));
            } else {
                knights[u].Player_Piece = false;
                knights[u].Movement(xChange(((u - 2) * 6) + 2), yChange(1));
            }
        }
        for (v = 0; v < 4; v++) {
            if (knights[v].Player_Piece == true) {
                block[yChange(9)][xChange((v * 6) + 2)] = "桂";
            } else if (knights[v].Player_Piece == false) {
                block[yChange(1)][xChange(((v - 2) * 6) + 2)] = "け";
            }
        }

        //香車の駒配置
        for (u = 0; u < 4; u++) {
            if (u <= 1) {
                lances[u].Player_Piece = true;
                lances[u].Movement(xChange((u * 8) + 1), yChange(9));
            } else {
                lances[u].Player_Piece = false;
                lances[u].Movement(xChange(((u - 2) * 8) + 1), yChange(1));
            }
        }
        for (v = 0; v < 4; v++) {
            if (lances[v].Player_Piece == true) {
                block[yChange(9)][xChange((v * 8) + 1)] = "香";
            } else if (lances[v].Player_Piece == false) {
                block[yChange(1)][xChange(((v - 2) * 8) + 1)] = "こ";
            }
        }
    }


    public int xChange(int xx) {
        if (xx == 1) {
            xx = 17;
        } else if (xx == 2) {
            xx = 15;
        } else if (xx == 3) {
            xx = 13;
        } else if (xx == 4) {
            xx = 11;
        } else if (xx == 5) {
            xx = 9;
        } else if (xx == 6) {
            xx = 7;
        } else if (xx == 7) {
            xx = 5;
        } else if (xx == 8) {
            xx = 3;
        } else if (xx == 9) {
            xx = 1;
        }
        return xx;
    }

    public int yChange(int yy) {
        if (yy == 1) {
            yy = 2;
        } else if (yy == 2) {
            yy = 4;
        } else if (yy == 3) {
            yy = 6;
        } else if (yy == 4) {
            yy = 8;
        } else if (yy == 5) {
            yy = 10;
        } else if (yy == 6) {
            yy = 12;
        } else if (yy == 7) {
            yy = 14;
        } else if (yy == 8) {
            yy = 16;
        } else if (yy == 9) {
            yy = 18;
        }
        return yy;
    }


    //JudgeクラスのpieceJudgeメソッドで使うためのpiece変数を作るためのメソッド
    //中身は駒の種類ごと順番よく並んでるので、順番よく取り出して使える
    public void MakePiece() {
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


    public Pawn[] getPawns() {
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

    public Pawn castPawns(Piece piece) {
        return (Pawn) piece;
    }

    public Bishop castBishop(Piece piece) {
        return (Bishop) piece;
    }

    public Rook castRooks(Piece piece) {
        return (Rook) piece;
    }

    public Lance castLances(Piece piece) {
        return (Lance) piece;
    }

    public Knight castKnights(Piece piece) {
        return (Knight) piece;
    }

    public Silver_General castSilvers(Piece piece) {
        return (Silver_General) piece;
    }

    public Gold_General castGolds(Piece piece) {
        return (Gold_General) piece;
    }

    public King castKings(Piece piece) {
        return (King) piece;
    }


    //JudgeクラスのJudge_Pieceメソッドで使う
    //指定した種類の駒を取り出すメソッド
    public Piece[] use_Piece(String str) {
        Piece[] piece = null;
        switch (str) {
            case "p":
                piece = pawns;
                break;
            case "b":
                piece = bishops;
                break;
            case "r":
                piece = rooks;
                break;
            case "l":
                piece = lances;
                break;
            case "kn":
                piece = knights;
                break;
            case "s":
                piece = silvers;
                break;
            case "g":
                piece = golds;
                break;
            case "k":
                piece = kings;
        }
        return piece;
    }

    //Pieceからいろんな型へcastするメソッド。　JudgeクラスのJudge_Pieceメソッドで使う
    //Piece型だとそれぞれの駒の動きを表すcan_Movementメソッドが使えないので、これをつかってcastする
    public void casterPiece(String str, Piece pieces, Pawn p, Bishop b, Rook r, Lance l, Knight kn, Silver_General s, Gold_General g, King k) {
        switch (str) {
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
}