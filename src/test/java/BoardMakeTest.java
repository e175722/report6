import org.junit.Test;

import static org.junit.Assert.*;

public class BoardMakeTest {
    @Test
    public void location() throws Exception {
        String test;
        BoardMake board = new BoardMake();
        board.MakeBoard();
        board.Location();
        test =board.block[board.yChange(7)][board.xChange( 8)];
        assertEquals(test,"歩");
    }

}