public class Buscaminas {
    public static void fill(String [][] board){

        for (int a = 0; a < 10; a++) {
            for (int j= 0; j < 10; j++) {
                if(Math.random() < 2)
                    board[a][j] = "*";
            }
        }
    }

    public static void fillDisplay(String[][] displayBoard){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                displayBoard[i][j] = '#';
            }
        }
    }

    public static void select(int i, int j){
        if(i > 10 || i < 1 || j > 10 || j < 1)
            System.out.println("Please choose valid indexes");
    }
    
    public static void run(String [][] board, String [][] displayedBoard){
        fill(board);
        Display.display(board);
        Display.display(displayedBoard);
    }
}
