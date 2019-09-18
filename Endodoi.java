import java.util.Scanner;

/**
 * @author Daniel McCarthy
 * @version 1.0
 */
public class Endodoi {
    /**
     * @param args main
     */
    public static void main(String[] args) {

        int[][] pits = {{0, 0, 1}, {1, 0, 1}};
        playGame(pits, 0, 0, true);


    }

    /**
     * @param gamePits           array
     * @param storePlayer1       store
     * @param storePlayer2       2nd player store
     * @param selectedPit        current pit
     * @param indicatePlayerTurn whose turn
     */
    public static void drawBoard(int[][] gamePits, int storePlayer1,
                                 int storePlayer2, char selectedPit,
                                 int indicatePlayerTurn) {


        firstRow(gamePits);
        secondRow(gamePits, storePlayer1, indicatePlayerTurn);
        thirdRow(gamePits, indicatePlayerTurn, selectedPit);
        firstRow(gamePits);
        fifthRow(gamePits, storePlayer2, indicatePlayerTurn);
        sixthRow(gamePits, indicatePlayerTurn, selectedPit);
        firstRow(gamePits);
    }

    /**
     * @param gamePits array
     */
    public static void firstRow(int[][] gamePits) {
        System.out.print(" +====++==++");
        for (int i = 0; i < gamePits[0].length; i++) {
            System.out.print("----+");
        }
        System.out.println();
    }

    /**
     * @param gamePits           array
     * @param storePlayer1       player 1 store
     * @param indicatePlayerTurn whose turn
     */
    public static void secondRow(int[][] gamePits,
                                 int storePlayer1, int indicatePlayerTurn) {

        System.out.print("1|(");
        if (storePlayer1 == 0) {
            System.out.print("  ");
        } else {
            System.out.printf("%2d", storePlayer1);
        }
        System.out.print(")||");
        if (indicatePlayerTurn == 1) {
            System.out.print("\\/||");
        } else {
            System.out.print("  ||");
        }

        for (int i = 0; i < gamePits[0].length; i++) {
            if (gamePits[0][i] == 0) {
                System.out.print("(  )|");
            } else {
                System.out.print("( ");
                System.out.print(gamePits[0][i]);
                System.out.print(")|");
            }
        }
        System.out.println();


    }

