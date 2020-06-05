package com.EduK.app;

/**
 * Hello world!
 *
 */
import java.util.Scanner;

class Main {
    static Scanner in;
    static String[] board;
    static String turn;

    public static void main(String[] args) {
        System.out.println("-------------------------");
        in = new Scanner(System.in);
        String [][] board = new String[10][10];
        String [][] displayedBoard = new String[10][10];
        Buscaminas.run(board, displayedBoard);
    }

}