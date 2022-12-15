package tictactoe.v1;

import lombok.Getter;

@Getter
public class Board {
    private int boardSize;
    private Cell[][] cells;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        this.cells = new Cell[boardSize][boardSize];

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                Cell cell = new Cell();
                cells[i][j] = cell;
            }
        }
    }

    public Cell getCell(int position) {
        int row = position / boardSize;
        int col = position % boardSize;
        System.out.println(row + ", " + col);
        return cells[row][col];
    }

}
