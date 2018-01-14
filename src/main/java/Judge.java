public class Judge{


    //trueのターンにfalseの駒と重なったらfalseの駒をtrueに変える（逆も）
    public void Rob(Piece piece ,BoardMake board) {
        if (board.turn == true) {
            piece.Player_Piece = true;
            piece.Alive = false;
        }
        else if (board.turn == false){
            piece.Player_Piece = false;
            piece.Alive = false;
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

    public void Judge_Piece(BoardMake board , int x1,int y1,int x2,int y2) {
        int i, j, k, l;
        Piece temp1 = null;
        Piece temp2 = null;
        Piece[] temp3 = null;

        Pawn tempPawnForFA = null; //FA = first atacker
        Pawn tempPawnForSA = null; //SA = second atacker
        Bishop tempBishopForFA = null;
        Bishop tempBishopForSA = null;
        Rook tempRookForFA = null;
        Rook tempRookForSA = null;
        Lance tempLanceForFA = null;
        Lance tempLanceForSA = null;
        Knight tempKnightForFA = null;
        Knight tempKnightForSA = null;
        Silver_General tempSilverForFA = null;
        Silver_General tempSilverForSA = null;
        Gold_General tempGoldForFA = null;
        Gold_General tempGoldForSA = null;
        King tempKingForFA = null;
        King tempKingForSA = null;


        if (board.turn == true) {//先行の場合

            for (i = 0; i < 8; i++) {//動かす駒の種類を取得
                if (board.block[x1][y1] == board.Pieces[0][i]) {
                    board.use_Piece(board.Pieces[2][i], temp3);

                    for (j = 0; j < temp3.length; j++) {//種類を把握したあと、その種類のどの駒か把握
                        if (x1 == temp3[j].X & y1 == temp3[j].Y) {
                            temp1 = temp3[j];
                            board.casterPiece(board.Pieces[2][i], temp1, tempPawnForFA, tempBishopForFA, tempRookForFA, tempLanceForFA, tempKnightForFA, tempSilverForFA, tempGoldForFA, tempKingForFA);
                        }
                    }
                }
            }
            for (k = 0; k < 8; k++) {//動かそうとしてる場所に駒があるかどうか。　なければtemp2の中身はnullのまま
                if (board.block[x2][y2] == board.Pieces[1][k]) {
                    board.use_Piece(board.Pieces[2][k], temp3);

                    for (l = 0; l < temp3.length; l++) {//駒があったとして、どの種類の駒か把握
                        if (x2 == temp3[l].X & y2 == temp3[l].Y) {
                            temp2 = temp3[l];
                            board.casterPiece(board.Pieces[2][k], temp2, tempPawnForSA, tempBishopForSA, tempRookForSA, tempLanceForSA, tempKnightForSA, tempSilverForSA, tempGoldForSA, tempKingForSA);
                        }
                    }
                }
            }

            if (temp1 == null) {
                System.out.println("そこには駒はないぞ(>Д<)");
            } else if (temp1.Player_Piece == false) {
                System.out.println("君の駒じゃないよ(>Д<)");
            } else if (temp2 == null) {
                if (i == 0) {
                    tempPawnForFA.can_Movement(x2, y2);
                    board.block[x1][y1] = "　";
                    board.block[x2][y2] = "歩";
                } else if (i == 1) {
                    tempBishopForFA.can_Movement(x2, y2);
                    board.block[x1][y1] = "　";
                    board.block[x2][y2] = "角";
                } else if (i == 2) {
                    tempRookForFA.can_Movement(x2, y2);
                    board.block[x1][y1] = "　";
                    board.block[x2][y2] = "飛";
                } else if (i == 3) {
                    tempLanceForFA.can_Movemet(x2, y2);
                    board.block[x1][y1] = "　";
                    board.block[x2][y2] = "香";
                } else if (i == 4) {
                    tempKnightForFA.can_Movement(x2, y2);
                    board.block[x1][y1] = "　";
                    board.block[x2][y2] = "桂";
                } else if (i == 5) {
                    tempSilverForFA.can_Movement(x2, y2);
                    board.block[x1][y1] = "　";
                    board.block[x2][y2] = "銀";
                } else if (i == 6) {
                    tempGoldForFA.can_Movement(x2, y2);
                    board.block[x1][y1] = "　";
                    board.block[x2][y2] = "金";
                } else if (i == 7) {
                    tempKingForFA.can_Movement(x2, y2);
                    board.block[x1][y1] = "　";
                    board.block[x2][y2] = "王";
                }
            } else if (temp1.Player_Piece == temp2.Player_Piece) {
                System.out.println("味方がいるよ(>Д<)");
            } else if (temp1.Player_Piece != temp2.Player_Piece) {
                if (i == 0) {
                    Rob(tempPawnForSA, board);
                    tempPawnForFA.can_Movement(x2, y2);
                    board.block[x1][y1] = "　";
                    board.block[x2][y2] = "歩";
                } else if (i == 1) {
                    Rob(tempBishopForSA, board);
                    tempBishopForFA.can_Movement(x2, y2);
                    board.block[x1][y1] = "　";
                    board.block[x2][y2] = "角";
                } else if (i == 2) {
                    Rob(tempRookForSA, board);
                    tempRookForFA.can_Movement(x2, y2);
                    board.block[x1][y1] = "　";
                    board.block[x2][y2] = "飛";
                } else if (i == 3) {
                    Rob(tempLanceForSA, board);
                    tempLanceForFA.can_Movemet(x2, y2);
                    board.block[x1][y1] = "　";
                    board.block[x2][y2] = "香";
                } else if (i == 4) {
                    Rob(tempKnightForSA, board);
                    tempKnightForFA.can_Movement(x2, y2);
                    board.block[x1][y1] = "　";
                    board.block[x2][y2] = "桂";
                } else if (i == 5) {
                    Rob(tempSilverForSA, board);
                    tempSilverForFA.can_Movement(x2, y2);
                    board.block[x1][y1] = "　";
                    board.block[x2][y2] = "銀";
                } else if (i == 6) {
                    Rob(tempGoldForSA, board);
                    tempGoldForFA.can_Movement(x2, y2);
                    board.block[x1][y1] = "　";
                    board.block[x2][y2] = "金";
                } else if (i == 7) {
                    Rob(tempKingForSA, board);
                    tempKingForFA.can_Movement(x2, y2);
                    board.block[x1][y1] = "　";
                    board.block[x2][y2] = "王";
                }
            }

        } else if (board.turn == false) {//後攻の場合
            for (i = 0; i < 8; i++) {//動かす駒の種類を取得
                if (board.block[x1][y1] == board.Pieces[1][i]) {
                    board.use_Piece(board.Pieces[2][i], temp3);

                    for (j = 0; j < temp3.length; j++) {//種類を把握したあと、その種類のどの駒か把握
                        if (x1 == temp3[j].X & y1 == temp3[j].Y) {
                            temp1 = temp3[j];
                            board.casterPiece(board.Pieces[2][i], temp1, tempPawnForFA, tempBishopForFA, tempRookForFA, tempLanceForFA, tempKnightForFA, tempSilverForFA, tempGoldForFA, tempKingForFA);
                        }
                    }
                }
            }
            for (k = 0; k < 8; k++) {//動かそうとしてる場所に駒があるかどうか。　なければtemp2の中身はnullのまま
                if (board.block[x2][y2] == board.Pieces[0][k]) {
                    board.use_Piece(board.Pieces[2][k], temp3);

                    for (l = 0; l < temp3.length; l++) {//駒があったとして、どの種類の駒か把握
                        if (x2 == temp3[l].X & y2 == temp3[l].Y) {
                            temp2 = temp3[l];
                            board.casterPiece(board.Pieces[2][k], temp2, tempPawnForSA, tempBishopForSA, tempRookForSA, tempLanceForSA, tempKnightForSA, tempSilverForSA, tempGoldForSA, tempKingForSA);
                        }
                    }
                }
            }
            if (temp1 == null) {
                System.out.println("そこには駒はないぞ(>Д<)");
            } else if (temp1.Player_Piece == false) {
                System.out.println("君の駒じゃないよ(>Д<)");
            }

            if (temp2 == null) {//動かす場所に駒がない場合
                if (i == 0) {
                    tempPawnForFA.can_Movement(x2, y2);
                    board.block[x1][y1] = "　";
                    board.block[x2][y2] = "ふ";
                } else if (i == 1) {
                    tempBishopForFA.can_Movement(x2, y2);
                    board.block[x1][y1] = "　";
                    board.block[x2][y2] = "か";
                } else if (i == 2) {
                    tempRookForFA.can_Movement(x2, y2);
                    board.block[x1][y1] = "　";
                    board.block[x2][y2] = "ひ";
                } else if (i == 3) {
                    tempLanceForFA.can_Movemet(x2, y2);
                    board.block[x1][y1] = "　";
                    board.block[x2][y2] = "こ";
                } else if (i == 4) {
                    tempKnightForFA.can_Movement(x2, y2);
                    board.block[x1][y1] = "　";
                    board.block[x2][y2] = "け";
                } else if (i == 5) {
                    tempSilverForFA.can_Movement(x2, y2);
                    board.block[x1][y1] = "　";
                    board.block[x2][y2] = "ぎ";
                } else if (i == 6) {
                    tempGoldForFA.can_Movement(x2, y2);
                    board.block[x1][y1] = "　";
                    board.block[x2][y2] = "き";
                } else if (i == 7) {
                    tempKingForFA.can_Movement(x2, y2);
                    board.block[x1][y1] = "　";
                    board.block[x2][y2] = "お";
                }
            } else if (temp1.Player_Piece == temp2.Player_Piece) {//動かしたい場所に駒があって、自分のだった場合
                System.out.println("味方がいるよ(>Д<)");
            } else if (temp1.Player_Piece != temp2.Player_Piece) {//動かしたい場所に駒があって、相手のだった場合
                if (i == 0) {
                    Rob(tempPawnForSA, board);
                    tempPawnForFA.can_Movement(x2, y2);
                    board.block[x1][y1] = "　";
                    board.block[x2][y2] = "ふ";
                } else if (i == 1) {
                    Rob(tempBishopForSA, board);
                    tempBishopForFA.can_Movement(x2, y2);
                    board.block[x1][y1] = "　";
                    board.block[x2][y2] = "か";
                } else if (i == 2) {
                    Rob(tempRookForSA, board);
                    tempRookForFA.can_Movement(x2, y2);
                    board.block[x1][y1] = "　";
                    board.block[x2][y2] = "ひ";
                } else if (i == 3) {
                    Rob(tempLanceForSA, board);
                    tempLanceForFA.can_Movemet(x2, y2);
                    board.block[x1][y1] = "　";
                    board.block[x2][y2] = "こ";
                } else if (i == 4) {
                    Rob(tempKnightForSA, board);
                    tempKnightForFA.can_Movement(x2, y2);
                    board.block[x1][y1] = "　";
                    board.block[x2][y2] = "け";
                } else if (i == 5) {
                    Rob(tempSilverForSA, board);
                    tempSilverForFA.can_Movement(x2, y2);
                    board.block[x1][y1] = "　";
                    board.block[x2][y2] = "ぎ";
                } else if (i == 6) {
                    Rob(tempGoldForSA, board);
                    tempGoldForFA.can_Movement(x2, y2);
                    board.block[x1][y1] = "　";
                    board.block[x2][y2] = "き";

                } else if (i == 7) {
                    Rob(tempKingForSA, board);
                    tempKingForFA.can_Movement(x2, y2);
                    board.block[x1][y1] = "　";
                    board.block[x2][y2] = "お";
                }
            }
        }
    }
}