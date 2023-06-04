package main;

import java.util.Random;
import java.util.Scanner;

import static methods.Methods.*;

public class TicTacToe {


    public static void main(String[] args) {

        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', ' ', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        while (true) {
            System.out.println("Player's turn");
            placePiecePlayer(gameBoard, "player", sc);
            printGameBoard(gameBoard);

            if (!checkWinner().equals("")) {
                System.out.println(checkWinner());
                break;
            }

            System.out.println("------------------------------------");

            System.out.println("Turn of Cpu");
            placePieceCpu(gameBoard, "cpu", rd);
            printGameBoard(gameBoard);

            if (!checkWinner().equals("")) {
                System.out.println(checkWinner());
                break;
            }
        }
    }
}

