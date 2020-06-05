package BuscaminaJuego;

public class Display {
    public static void display(String[][] board) {

        for (int a = 0; a < 10; a++) {
            System.out.printf("|");
            for (int j= 0; j < 10; j++) {
                System.out.printf(board[a][j] + "|");
            }
            System.out.println("\n---------------------");
        }
    }

    public static boolean prompt(int i, int j){
        if(i > 10 || i < 1 || j > 10 || j < 1){
            System.out.println("Please choose valid indexes");
            return true;
        }
        return false;
    }

    public static void lose(){
        System.out.println("You lost :C");
    }

    public static void win(){
        System.out.println("You win :)");
    }
}
