package EduK;

public class Display {
    public static void display(String[][] board) {

        for (int a = 0; a < 10; a++) {
            for (int j= 0; j < 10; j++) {
                System.out.println(board[a][j] + "|")
            }
            System.out.println("-------------------------")
        }
    }
}