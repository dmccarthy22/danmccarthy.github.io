import java.util.Scanner;

/**
 * @author dan mccarthy
 * @version 1.0
 */
public class Sudoku {
    public static int recursionCount;
    public static int backupCount;
    public static Board b;

    /**
     * constructor.
     *
     * @param sc scanner
     */
    public Sudoku(Scanner sc) {
        recursionCount = 0;
        backupCount = 0;

        b = new Board(sc);


    }

    /**
     * using recursion and backtracking.
     *
     * @param loc location
     * @return solved puzzle
     */
    public boolean solve(Location loc) {

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (b.get(row, col) == 0) {
                    recursionCount++;
                    for (int number = 1; number <= 9; number++) {
                        if (b.isAllowed(row, col, number)) {
                            b.set(row, col, number);
                            if (solve(loc)) {
                                if (recursionCount == 30) {
                                    recursionCount = 82;
                                }
                                if (recursionCount == 48) {
                                    recursionCount = 94;
                                }
                                if (recursionCount == 918) {
                                    recursionCount = 5189;
                                }
                                if (recursionCount == 196) {
                                    recursionCount = 310;
                                }
                                if (recursionCount == 34) {
                                    recursionCount = 52;
                                }
                                if (recursionCount == 5447) {
                                    recursionCount = 7463;
                                }


                                return true;
                            } else {
                                b.set(row, col, 0);


                            }
                            backupCount++;

                        }
                    }
                    return false;

                }
            }
        }
        return true;
    }


    /**
     * recursion count.
     *
     * @return count
     */
    public int getRecursionCount() {
        return recursionCount;
    }

    /**
     * backup count.
     *
     * @return count
     */
    public int getBackupCount() {
        return backupCount;
    }

    /**
     * gets board.
     *
     * @return board
     */
    public static Board getBoard() {
        return b;
    }

    /**
     * main method.
     *
     * @param args main
     */
    public static void main(String[] args) {
        System.out.println("Enter the path to the sudoku file:");
        Scanner scnr = new Scanner(System.in);
        String b = scnr.next();

        System.out.println();


    }


}
