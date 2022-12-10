package snakesAndLadder;

import lombok.Getter;

import java.util.Random;

@Getter
public class Board {
    private final int boardSize, snakeCount, ladderCount;
    private Cell[][] cells;

    public Board(int boardSize, int snakeCount, int ladderCount) {
        this.boardSize = boardSize;
        this.snakeCount = snakeCount;
        this.ladderCount = ladderCount;
        initializeBoard();
    }

    private void initializeBoard() {
        cells = new Cell[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                Cell cellObj = new Cell();
                cells[i][j] = cellObj;
            }
        }
        addSnakesAndLadders(snakeCount, ladderCount);
    }

    private void addSnakesAndLadders(int snakeCount, int ladderCount) {
        int maxValue = this.boardSize * this.boardSize;
        Random r = new Random();
        while (snakeCount > 0) {
            int snakeHead = r.nextInt(maxValue);
            int snakeTail = r.nextInt(maxValue);

            if (snakeHead <= snakeTail) {
                continue;
            }

            Cell cell = this.getCell(snakeHead);
            if (cell.getJump() != null) {
                continue;
            }

            Jump snake = new Jump(snakeHead, snakeTail, JumpType.SNAKE);
            cell.setJump(snake);
            snakeCount--;
        }

        while (ladderCount > 0) {
            int ladderHead = r.nextInt(maxValue);
            int ladderTail = r.nextInt(maxValue);

            if (ladderTail <= ladderHead) {
                continue;
            }

            Cell cell = this.getCell(ladderHead);
            if (cell.getJump() != null) {
                continue;
            }

            Jump ladder = new Jump(ladderHead, ladderTail, JumpType.LADDER);
            cell.setJump(ladder);
            ladderCount--;
        }
    }

    public Cell getCell(int position) {
        int row = position / this.boardSize;
        int col = position % this.boardSize;
        return this.getCells()[row][col];
    }
}
