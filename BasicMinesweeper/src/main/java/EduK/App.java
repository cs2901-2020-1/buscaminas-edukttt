package EduK;

public class App 
{
    static Scanner in;
    static String[] board;
    static String turn;

    public static void App(String[] args) {
        in = new Scanner(System.in);
        String [][] board = new String[10][10];
        String [][] displayedBoard = new String[10][10];
        Buscaminas.run(board, displayedBoard);

        TicTacToe.run(board, turn, in);
    }
}
