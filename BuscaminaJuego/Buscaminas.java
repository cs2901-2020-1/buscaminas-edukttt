package BuscaminaJuego;
import java.util.Scanner;

public class Buscaminas {

    public static int checkNearby(String [][] board, int x, int y){
        int cnt = 0;
	    if(x != 9 && board[x+1][y].equals("*")){     //derecho
            cnt +=1;
        }
	    if(y != 0 && board[x][y-1].equals("*")){     //superior
            cnt +=1;
        }
	    if(y != 0 && x != 9 && board[x+1][y-1].equals("*")){   //superior derecho
            cnt +=1;
        }
	    if(y != 0 && x != 0 && board[x-1][y-1].equals("*")){   //superior izquierdo
            cnt +=1;
        }
	    if(x != 0 && board[x-1][y].equals("*")){     //izquierdo
            cnt +=1;
        }
	    if(x != 0 && y != 9 && board[x-1][y+1].equals("*")){   //inferior izquierdo
            cnt +=1;
        }
	    if(y != 9 && board[x][y+1].equals("*")){     //inferior
            cnt +=1;
        }
	    if(y != 9 && x != 9 && board[x+1][y+1].equals("*")){   //inferior derecho
            cnt +=1;
        }
        return cnt;
    }

    public static void fill(String [][] board){

        for (int a = 0; a < 10; a++) {
            for (int j= 0; j < 10; j++) {
                if(Math.random()*10 < 2)
                    board[a][j] = "*";
                else
                    board[a][j]= " ";
            }
        }
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
        if(x != 9 && (!board[x+1][y].equals("*"))){     //derecho
            if(board[x+1][y].equals(" ")){
                board[x+1][y] = ".";
                checkAround(board, displayedBoard, x+1, y);
            }
            // else
                displayedBoard[x+1][y] = board[x+1][y];
        }
	    if(y != 0 && !board[x][y-1].equals("*")){     //superior
            if(board[x][y-1].equals(" ")){
                board[x][y-1] = ".";
                checkAround(board, displayedBoard, x, y-1);
            }
            // else
                displayedBoard[x][y-1] = board[x][y-1];
        }
	    if(y != 0 && x != 9 && !board[x+1][y-1].equals("*")){   //superior derecho
            if(board[x+1][y-1].equals(" ")){
                board[x+1][y-1] = ".";
                checkAround(board, displayedBoard, x+1, y-1);
            }
            // else
                displayedBoard[x+1][y-1] = board[x+1][y-1];
        }
	    if(y != 0 && x != 0 && !board[x-1][y-1].equals("*")){   //superior izquierdo
            if(board[x-1][y-1].equals(" ")){
                board[x-1][y-1] = ".";
                checkAround(board, displayedBoard, x-1, y-1);
            }
            // else
                displayedBoard[x-1][y-1] = board[x-1][y-1];
        }
	    if(x != 0 && !board[x-1][y].equals("*")){     //izquierdo
            if(board[x-1][y].equals(" ")){
                board[x-1][y] = ".";
                checkAround(board, displayedBoard, x-1, y);
            }
            // else
                displayedBoard[x-1][y] = board[x-1][y];
        }
	    if(x != 0 && y != 9 && !board[x-1][y+1].equals("*")){   //inferior izquierdo
            if(board[x-1][y+1].equals(" ")){
                board[x-1][y+1] = ".";
                checkAround(board, displayedBoard, x-1, y+1);
            }
            // else
                displayedBoard[x-1][y+1] = board[x-1][y+1];
        }
	    if(y != 9 && !board[x][y+1].equals("*")){     //inferior
            if(board[x][y+1].equals(" ")){
                board[x][y+1] = ".";
                checkAround(board, displayedBoard, x, y+1);
            }
            // else
                displayedBoard[x][y+1] = board[x][y+1];
        }
	    if(y != 9 && x != 9 && !board[x+1][y+1].equals("*")){   //inferior derecho
            if(board[x+1][y+1].equals(" ")){
                board[x+1][y+1] = ".";
                checkAround(board, displayedBoard, x+1, y+1);
            }
            // else
                displayedBoard[x+1][y+1] = board[x+1][y+1];
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
            displayedBoard[x][y] = board[x][y];
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
        while(select(board, displayedBoard, input)){
            Display.display(displayedBoard);
        }
    }
}
