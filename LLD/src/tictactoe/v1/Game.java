package tictactoe.v1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Game {
    private static List<SymbolType> symbolTypes = List.of(SymbolType.values());
    private Board board;
    private Deque<Player> players;

    public void initializeGameObjects(int boardSize, int playerSymbolCount) {
        board = new Board(boardSize);
        players = getPlayersWithSymbol(playerSymbolCount);
    }

    public void testInitialization() {
        printBoardStatus();

        System.out.println("Players");
        players.forEach(player -> System.out.print(player + ", "));
        System.out.println();
    }

    public void startGame() {
        Player winner = null;
        while (true) {
            Player currPlayer = getCurrentPlayer();
            System.out.println("Current player turn is " + currPlayer.getId());

            boolean isInvalidPosition = false;
            Cell boardCell;
            int rowColCalculator;
            do {
                int turnIndex = currPlayer.playTurn(board.getBoardSize());
                rowColCalculator = turnIndex;
                System.out.println(turnIndex);
                boardCell = board.getCell(turnIndex);
                if (boardCell.getSymbol() != null) {
                    isInvalidPosition = true;
                } else {
                    isInvalidPosition = false;
                }
            } while (isInvalidPosition);

            boardCell.setSymbol(new Symbol(SymbolType.fromString(currPlayer.getSymbolType())));
            printBoardStatus();

            if (checkForWinner(rowColCalculator, SymbolType.fromString(currPlayer.getSymbolType()))) {
                System.out.println("Winner is " + currPlayer);
                winner = currPlayer;
                break;
            }

            if (isGameInvalid()) {
                break;
            }
        }

        if (winner == null)
            System.out.println("Draw: No result");
    }

    public boolean checkForWinner(int rowColCalculator, SymbolType symbolType) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;
        int row = rowColCalculator / board.getBoardSize();
        int column = rowColCalculator % board.getBoardSize();

        //need to check in row
        for (int i = 0; i < board.getBoardSize(); i++) {

            if (board.getCells()[row][i] == null || board.getCells()[row][i].getSymbol() == null || board.getCells()[row][i].getSymbol().getSymbolType() != symbolType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for (int i = 0; i < board.getBoardSize(); i++) {

            if (board.getCells()[i][column] == null || board.getCells()[i][column].getSymbol() == null || board.getCells()[i][column].getSymbol().getSymbolType() != symbolType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for (int i = 0, j = 0; i < board.getBoardSize(); i++, j++) {
            if (board.getCells()[i][j] == null || board.getCells()[i][j].getSymbol() == null || board.getCells()[i][j].getSymbol().getSymbolType() != symbolType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for (int i = 0, j = board.getBoardSize() - 1; i < board.getBoardSize(); i++, j--) {
            if (board.getCells()[i][j] == null || board.getCells()[i][j].getSymbol() == null || board.getCells()[i][j].getSymbol().getSymbolType() != symbolType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }


    private boolean isGameInvalid() {
        boolean isInvalid = true;
        for (int i = 0; i < board.getBoardSize(); i++) {
            for (int j = 0; j < board.getBoardSize(); j++) {
                if (board.getCells()[i][j].getSymbol() == null) {
                    isInvalid = false;
                    break;
                }
            }
        }
        return isInvalid;
    }

    private Player getCurrentPlayer() {
        Player curr = players.removeFirst();
        players.addLast(curr);
        return curr;
    }

    private void printBoardStatus() {
        System.out.println("Board Status");
        for (int i = 0; i < board.getBoardSize(); i++) {
            for (int j = 0; j < board.getBoardSize(); j++) {
                if (j > 0) {
                    System.out.print(" | ");
                }
                System.out.print(board.getCells()[i][j]);
            }
            System.out.println();
            if (i < board.getBoardSize() - 1) {
                for (int j = 0; j < board.getBoardSize(); j++) {
                    System.out.print("----");
                }
            }
            System.out.println();
        }
    }

    private Deque<Player> getPlayersWithSymbol(int playerSymbolCount) {
        Deque<Player> players = new LinkedList<>();

        for (int i = 1; i <= playerSymbolCount; i++) {
            Player player = new Player("P" + i, symbolTypes.get(i - 1).getVal());
            players.addLast(player);
        }

        return players;
    }
}
