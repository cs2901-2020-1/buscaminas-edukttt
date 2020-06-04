package EduK;

import java.util.*

public class Buscaminas {
    public static void fill(String [][] board){

        for (int a = 0; a < 10; a++) {
            for (int j= 0; j < 10; j++) {
                if(Mat.random() < 2)
                    board[a][j] = '*';
            }
        }
    }

    public static void run(String [][] board, String [][] displayedBoard){
        fill(board);
        Display.display(board);
        Display.display(displayedBoard);
    }
}