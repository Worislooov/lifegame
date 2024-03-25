import java.util.Random;
import java.lang.Thread;

public class Main {
    public static void clearScreen() {
        for (int i = 0; i < 80; i++){
            System.out.println();
        }
    }

    public static int[][] setBoard(int board_size) {
        int[][] board = new int[board_size][board_size];
        for (int i = 0; i < board_size; i++) {
            for (int j = 0; j < board_size; j++) {
                board[i][j] = 0;
            }
        }
        return board;
    }

    public static int[][] fillBoard(int[][] board) {
        Random r = new Random();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = r.nextInt(3);
            }
        }
        return board;
    }

    public static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    System.out.print("# ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }




    public static int[][] playGame(int[][] board) {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                int count = 0;
                for (int k = -1; k < 2; k++){
                    for (int l = -1; l < 2; l++){
                        try{
                            if ((board[i+k][j+l] ==1 )&& (k!= i && l != j)){
                                count++;
                            }
                        }
                        catch(Exception e){
                            continue;
                        }
                    }
                }
                if (count >= 2 && count <= 4){
                    board[i][j] = 1;
                }
                else{
                    board[i][j] = 0;
                }
            }
        }
        return board;
    }

    public static boolean isPlaying(int[][] board) {
        /*
         * for (int i = 0; i < board.length; i++) {
         * for (int j = 0; j < board[i].length; j++) {
         * if (board[i][j] == 1) {
         * return true;
         * }
         * }
         * return false;
         */
        // пока ничего нету, скорее всего и не понадобится:3
        return true;
    }

    public static void main(String[] args) {
        int[][] gameboard = setBoard(6);
        gameboard = fillBoard(gameboard);
        while (isPlaying(gameboard)) {
            clearScreen();
            gameboard = playGame(gameboard);
            printBoard(gameboard);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}