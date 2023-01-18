package chess.v1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;
    private Deque<Player> players;

    private Scanner sc = new Scanner(System.in);

    private static List<Color> colorTypes = List.of(Color.values());

    public void initialiseGame(int boardSize, int playerCount) {
        board = new Board(boardSize);
        players = new LinkedList<>();
        initialisePlayers(playerCount);
    }

    private void initialisePlayers(int playerCount) {
        for (int i = 1; i <= playerCount; i++) {
            Player player = new Player("P"+i, colorTypes.get(i-1));
            this.players.addLast(player);
        }
    }

    public void checkInitialization() {
        System.out.println("Players");
        for(Player p: players) {
            System.out.println(p);
        }

        System.out.println("Board");
        int boardSize = board.getBoardSize();
        for (int i=0; i<boardSize; i++) {
            for (int j=0; j<boardSize; j++) {
                if (board.getCells()[i][j] != null && board.getCells()[i][j].getPiece() != null) {
                    System.out.print(board.getCells()[i][j].getPiece().getPieceType().getVal() + "  ");
                } else {
                    System.out.print("-  ");
                }
            }
            System.out.println();
        }
    }

    public void startGame() {
        Player winner = null;
        boolean hasWinnerFound = false;
        int counter = 0;
        while(true) {
            Player currPlayer = getCurrentPlayer();
            System.out.println("Current player is " + currPlayer);
            System.out.println("Enter your move");
            boolean isValidMove = true;
            Cell startCell, endCell;

            do {
                System.out.println("Enter start cell co-ordinates");
                int x1 = sc.nextInt();
                int y1 = sc.nextInt();
                System.out.println("Enter end cell co-ordinates");
                int x2 = sc.nextInt();
                int y2 = sc.nextInt();

                startCell = board.getCell(x1, y1);
                endCell = board.getCell(x2, y2);

                if (endCell.getPiece() != null) {
                    Piece startCellPiece = startCell.getPiece();
                    Piece endCellPiece = endCell.getPiece();
                    if (startCellPiece.getColor() == endCellPiece.getColor() || !startCellPiece.isValidMove()) {
                        isValidMove = false;
                        System.out.println("Enter your move again");
                    } else {
                        isValidMove = true;
                    }
                }
            } while(!isValidMove);

            endCell.setPiece(startCell.getPiece());
            startCell.setPiece(null);

            if (counter > 10 && isCheckMate()) {
                winner = currPlayer;
                hasWinnerFound = true;
                break;
            } else if (isDraw()) {
                break;
            }
            counter++;
            printGameStatus();
        }

        if (hasWinnerFound) {
            System.out.println("Winner is " + winner);
        } else {
            System.out.println("Match is draw");
        }
    }

    private void printGameStatus() {
        int boardSize = board.getBoardSize();
        for (int i=0; i<boardSize; i++) {
            for (int j=0; j<boardSize; j++) {
                if (board.getCells()[i][j] != null && board.getCells()[i][j].getPiece() != null) {
                    System.out.print(board.getCells()[i][j].getPiece().getPieceType().getVal() + "  ");
                } else {
                    System.out.print("-  ");
                }
            }
            System.out.println();
        }
    }

    private boolean isCheckMate() {
        return true;
    }

    private boolean isDraw() {
        return false;
    }
    private Player getCurrentPlayer() {
        Player p = players.removeFirst();
        players.addLast(p);
        return p;
    }
}
