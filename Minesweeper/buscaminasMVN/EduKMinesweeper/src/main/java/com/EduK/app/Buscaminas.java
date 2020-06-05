package BuscaminaJuego;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Buscaminas {
    private static int bombs=0;
    private static int box=0;
    private static List<Integer> posx = new ArrayList<>(List.of(-1,-1,-1, 0, 0, 1, 1, 1));
    private static List<Integer> posy = new ArrayList<>(List.of(-1, 0, 1,-1, 1,-1, 0, 1));
    private static List<Integer> checkx = new ArrayList<>(List.of(0, 0, 0,-1,-1, 9, 9, 9));
    private static List<Integer> checky = new ArrayList<>(List.of(0,-1, 9, 0, 9, 0,-1, 9));


    public static int checkNearby(String [][] board, int x, int y){
        int cnt = 0;
        for(int i=0; i<8; i++){
            if(x != checkx.get(i) && y != checky.get(i) && board[x+posx.get(i)][y+posy.get(i)].equals("*")){
                cnt++;
            }
        }
        return cnt;
    }

    public static void fill(String [][] board){

        for (int a = 0; a < 10; a++) {
            for (int j= 0; j < 10; j++) {
                if(Math.random()*10 < 2) {
                    board[a][j] = "*";
                    bombs++;
                }else
                    board[a][j]= " ";
            }
        }
        box = 100-bombs;
        int cont = 0;
        for (int a = 0; a < 10; a++) {
            for (int j= 0; j < 10; j++) {
                if(board[a][j].equals(" ")){
                    cont = checkNearby(board, a, j);
                    if (cont != 0) board[a][j] = String.valueOf(cont);
                }
            }
        }
    }

    public static void fillDisplay(String[][] displayBoard){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                displayBoard[i][j] = "#";
            }
        }
    }



    public static boolean look(String[][] board, int x, int y){
        if (board[x][y].equals("*")) return false; else return true;
    }

    public static void checkAround(String[][] board, String[][] displayedBoard, int x, int y){
        for(int i=0; i<8; i++){
            if(x != checkx.get(i) && y != checky.get(i) && (!board[x+posx.get(i)][y+posy.get(i)].equals("*"))){
                if(board[x+posx.get(i)][y+posy.get(i)].equals(" ")){
                    board[x+posx.get(i)][y+posy.get(i)] = ".";
                    checkAround(board, displayedBoard, x+posx.get(i), y+posy.get(i));
                }
                if(displayedBoard[x+posx.get(i)][y+posy.get(i)].equals("#")) box--;
                displayedBoard[x+posx.get(i)][y+posy.get(i)] = board[x+posx.get(i)][y+posy.get(i)];
            }
        }
    }

    public static boolean repeated(String[][] displayedBoard, int x, int y){
        if (!displayedBoard[x-1][y-1].equals("#")){
            System.out.println("Please choose unknown indexes");
            return true;
        }
        return false;
    }
    public static boolean select(String[][] board, String[][] displayedBoard, Scanner input){
        int x = 0;
        int y = 0;
        do {
            x = Integer.parseInt(input.nextLine());
            y = Integer.parseInt(input.nextLine());
        } while(Display.prompt(x,y) || repeated(displayedBoard, x, y));
        x -= 1; y -= 1;
        if (look(board, x, y) ){
            displayedBoard[x][y] = board[x][y]; box--;
            checkAround(board, displayedBoard, x, y);
            return true;
        }
        Display.lose();
        return false;
    }

    public static void run(String[][] board, String [][] displayedBoard){
        fill(board);
        fillDisplay(displayedBoard);
        Display.display(board);
        Display.display(displayedBoard);
        Scanner input = new Scanner(System.in);
        while(box != 0 && select(board, displayedBoard, input)){
            Display.display(displayedBoard);
        }
        if (box==0)
            Display.win();
    }
}
