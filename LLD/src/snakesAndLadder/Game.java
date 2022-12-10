package snakesAndLadder;

import java.util.LinkedList;
import java.util.Queue;

public class Game {
    private Board board;
    private Dice dice;
    private Queue<Player> players;

    public void initializeGame(int boardSize, int diceCount, int playerCount, int snakesCount, int ladderCount) {
        board = new Board(boardSize, snakesCount, ladderCount);
        dice = new Dice(diceCount);
        players = initializePlayers(playerCount);
    }

    private Queue<Player> initializePlayers(int playerCount) {
        Queue<Player> players = new LinkedList<>();
        for (int i = 1; i <= playerCount; i++) {
            Player p = new Player("P" + i, 0);
            players.add(p);
        }
        return players;
    }

    public void testInitialization() {
        int snakeCount = 0, ladderCount = 0;
        for (int i = 0; i < board.getCells().length; i++) {
            for (int j = 0; j < board.getCells().length; j++) {
                if (board.getCells()[i][j].getJump() != null) {
                    System.out.println(board.getCells()[i][j]);
                    if (board.getCells()[i][j].getJump().getJumpType() == JumpType.SNAKE)
                        snakeCount++;
                    else
                        ladderCount++;
                }
            }
            System.out.println();
        }
        System.out.println(snakeCount + " " + ladderCount);
        System.out.println();
        System.out.println(dice.getDiceCount());
        players.forEach(player -> System.out.print(player.getId() + " "));
        System.out.println();
    }

    public void start() {
        Player winner = null;

        while (winner == null) {

            Player currPlayer = getCurrPlayer();

            boolean hasLandedOnLadder = false;
            int newPosition = 0;
            do {
                System.out.println("Current player with position is " + currPlayer);
                int diceVal = dice.roll();
                newPosition = currPlayer.getCurrPosition() + diceVal;
                if (newPosition >= board.getCells().length * board.getCells().length) {
                    winner = currPlayer;
                    break;
                }
                Cell cell = board.getCell(newPosition);
                newPosition = addJumpIfExists(newPosition, cell);
                currPlayer.setCurrPosition(newPosition);
                if (cell.getJump() != null && cell.getJump().getJumpType().equals(JumpType.LADDER)) {
                    hasLandedOnLadder = true;
                } else {
                    hasLandedOnLadder = false;
                }
            } while (hasLandedOnLadder);
            System.out.println("Current player with newPosition is " + currPlayer);

            // Winning logic: can have strategy pattern
            if (winner == null && newPosition >= board.getCells().length * board.getCells().length) {
                winner = currPlayer;
            }

        }

        System.out.println();
        System.out.println("Winner is " + winner.getId());
    }

    private int addJumpIfExists(int newPosition, Cell cell) {
        if (cell.getJump() != null && cell.getJump().getStart() == newPosition) {
            System.out.println("Had " + cell.getJump().getJumpType() + " so moving from " + cell.getJump().getStart() + " to " + cell
                    .getJump().getEnd());
            newPosition = cell.getJump().getEnd();
        }

        return newPosition;
    }

    private Player getCurrPlayer() {
        Player curr = players.poll();
        players.add(curr);
        return curr;
    }
}