    /**
     * @param gamePits           array
     * @param indicatePlayerTurn whose turn
     * @param selectedPit        character
     */
    public static void thirdRow(int[][] gamePits,
                                int indicatePlayerTurn, char selectedPit) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        System.out.print(" | st ||");
        if (indicatePlayerTurn == 1) {
            System.out.print("/\\||");
        } else {
            System.out.print("  ||");
        }
        if (indicatePlayerTurn == 2) {

            for (int i = 0; i < gamePits[1].length; i++) {
                if (alphabet[i] == selectedPit) {
                    System.out.print("  * ");
                } else {
                    System.out.print("   ");
                }
                System.out.print(" |");
            }


        } else {
            for (int i = 0; i < gamePits[1].length; i++) {
                System.out.print("  ");
                if (selectedPit == alphabet[i]) {
                    System.out.print("*");
                } else {
                    System.out.print(alphabet[i]);
                }
                System.out.print(" |");
            }


        }
        System.out.println();
    }

    /**
     * @param gamePits           array
     * @param storePlayer2       2nd store
     * @param indicatePlayerTurn whose turn
     */
    public static void fifthRow(int[][] gamePits,
                                int storePlayer2, int indicatePlayerTurn) {

        System.out.print("2|(");
        if (storePlayer2 == 0) {
            System.out.print("  ");
        } else {
            System.out.printf("%2d", storePlayer2);
        }
        System.out.print(")||");
        if (indicatePlayerTurn == 2) {
            System.out.print("\\/||");
        } else {
            System.out.print("  ||");
        }

        for (int i = 0; i < gamePits[1].length; i++) {
            if (gamePits[1][i] == 0) {
                System.out.print("(  )|");
            } else {
                System.out.print("( ");
                System.out.print(gamePits[1][i]);
                System.out.print(")|");
            }
        }
        System.out.println();
    }

    /**
     * @param gamePits           array
     * @param indicatePlayerTurn whose turn
     * @param selectedPit        character
     */
    public static void sixthRow(int[][] gamePits,
                                int indicatePlayerTurn, char selectedPit) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        System.out.print(" | st ||");
        if (indicatePlayerTurn == 2) {
            System.out.print("/\\||");
        } else {
            System.out.print("  ||");
        }
        if (indicatePlayerTurn == 1) {
            for (int i = 0; i < gamePits[1].length; i++) {
                if (alphabet[i] + gamePits[0].length == selectedPit) {
                    System.out.print("  *");
                } else {
                    System.out.print("   ");
                }
                System.out.print(" |");
            }

        } else {
            for (int i = 0; i < gamePits[1].length; i++) {
                System.out.print("  ");
                if (selectedPit == alphabet[i + gamePits[1].length]) {
                    System.out.print("*");
                } else {
                    System.out.print(alphabet[i + gamePits[0].length]);
                }
                System.out.print(" |");
            }

        }
        System.out.println();
    }

    /**
     * @param pitsPerRow how many columns
     * @param numSeeds   how many per
     * @return array of pits
     */
    public static int[][] createNewPits(int pitsPerRow, int numSeeds) {
        int[][] gamePits = new int[2][pitsPerRow];
        for (int i = 0; i < gamePits[0].length; i++) {
            gamePits[0][i] = numSeeds;
        }
        for (int j = 0; j < gamePits[1].length; j++) {
            gamePits[1][j] = numSeeds;
        }
        return gamePits;
    }

    /**
     * @param playerPits array
     * @return characters of labels
     */
    public static char[][] playerPitLabels(int[][] playerPits) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[][] labels = new char[2][playerPits[0].length];
        for (int i = 0; i < playerPits[0].length; i++) {
            labels[0][i] = alphabet[i];
        }
        for (int i = 0; i < playerPits[1].length; i++) {
            labels[1][i] = alphabet[i + playerPits[1].length];
        }
        return labels;
    }

    /**
     * @param pitLabel   how many columns
     * @param playerPits array
     * @return 1d array of coordinates
     */
    public static int[] pit2Coordinates(char pitLabel, int[][] playerPits) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int[] coordinates = new int[2];
        for (int i = 0; i < alphabet.length; i++) {
            if (pitLabel == alphabet[i]) {
                if (i < playerPits[0].length) {
                    coordinates[0] = 0;
                    coordinates[1] = i;
                    // break;
                } else {
                    coordinates[0] = 1;
                    coordinates[1] = i - playerPits[0].length;
                    break;
                }
            }
        }
        return coordinates;
    }

    /**
     * @param pit         where
     * @param playersPits array
     * @return opposite pits
     */
    public static char getOpposingPit(char pit, int[][] playersPits) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char finish = ' ';
        int[] current = pit2Coordinates(pit, playersPits);
        char[][] allLabels = playerPitLabels(playersPits);
        if (current[0] == 0) {
            finish = allLabels[1][current[1]];
        } else {
            finish = allLabels[0][current[1]];
        }


        return finish;
    }

    /**
     * @param player      who is player
     * @param pit         where pit is
     * @param playersPits array
     * @return if pit is in row
     */
    public static boolean isPitInPlayerRow(int player, char pit,
                                           int[][] playersPits) {
        boolean inRow = false;
        int[] coordinates = pit2Coordinates(pit, playersPits);
        if (player == 1) {
            if (coordinates[0] == 0) {
                inRow = true;
            } else {
                inRow = false;
            }
        }
        if (player == 2) {
            if (coordinates[0] == 1) {
                inRow = true;
            } else {
                inRow = false;
            }
        }
        return inRow;
    }

    /**
     * @param currentPit  where current is
     * @param playersPits 2d array
     * @return next pit
     */
    public static char nextPit(char currentPit, int[][] playersPits) {
        char next = ' ';
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int[] location = pit2Coordinates(currentPit, playersPits);
        if (currentPit == 'a') {
            next = getOpposingPit(currentPit, playersPits);
        } else if ((location[1] == playersPits[0].length - 1)
                && (location[0]) != 0) {
            next = getOpposingPit(currentPit, playersPits);
            return next;
        } else if (location[0] == 1) {
            next = alphabet[location[1] + 1 + playersPits[0].length];

        } else if ((location[0] == 0) && (currentPit != 'a')) {
            next = alphabet[location[1] - 1];

        }


        return next;
    }

    /**
     * @param pit         where its located
     * @param playersPits 2d array
     * @return number of seeds in pit
     */
    public static int getPitSeedCount(char pit, int[][] playersPits) {
        int[] location = pit2Coordinates(pit, playersPits);
        int seeds = playersPits[location[0]][location[1]];
        return seeds;
    }

    /**
     * @param pickPit     picked pit
     * @param playersPits 2d array
     * @return last seed sown
     */
    public static char singleSow(char pickPit, int[][] playersPits) {
        int[] starting = pit2Coordinates(pickPit, playersPits);
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char end = pickPit;
        char nextLetter = pickPit;
        for (int i = 0; i < playersPits[starting[0]][starting[1]]; i++) {
            char next = nextPit(nextLetter, playersPits);
            int[] nextLocation = pit2Coordinates(next, playersPits);
            playersPits[nextLocation[0]][nextLocation[1]]
                    = playersPits[nextLocation[0]][nextLocation[1]] + 1;
            nextLetter = nextPit(nextLetter, playersPits);

            end = nextLetter;
        }
        playersPits[starting[0]][starting[1]] = 0;


        return end;
    }

    /**
     * @param playersPits   pits
     * @param isPlayer1Turn whose turn
     * @return whose turn
     */
    public static boolean checkEndGame(int[][] playersPits, boolean isPlayer1Turn) {
        boolean end = true;
        if (isPlayer1Turn == true) {
            for (int i = 0; i < playersPits[0].length; i++) {
                if (playersPits[1][i] != 0) {
                    end = false;
                }
            }
        }
        if (isPlayer1Turn == false) {
            for (int i = 0; i < playersPits[0].length; i++) {
                if (playersPits[0][i] != 0) {
                    end = false;
                }
            }
        }
        return end;

    }

    /**
     * @param playersPits 2d array
     * @return how many seeds on board
     */
    public static int totalSeedsOnBoard(int[][] playersPits) {
        int sum = 0;
        for (int i = 0; i < playersPits.length; i++) {
            for (int j = 0; j < playersPits[0].length; j++) {
                sum = sum + playersPits[i][j];
            }
        }
        return sum;
    }

    /**
     * @param playersPits 2d array
     */
    public static void clearBoard(int[][] playersPits) {
        for (int i = 0; i < playersPits.length; i++) {
            for (int j = 0; j < playersPits[0].length; j++) {
                playersPits[i][j] = 0;
            }
        }
    }

    /**
     * @param playersPits   2d array
     * @param player1Store  store
     * @param player2Store  store
     * @param isPlayer1Turn turn
     */
    public static void playGame(int[][] playersPits, int player1Store,
                                int player2Store, boolean isPlayer1Turn) {
        char inputA = ' ';
        char inputB = ' ';
        String inputStrA = "";
        String inputStrB = "";
        int[] start = new int[2];
        int seedCount = 100;
        int oppSeedCount = 1;
        int counter = 0;
        int counterB = 0;
        int relay = 0;
        int relayB = 0;
        Scanner scnr = new Scanner(System.in);
        System.out.println("Starting game of Endodoi");
        drawBoard(playersPits, player1Store, player2Store, '?', 1);

        while ((inputA != '!') && (inputB != '!')) {
            if (isPlayer1Turn) {
                System.out.println("Player 1 chose a pit: ");
                inputStrA = scnr.next();
                inputA = inputStrA.charAt(0);
                if (inputA == '!') {
                    System.out.print("Game ended ");
                    break;
                }
                start = pit2Coordinates(inputA, playersPits);
                char currChar = inputA;
                while (seedCount != 1) {
                    currChar = singleSow(currChar, playersPits);
                    drawBoard(playersPits, player1Store, player2Store, currChar, 1);
                    char oppPit = getOpposingPit(currChar, playersPits);
                    oppSeedCount = getPitSeedCount(oppPit, playersPits);
                    int[] oppLoc = pit2Coordinates(oppPit, playersPits);
                    seedCount = getPitSeedCount(currChar, playersPits);
                    int[] currLoc = pit2Coordinates(currChar, playersPits);
                    relay = relay + 1;


                    if ((seedCount == 1) && (currLoc[0] == 0) && (oppSeedCount == 0)) {
                        isPlayer1Turn = false;
                        System.out.println("Player 1's turn ended.");
                    }

                    if ((seedCount == 1) && (currLoc[0] == 0) && (oppSeedCount != 0)) {

                        playersPits[0][currLoc[1]] = 0;
                        counter = 0;
                        counter = counter + 1;
                        counter = counter + oppSeedCount;
                        isPlayer1Turn = false;
                        playersPits[1][oppLoc[1]] = 0;
                        player1Store = player1Store + counter;
                        System.out.println("Player 1's turn ended.");
                        System.out.println("Player 1 captured " + counter + " seeds");

                    }
                    if ((seedCount == 1) && (currLoc[0] == 1)) {
                        isPlayer1Turn = false;
                        System.out.println("Player 1's turn ended.");

                    }
                    if (seedCount != 1) {
                        System.out.println("Sowing ended in non-empty pit. Multi-lap " +
                                relay + ". Resowing seeds...");
                    }
                }


            }
            seedCount = 2;
            drawBoard(playersPits, player1Store, player2Store, '<', 2);
            if (checkEndGame(playersPits, true)) {
                System.out.println("Player 2 can't move.");
                int total = totalSeedsOnBoard(playersPits);
                System.out.println("The remaining " + total + " seeds go to Player 1");
                player1Store = player1Store + total;
                clearBoard(playersPits);
                drawBoard(playersPits, player1Store, player2Store, '?', -1);
                isPlayer1Turn = true;
                if (player1Store > player2Store) {
                    System.out.println("Player 1 is the winner!");
                    break;
                }
                if (player2Store > player1Store) {
                    System.out.println("Player 2 is the winner!");
                    break;
                }
                break;
            }


            if (isPlayer1Turn == false) {
                System.out.println("Player 2 chose a pit: ");
                inputStrB = scnr.next();
                inputB = inputStrB.charAt(0);
                if (inputB == '!') {
                    System.out.println("Game ended");
                    break;
                }
                start = pit2Coordinates(inputB, playersPits);
                char currChar = inputB;
                //seedCount = getPitSeedCount(currChar, playersPits);

                while (seedCount != 1) {
                    currChar = singleSow(currChar, playersPits);
                    drawBoard(playersPits, player1Store, player2Store, currChar, 2);
                    char oppPit = getOpposingPit(currChar, playersPits);
                    oppSeedCount = getPitSeedCount(oppPit, playersPits);
                    int[] oppLoc = pit2Coordinates(oppPit, playersPits);
                    seedCount = getPitSeedCount(currChar, playersPits);
                    int[] currLoc = pit2Coordinates(currChar, playersPits);
                    relayB = relayB + 1;


                    if ((seedCount == 1) && (currLoc[0] == 1) && (oppSeedCount == 0)) {
                        isPlayer1Turn = true;
                        System.out.println("Player 2's turn ended");
                    }

                    if ((seedCount == 1) && (currLoc[0] == 1) && (oppSeedCount != 0)) {
                        counterB = 0;
                        playersPits[1][currLoc[1]] = 0;
                        counterB = counterB + 1;
                        counterB = counterB + oppSeedCount;

                        playersPits[0][oppLoc[1]] = 0;
                        player2Store = player2Store + counterB;
                        System.out.println("Player 2's turn ended.");
                        System.out.println("Player 2 captured " + counterB + " seeds");
                        isPlayer1Turn = true;
                    }
                    if ((seedCount == 1) && (currLoc[0] == 0)) {
                        isPlayer1Turn = true;
                        System.out.println("Player 2's turn ended.");


                    }
                    if (seedCount != 1) {
                        System.out.println("Sowing ended in non-empty pit. Multi-lap " +
                                relayB + ". Resowing seeds...");

                    }


                }

            }

            seedCount = 2;
            drawBoard(playersPits, player1Store, player2Store, '?', 1);
            if (checkEndGame(playersPits, true)) {
                System.out.println("Player 2 can't move.");
                int total = totalSeedsOnBoard(playersPits);
                System.out.println("The remaining " + total + " seeds go to Player 1");
                player1Store = player1Store + total;
                clearBoard(playersPits);
                drawBoard(playersPits, player1Store, player2Store, '?', -1);
                isPlayer1Turn = false;
                if (player1Store > player2Store) {
                    System.out.println("Player 1 is the winner!");
                }
                if (player2Store > player1Store) {
                    System.out.println("Player 2 is the winner!");
                }
                break;



            }
        }

    }


}
