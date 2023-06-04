package methods;

import java.util.*;

public class Methods {
    static ArrayList<Integer> playerPositions = new ArrayList<>();
    static ArrayList<Integer> cpuPositions = new ArrayList<>();

    public static String checkWinner() {

        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> middleRow = Arrays.asList(4, 5, 6);
        List<Integer> botRow = Arrays.asList(7, 8, 9);
        List<Integer> leftCol = Arrays.asList(1, 4, 7);
        List<Integer> midCol = Arrays.asList(2, 5, 8);
        List<Integer> rightCol = Arrays.asList(3, 6, 9);
        List<Integer> cross1 = Arrays.asList(1, 5, 9);
        List<Integer> cross2 = Arrays.asList(3, 5, 7);
        List<List> winning = new ArrayList<>();
        winning.add(topRow);
        winning.add(middleRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);
        for (List l : winning) {

            if (playerPositions.containsAll(l)) {
                return "You won!!!";
            } else if (cpuPositions.containsAll(l)) {
                return "Cpu won!!!";
            } else if (playerPositions.size() + cpuPositions.size() == 9) {
                return "Draw!!!";
            }
        }
        return "";
    }

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            System.out.println(row);
        }
    }

    public static void placePieceCpu(char[][] gameBoard, String user, Random rd) {

        int cpuPos = rd.nextInt(9) + 1;
        while (cpuPositions.contains(cpuPos) || playerPositions.contains(cpuPos)) {
            cpuPos = rd.nextInt(9) + 1;
        }
        char symbol = ' ';

        if (user.equals("player")) {
            symbol = 'X';
            playerPositions.add(cpuPos);
        } else if (user.equals("cpu")) {
            symbol = 'O';
            cpuPositions.add(cpuPos);
        }

        switch (cpuPos) {
            case 1 -> gameBoard[0][0] = symbol;

            case 2 -> gameBoard[0][2] = symbol;

            case 3 -> gameBoard[0][4] = symbol;

            case 4 -> gameBoard[2][0] = symbol;

            case 5 -> gameBoard[2][2] = symbol;

            case 6 -> gameBoard[2][4] = symbol;

            case 7 -> gameBoard[4][0] = symbol;

            case 8 -> gameBoard[4][2] = symbol;

            case 9 -> gameBoard[4][4] = symbol;
        }
    }

    public static void placePiecePlayer(char[][] gameBoard, String user, Scanner sc) {
        System.out.println("Enter your placement (1-9)");
        int pos = sc.nextInt();
        while (playerPositions.contains(pos) || cpuPositions.contains(pos)) {
            System.out.print("Position taken! Enter a new position: ");
            pos = sc.nextInt();
        }
        char symbol = ' ';

        if (user.equals("player")) {
            symbol = 'X';
            playerPositions.add(pos);
        } else if (user.equals("cpu")) {
            symbol = 'O';
            cpuPositions.add(pos);
        }

        switch (pos) {
            case 1 -> gameBoard[0][0] = symbol;

            case 2 -> gameBoard[0][2] = symbol;

            case 3 -> gameBoard[0][4] = symbol;

            case 4 -> gameBoard[2][0] = symbol;

            case 5 -> gameBoard[2][2] = symbol;

            case 6 -> gameBoard[2][4] = symbol;

            case 7 -> gameBoard[4][0] = symbol;

            case 8 -> gameBoard[4][2] = symbol;

            case 9 -> gameBoard[4][4] = symbol;
        }
    }
}