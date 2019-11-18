import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {

    static String[] board;
    static String turnOfPlayer;

    public static void main(String[] args) {
        board = new String[9];
        turnOfPlayer = "X";
        fillArray();
        System.out.println("Welcome to Game.");
        drawBoard();
        System.out.println("X will play first.");
        game();
    }

    public static void game() {
        int turn = 1;
        while (turn <= 10) {
            if (turn == 10) {
                System.out.println("Game over, it's a tie!");
                break;
            } else {
                turn++;
                try {
                    Scanner scanner = new Scanner(System.in);
                    if (turnOfPlayer.equals("X")) {
                        System.out.println("Enter a place for X: ");
                        int inputX = scanner.nextInt();
                        List<String> boardList = Arrays.asList(board);
                        if (boardList.get(inputX).equals("X") || boardList.get(inputX).equals("O")) {
                            System.out.println("Cannot overwrite cell!");
                            turn--;
                            drawBoard();
                        } else {
                            boardList.set(inputX, "X");
                            System.out.println("New board:");
                            drawBoard();
                            checkWinner();
                            turnOfPlayer = "O";
                        }
                    } else {
                        System.out.println("Enter a place for O: ");
                        int inputX = scanner.nextInt();
                        List<String> boardList = Arrays.asList(board);
                        if (boardList.get(inputX).equals("X") || boardList.get(inputX).equals("O")) {
                            System.out.println("Cannot overwrite cell!");
                            turn--;
                            drawBoard();
                        } else {
                            boardList.set(inputX, "O");
                            System.out.println("New board:");
                            drawBoard();
                            checkWinner();
                            turnOfPlayer = "X";
                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a number!");
                    turn--;
                    drawBoard();
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Please enter between 0 - 8");
                    turn--;
                    drawBoard();
                }
            }
        }
    }

    public static String checkWinner() {
        for (int a = 0; a < 8; a++) {
            String line = null;
            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[6] + board[4] + board[2];
                    break;
                case 7:
                    line = board[0] + board[4] + board[8];
                    break;
            }
            if (line.equals("XXX")) {
                System.out.println("Game over, X wins the game!");
                System.exit(0);
            } else if (line.equals("OOO")) {
                System.out.println("Game over, O wins the game!");
                System.exit(0);
            }
        }
        return null;
    }

    public static void drawBoard() {
        System.out.println("-------");
        System.out.println("|" + board[0] + "|" + board[1] + "|" + board[2] + "|");
        System.out.println("-------");
        System.out.println("|" + board[3] + "|" + board[4] + "|" + board[5] + "|");
        System.out.println("-------");
        System.out.println("|" + board[6] + "|" + board[7] + "|" + board[8] + "|");
        System.out.println("-------");
    }

    public static void fillArray() {
        for (int i = 0; i < 9; i++) {
            board[i] = String.valueOf(i);
        }
    }
}
